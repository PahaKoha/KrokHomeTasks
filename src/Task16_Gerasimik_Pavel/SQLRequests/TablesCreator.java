package Task16_Gerasimik_Pavel.SQLRequests;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TablesCreator {
    public static void createPersonTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String createTableRequest = "CREATE TABLE person (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "surname VARCHAR(50) NOT NULL," +
                    "phone_number VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPetTable (Connection connection)  {
        try (Statement statement = connection.createStatement()) {
            String createTableRequest = "CREATE TABLE pet (" +
                    "med_card_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "age VARCHAR(50) NOT NULL)";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createPersonPetTable(Connection connection)  {
        try (Statement statement = connection.createStatement()) {
            String createTableRequest = "CREATE TABLE person_pet (" +
                    "person_id INT," +
                    "pet_med_card_id INT," +
                    "PRIMARY KEY (person_id, pet_med_card_id)," +
                    "FOREIGN KEY (person_id) REFERENCES person(id) ON DELETE CASCADE ," +
                    "FOREIGN KEY (pet_med_card_id) REFERENCES pet(med_card_id) ON DELETE CASCADE " +
                    ")";
            statement.executeUpdate(createTableRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
