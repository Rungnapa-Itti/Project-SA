package database;

import Model.Employee;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class CustomerDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Employee> result = new TreeMap<>();

    public void selectCustomerById(String id) throws ClassNotFoundException, SQLException {
           String arrayCustomer[] = new String[5];
            Class.forName(dbName);
            Connection connection = DriverManager.getConnection(dbURL);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select c_id , c_name ,email , name_company , phone from Customer where c_id = '"+id+"'");

            while (resultSet.next()){
                String idCustomer = resultSet.getString("c_id");
                String name = resultSet.getString("c_name");
                String email = resultSet.getString("email");
                String name_company = resultSet.getString("name_company");
                String phone = resultSet.getString("phone");
                arrayCustomer[0] = idCustomer;
                arrayCustomer[1] = name;
                arrayCustomer[2] = email;
                arrayCustomer[3] = name_company;
                arrayCustomer[4] = phone;


            }
            connection.close();
            insertCustomer(arrayCustomer);

    }
    public void insertCustomer(String[] arrayCustomer) throws ClassNotFoundException, SQLException {

        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StorageCustomer (c_id,c_name,email,name_company,phone)"+" values (?, ?, ?, ?, ?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,arrayCustomer[0]);
        preparedStatement.setString(2,arrayCustomer[1]);
        preparedStatement.setString(3,arrayCustomer[2]);
        preparedStatement.setString(4,arrayCustomer[3]);
        preparedStatement.setString(5,arrayCustomer[4]);




        preparedStatement.execute();
        connection.close();
    }

    public String[] getCustomer() throws SQLException, ClassNotFoundException {
        String array[] = new String[5];
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select c_id , c_name ,email , name_company , phone from StorageCustomer ");

        while (resultSet.next()){
            String idCustomer = resultSet.getString("c_id");
            String name = resultSet.getString("c_name");
            String email = resultSet.getString("email");
            String name_company = resultSet.getString("name_company");
            String phone = resultSet.getString("phone");
            array[0] = idCustomer;
            array[1] = name;
            array[2] = email;
            array[3] = name_company;
            array[4] = phone;

            System.out.println(idCustomer +" "+name+" "+email+" "+name_company+" "+phone);


        }
        connection.close();
        return array;
    }

    public void delectAll() throws ClassNotFoundException, SQLException {

        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StorageCustomer";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();

    }
}
