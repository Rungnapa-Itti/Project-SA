package database;

import javafx.scene.control.Label;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterCutomerDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";

    public void insertCustomer(String id, String department, String customerName, String phone, String email) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into Customer (c_id,c_name,email,name_company,phone)"+" values (?, ?, ?, ?, ?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,customerName);
        preparedStatement.setString(3,email);
        preparedStatement.setString(4,department    );
        preparedStatement.setString(5,phone);




        preparedStatement.execute();
        connection.close();
    }
}
