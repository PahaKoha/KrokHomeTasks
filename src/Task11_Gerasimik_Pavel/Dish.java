package Task11_Gerasimik_Pavel;

import java.util.Comparator;
import java.util.Objects;

public class Dish {
    private String name;
    private String ingredients;
    private DishCategory category;
    private int kingRating;
    private int peopleRating;

    public Dish(String name, String ingredients, DishCategory category, int kingRating, int peopleRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        setKingRating(kingRating);
        setPeopleRating(peopleRating);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public DishCategory getCategory() {
        return category;
    }

    public void setCategory(DishCategory category) {
        this.category = category;
    }

    public int getKingRating() {
        return kingRating;
    }

    public void setKingRating(int kingRating) {
        if (kingRating >= 0 && kingRating <= 100) {
            this.kingRating = kingRating;
        }
    }

    public int getPeopleRating() {
        return peopleRating;
    }

    public void setPeopleRating(int peopleRating) {
        if (peopleRating >= 0 && peopleRating <= 100) {
            this.peopleRating = peopleRating;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return kingRating == dish.kingRating && peopleRating == dish.peopleRating && Objects.equals(name, dish.name) && Objects.equals(ingredients, dish.ingredients) && Objects.equals(category, dish.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, category, kingRating, peopleRating);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", category='" + category + '\'' +
                ", kingRating=" + kingRating +
                ", peopleRating=" + peopleRating +
                '}';
    }
}

class DishComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        int kingRatingComparison = o2.getKingRating() - o1.getKingRating();

        if (kingRatingComparison == 0) {
            return o2.getPeopleRating() - o1.getPeopleRating();
        }

        return kingRatingComparison;
    }
}
