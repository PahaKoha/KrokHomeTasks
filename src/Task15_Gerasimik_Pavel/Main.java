package Task15_Gerasimik_Pavel;

import Task15_Gerasimik_Pavel.SQLRequest.CreateTables;
import Task15_Gerasimik_Pavel.SQLRequest.GetInformation;
import Task15_Gerasimik_Pavel.SQLRequest.InsertToTable;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        List<String> listWithInformationAboutPersonsAndTheirPest =
                CSVHandler.getLinesFromCSVFile("src/Task15_Gerasimik_Pavel/informationAboutPersonAndTheirPet.txt");

        CreateTables.createPersonTable();
        CreateTables.createPetTable();
        CreateTables.createPersonPetTable();

        for (String str : listWithInformationAboutPersonsAndTheirPest) {
            InsertToTable.insertPersonToPersonTable(UsefulTools.parseLinesFromCSVFile(str));
        }
        for (String str : listWithInformationAboutPersonsAndTheirPest) {
            InsertToTable.insertPetToPetTable(UsefulTools.parseLinesFromCSVFile(str));
        }
        for (String str : listWithInformationAboutPersonsAndTheirPest) {
            InsertToTable.insertPersonPetRelation(UsefulTools.parseLinesFromCSVFile(str));
        }

        GetInformation.selectPersonPetData().forEach(str -> System.out.println(str + "-------------"));
    }


}
