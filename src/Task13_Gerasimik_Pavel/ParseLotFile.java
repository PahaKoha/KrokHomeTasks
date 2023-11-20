package Task13_Gerasimik_Pavel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ParseLotFile {
    public static List<String> parseLotFile(String path) {
        List<String> lotInformationList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
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
