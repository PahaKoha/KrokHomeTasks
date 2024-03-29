package Task15_Gerasimik_Pavel.SQLRequest;

import Task15_Gerasimik_Pavel.DBConnector;
import Task15_Gerasimik_Pavel.EntityAlreadyExistsException;
import Task15_Gerasimik_Pavel.UsefulTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collections;


public class TableDataInserter {
    private TableDataInserter () {

    }
    public static void insertPersonToPersonTable(String[] data, Connection connection) {
        String SQLRequest = "INSERT INTO person (id, name, surname, phone_number) VALUES (?,?,?,?)";

        try (PreparedStatement insertStatement = connection.prepareStatement(SQLRequest)) {
            UsefulTools.isPersonIdDuplicate(data[0]);
            insertStatement.setString(1, data[0]);
            insertStatement.setString(2, data[1]);
            insertStatement.setString(3, data[2]);
            insertStatement.setString(4, data[3]);
            insertStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EntityAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertPetToPetTable(String[] data, Connection connection) {
        String insertDataSQL = "INSERT INTO pet (med_card_id, name, age) VALUES (?,?,?)";

        try (PreparedStatement insertStatement = connection.prepareStatement(insertDataSQL)) {
            UsefulTools.isPetIdDuplicate(data[4]);
            insertStatement.setString(1, data[4]);
            insertStatement.setString(2, data[5]);
            insertStatement.setString(3, data[6]);
            insertStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EntityAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void insertPersonPetRelation(String[] data, Connection connection) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO person_pet (person_id, pet_med_card_id) VALUES (?, ?)")) {
            preparedStatement.setString(1, data[0]);
            preparedStatement.setString(2, data[4]);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
