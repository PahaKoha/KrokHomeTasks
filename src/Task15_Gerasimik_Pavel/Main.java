package Task15_Gerasimik_Pavel;

import Task15_Gerasimik_Pavel.SQLRequest.TableCreator;
import Task15_Gerasimik_Pavel.SQLRequest.InformationGetter;
import Task15_Gerasimik_Pavel.SQLRequest.TableDataInserter;
import Task16_Gerasimik_Pavel.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try (Connection connection = DBConnector.getDbConnection()) {
            List<String> listWithInformationAboutPersonsAndTheirPest =
                    CSVHandler.getLinesFromCSVFile("src/Task15_Gerasimik_Pavel/informationAboutPersonAndTheirPet.txt");

            TableCreator.createPersonTable(connection);
            TableCreator.createPetTable(connection);
            TableCreator.createPersonPetTable(connection);

            for (String str : listWithInformationAboutPersonsAndTheirPest) {
                TableDataInserter.insertPersonToPersonTable(UsefulTools.parseLinesFromCSVFile(str), connection);
            }
            for (String str : listWithInformationAboutPersonsAndTheirPest) {
                TableDataInserter.insertPetToPetTable(UsefulTools.parseLinesFromCSVFile(str), connection);
            }
            for (String str : listWithInformationAboutPersonsAndTheirPest) {
                TableDataInserter.insertPersonPetRelation(UsefulTools.parseLinesFromCSVFile(str), connection);
            }

            InformationGetter.selectPersonPetData(connection).forEach(str -> System.out.println(str + "-------------"));
        }
    }

}
