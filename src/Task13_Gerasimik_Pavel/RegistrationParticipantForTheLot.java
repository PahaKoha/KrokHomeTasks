package Task13_Gerasimik_Pavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RegistrationParticipantForTheLot {
    public static List<Thread> registration(Set<String> participants, AuctionLot lot) {
        List<Thread> threadsOfParticipants = new ArrayList<>();
        participants.forEach(participant -> threadsOfParticipants.add(new Thread(new AuctionParticipant(participant, lot))));
        return threadsOfParticipants;
    }

    public static void startAuction (List<Thread> registeredParticipants) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(registeredParticipants.size());
        registeredParticipants.forEach(executorService::execute);
        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.HOURS);
    }
}
