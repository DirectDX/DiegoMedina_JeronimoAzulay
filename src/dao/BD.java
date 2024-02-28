package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    public static Connection getConnection() throws Exception {
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./JeronimoAzulay_DiegoMedina",
                "sa", "sa");
    }
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS ODONTOLOGOS;" +
            "CREATE TABLE ODONTOLOGOS (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "MATRICULA VARCHAR(100) NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL)";

    public static void createTableOdontologos() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
