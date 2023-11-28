package Task16_Gerasimik_Pavel.DAO;

import Task16_Gerasimik_Pavel.DBConnection;
import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.EntityDoNotExistException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PersonPetDAO {
    public static void linkPetWithPersons(int medCardId, List<Person> personList) throws SQLException, ClassNotFoundException, EntityDoNotExistException {
        try (PreparedStatement statement = DBConnection.getDbConnection().prepareStatement(
                "INSERT INTO person_pet (person_id, pet_med_card_id) VALUES (?, ?)")) {
            PersonDAO personDAO = new PersonDAO();
            for (Person person : personList) {
                personDAO.findEntity(person.getId());
                statement.setInt(1, person.getId());
                statement.setInt(2, medCardId);
                statement.executeUpdate();
            }
        }
    }
}
