package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.*;

public class CooksAssignment {
    public Map<Cook, List<Dish>> listOfCooksAndTheirDishes = new HashMap<>();

    {
        listOfCooksAndTheirDishes.put(new Cook("Павел", new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SUNDAY)))
                , new ArrayList<>(List.of(new Dish("Котлета по-Киевски", "курица, мука, соль", DishCategory.MAIN_DISH, 100, 100)
                        , new Dish("Жаренная курица", "курица, соль", DishCategory.MAIN_DISH, 45, 67)
                        , new Dish("фреш", "сок, лёд", DishCategory.DESSERT, 56, 74))));
        listOfCooksAndTheirDishes.put(new Cook("Матвей", new HashSet<>(List.of(DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY)))
                , new ArrayList<>(List.of(new Dish("Мороженное", "шоколад, сахар", DishCategory.DESSERT, 45, 89),
                        new Dish("Знаменитый жаренный суп", "вода, картошка, перец, соль", DishCategory.MAIN_DISH, 98, 89))));
        listOfCooksAndTheirDishes.put(new Cook("Артем", new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SUNDAY)))
                , new ArrayList<>(List.of(new Dish("Морковь в соевом соусе", "морковь, соевый_соус", DishCategory.SALAD, 69, 24),
                        new Dish("Банан с шоколадом", "бананы, шоколад, сахар", DishCategory.DESSERT, 53, 49))));
        listOfCooksAndTheirDishes.put(new Cook("Володя", new HashSet<>(List.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY)))
                , new ArrayList<>(List.of(new Dish("Чебупицца", "мука, курица, сыр", DishCategory.MAIN_DISH, 90, 97),
                        new Dish("Чебупели", "мука, свинина", DishCategory.MAIN_DISH, 99, 98)
                        , new Dish("Жаренное молоко", "молоко", DishCategory.DESSERT, 26, 90))));
        listOfCooksAndTheirDishes.put(new Cook("Илья", new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SATURDAY)))
                , new ArrayList<>(List.of(new Dish("Несквик с пивом", "несквик, пиво", DishCategory.MAIN_DISH, 100, 100),
                        new Dish("Кортошка с курицей", "курица, картошка", DishCategory.MAIN_DISH, 35, 78)
                        , new Dish("Яблоки в карамели", "яблоки, карамель", DishCategory.DESSERT, 62, 41))));
        listOfCooksAndTheirDishes.put(new Cook("Сева", new HashSet<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.THURSDAY)))
                , new ArrayList<>(List.of(new Dish("Свинина в куринном бульоне", "свинина, вода, соль, перец", DishCategory.MAIN_DISH, 86, 34),
                        new Dish("Плов", "говядина, рис, перец, лук, соль", DishCategory.MAIN_DISH, 56, 33)
                        , new Dish("Пахлава", "мёд, тесто", DishCategory.DESSERT, 100, 100))));
    }

    public void removeCook(String name) {
        Cook cookToRemove = findCookFromMap(name);
        if (cookToRemove != null) {
            listOfCooksAndTheirDishes.remove(cookToRemove);
        } else {
            System.out.println("Повара с именем " + name + " не существует.");
        }
    }

    public void addCook(String name, Set<DayOfWeek> workDays) {
        listOfCooksAndTheirDishes.put(new Cook(name, workDays), new ArrayList<>());
    }

    public void addDishForCook(String nameOfCook, String nameOfDish, String ingredients, DishCategory category, int kingRating, int peopleRating) {
        Cook cookForAddDish = findCookFromMap(nameOfCook);
        if (cookForAddDish != null) {
            List<Dish> dishes = listOfCooksAndTheirDishes.get(cookForAddDish);
            Dish newDish = new Dish(nameOfDish, ingredients, category, kingRating, peopleRating);
            dishes.add(newDish);
        } else {
            System.out.println("Повара с именем " + nameOfCook + " не существует.");
        }
    }

    public Cook findCookFromMap(String nameOfCook) {
        for (Cook cook : listOfCooksAndTheirDishes.keySet()) {
            if (Objects.equals(cook.getName(), nameOfCook)) {
                return cook;
            }
        }
        return null;
    }
}
