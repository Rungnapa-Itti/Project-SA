package database;

import Model.Customer;
import Model.Project;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class ProjectDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Project> result = new TreeMap<>();

    public void selectProjectById(String id) throws ClassNotFoundException, SQLException {
        String idProject="";
        String nameProject ="";
        String detail = "";
        String d_Start ="";
        String d_end = "";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , detail ,d_start,d_end  from Project where p_id = '"+id+"'");

        while (resultSet.next()){
            idProject = resultSet.getString("p_id");
            nameProject = resultSet.getString("p_name");
            detail = resultSet.getString("detail");
            d_Start = resultSet.getString("d_Start");
            d_end = resultSet.getString("d_end");




        }
        System.out.println("test "+idProject+" "+nameProject);
        connection.close();
        insertProject(idProject,nameProject,detail,d_Start,d_end);

    }
    public void updateStatus(String status,String id) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE Project SET status = '"+status+"' where p_id = '"+id+"'";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();


    }
    public void insertProject(String id , String name ,String detail , String dateStrat,String dateEnd) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StorageProject (p_id , p_name , detail , d_start,d_end)"+" values (?, ? , ?,?,?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,detail);
        preparedStatement.setString(4,dateStrat);
        preparedStatement.setString(5,dateEnd);


        preparedStatement.execute();
        connection.close();
        insertStoringProject(id);
    }
    public void insertStoringProject(String id) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StoringProject (p_id )"+" values (?) ";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1,id);


        preparedStatement.execute();
        connection.close();
    }

    public String[] getNameProject() throws ClassNotFoundException, SQLException {
        String[] data = new String[5];
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , detail , d_start,d_end from StorageProject");

        while (resultSet.next()){
            data[0] = resultSet.getString("p_name");
            data[1] = resultSet.getString("detail");
            data[2] = resultSet.getString("d_start");
            data[3] = resultSet.getString("d_end");
            data[4] = resultSet.getString("p_id");


        }
        connection.close();
        return data;
    }


    public void deleteAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StorageProject";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }

    public String getProjectId() throws ClassNotFoundException, SQLException {
        String idProject ="";
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id  from StoringProject");

        while (resultSet.next()){
            idProject = resultSet.getString("p_id");

        }
        connection.close();

        return idProject;
    }
    public void updateWorkEmployee(String idEmployee, String idProject, String dateStart ,String dateEnd) throws ClassNotFoundException, SQLException {


        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE Project SET e_id = '"+idEmployee+"' , status = 'ระหว่างดำเนินการ' ,d_start = '"+dateStart+"' ,d_end ='"+dateEnd+"' where p_id = '"+idProject+"'";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();


    }
    public void upDateSentWorkById(String id) throws ClassNotFoundException, SQLException {
        System.out.println("what is a id "+id);
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "UPDATE Project SET  status = 'รอตรวจสอบ' where p_id = '"+id+"'";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }

    public void deleteAllStoring() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StoringProject";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }

    public Map<String, Project> getMap(){
        return result;
    }

}


