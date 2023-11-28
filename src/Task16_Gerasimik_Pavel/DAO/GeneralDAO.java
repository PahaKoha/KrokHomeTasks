package Task16_Gerasimik_Pavel.DAO;

import Task16_Gerasimik_Pavel.DBConnection;
import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.Entities.Pet;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneralDAO {
    public List<String> findPersonPhoneNumbersBy(Pet pet) {
        List<String> phoneNumbers = new ArrayList<>();

        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(
                "SELECT p.phone_number " +
                        "FROM person p " +
                        "JOIN person_pet pp ON p.id = pp.person_id " +
                        "JOIN pet pet ON pp.pet_med_card_id = pet.med_card_id " +
                        "WHERE pet.med_card_id = ?")) {

            preparedStatement.setInt(1, pet.getMedCardId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String phoneNumber = resultSet.getString("phone_number");
                phoneNumbers.add(phoneNumber);
            }

        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return phoneNumbers;
    }

    public List<Pet> getAllPetsOf(Person person) {
        List<Pet> petList = new ArrayList<>();
        String SQLRequest = "SELECT * " +
                "FROM pet p " +
                "JOIN person_pet pp ON p.med_card_id=pp.pet_med_card_id " +
                "JOIN person person ON pp.person_id=person.id " +
                "WHERE person.id = ?";
        try (PreparedStatement preparedStatement = DBConnection.getDbConnection().prepareStatement(SQLRequest)) {
            preparedStatement.setInt(1, person.getId());
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Pet pet = new Pet(resultSet.getInt("med_card_id"),
                        resultSet.getString("name"), resultSet.getInt("age"));
                petList.add(pet);
            }
            return petList;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
