package wsb.database;

import wsb.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/oop";

    public static void connect() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", Configuration.USER);
        props.setProperty("password", Configuration.PASS);
        Connection conn = DriverManager.getConnection(DB_URL, props);
        System.out.println("connected");
        Statement statement = conn.createStatement();

        statement.execute("select * from animal");
    }
}
