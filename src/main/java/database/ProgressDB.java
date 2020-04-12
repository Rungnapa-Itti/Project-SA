package database;

import Model.Project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class ProgressDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Project> result = new TreeMap<>();

    public void insertWork(String idEmployee ,String idProject , String detail , String date) throws ClassNotFoundException, SQLException {
        System.out.println(idEmployee +" "+idProject +" "+detail+" "+date);
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into Progress (e_id , p_id,detail,report_Date)"+" values (?, ?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,idEmployee);
        preparedStatement.setString(2,idProject);
        preparedStatement.setString(3,detail);
        preparedStatement.setString(4,date);

        preparedStatement.execute();
        connection.close();
    }
}
