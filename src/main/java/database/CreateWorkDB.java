package database;

import Model.Customer;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class CreateWorkDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String,Customer> result = new TreeMap<>();




    public void getNameCustomer() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Customer ");

        while (resultSet.next()){

            String id = resultSet.getString("c_id");
            String name = resultSet.getString("c_name");
            String email = resultSet.getString("email");
            String nameCompany = resultSet.getString("name_company");
            String phone = resultSet.getString("phone");
            addMap(id,name,email,nameCompany,phone);

        }
        connection.close();
    }

    public void createProject(String p_id, String p_name , String idCustomer, String detail ) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into Project (p_id,p_name,c_id,status,detail)"+" values (?, ?, ?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,p_id);
        preparedStatement.setString(2,p_name);
        preparedStatement.setString(3,idCustomer);
        preparedStatement.setString(4,"ยังไม่ได้มอบหมาย");
        preparedStatement.setString(5,detail);




        preparedStatement.execute();
        connection.close();
    }



    public void addMap(String id, String name, String email , String nameCompany, String phone) {
        this.result.put(id,new Customer(name,email,nameCompany,phone));
    }

    public Map<String,Customer> getResult(){
        return result;
    }


}
