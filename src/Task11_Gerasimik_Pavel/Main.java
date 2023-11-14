package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        CooksAssignment cooksAssignment = new CooksAssignment();
        Kitchen kitchen = new Kitchen();
        Menu menu = new Menu();

        cooksAssignment.addCook("Настя", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY)));
        cooksAssignment.addDishForCook("Настя", "Золотое яблоко", "яблоки", DishCategory.DESSERT, 67, 32);

        ToolsForMenuCreation toolsForMenuCreation = new ToolsForMenuCreation();

        Map<Cook, List<Dish>> listWithCooksWhoCanWorkToday = toolsForMenuCreation.checkCookWorkDays(cooksAssignment.listOfCooksAndTheirDishes);
        List<Dish> listWithDishWhichCookCanCookedToday = toolsForMenuCreation.checkTheCooksListOfDishesForToday(listWithCooksWhoCanWorkToday);
        Set<String> ingredientsOnKitchenToday = kitchen.getProductsOnKitchen();

        List<Dish> menuForToday = toolsForMenuCreation.createMenuForToday(listWithDishWhichCookCanCookedToday, ingredientsOnKitchenToday, 4);

        menuForToday = toolsForMenuCreation.filterByTheWhimsOfTheKing(menuForToday, dish -> dish.getCategory() == DishCategory.DESSERT);

        System.out.println(menu.getMenu(menuForToday));
    }
}
