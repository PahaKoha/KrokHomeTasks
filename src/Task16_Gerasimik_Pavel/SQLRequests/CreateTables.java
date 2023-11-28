package Task16_Gerasimik_Pavel.SQLRequests;

import Task16_Gerasimik_Pavel.DBConnection;

import java.sql.SQLException;
import java.sql.Statement;

public class CreateTables {
    public static void createPersonTable() {
        try (Statement statement = DBConnection.getDbConnection().createStatement()) {
            String createTableRequest = "CREATE TABLE person (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "surname VARCHAR(50) NOT NULL," +
                    "phone_number VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPetTable ()  {
        try (Statement statement = DBConnection.getDbConnection().createStatement()) {
            String createTableRequest = "CREATE TABLE pet (" +
                    "med_card_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "age VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createPersonPetTable()  {
        try (Statement statement = DBConnection.getDbConnection().createStatement()) {
            String createTableRequest = "CREATE TABLE person_pet (" +
                    "person_id INT," +
                    "pet_med_card_id INT," +
                    "PRIMARY KEY (person_id, pet_med_card_id)," +
                    "FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ," +
                    "FOREIGN KEY (pet_med_card_id) REFERENCES pet(med_card_id) ON DELETE CASCADE " +
                    ")";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
