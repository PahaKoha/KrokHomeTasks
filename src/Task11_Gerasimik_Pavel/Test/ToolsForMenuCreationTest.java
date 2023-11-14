package Task11_Gerasimik_Pavel.Test;

import Task11_Gerasimik_Pavel.Cook;
import Task11_Gerasimik_Pavel.Dish;
import Task11_Gerasimik_Pavel.DishCategory;
import Task11_Gerasimik_Pavel.ToolsForMenuCreation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ToolsForMenuCreationTest {
    private Cook cook1;
    private Cook cook2;
    private Dish dish1;
    private Dish dish2;
    private Dish dish3;
    private Dish dish4;
    private Set<String> ingredients;
    private List<Dish> dishList;
    private ToolsForMenuCreation toolsForMenuCreation;
    private Map<Cook, List<Dish>> mapWithCooksAndTheirDishes;

    @BeforeEach
    void initialize() {
        toolsForMenuCreation = new ToolsForMenuCreation();
        mapWithCooksAndTheirDishes = new HashMap<>();
        cook1 = new Cook("Павел", new HashSet<>(Set.of(DayOfWeek.MONDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.THURSDAY, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY)));
        cook2 = new Cook("Матвей", new HashSet<>(Set.of(DayOfWeek.THURSDAY, DayOfWeek.TUESDAY, DayOfWeek.SUNDAY)));
        dish1 = new Dish("dish1", "соль, икра", DishCategory.MAIN_DISH, 43, 98);
        dish2 = new Dish("dish2", "соль, помидоры, картошка, курица", DishCategory.MAIN_DISH, 67, 65);
        dish3 = new Dish("dish3", "сахар, шоколад, бананы", DishCategory.DESSERT, 90, 34);
        dish4 = new Dish("dish4", "картошка, курица", DishCategory.DESSERT, 43, 89);
        ingredients = Set.of("соль", "икра", "помидоры", "курица", "картошка");
        dishList = List.of(dish1, dish2, dish3, dish4);
        mapWithCooksAndTheirDishes.put(cook1, new ArrayList<>(List.of(dish1, dish2)));
        mapWithCooksAndTheirDishes.put(cook2, new ArrayList<>(List.of(dish3, dish4)));
    }

    @Test
    void checkIngredients() {
        boolean result = toolsForMenuCreation.checkIngredients(dish1, ingredients);
        assertTrue(result);
    }

    @Test
    void createMenuForTodayTestLimit() {
        int limit = 2;
        List<Dish> result = toolsForMenuCreation.createMenuForToday(dishList, ingredients, limit);

        assertTrue(limit >= result.size());
    }

    @Test
    void createMenuForTodayTestMenuResult() {
        List<Dish> lisForTest = new ArrayList<>(List.of(new Dish("dish2", "соль, помидоры, картошка, курица", DishCategory.MAIN_DISH, 67, 65)
                , new Dish("dish1", "соль, икра", DishCategory.MAIN_DISH, 43, 98)
                , new Dish("dish4", "картошка, курица", DishCategory.DESSERT, 43, 89)
        ));

        lisForTest.sort((o1, o2) -> {
            int kingRatingComparison = o2.getKingRating() - o1.getKingRating();

            if (kingRatingComparison == 0) {
                return o2.getPeopleRating() - o1.getPeopleRating();
            }

            return kingRatingComparison;
        });

        assertEquals(lisForTest, toolsForMenuCreation.createMenuForToday(dishList, ingredients, 5));
    }

    @Test
    void createMenuForTodayTestNullDishesList() {
        List<Dish> result = toolsForMenuCreation.createMenuForToday(null, ingredients, 2);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }


    @Test
    void checkCookWorkDaysTestResult() {
        Map<Cook, List<Dish>> expectedMap = new HashMap<>();

        expectedMap.put(cook1, new ArrayList<>(List.of(dish1, dish2)));

        assertEquals(expectedMap, toolsForMenuCreation.checkCookWorkDays(mapWithCooksAndTheirDishes));
    }

    @Test
    void checkCookWorkDaysTestNullValue() {
        Map<Cook, List<Dish>> expectedMap = new HashMap<>();
        expectedMap.put(null, null);
        Map<Cook, List<Dish>> result = toolsForMenuCreation.checkCookWorkDays(expectedMap);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void checkTheCooksListOfDishesForTodayTestResult() {
        List<Dish> result = new ArrayList<>(List.of(dish1, dish2, dish3, dish4));

        result.sort((o1, o2) -> {
            int kingRatingComparison = o2.getKingRating() - o1.getKingRating();

            if (kingRatingComparison == 0) {
                return o2.getPeopleRating() - o1.getPeopleRating();
            }

            return kingRatingComparison;
        });

        assertEquals(result, toolsForMenuCreation.checkTheCooksListOfDishesForToday(mapWithCooksAndTheirDishes));
    }

    @Test
    void checkTheCooksListOfDishesForTodayTestListByNull() {
        Map<Cook, List<Dish>> expectedMap = new HashMap<>();
        expectedMap.put(cook1, null);

        List<Dish> result = toolsForMenuCreation.checkTheCooksListOfDishesForToday(expectedMap);

        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void isDishNullTest() {
        Dish dish = null;
        assertFalse(toolsForMenuCreation.isDishNull(dish));
    }

    @Test
    void filterByTheWhimsOfTheKing() {
        List<Dish> testList = List.of(dish3, dish4);
        List<Dish> result = toolsForMenuCreation.filterByTheWhimsOfTheKing(List.copyOf(dishList), dish -> dish.getCategory() == DishCategory.DESSERT);
        assertEquals(testList, result);
    }
}