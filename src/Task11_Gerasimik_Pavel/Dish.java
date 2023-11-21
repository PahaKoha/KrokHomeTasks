package Task11_Gerasimik_Pavel;

import java.util.Objects;
import java.util.Set;

public class Dish {
    private final String name;
    private final Set<String> ingredients;
    private final DishCategory category;
    private int kingRating;
    private int peopleRating;

    public Dish(String name, Set<String> ingredients, DishCategory category, int kingRating, int peopleRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        setKingRating(kingRating);
        setPeopleRating(peopleRating);

    }

    public String getName() {
        return name;
    }

    public Set<String> getIngredients() {
        return ingredients;
    }

    public DishCategory getCategory() {
        return category;
    }

    public int getKingRating() {
        return kingRating;
    }

    public void setKingRating(int kingRating) {
        if (kingRating >= 0 && kingRating <= 100) {
            this.kingRating = kingRating;
        } else {
            throw new IncorrectRatingValueException();
        }
    }

    public int getPeopleRating() {
        return peopleRating;
    }

    public void setPeopleRating(int peopleRating) {
        if (peopleRating >= 0 && peopleRating <= 100) {
            this.peopleRating = peopleRating;
        } else {
            throw new IncorrectRatingValueException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) && Objects.equals(ingredients, dish.ingredients)
                && Objects.equals(category, dish.category);
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
