package bussinessLogic;

import bussinessLogic.product.CompositeProduct;
import bussinessLogic.product.MenuItem;
import bussinessLogic.role.Client;
import bussinessLogic.utilities.Days;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IDeliveryServiceProcessing {

    public void addOrder(String client, ArrayList<MenuItem> products) throws IOException;

    public void generateBill(Order order, ArrayList<MenuItem> products);

    public Collection<MenuItem> search(String name, double rating1, double rating2, int calories1, int calories2, int protein1, int protein2, int fat1, int fat2, int sodium1, int sodium2, int price1, int price2);

    public void importProduct() throws IOException;

    public List<Order> reportTime(int from, int to);

    public List<MenuItem> reportProductsNo(int n);

    public List<Client> reportProductsNoVal(int n, int val);

    public Map<MenuItem, Integer> reportDay(Days d);

    public void addProduct(MenuItem product);

    public void deleteProduct(MenuItem product);

    public void updateProduct(MenuItem product1, MenuItem product2);

    public void createMenu(CompositeProduct menu, MenuItem product);
}
