package Task11_Gerasimik_Pavel;

import java.util.List;
import java.util.Set;

public class Menu {
    public String getMenu(Set<Dish> listWithDishes) {
        StringBuilder stringBuilder = new StringBuilder().append("Меню для Его Величества на сегодня:\n");
        listWithDishes.forEach(dish -> stringBuilder.append(dish.getName()).append(" - ")
                .append(dish.getCategory()).append(". ").append("Оценка короля - ").append(dish.getKingRating())
                .append(". ").append("Оценка людей - ").append(dish.getPeopleRating()).append("\n"));
        return stringBuilder.toString();
    }
}
