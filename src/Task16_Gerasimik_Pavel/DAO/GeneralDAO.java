package Task16_Gerasimik_Pavel.DAO;

import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.Entities.Pet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {
    private Connection connection;

    public GeneralDAO(Connection connection) {
        this.connection = connection;
    }

    public List<String> findPersonPhoneNumbersBy(Pet pet) {
        List<String> phoneNumbers = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(
                "SELECT p.phone_number\n" +
                        "FROM person p\n" +
                        "JOIN person_pet pp ON p.id = pp.person_id AND pp.pet_med_card_id = ?")) {

            preparedStatement.setInt(1, pet.getMedCardId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String phoneNumber = resultSet.getString("phone_number");
                phoneNumbers.add(phoneNumber);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return phoneNumbers;
    }

    public List<Pet> getAllPetsOf(Person person) {
        List<Pet> petList = new ArrayList<>();
        String SQLRequest = "SELECT *\n" +
                "FROM pet p\n" +
                "JOIN person_pet pp ON p.med_card_id = pp.pet_med_card_id AND pp.person_id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(SQLRequest)) {
            preparedStatement.setInt(1, person.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pet pet = new Pet(resultSet.getInt("med_card_id"),
                        resultSet.getString("name"), resultSet.getInt("age"));
                petList.add(pet);
            }
            return petList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
