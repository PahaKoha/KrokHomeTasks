package Task11_Gerasimik_Pavel;

import java.util.Comparator;

public class DishComparator implements Comparator<Dish> {
    @Override
    public int compare(Dish o1, Dish o2) {
        int kingRatingComparison = o2.getKingRating() - o1.getKingRating();

        if (kingRatingComparison == 0) {
            return o2.getPeopleRating() - o1.getPeopleRating();
        }

        return kingRatingComparison;
    }
}
