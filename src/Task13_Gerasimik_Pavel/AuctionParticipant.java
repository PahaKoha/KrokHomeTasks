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
        priceWhichUserCanStake = lot.getCurrentPrice() + randomPrice.nextInt(20000, 50000);
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            lot.stake(priceWhichUserCanStake, name);
            priceWhichUserCanStake = randomPrice.nextInt();
        }
    }
}
