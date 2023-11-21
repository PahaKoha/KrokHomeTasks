package Task13_Gerasimik_Pavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RegistrationParticipantForTheLot {
    private RegistrationParticipantForTheLot() {

    }
    public static List<Thread> registration(Set<String> participants, AuctionLot lot) {
        List<Thread> threadsOfParticipants = new ArrayList<>();
        participants.forEach(participant -> threadsOfParticipants.add(
                new Thread(new AuctionParticipant(participant, lot))));
        return threadsOfParticipants;
    }
}
