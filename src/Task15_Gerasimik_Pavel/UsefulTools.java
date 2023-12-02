package Task15_Gerasimik_Pavel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsefulTools {
    private UsefulTools () {

    }
    public static void isPersonIdDuplicate(String personId) throws SQLException, ClassNotFoundException, EntityAlreadyExistsException {
        String selectSQL = "SELECT COUNT(*) FROM person WHERE id = ?";

        try (PreparedStatement selectStatement = DBConnector.getDbConnection().prepareStatement(selectSQL)) {
            selectStatement.setString(1, personId);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                throw new EntityAlreadyExistsException(Integer.parseInt(personId), "person");
            }
        }
    }

    public static void isPetIdDuplicate(String medCardId) throws SQLException, ClassNotFoundException, EntityAlreadyExistsException {
        String selectSQL = "SELECT COUNT(*) FROM pet WHERE med_card_id = ?";

        try (PreparedStatement selectStatement = DBConnector.getDbConnection().prepareStatement(selectSQL)) {
            selectStatement.setString(1, medCardId);
            ResultSet resultSet = selectStatement.executeQuery();
            resultSet.next();
            int count = resultSet.getInt(1);
            if (count > 0) {
                throw new EntityAlreadyExistsException(Integer.parseInt(medCardId), "pet");
            }
        }
    }

    public static String[] parseLinesFromCSVFile(String str) {
        return str.split(",");
    }
}
