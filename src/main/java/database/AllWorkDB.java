package database;

import Model.Project;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class AllWorkDB {
    private static String dbURL = "jdbc:sqlite:Database.db";
    private static String  dbName = "org.sqlite.JDBC";
    private Map<String, Project> result = new TreeMap<>();


    public void getAllWork() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , x.e_name , p_name,y.name_company,d_start,d_end,status,detail from Project,Employee x ,Customer y where Project.e_id = x.e_id and Project.c_id = y.c_id");

        while (resultSet.next()){

            String id = resultSet.getString("p_id");
            String e_name = resultSet.getString("e_name");
            String p_name = resultSet.getString("p_name");
            String c_name = resultSet.getString("name_company");
            String d_start = resultSet.getString("d_start");
            String d_end = resultSet.getString("d_end");
            String status = resultSet.getString("status");
            String detail = resultSet.getString("detail");


            addMapAllWork(id,p_name,e_name,c_name,d_start,d_end,status,detail);
        }
        connection.close();
    }

    public void getFinishWork() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , x.e_name , p_name,y.name_company,d_start,d_end,status,detail from Project,Employee x ,Customer y where Project.e_id = x.e_id and Project.c_id = y.c_id and status = 'ปิดงาน'");

        while (resultSet.next()){

            String id = resultSet.getString("p_id");
            String e_name = resultSet.getString("e_name");
            String p_name = resultSet.getString("p_name");
            String c_name = resultSet.getString("name_company");
            String d_start = resultSet.getString("s_start");
            String d_end = resultSet.getString("d_end");
            String status = resultSet.getString("status");
            String detail = resultSet.getString("detail");


            addMapAllWork(id,p_name,e_name,c_name,d_start,d_end,status,detail);
        }
        connection.close();
    }

    public void getDoing() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , x.e_name , p_name,y.name_company,d_start,d_end,status ,detail from Project,Employee x ,Customer y where Project.e_id = x.e_id and Project.c_id = y.c_id and status = 'ระหว่างดำเนินการ'");

        while (resultSet.next()){

            String id = resultSet.getString("p_id");
            String e_name = resultSet.getString("e_name");
            String p_name = resultSet.getString("p_name");
            String c_name = resultSet.getString("name_company");
            String d_start = resultSet.getString("d_start");
            String d_end = resultSet.getString("d_end");
            String status = resultSet.getString("status");
            String detail = resultSet.getString("detail");


            addMapAllWork(id,p_name,e_name,c_name,d_start,d_end,status,detail);
        }
        connection.close();
    }

    public void getNotEmployee() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id  , p_name,y.name_company ,status , detail from Project ,Customer y where Project.c_id = y.c_id and status = 'ยังไม่ได้มอบหมาย'");

        while (resultSet.next()){

            String id = resultSet.getString("p_id");
            String p_name = resultSet.getString("p_name");
            String c_name = resultSet.getString("name_company");
            String status = resultSet.getString("status");
            String detail = resultSet.getString("detail");


            System.out.println(id +" "+p_name+" "
                    +c_name+" "+status);
            //addMapStorang(id,p_name,c_name,status,detail);
            addMapAllWork(id,p_name,"",c_name,"","",status,detail);
        }
        connection.close();
    }
    public void getWaitingVerify() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , x.e_name , p_name,y.name_company,d_start,d_end,status ,detail from Project,Employee x ,Customer y where Project.e_id = x.e_id and Project.c_id = y.c_id and status = 'รอตรวจสอบ'");

        while (resultSet.next()){

            String id = resultSet.getString("p_id");
            String e_name = resultSet.getString("e_name");
            String p_name = resultSet.getString("p_name");
            String c_name = resultSet.getString("name_company");
            String d_start = resultSet.getString("s_start");
            String d_end = resultSet.getString("d_end");
            String status = resultSet.getString("status");
            String detail = resultSet.getString("detail");


            addMapAllWork(id,p_name,e_name,c_name,"","",status,detail);
        }
        connection.close();
    }
     public void getEditProject() throws ClassNotFoundException, SQLException {
         result.clear();
         Class.forName(dbName);
         Connection connection = DriverManager.getConnection(dbURL);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery("select p_id , x.e_name , p_name,y.name_company,d_start,d_end,status ,detail from Project,Employee x ,Customer y where Project.e_id = x.e_id and Project.c_id = y.c_id and status = 'แก้ไขงาน'");

         while (resultSet.next()){

             String id = resultSet.getString("p_id");
             String e_name = resultSet.getString("e_name");
             String p_name = resultSet.getString("p_name");
             String c_name = resultSet.getString("name_company");
             String d_start = resultSet.getString("d_start");
             String d_end = resultSet.getString("d_end");
             String status = resultSet.getString("status");
             String detail = resultSet.getString("detail");


             addMapAllWork(id,p_name,e_name,c_name,d_start,d_end,status,detail);
         }
         connection.close();

     }

    public String[] getWorkById(String id) throws ClassNotFoundException, SQLException {
        String[] data = new String[4];
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , x.e_name , detail from Project , Employee x where Project.e_id = x.e_id and Project.p_id = '"+ id +"'");

        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");
            String e_name = resultSet.getString("e_name");
            String p_name = resultSet.getString("p_name");
            String detail = resultSet.getString("detail");

            data[0] = idProject;
            data[1] = p_name;
            data[2] = e_name;
            data[3] = detail;
            System.out.println("test"+idProject +" "+e_name +" "+p_name+" "+detail);

        }
        connection.close();
        return data;
    }
    public String[] getWorkByIdNotEmployee(String id) throws ClassNotFoundException, SQLException {

        String[] data = new String[4];
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , detail from Project where Project.p_id = '"+ id +"'");

        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");

            String p_name = resultSet.getString("p_name");
            String detail = resultSet.getString("detail");

            data[0] = idProject;
            data[1] = p_name;
            data[2] = "-";
            data[3] = detail;
            System.out.println("test"+idProject +" -" +" "+p_name+" "+detail);

        }
        connection.close();
        return data;
    }

    public void getAllWorkByStatus() throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , x.e_name , d_start,d_end , y.name_company from Project , Employee x , Customer y where status = 'รอตรวจสอบ'");


        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");
            String p_name = resultSet.getString("p_name");
            String e_name = resultSet.getString("e_name");
            String d_start = resultSet.getString("d_start");
            String d_end = resultSet.getString("d_end");
            String c_name = resultSet.getString("name_company");
            addMapAllWork(idProject,e_name,p_name,c_name,d_start,d_end,"","");

        }
        connection.close();

    }

    //ไม่เขียน
    public void getId() throws ClassNotFoundException, SQLException {
        String idProject = "";
        Class.forName(dbName);
        Connection connection;
        connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id  from StorageProject");

        while (resultSet.next()){

            idProject = resultSet.getString("p_id");
        }

        connection.close();
        getAllWorkEngineer(idProject);
    }

    public void getAllWorkEngineer(String id) throws SQLException, ClassNotFoundException {

        Class.forName(dbName);
        Connection connection;
        connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id , p_name , status , x.name_company ,detail from Project , Customer x where x.c_id = Project.c_id and Project.status = 'ระหว่างดำเนินการ' or Project.status = 'รอตรวจสอบ' and  Project.e_id = '"+id+"'");

        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");
            String p_name = resultSet.getString("p_name");
            String status = resultSet.getString("status");
            String c_name = resultSet.getString("name_company");
            String detail = resultSet.getString("detail");


            System.out.println("get "+idProject +" "+p_name+" "+status+" "+c_name);
            addMapStorang(idProject,p_name,c_name,status,detail);
            //insertAllWorkEngineer(idProject,e_name,status,c_name);
        }
        
        connection.close();


    }
    //ไม่เขียนลงรายงาน
    public void insertAllWorkEngineerById(String id ) throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        String query = "insert into StorageProject (p_id)"+" values (?) ";
        PreparedStatement preparedStatement = connection.prepareStatement(query);

        preparedStatement.setString(1, id);

        preparedStatement.execute();
        connection.close();
    }
    //ไม่เขียนลงรายงาน
    public void deleteAll() throws ClassNotFoundException, SQLException {
        Class.forName(dbName);
        Connection connection = DriverManager .getConnection(dbURL);
        String query  = "Delete from StorageProject";
        PreparedStatement p = connection.prepareStatement(query);
        p.executeUpdate();
        connection.close();
    }
