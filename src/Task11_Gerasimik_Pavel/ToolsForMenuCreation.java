package Task11_Gerasimik_Pavel;

import java.time.DayOfWeek;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ToolsForMenuCreation {
    /**
     * Проверяет, возможно ли приготовить блюда из имеющихся на кухнне ингредиентов
     *
     * @param dish        - блюдо
     * @param ingredients - ингредиенты на кухне
     * @return - я не знаю что тут пизать. True или False
     */
    public boolean checkIngredients(Dish dish, Set<String> ingredients) {
        List<String> stringsFromDish = Arrays.stream(dish.getIngredients().split("[,\\s]+")).toList();
        return ingredients.containsAll(stringsFromDish);
    }

    /**
     * Этот метод возвращает List с блюдами, которые можно приготовить из ингредиентво на кухне.
     *
     * @param dishListForToday - список блюд поваров, которые сегодян работатют
     * @param ingredients      - ингредиенты на кухнне
     * @param limit            - предел блюд для подачи королю
     * @return - возвращает список блюд
     */
    public List<Dish> createMenuForToday(List<Dish> dishListForToday, Set<String> ingredients, int limit) {
        if (dishListForToday == null) {
            return Collections.emptyList();
        }
        return dishListForToday.stream()
                .filter(dish -> checkIngredients(dish, ingredients))
                .sorted(new DishComparator()).limit(limit).collect(Collectors.toList());
    }

    /**
     * Этот метод проверяет сегодняшний день недели и возвращает список поваров, которые смогут сегодня готовить
     *
     * @param cooksAndTheirDishes - map который хранит в себе поваров и их список их блюд
     * @return - возвращает отфильтрованный список поворов, которые могу сегодня работать
     */
    public Map<Cook, List<Dish>> checkCookWorkDays(Map<Cook, List<Dish>> cooksAndTheirDishes) {
        return cooksAndTheirDishes.entrySet().stream()
                .filter(entry -> entry.getKey() != null && entry.getKey().getWorkDays().contains(DayOfWeek.MONDAY)) // выбрал рандомный день недели, чтобы тесты работали как надо.
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue
                ));
    }

    /**
     * Этот метод возвращает список блюд, которые могу приготовить повара сегодня
     *
     * @param cooksAndTheirDishes - map с поварами и списками их блюд
     * @return - список блюд в соответствии с поворами, у которых сегодня рабочий день
     */
    public List<Dish> checkTheCooksListOfDishesForToday(Map<Cook, List<Dish>> cooksAndTheirDishes) {
        if (cooksAndTheirDishes == null) {
            return Collections.emptyList();
        }
        return cooksAndTheirDishes.values().stream()
                .filter(Objects::nonNull)
                .flatMap(List::stream)
                .filter(Objects::nonNull)
                .sorted(new DishComparator())
                .collect(Collectors.toList());
    }


    /**
     * Этот метод филтрует список с учетом "капризов короля"
     *
     * @param menu      - уже составленное меню
     * @param predicate - предикат для обработки того или иного "каприза"
     * @return - меню с учетом "капризов"
     */
    public List<Dish> filterByTheWhimsOfTheKing(List<Dish> menu, Predicate<Dish> predicate) {
        return menu.stream().filter(predicate)
                .collect(Collectors.toList());
    }

}
