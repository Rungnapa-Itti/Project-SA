package nonuse.db;

import nonuse.classp.Project;

import java.sql.*;

public class StateDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    public static Project project;

    public static void ShowAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Project");

        while (resultSet.next()){

            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String detial = resultSet.getString("detial");
            String startDate = resultSet.getString("startdate");
            String finishDate = resultSet.getString("finishdate");
            String status = resultSet.getString("status");
            String department = resultSet.getString("department");
            String employeeId = resultSet.getString("employeeid");

            project = new Project(id,name,detial,startDate,finishDate,status,department,employeeId);


        }
        connection.close();

    }
}
