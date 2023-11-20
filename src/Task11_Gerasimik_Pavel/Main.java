package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CooksAssignment cooksAssignment = new CooksAssignment();
        Kitchen kitchen = new Kitchen();
        Menu menu = new Menu();
        Cook newCook = new Cook("Настя", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY)));
        Dish newDish = new Dish("Золотое яблоко", Set.of("яблоки"),
                DishCategory.DESSERT, 67, 32);

        cooksAssignment.addCook(newCook);
        cooksAssignment.addDishForCook("Настя", newDish);

        ToolsForMenuCreation toolsForMenuCreation = new ToolsForMenuCreation();

        Set<Dish> menuForToday = toolsForMenuCreation.createMenuForToday(cooksAssignment.listOfCooksAndTheirDishes,
                kitchen.getProductsWitchNotOnKitchen());

        menuForToday = toolsForMenuCreation.filterByTheWhimsOfTheKing(menuForToday,
                dish -> dish.getCategory() == DishCategory.DESSERT, 3);

        System.out.println(menu.getMenu(menuForToday));

    }
}
