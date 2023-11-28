package Task16_Gerasimik_Pavel.DAO;

import Task16_Gerasimik_Pavel.DBConnection;
import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.Entities.Pet;
import Task16_Gerasimik_Pavel.EntityDoNotExistException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PetDAO extends AbstractDAO<Pet> {
    public void createPet(Pet pet, List<Person> personList) {
        try (PreparedStatement statement = DBConnection.getDbConnection().prepareStatement(
                "INSERT INTO pet (med_card_id, name, age) VALUES (?, ?, ?)")) {

            statement.setInt(1, pet.getMedCardId());
            statement.setString(2, pet.getName());
            statement.setInt(3, pet.getAge());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating pet failed, no rows affected.");
            }

            PersonPetDAO.linkPetWithPersons(pet.getMedCardId(), personList);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (EntityDoNotExistException e) {
            System.out.println(this.getClass() + ": " + e.getMessage());
        }
    }

    @Override
    public Pet findEntity(int medCardId) {
        String selectSQL = "SELECT * FROM pet WHERE med_card_id = ?";

        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(selectSQL)) {
            preparedStatement.setInt(1, medCardId);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int medCardIdResult = (resultSet.getInt("med_card_id"));
                    String petName = (resultSet.getString("name"));
                    int petAge = (resultSet.getInt("age"));
                    return new Pet(medCardIdResult, petName, petAge);
                } else {
                    throw new EntityDoNotExistException(medCardId, "pet");
                }
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Pet updateEntity(Pet pet) {
        String SQLRequest = "UPDATE pet SET name=?, age=? WHERE med_card_id=?";
        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(SQLRequest)) {
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setInt(2, pet.getAge());
            preparedStatement.setInt(3, pet.getMedCardId());
            preparedStatement.executeUpdate();
            return pet;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteEntity(int medCardId) {
        String SQLRequest = "DELETE FROM pet WHERE med_card_id=?";

        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(SQLRequest)) {
            preparedStatement.setInt(1, medCardId);
            preparedStatement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
