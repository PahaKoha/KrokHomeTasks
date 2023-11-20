package Task13_Gerasimik_Pavel;

import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AuctionLot auctionLot = new AuctionLot(Instant.now().plusSeconds(20), 50000, 1000,"src/Task13_Gerasimik_Pavel/txtFiles/lot.txt");
        System.out.println(auctionLot.getLotName() + " " + auctionLot.getCurrentPrice());
        Set<String> listWithFutureParticipants = ParseParticipantsFile.participants;
        List<Thread> registeredParticipants = RegistrationParticipantForTheLot.registration(listWithFutureParticipants, auctionLot);
        RegistrationParticipantForTheLot.startAuction(registeredParticipants);
        System.out.println("Победитель: " + auctionLot.getWinnerUserName() + "!\n"
                + auctionLot.getWinnerUserName() + " забирает текущий лот за " + auctionLot.getCurrentPrice());
    }
}


