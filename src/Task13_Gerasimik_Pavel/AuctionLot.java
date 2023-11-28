package Task13_Gerasimik_Pavel;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Objects;


public class AuctionLot {
    private final String lotName;
    private int currentPrice;
    private String currentUser;
    private final LocalTime endOfLot;
    private static final Object lock = new Object();

    public AuctionLot(LocalTime endOfLot, List<String> lotInformation) {
        this.lotName = lotInformation.get(0);
        this.currentPrice = Integer.parseInt(lotInformation.get(1));
        this.currentUser = null;
        this.endOfLot = endOfLot;
    }

    public synchronized void stake(int stakePrice, String newUser) {
        if (isValidStake(newUser, stakePrice)) {
            updateStake(stakePrice, newUser);
            printStakeInfo(newUser);
        }

    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public String getLotName() {
        return this.lotName;
    }

    public String getWinnerUserName() {
        return currentUser;
    }

    private boolean isValidStake(String newUser, int stakePrice) {
        return currentPrice < stakePrice &&
                !endOfLot.isBefore(LocalTime.now()) &&
                !Objects.equals(newUser, currentUser);
    }

    private void updateStake(int stakePrice, String newUser) {
        currentPrice = stakePrice;
        currentUser = newUser;
    }

    private void printStakeInfo(String newUser) {
        String timeUntilEnd = (LocalTime.now().until(endOfLot, ChronoUnit.SECONDS)) >= 60
                ? LocalTime.now().until(endOfLot, ChronoUnit.MINUTES) + " minutes."
                : LocalTime.now().until(endOfLot, ChronoUnit.SECONDS) + " seconds.";
        System.out.println(UsefulTools.getClearOutputTime(LocalTime.now()) + ": Участник " + newUser
                + " перебил текущую ставку! " + "Цена лота составляет " + UsefulTools.getFormatPrice(currentPrice)
                + ".  ВРЕМЯ ДО КОНЦА ЛОТА: " + timeUntilEnd);
    }
}