//    public void getAllWorkEngineer() throws SQLException, ClassNotFoundException {
//        result.clear();
//        Class.forName(dbName);
//        Connection connection;
//        connection = DriverManager.getConnection(dbURL);
//        Statement statement = connection.createStatement();
//        ResultSet resultSet = statement.executeQuery("select p_id , p_name , status , c_name from StorageProject ");
//
//        while (resultSet.next()){
//
//            String idProject = resultSet.getString("p_id");
//            String p_name = resultSet.getString("p_name");
//            String status = resultSet.getString("status");
//            String c_name = resultSet.getString("name_company");
//
//            addMapStorang(idProject,p_name,c_name,status);
//
//        }
//
//        connection.close();
//
//    }

    public void addMapAllWork(String id , String e_name , String p_name , String c_name , String startDate,String endDate , String status,String detail){

            result.put(id,new Project(p_name,e_name,c_name,startDate,endDate,status,detail));



    }


    public Map<String, Project> getResult(){
        return result;
    }
    //ไม่เขียน

    public void addMapStorang(String idProject,  String p_name, String c_name, String status,String detail){

        result.put(idProject,new Project(p_name,"",c_name,"","",status,detail));
    }
    //ไม่เขียน
    public Map<String, Project> getMapStorage(){
        return result;
    }
    //imm
    public void selectWorkNotComplete(String id)throws ClassNotFoundException, SQLException{
        String arrayCustomer[] = new String[7];
        Class.forName(dbName);
        Connection connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id, p_name, status,  d_start,d_end from Project where Project.status = 'ระหว่างดำเนินการ' or Project.status = 'แก้ไขงาน' and e_id = '"+id+"'");

        while (resultSet.next()){

            String projectId = resultSet.getString("p_id");
            String projectName = resultSet.getString("p_name");
            String status = resultSet.getString("status");
            String dateStart = resultSet.getString("d_start");
            String dateEnd = resultSet.getString("d_end");

            addMapAllWork(projectId,"","","",dateStart,dateEnd,status,projectName);
        }

    }
    public void getAllWorkEngineerById(String id) throws SQLException, ClassNotFoundException {
       result.clear();
        Class.forName(dbName);
        Connection connection;
        connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id,p_name,status,x.name_company,d_start,d_end from Project , Customer x where x.c_id = Project.c_id and Project.e_id = '"+id+"'");
        int i = 0;
        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");
            String p_name = resultSet.getString("p_name");
            String status = resultSet.getString("status");
            String c_name = resultSet.getString("name_company");
            String d_start = resultSet.getString("s_start");
            String d_end = resultSet.getString("d_end");



            addMapAllWork(idProject,"","",c_name,d_start,d_end,status,p_name);
            i++;
            //insertAllWorkEngineer(idProject,e_name,status,c_name);
        }

        connection.close();

    }
    public void getEditWork(String id) throws ClassNotFoundException, SQLException {
        result.clear();
        Class.forName(dbName);
        Connection connection;
        connection = DriverManager.getConnection(dbURL);
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select p_id,p_name,x.name_company,d_start,d_end from Project , Customer x where x.c_id = Project.c_id and status = 'แก้ไขงาน' and e_id = '"+id+"'");

        while (resultSet.next()){

            String idProject = resultSet.getString("p_id");
            String p_name = resultSet.getString("p_name");

            String c_name = resultSet.getString("name_company");
            String dateStart = resultSet.getString("d_start");
            String dateEnd = resultSet.getString("d_end");


            System.out.println("get "+idProject +" "+p_name+" "+" "+c_name);
            addMapAllWork(idProject,"",p_name,c_name,dateStart,dateEnd,"","");

            //insertAllWorkEngineer(idProject,e_name,status,c_name);
        }

        connection.close();
    }


}
