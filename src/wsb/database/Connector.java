package wsb.database;

import wsb.Configuration;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Connector {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/oop";
    static private Connection CONNECTION;

    public static void connect() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user", Configuration.USER);
        props.setProperty("password", Configuration.PASS);
        CONNECTION = DriverManager.getConnection(DB_URL, props);
        System.out.println("connected");
    }

    public static Statement getStatement() throws SQLException {
        return CONNECTION.createStatement();
    }

    public static void executeSQL(String sql) throws SQLException {
        CONNECTION.createStatement().execute(sql);
    }
}
