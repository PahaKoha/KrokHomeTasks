package Task16_Gerasimik_Pavel.DAO;

import Task16_Gerasimik_Pavel.DBConnection;
import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.EntityDoNotExistException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonDAO extends AbstractDAO<Person>{
    public void createPerson(Person person) {
        String selectSQL = "SELECT COUNT(*) FROM person WHERE id = ?";
        String insertDataSQL = "INSERT INTO person (id, name, surname, phone_number) VALUES (?,?,?,?)";

        try (PreparedStatement selectStatement = DBConnection.getDbConnection().prepareStatement(selectSQL);
             PreparedStatement insertStatement = DBConnection.getDbConnection().prepareStatement(insertDataSQL)) {

            selectStatement.setInt(1, person.getId());
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();

            int count = resultSet.getInt(1);
            if (count == 0) {
                insertStatement.setInt(1, person.getId());
                insertStatement.setString(2, person.getName());
                insertStatement.setString(3, person.getSurname());
                insertStatement.setString(4, person.getPhoneNumber());
                insertStatement.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Person findEntity(int id) {
        String selectSQL = "SELECT * FROM person WHERE id = ?";

        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int personId =(resultSet.getInt("id"));
                    String personName = (resultSet.getString("name"));
                    String personSurname = (resultSet.getString("surname"));
                    String personPhoneNumber = (resultSet.getString("phone_number"));
                    return new Person(personId, personName, personSurname, personPhoneNumber);
                } else {
                    throw new EntityDoNotExistException(id, "person");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);        }
    }

    @Override
    public Person updateEntity(Person person) {
        String SQLRequest = "UPDATE person SET name=?, surname=?, phone_number=? WHERE id=?";
        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(SQLRequest)) {
            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getSurname());
            preparedStatement.setString(3, person.getPhoneNumber());
            preparedStatement.setInt(4, person.getId());
            preparedStatement.executeUpdate();
            return person;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(int id) {
        String SQLRequest = "DELETE FROM person WHERE id=?";

        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(SQLRequest)) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
