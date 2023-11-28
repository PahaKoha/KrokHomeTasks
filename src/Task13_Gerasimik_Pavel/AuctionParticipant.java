package Task13_Gerasimik_Pavel;

import java.util.Random;

public class AuctionParticipant implements Runnable {
    private final String name;
    private final AuctionLot lot;
    private int priceWhichUserCanStake;
    private final Random randomPrice = new Random();

    public AuctionParticipant(String name, AuctionLot lot) {
        this.name = name;
        this.lot = lot;
        setPriceWhichUserCanStake();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            lot.stake(priceWhichUserCanStake, name);
            setPriceWhichUserCanStake();
        }
    }

    public void setPriceWhichUserCanStake() {
        priceWhichUserCanStake = randomPrice.nextInt(100000, 10000000);
    }
}
