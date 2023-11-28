package Task13_Gerasimik_Pavel;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {
    private FileReader() {

    }
    public static List<String> getInformationFromFile(String path) {
        List<String> lotInformationList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lotInformationList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lotInformationList;
    }
}
