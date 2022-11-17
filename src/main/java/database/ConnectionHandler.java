package database;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {

    private static Connection connection;

    public static Connection getInstance()  {
        if (connection == null) {
            try {
                connect();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return connection;
    }

    private static void connect() throws IOException {
        InputStream file = new FileInputStream("src/main/java/database/database.properties");
        Properties config = new Properties();
        config.load(file);

        String dbAddress = config.getProperty("db.address");
        String dbLogin = config.getProperty("db.login");
        String dbPassword = config.getProperty("db.password");

        try {
            connection = DriverManager.getConnection(dbAddress, dbLogin, dbPassword);
            System.out.println("Successfully connected to PostgreSQL server!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disconnect() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
