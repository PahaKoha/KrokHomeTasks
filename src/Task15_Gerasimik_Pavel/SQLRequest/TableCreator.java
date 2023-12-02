package Task15_Gerasimik_Pavel.SQLRequest;

import Task15_Gerasimik_Pavel.DBConnector;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TableCreator {
    private TableCreator() {

    }
    public static void createPersonTable(Connection connection) {
        try (Statement statement = connection.createStatement()) {
            String SQLRequest = "CREATE TABLE person (" +
                    "id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "surname VARCHAR(50) NOT NULL," +
                    "phone_number VARCHAR(50) NOT NULL)";
            statement.executeUpdate(SQLRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void createPetTable (Connection connection)  {
        try (Statement statement = connection.createStatement()) {
            String SQLRequest = "CREATE TABLE pet (" +
                    "med_card_id INT PRIMARY KEY," +
                    "name VARCHAR(50) NOT NULL," +
                    "age VARCHAR(50) NOT NULL)";
            statement.executeUpdate(SQLRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void createPersonPetTable(Connection connection)  {
        try (Statement statement = connection.createStatement()) {
            String SQLRequest = "CREATE TABLE person_pet (" +
                    "person_id INT," +
                    "pet_med_card_id INT," +
                    "PRIMARY KEY (person_id, pet_med_card_id)," +
                    "FOREIGN KEY (person_id) REFERENCES person(id)," +
                    "FOREIGN KEY (pet_med_card_id) REFERENCES pet(med_card_id)" +
                    ")";
            statement.executeUpdate(SQLRequest);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
