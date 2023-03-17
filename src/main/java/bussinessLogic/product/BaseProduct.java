package bussinessLogic.product;

public class BaseProduct extends MenuItem{

    private Double rating;
    private int calories;
    private int protein;
    private int fat;
    private int sodium;
    private int price;

    public BaseProduct(String title, Double rating, int calories, int protein, int fat, int sodium, int price) {
        super(title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    @Override
    public Double getRating() {
        return this.rating;
    }

    @Override
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @Override
    public int getCalories() {
        return this.calories;
    }

    @Override
    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public int getProtein() {
        return this.protein;
    }

    @Override
    public void setProtein(int protein) {
        this.protein = protein;
    }

    @Override
    public int getFat() {
        return this.fat;
    }

    @Override
    public void setFat(int fat) {
        this.fat = fat;
    }

    @Override
    public int getSodium() {
        return this.sodium;
    }

    @Override
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Menu: " + super.getTitle() + ", Rating: " + this.getRating() + ", Calories: " + this.getCalories() + ", Proteins: " + this.getProtein() + ", Fats: " + this.getFat() + ", Sodium: " + this.getSodium() + ", Price: " + this.getPrice();
    }
}
