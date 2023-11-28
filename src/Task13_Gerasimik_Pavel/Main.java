package Task13_Gerasimik_Pavel;

import java.time.LocalTime;
import java.util.List;



public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> lotInformation = FileReader.getInformationFromFile("src/Task13_Gerasimik_Pavel/txtFiles/lot.txt");
        AuctionLot auctionLot = new AuctionLot(LocalTime.now().plusSeconds(60), lotInformation);

        System.out.println(auctionLot.getLotName() + " " + UsefulTools.getFormatPrice(auctionLot.getCurrentPrice()));
        List<String> listWithFutureParticipants = FileReader.getInformationFromFile("src/Task13_Gerasimik_Pavel/txtFiles/participants.txt");

        List<Thread> registeredParticipants =
                RegistrationParticipantForTheLot.registration(listWithFutureParticipants, auctionLot);

        StartAuctionLot.startAuction(registeredParticipants);

        System.out.println("Победитель: " + auctionLot.getWinnerUserName() + "!\n"
                + auctionLot.getWinnerUserName()
                + " забирает текущий лот за " + UsefulTools.getFormatPrice(auctionLot.getCurrentPrice()));
    }

}


