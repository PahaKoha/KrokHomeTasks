package Task13_Gerasimik_Pavel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ParseParticipantsFile {
    public static Set<String> participants = new HashSet<>();
    private ParseParticipantsFile() {

    }
    static {
        try (BufferedReader reader = new BufferedReader(
                new FileReader("src/Task13_Gerasimik_Pavel/txtFiles/participants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participants.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
