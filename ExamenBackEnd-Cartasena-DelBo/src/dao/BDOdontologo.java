package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BDOdontologo {
    private static final String SQL_TABLE_CREATE = "DROP TABLE IF EXISTS ODONTOLOGO;" +
            "CREATE TABLE ODONTOLOGO (" +
            "ID INT AUTO_INCREMENT PRIMARY KEY," +
            "MATRICULA VARCHAR(100) NOT NULL," +
            "NOMBRE VARCHAR(100) NOT NULL," +
            "APELLIDO VARCHAR(100) NOT NULL" +
            ")";
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:./202402",
                "sa", "sa");
    }
    public static void createTable() {
        Connection connection = null;

        try {
            connection = getConnection();

            Statement statement = connection.createStatement();
            statement.execute(SQL_TABLE_CREATE);

        }catch (Exception e) {
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
