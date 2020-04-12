package nonuse.db;

import nonuse.classp.Employee;

import java.sql.*;

public class RegisterDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    protected static Employee employee;

    public static void showAll(String managerId) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("");

        if (resultSet.next()){

            


            connection.close();
        }
        else{

        }

    }

}
