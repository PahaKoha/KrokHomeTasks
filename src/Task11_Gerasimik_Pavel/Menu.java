package Task11_Gerasimik_Pavel;

import java.util.List;

public class Menu {
    public String getMenu(List<Dish> listWithDishes) {
        StringBuilder stringBuilder = new StringBuilder().append("Меню для Его Величества на сегодня:\n");
        listWithDishes.forEach(dish -> stringBuilder.append(dish.getName()).append(" - ")
                .append(dish.getCategory()).append("\n"));
        return stringBuilder.toString();
    }
}
