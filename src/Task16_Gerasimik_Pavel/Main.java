package Task16_Gerasimik_Pavel;

import Task15_Gerasimik_Pavel.DBConnector;
import Task16_Gerasimik_Pavel.DAO.GeneralDAO;
import Task16_Gerasimik_Pavel.DAO.PetDAO;
import Task16_Gerasimik_Pavel.DAO.PersonDAO;
import Task16_Gerasimik_Pavel.Entities.Person;
import Task16_Gerasimik_Pavel.Entities.Pet;
import Task16_Gerasimik_Pavel.SQLRequests.TablesCreator;
import Task16_Gerasimik_Pavel.SQLRequests.InformationGetter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, EntityDoNotExistException {
        try (Connection connection = DBConnector.getDbConnection()) {
            TablesCreator.createPersonTable(connection);
            TablesCreator.createPetTable(connection);
            TablesCreator.createPersonPetTable(connection);

            PersonDAO personDAO = new PersonDAO(connection);
            PetDAO petDAO = new PetDAO(connection);
            GeneralDAO generalDAO = new GeneralDAO(connection);

            Person person1 = new Person(1, "Павел", "Герасимик", "+79142132176");
            Person person2 = new Person(2, "Артем", "Вичук", "+79245678904");
            Person person3 = new Person(3, "Матвей", "Русс", "+79244574745");
            Person person4 = new Person(4, "Алексей", "Стрельцов", "+79245873498");
            Pet pet1 = new Pet(1, "Бублик", 4);
            Pet pet2 = new Pet(2, "Сахарок", 8);
            Pet pet3 = new Pet(3, "Чипа", 3);
            Pet pet4 = new Pet(4, "Каво", 7);
            List<Person> personListForPet1 = new ArrayList<>();
            List<Person> personListForPet2 = new ArrayList<>();
            List<Person> personListForPet3 = new ArrayList<>();
            List<Person> personListForPet4 = new ArrayList<>();
            personListForPet1.add(person1);
            personListForPet1.add(person3);
            personListForPet2.add(person2);
            personListForPet3.add(person4);
            personListForPet4.add(person4);

            try {
                personDAO.createPerson(person1);
                personDAO.createPerson(person2);
                personDAO.createPerson(person3);
                personDAO.createPerson(person4);
                System.out.println("Поиск person по id: " + personDAO.findEntity(2));
                System.out.println("Изменение person по id и return уже нового person: " + personDAO.updateEntity(
                        new Person(1, "Илья", "Рябко", "+79243179260")));
                personDAO.deleteEntity(2);


                petDAO.createPet(pet1, personListForPet1);
                petDAO.createPet(pet2, personListForPet2);
                petDAO.createPet(pet3, personListForPet3);
                petDAO.createPet(pet4, personListForPet4);
                System.out.println("Поиск pet по id: " + petDAO.findEntity(3));
                System.out.println("Изменение pet по id и return уже нового pet: " + petDAO.updateEntity(
                        new Pet(2, "Котик", 8)
                ));
                petDAO.deleteEntity(2);


                System.out.println("Информациия по всем person и их pet:");
                InformationGetter.selectPersonPetData(connection).forEach(System.out::println);
                System.out.println("Номера телефонов persons для определенного pet:");
                generalDAO.findPersonPhoneNumbersBy(pet1).forEach(System.out::println);
                System.out.println("Список pet для определенного person:");
                generalDAO.getAllPetsOf(person4).forEach(System.out::println);

            } catch (EntityDoNotExistException e) {
                System.out.println("Main: " + e.getMessage());
            } catch (PersonAlreadyExistsException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
