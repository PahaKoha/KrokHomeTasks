package Task13_Gerasimik_Pavel;

import java.time.Instant;
import java.util.Objects;

public class AuctionLot {
    private final String lotName;
    private int currentPrice;
    private String currentUser;
    private final Instant timeUntilLotEnd;
    private final int maxStake;
    private final int minStake;

    public AuctionLot(Instant timeUntilLotEnd, int maxStake, int minStake, String path) {
        this.lotName = ParseLotFile.parseLotFile(path).get(0);
        this.currentPrice = Integer.parseInt(ParseLotFile.parseLotFile(path).get(1));
        this.currentUser = null;
        this.timeUntilLotEnd = timeUntilLotEnd;
        this.maxStake = maxStake;
        this.minStake = minStake;
    }

    public synchronized void stake(int newPrice, String newUser) {
        if (isValidStake(newPrice, newUser)) {
            updateStake(newPrice, newUser);
            printStakeInfo(newPrice, newUser);
            sleep(1000);
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

    private boolean isValidStake(int newPrice, String newUser) {
        return newPrice > currentPrice
                && !timeUntilLotEnd.isBefore(Instant.now())
                && !Objects.equals(newUser, currentUser)
                && newPrice - currentPrice <= maxStake
                && newPrice - currentPrice >= minStake;
    }

    private void updateStake(int newPrice, String newUser) {
        currentPrice = newPrice;
        currentUser = newUser;
    }

    private void printStakeInfo(int newPrice, String newUser) {
        System.out.println("Участник " + newUser + " перебил текущую ставку! " + "Цена лота составляет " + newPrice);
    }

    private void sleep(int timeForSleep) {
        try {
            Thread.sleep(timeForSleep);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
