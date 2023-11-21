package Task13_Gerasimik_Pavel;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.Random;


public class AuctionLot {
    private final String lotName;
    private int currentPrice;
    private String currentUser;
    private final LocalTime endOfLot;
    private final int maxStake;
    private final int minStake;
    private final Random random = new Random();

    public AuctionLot(LocalTime endOfLot, int maxStake, int minStake, String path) {
        this.lotName = ParseLotFile.parseLotFile(path).get(0);
        this.currentPrice = Integer.parseInt(ParseLotFile.parseLotFile(path).get(1));
        this.currentUser = null;
        this.endOfLot = endOfLot;
        this.maxStake = maxStake;
        this.minStake = minStake;
    }

    public synchronized void stake(int stakePrice, String newUser) {
        if (isValidStake(newUser)) {
            updateStake(stakePrice, newUser);
            printStakeInfo(newUser);
            sleep();
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

    private boolean isValidStake(String newUser) {
        return !endOfLot.isBefore(LocalTime.now()) && !Objects.equals(newUser, currentUser);
    }

    private void updateStake(int stakePrice, String newUser) {
        currentPrice += stakePrice;
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

    private void sleep() {
        try {
            Thread.sleep(random.nextInt(1000, 10000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public int getMaxStake() {
        return maxStake;
    }

    public int getMinStake() {
        return minStake;
    }
}
