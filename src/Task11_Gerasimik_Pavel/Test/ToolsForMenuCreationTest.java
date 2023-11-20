package Task11_Gerasimik_Pavel.Test;

import Task11_Gerasimik_Pavel.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToolsForMenuCreationTest {
    ToolsForMenuCreation toolsForMenuCreation;
    Cook cook1;
    Cook cook2;
    Cook cook3;
    Cook cook4;
    Cook cook5;
    Cook cook6;
    Dish dish1;
    Dish dish2;
    Dish dish3;
    Dish dish4;
    Dish dish5;
    Set<String> ingredientsWitchNotOnKitchen;
    Map<Cook, Set<Dish>> cooksAndTheirDishes;

    @BeforeEach
    void initialize() {
        toolsForMenuCreation = new ToolsForMenuCreation();
        cook1 = new Cook("Павел", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.MONDAY)));
        cook2 = new Cook("Матвей", new HashSet<>(Set.of(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY)));
        cook3 = new Cook("Артем", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY)));
        cook4 = new Cook("Всеволод", new HashSet<>(Set.of(DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY)));
        cook5 = new Cook("Сергей", new HashSet<>(Set.of(DayOfWeek.SUNDAY, DayOfWeek.SATURDAY)));
        cook6 = new Cook("Николай", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.MONDAY)));
        dish1 = new Dish("Мороженное", Set.of("молоко", "сливки", "сахар"),
                DishCategory.DESSERT, 100, 100);
        dish2 = new Dish("Жаренная курица", Set.of("курица", "соль"),
                DishCategory.MAIN_DISH, 45, 67);
        dish3 = new Dish("фреш", Set.of("сок", "лёд"),
                DishCategory.DESSERT, 56, 74);
        dish4 = new Dish("Бананый в шокоаде", Set.of("бнаны", "шоколад", "сахар"),
                DishCategory.DESSERT, 90, 80);
        dish5 = new Dish("Золотое яблоко", Set.of("яблоки"),
                DishCategory.DESSERT, 70, 67);
        ingredientsWitchNotOnKitchen = new HashSet<>(Set.of("сок"));
        cooksAndTheirDishes = new HashMap<>();
        cooksAndTheirDishes.put(cook1, Set.of(dish1));
        cooksAndTheirDishes.put(cook2, Set.of(dish3, dish2));
        cooksAndTheirDishes.put(cook3, Set.of(dish3));
        cooksAndTheirDishes.put(cook4, Set.of(dish2));
        cooksAndTheirDishes.put(cook5, Set.of(dish1, dish3));
    }

    @Test
    void createMenuForTodayTest() {
        Set<Dish> dishSet = new TreeSet<>(new DishComparator());
        dishSet.add(dish1);
        dishSet.add(dish2);
        assertEquals(dishSet, toolsForMenuCreation.createMenuForToday(cooksAndTheirDishes, ingredientsWitchNotOnKitchen));
    }

    @Test
    void filterByTheWhimsOfTheKingTest() {
        Set<Dish> testSet = new TreeSet<>(new DishComparator());
        testSet.add(dish4);
        testSet.add(dish1);
        testSet.add(dish5);
        Set<Dish> result = toolsForMenuCreation.filterByTheWhimsOfTheKing(Set.of(dish1, dish2, dish3, dish4, dish5),
                dish -> dish.getCategory() == DishCategory.DESSERT, 3);
        assertEquals(testSet, result);
    }

}