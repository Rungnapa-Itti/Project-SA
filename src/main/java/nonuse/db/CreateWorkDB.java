package nonuse.db;

import nonuse.classp.Assignment;

import java.sql.*;

public class CreateWorkDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    protected static Assignment assignment;

    public static void showAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Project");

        if (resultSet.next()){

            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            String detial = resultSet.getString("detial");
            String startDate = resultSet.getString("start date");
            String finishDate = resultSet.getString("finish date");
            String status = resultSet.getString("status");
            String department = resultSet.getString("department");
            String employeeid = resultSet.getString("employeeid");

            assignment = new Assignment(id,name,detial,startDate,finishDate,status,department,employeeid);

        }else{
            assignment = new Assignment("NULL","NULL","NULL","NULL","NULL","NULL","NULL","NULL");
        }

    }
    public static void insert(String pid, String pname, String pdetial, String pstartDate, String pfinnishDate, String pstatus, String pdepartment,String pemployeeid) throws SQLException, ClassNotFoundException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into Project (id,name,detial,startdate,finishdate,status,department,employeeid)"+" values (?, ?, ?, ?, ?, ?, ?, ?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,pid);
        preparedStatement.setString(2,pname);
        preparedStatement.setString(3,pdetial);
        preparedStatement.setString(4,pstartDate);
        preparedStatement.setString(5,pfinnishDate);
        preparedStatement.setString(6,pstatus);
        preparedStatement.setString(7,pdepartment);
        preparedStatement.setString(8,pemployeeid);


        preparedStatement.execute();
        connection.close();
    }
}

