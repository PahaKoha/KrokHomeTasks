package Task11_Gerasimik_Pavel;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ToolsForMenuCreation {
    /**
     * Этот метод проверяет, может ли быть приготовлено блюдо с учетом отсутствующих ингредиентов на кухне.
     *
     * @param dish                         - блюдо с ингредиентами для проверки.
     * @param ingredientsWitchNotOnKitchen - ингредиенты, которых нет на кухне.
     * @return - если в set ingredientsWitchNotOnKitchen есть хотя бы один ингредиент из списка ингредиентов для блюда,
     * то ворзвращает false, в противном случае - true.
     */
    private boolean checkIngredients(Dish dish, Set<String> ingredientsWitchNotOnKitchen) {
        return dish.getIngredients().stream().noneMatch(ingredientsWitchNotOnKitchen::contains);
    }

    /**
     * Этот метод составляет список из блюд, которые могут быть приготовлены сегодня.
     *
     * @param cooksAndTheirDishes          - список всех поваров и их блюд.
     * @param ingredientsWitchNotOnKitchen - ингредиенты, которых нет на кухне.
     * @return - возвращает set с блюдами, которые могут быть приготовлены сегодня.
     */
    public Set<Dish> createMenuForToday(Map<Cook, Set<Dish>> cooksAndTheirDishes, Set<String> ingredientsWitchNotOnKitchen) {
        if (cooksAndTheirDishes == null) {
            return Collections.emptySet();
        }
        return checkTheCooksListOfDishesForToday(cooksAndTheirDishes).stream()
                .filter(dish -> checkIngredients(dish, ingredientsWitchNotOnKitchen))
                .collect(Collectors.toCollection(() -> new TreeSet<>(new DishComparator())));
    }

    /**
     * @param cooksAndTheirDishes - список всех поваров и их блюд.
     * @return - возвращает список поваров, которые могут работать в этот день.
     */
    private Set<Cook> setWithCooksWhichWorkToday(Map<Cook, Set<Dish>> cooksAndTheirDishes) {
        return cooksAndTheirDishes.keySet().stream()
                .filter(key -> key != null && key.getWorkDays().contains(LocalDate.now().getDayOfWeek()))
                .collect(Collectors.toSet());
    }

    /**
     * @param cooksAndTheirDishes - список всех поваров и их блюд.
     * @return - возвращает объединенный сет из блюд, которые могут приготовить повара сегодня.
     */
    private Set<Dish> checkTheCooksListOfDishesForToday(Map<Cook, Set<Dish>> cooksAndTheirDishes) {
        if (cooksAndTheirDishes == null) {
            return Collections.emptySet();
        }
        return cooksAndTheirDishes.entrySet().stream()
                .filter(entry -> setWithCooksWhichWorkToday(cooksAndTheirDishes).contains(entry.getKey()))
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toSet());
    }


    /**
     * @param menu - составленное меню без учета "капризов" короля.
     * @param predicate - предикат для преобразования меню с учетом капризов кораля.
     * @param limit - максимальное кол-во блюд.
     * @return - возвращает отфильтрованное меню.
     */
    public Set<Dish> filterByTheWhimsOfTheKing(Set<Dish> menu, Predicate<Dish> predicate, int limit) {
        return menu.stream().filter(predicate)
                .sorted(new DishComparator())
                .limit(limit)
                .collect(Collectors.toSet());
    }
}
