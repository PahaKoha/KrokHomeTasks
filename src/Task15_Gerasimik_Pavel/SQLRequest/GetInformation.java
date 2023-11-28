package Task15_Gerasimik_Pavel.SQLRequest;

import Task15_Gerasimik_Pavel.DBConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetInformation {
    public static List<String> selectPersonPetData()  {
        try (Statement statement = DBConnection.getDbConnection().createStatement()) {
            String SQLRequest = "SELECT " +
                    "person.id AS person_id, " +
                    "person.name AS person_name, " +
                    "person.surname AS person_surname, " +
                    "pet.med_card_id AS pet_med_card_id, " +
                    "pet.name AS pet_name " +
                    "FROM person " +
                    "INNER JOIN person_pet ON person.id = person_pet.person_id " +
                    "INNER JOIN pet ON person_pet.pet_med_card_id = pet.med_card_id";

            try (ResultSet resultSet = statement.executeQuery(SQLRequest)) {
                List<String> information = new ArrayList<>();
                while (resultSet.next()) {
                    int personId = resultSet.getInt("person_id");
                    String personName = resultSet.getString("person_name");
                    String personSurname = resultSet.getString("person_surname");
                    int petMedCardId = resultSet.getInt("pet_med_card_id");
                    String petName = resultSet.getString("pet_name");

                    String result = "Person ID: " + personId + ", \n" +
                            "Person Name: " + personName + ", \n" +
                            "Person Surname: " + personSurname + ", \n" +
                            "Pet Med Card ID: " + petMedCardId + ", \n" +
                            "Pet Name: " + petName + ".\n";

                    information.add(result);
                }
                return information;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
