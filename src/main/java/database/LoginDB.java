package database;

import nonuse.classp.Manager;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoginDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    public static Manager manager;

    public static String login(String e_id, String password) throws ClassNotFoundException, SQLException {


        String id = "null";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select e_id from User where e_id = '"+e_id+"' and password = '"+password+"'");

        if (resultSet.next()){
            id = resultSet.getString("e_id");

        }
        System.out.println(id);
        connection.close();

        return id;
    }
    public void updateStateLogin(String id,String date) throws SQLException, ClassNotFoundException {

        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE User SET state = 1 , date ='"+date+"' where e_id = '"+id+"'" ;
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }
    public void updateStateLogout(String id ,String date ) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE User SET state = 0 , date ='"+date+"' where e_id = '"+id+"'";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }
    public String getId() throws ClassNotFoundException, SQLException {
        String id ="";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select e_id from User where  state = 1");

        if (resultSet.next()){
            id = resultSet.getString("e_id");

        }
        System.out.println(id);
        connection.close();
        return id;
    }
}
