package bussinessLogic.product;

import java.io.Serializable;

public abstract class MenuItem implements Serializable {
    private String title;

    public MenuItem(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract Double getRating();

    public abstract void setRating(Double rating);

    public abstract int getCalories();

    public abstract void setCalories(int calories);

    public abstract int getProtein();

    public abstract void setProtein(int protein);

    public abstract int getFat();

    public abstract void setFat(int fat);

    public abstract int getSodium();

    public abstract void setSodium(int sodium);

    public abstract int getPrice();

    public abstract void setPrice(int price);

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuItem menuItem = (MenuItem) o;

        return title.equals(menuItem.title);
    }
}
