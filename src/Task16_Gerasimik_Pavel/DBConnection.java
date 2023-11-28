package Task16_Gerasimik_Pavel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String JDBC_URL_PREFIX = "jdbc:h2:mem:./testDB";
    private static final String DB_NAME = "sa";
    private static final String DB_PASSWORD = "";

    public static Connection getDbConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection(JDBC_URL_PREFIX,
                DB_NAME, DB_PASSWORD);
    }
}

