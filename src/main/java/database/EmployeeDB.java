package database;

import Model.Employee;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class EmployeeDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Employee> result = new TreeMap<>();

    public void getListName() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select email , phone , e_id, e_name ,count ,position from Employee  where e_id like '%53%' order by count");

        while (resultSet.next()){

            String email = resultSet.getString("email");
            String phone = resultSet.getString("phone");
            String id = resultSet.getString("e_id");
            String name = resultSet.getString("e_name");
            String count = resultSet.getString("count");
            String position = resultSet.getString("position");

            System.out.println(id +" "+name+" "+email+" "+phone+" "+position+" "+count);
            addMapListName(id,name,email,phone,position,count);
        }
        connection.close();
    }
    public void selectProjectById(String id) throws ClassNotFoundException, SQLException {
        String idEmployee="";
        String nameEmployee ="";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select e_id , e_name from Employee where e_id = '"+id+"'");

        while (resultSet.next()){
            idEmployee = resultSet.getString("e_id");
            nameEmployee = resultSet.getString("e_name");



        }

        connection.close();
        insertEmployee(idEmployee,nameEmployee);

    }
    public Integer checkCountProjectById(String id) throws ClassNotFoundException, SQLException {
        int count = 0;
        Class.forName(dbName);
        Connection connection;
        connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select count  from Employee where e_id = '"+id+"'");
        while (resultSet.next()){
            count = resultSet.getInt("count");
        }

        return count;
    }

    public void updateWorkEmployee(String id) throws ClassNotFoundException, SQLException {
        int count  = checkCountProjectById(id)+1;
        System.out.println(count +" "+id);
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE Employee SET count = '"+count+"' where e_id = '"+id+"'";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();


    }

    //ไม่เขียนลงรายงาน
    public void insertEmployee(String idEmployee, String nameEmployee) throws ClassNotFoundException, SQLException {

        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StorageEmployee (e_id , e_name)"+" values (?, ?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,idEmployee);
        preparedStatement.setString(2,nameEmployee);

        preparedStatement.execute();
        connection.close();


    }
    public String getEmployeeId() throws ClassNotFoundException, SQLException {
        String idEmployee ="";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select e_id  from StorageEmployee");

        while (resultSet.next()){
            idEmployee = resultSet.getString("e_id");

        }
        connection.close();

        return idEmployee;
    }


    public void addMapListName(String id, String name, String email, String phone, String position, String count){
        result.put(id,new Employee(name,position,phone,email,count));
    }

    public Map<String, Employee> getResult(){
        return result;
    }
    //ไม่เขียนลงรายงาน
    public String getNameEmployee() throws ClassNotFoundException, SQLException {
        String nameEmployee = "";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select e_id , e_name from StorageEmployee");

        while (resultSet.next()){
            nameEmployee = resultSet.getString("e_name");


        }

        connection.close();
        return nameEmployee;
    }
    //ไม่เขียนลงรายงาน
    public void deleteAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StorageEmployee";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }
}
