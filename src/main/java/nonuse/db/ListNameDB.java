package nonuse.db;

import nonuse.classp.Employee;

import java.sql.*;

public class ListNameDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    protected static Employee employee;

    public static void showAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Employee");

        while (resultSet.next()){

            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String phone = resultSet.getString("phone");
            String email = resultSet.getString("e-mail");
            String managerid = resultSet.getString("managerid");
            String projectid = resultSet.getString("projectid");

            employee = new Employee(id,name,phone,email,managerid,projectid);

        }
        connection.close();
    }
}
