package wsb.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Connector {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/oop";
    static final String USER = "postgres";
    static final String PASS = "sela1234";

    public static void connect() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASS);
        Connection conn = DriverManager.getConnection(DB_URL, props);
        System.out.println("connected");
    }
}
