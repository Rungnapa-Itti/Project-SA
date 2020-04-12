package database;

import Model.Project;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class StateOnclickDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Project> result = new TreeMap<>();

    public void insertState(String state) throws ClassNotFoundException, SQLException {
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StateOnClick (state)"+" values (?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, state);

        preparedStatement.execute();
        connection.close();

    }
    public void deleteAll() throws SQLException, ClassNotFoundException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StateOnClick ";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }
    public String selectState ()throws ClassNotFoundException, SQLException {
        System.out.println("test t");
        String state ="";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select state from StateOnClick");

        while (resultSet.next()){
            state = resultSet.getString("state");


        }


        connection.close();
        return state;
    }
}
