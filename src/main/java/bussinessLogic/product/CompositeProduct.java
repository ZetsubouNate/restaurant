package bussinessLogic.product;

import java.util.ArrayList;

public class CompositeProduct extends MenuItem{

    private ArrayList<BaseProduct> menu = new ArrayList<BaseProduct>();

    public CompositeProduct(String title) {
        super(title);
    }

    public void addProduct(BaseProduct product) {
        menu.add(product);
    }

    @Override
    public Double getRating() {
        double r = 0.00;
        for (BaseProduct baseProduct : menu) {
            r += baseProduct.getRating();
        }
        r = r / menu.size();
        return r;
    }

    @Override
    public void setRating(Double rating) {

    }

    @Override
    public int getCalories() {
        int cal = 0;
        for (BaseProduct baseProduct : menu) {
            cal += baseProduct.getCalories();
        }
        return cal;
    }

    @Override
    public void setCalories(int calories) {

    }

    @Override
    public int getProtein() {
        int pro = 0;
        for (BaseProduct baseProduct : menu) {
            pro += baseProduct.getProtein();
        }
        return pro;
    }

    @Override
    public void setProtein(int protein) {

    }

    @Override
    public int getFat() {
        int fat = 0;
        for (BaseProduct baseProduct : menu) {
            fat += baseProduct.getFat();
        }
        return fat;
    }

    @Override
    public void setFat(int fat) {

    }

    @Override
    public int getSodium() {
        int s = 0;
        for (BaseProduct baseProduct : menu) {
            s += baseProduct.getSodium();
        }
        return s;
    }

    @Override
    public void setSodium(int sodium) {

    }

    @Override
    public int getPrice() {
        int price = 0;
        for (BaseProduct baseProduct : menu) {
            price += baseProduct.getPrice();
        }
        return price;
    }

    @Override
    public void setPrice(int price) {

    }

    @Override
    public String toString() {
        return "Menu: " + super.getTitle() + ", Rating: " + this.getRating() + ", Calories: " + this.getCalories() + ", Proteins: " + this.getProtein() + ", Fats: " + this.getFat() + ", Sodium: " + this.getSodium() + ", Price: " + this.getPrice();
    }
}
