package bussinessLogic;

import bussinessLogic.product.BaseProduct;
import bussinessLogic.product.CompositeProduct;
import bussinessLogic.product.MenuItem;
import bussinessLogic.role.Client;
import bussinessLogic.utilities.Days;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DeliveryService extends Observable implements IDeliveryServiceProcessing, Serializable {
    private Map<Order, Collection<MenuItem>> orders = new HashMap<>();
    private ArrayList<MenuItem> productList = new ArrayList<>();

    public Map<Order, Collection<MenuItem>> getOrders() {
        return orders;
    }

    public void setOrders(Map<Order, Collection<MenuItem>> orders) {
        this.orders = orders;
    }

    public ArrayList<MenuItem> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<MenuItem> productList) {
        this.productList = productList;
    }

    @Override
    public void addOrder(String client, ArrayList<MenuItem> products) {
        int maxId = 1;
        Optional<Order> lastOrder = orders.keySet().stream().max(Comparator.comparingInt(Order::getId));
        if (lastOrder.isPresent()) {
            maxId = lastOrder.get().getId() + 1;
        }
        Order order = new Order(maxId, client, new Date());
        orders.put(order, products);
        setChanged();
        notifyObservers(new AbstractMap.SimpleEntry<>(order, products));
        generateBill(order, products);
    }

    @Override
    public void generateBill(Order order, ArrayList<MenuItem> products) {

    }

    @Override
    public Collection<MenuItem> search(String name, double rating1, double rating2, int calories1, int calories2, int protein1, int protein2, int fat1, int fat2, int sodium1, int sodium2, int price1, int price2) {
        return productList.stream().filter(e -> e.getTitle().contains(name)
                && e.getRating() >= rating1 && e.getRating() <= rating2
                && e.getCalories() >= calories1 && e.getCalories() <= calories2
                && e.getProtein() >= protein1 && e.getProtein() <= protein2
                && e.getFat() >= fat1 && e.getFat() <= fat2
                && e.getSodium() >= sodium1 && e.getSodium() <= sodium2
                && e.getPrice() >= price1 && e.getPrice() <= price2).collect(Collectors.toList());
    }


    @Override
    public void importProduct() throws IOException {
        Files.lines(Paths.get("src/main/resources/products.csv")).skip(1).distinct().forEach((l) -> {
            int i = l.indexOf(",");
            String[] prod = l.split(",");
            BaseProduct p = new BaseProduct(prod[0].substring(0, i - 1), Double.valueOf(prod[1]), Integer.parseInt(prod[2]), Integer.parseInt(prod[3]), Integer.parseInt(prod[4]), Integer.parseInt(prod[5]), Integer.parseInt(prod[6]));
            if(!productList.contains(p)) {
                productList.add(p);
            }
        });
    }

    @Override
    public List<Order> reportTime(int from, int to) {
        ArrayList<Order> report = (ArrayList<Order>) orders.keySet().stream().filter(f -> f.getOrderDate().getHours() <= to &&  f.getOrderDate().getHours() >= from).collect(Collectors.toList());
        return report;
    }

    @Override
    public List<MenuItem> reportProductsNo(int n) {
        ArrayList<MenuItem> p = new ArrayList<>();
        ArrayList<MenuItem> p2 = new ArrayList<>();
        orders.values().forEach(p::addAll);
        p2 = (ArrayList<MenuItem>) p.stream().filter(f -> p.stream().filter(f::equals).count() >= n).distinct().collect(Collectors.toList());
        return p2;
    }

    @Override
    public List<Client> reportProductsNoVal(int n, int val) {
        return null;
    }

    @Override
    public Map<MenuItem, Integer> reportDay(Days d) {
        return null;
    }

    @Override
    public void addProduct(MenuItem product) {
        if(!productList.contains(product)) {
            productList.add(product);
        }
    }

    @Override
    public void deleteProduct(MenuItem product) {
        productList.remove(product);
    }

    @Override
    public void updateProduct(MenuItem product1, MenuItem product2) {
        for(int i = 0; i < productList.size(); i++) {
            if(productList.get(i).equals(product1)) {
                if(!productList.contains(product2)) {
                    productList.remove(productList.get(i));
                    productList.add(product2);
                }
            }
        }
    }

    @Override
    public void createMenu(CompositeProduct menu, MenuItem product) {
        menu.addProduct((BaseProduct) product);
    }
}
