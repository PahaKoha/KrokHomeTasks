package Task15_Gerasimik_Pavel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CSVHandler {
    public static List<String> getLinesFromCSVFile(String path) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(path))) {
            List<String> listWithLineFromCSVFile = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                listWithLineFromCSVFile.add(line);
            }
            return listWithLineFromCSVFile;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
