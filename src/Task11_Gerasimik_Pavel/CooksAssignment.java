package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.*;

public class CooksAssignment {
    public Map<Cook, Set<Dish>> listOfCooksAndTheirDishes = new HashMap<>();

    {
        listOfCooksAndTheirDishes.put(new Cook("Павел",
                        new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SUNDAY))),
                new HashSet<>(Set.of(
                        new Dish("Котлета по-Киевски", Set.of("курица", "мука", "соль"),
                                DishCategory.MAIN_DISH, 100, 100),
                        new Dish("Жаренная курица", Set.of("курица", "соль"),
                                DishCategory.MAIN_DISH, 45, 67),
                        new Dish("фреш", Set.of("сок", "лёд"),
                                DishCategory.DESSERT, 56, 74))));
        listOfCooksAndTheirDishes.put(new Cook("Матвей",
                        new HashSet<>(List.of(DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY))),
                new HashSet<>(Set.of(
                        new Dish("Мороженное", Set.of("шоколад", "сахар"),
                                DishCategory.DESSERT, 45, 89),
                        new Dish("Знаменитый жаренный суп", Set.of("вода", "картошка", "перец", "соль"),
                                DishCategory.MAIN_DISH, 98, 89))));
        listOfCooksAndTheirDishes.put(new Cook("Артем",
                        new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SUNDAY))),
                new HashSet<>(Set.of(
                        new Dish("Морковь в соевом соусе", Set.of("морковь", "соевый_соус"),
                                DishCategory.SALAD, 69, 24),
                        new Dish("Банан с шоколадом", Set.of("бананы", "шоколад", "сахар"),
                                DishCategory.DESSERT, 53, 49))));
        listOfCooksAndTheirDishes.put(new Cook("Володя",
                        new HashSet<>(List.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY))),
                new HashSet<>(Set.of(
                        new Dish("Чебупицца", Set.of("мука", "курица", "сыр"),
                                DishCategory.MAIN_DISH, 90, 97),
                        new Dish("Чебупели", Set.of("мука", "свинина"),
                                DishCategory.MAIN_DISH, 99, 98)
                        , new Dish("Жаренное молоко", Set.of("молоко"),
                                DishCategory.DESSERT, 26, 90))));
        listOfCooksAndTheirDishes.put(new Cook("Илья",
                        new HashSet<>(List.of(DayOfWeek.MONDAY, DayOfWeek.SATURDAY))),
                new HashSet<>(Set.of(
                        new Dish("Несквик с пивом", Set.of("несквик", "пиво"),
                                DishCategory.MAIN_DISH, 100, 100),
                        new Dish("Кортошка с курицей", Set.of("курица", "картошка"),
                                DishCategory.MAIN_DISH, 35, 78)
                        , new Dish("Яблоки в карамели", Set.of("яблоки", "карамель"),
                                DishCategory.DESSERT, 62, 41))));
        listOfCooksAndTheirDishes.put(new Cook("Сева",
                        new HashSet<>(List.of(DayOfWeek.FRIDAY, DayOfWeek.THURSDAY))),
                new HashSet<>(Set.of(
                        new Dish("Свинина в куринном бульоне", Set.of("свинина", "вода", "соль", "перец"),
                                DishCategory.MAIN_DISH, 86, 34),
                        new Dish("Плов", Set.of("говядина", "рис", "перец", "лук", "соль"),
                                DishCategory.MAIN_DISH, 56, 33),
                        new Dish("Пахлава", Set.of("мёд", "тесто"),
                                DishCategory.DESSERT, 100, 100))));
    }

    public void removeCook(String nameOfCook) throws IncorrectNameException {
        Cook cookToRemove = findCookFromMap(nameOfCook);
        if (cookToRemove != null) {
            listOfCooksAndTheirDishes.remove(cookToRemove);
        } else {
            throw new IncorrectNameException(nameOfCook);
        }
    }

    public void addCook(Cook cook) {
        listOfCooksAndTheirDishes.put(cook, new HashSet<>());
    }

    public void addDishForCook(String nameOfCook, Dish newDish) {
        Cook cookForAddDish = findCookFromMap(nameOfCook);
        if (cookForAddDish != null) {
            Set<Dish> dishes = listOfCooksAndTheirDishes.get(cookForAddDish);
            dishes.add(newDish);
        } else {
            throw new IncorrectNameException(nameOfCook);
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
