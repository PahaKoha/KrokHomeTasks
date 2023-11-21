package Task13_Gerasimik_Pavel;

import java.time.Instant;
import java.time.LocalTime;
import java.util.List;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        AuctionLot auctionLot = new AuctionLot(LocalTime.now().plusSeconds(70),
                50000, 20000, "src/Task13_Gerasimik_Pavel/txtFiles/lot.txt");

        System.out.println(auctionLot.getLotName() + " " + UsefulTools.getFormatPrice(auctionLot.getCurrentPrice()));
        Set<String> listWithFutureParticipants = ParseParticipantsFile.participants;

        List<Thread> registeredParticipants =
                RegistrationParticipantForTheLot.registration(listWithFutureParticipants, auctionLot);

        StartAuctionLot.startAuction(registeredParticipants);

        System.out.println("Победитель: " + auctionLot.getWinnerUserName() + "!\n"
                + auctionLot.getWinnerUserName()
                + " забирает текущий лот за " + UsefulTools.getFormatPrice(auctionLot.getCurrentPrice()));
    }
}


