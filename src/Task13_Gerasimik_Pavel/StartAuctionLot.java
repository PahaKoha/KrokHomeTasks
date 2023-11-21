package Task13_Gerasimik_Pavel;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class StartAuctionLot {
    private StartAuctionLot() {

    }
    public static void startAuction(List<Thread> registeredParticipants) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(registeredParticipants.size());
        registeredParticipants.forEach(executorService::execute);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
