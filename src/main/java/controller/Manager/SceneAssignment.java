package controller.Manager;

import Model.Project;
import controller.AlertBox;
import database.AllWorkDB;
import database.EmployeeDB;
import database.ProjectDB;
import database.StateOnclickDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class SceneAssignment {
    StateOnclickDB stateOnclickDB = new StateOnclickDB();
    ProjectDB projectDB = new ProjectDB();
    EmployeeDB employeeDB = new EmployeeDB();
    AllWorkDB allWorkDB = new AllWorkDB();
    private String dateStart;
    private String dateEnd;
    @FXML
    private Button buttonSelectProject;
    @FXML
    private Button buttonSelectEmployee;
    @FXML
    private Label labelProject;
    @FXML
    private Label labelEmployee;
    @FXML
    private Label labelDescription;
    @FXML
    private DatePicker datePickerStart;
    @FXML
    private DatePicker datePickerFinish;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonNext;
    @FXML
    private Label labelCount;
    Integer count = 0;
    @FXML
    private Map<String, Project> map = new TreeMap<>();
    @FXML
    private Label labelException;

    public void initialize() throws SQLException, ClassNotFoundException {
        projectDB.deleteAll();

    }

    public void handleSelectProjectOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
            projectDB.deleteAll();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneProjectNotEmployee.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(),694,505));
            stage.showAndWait();
            stage.setResizable(false);
            String[] data = projectDB.getNameProject();
            labelProject.setText(data[0]);
            labelDescription.setText(data[1]);
            //map = allWorkDB.getMapStorage();



    }

    public void handleSelectEmployee(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneListEmployee.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(),694,505));
        stage.showAndWait();
        stage.setResizable(false);

        labelEmployee.setText(employeeDB.getNameEmployee());

    }

    public void handelSaveOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        String text ="";

        projectDB.deleteAll();
        if (labelProject.getText() == "" || labelEmployee.getText() == "" || labelDescription.getText() == "" ) {
            System.out.println(datePickerStart.isShowWeekNumbers() +" "+datePickerFinish.isShowWeekNumbers());
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotdata.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }

        Boolean check = checkDate();
        System.out.println(check);
        if (check == false){
            labelException.setText("ข่้อมูลไม่ถูกต้อง กรุณาตรวจสอบข้อมูลอีกครั้ง");
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการมอบหมายงาน");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                String idEmployee = employeeDB.getEmployeeId();
                employeeDB.updateWorkEmployee(idEmployee);
                String idProject = projectDB.getProjectId();
                projectDB.updateWorkEmployee(idEmployee, idProject, dateStart,dateEnd);
                projectDB.deleteAllStoring();
                labelException.setText("");
                labelDescription.setText("");
                labelEmployee.setText("");
                labelProject.setText("");
                check = true;


            }

        }


    }

    public Boolean checkDate(){
        String dateStart = datePickerStart.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dateFinish = datePickerFinish.getValue().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String dayStart = dateStart.charAt(0)+""+dateStart.charAt(1);
        String dayFinish = dateFinish.charAt(0)+""+dateFinish.charAt(1);
        String monthStart = dateStart.charAt(3)+""+dateStart.charAt(4);
        String monthFinish = dateFinish.charAt(3)+""+dateFinish.charAt(4);
        String yearStart = dateStart.charAt(6)+""+dateStart.charAt(7)+""+dateStart.charAt(8)+""+dateStart.charAt(9);
        String yearFinish = dateFinish.charAt(6)+""+dateFinish.charAt(7)+""+dateFinish.charAt(8)+""+dateFinish.charAt(9);
        countMount(dayStart,dayFinish);
        if (new Integer(dayStart) <= new Integer(dayFinish ) &&
            new Integer(monthStart) <= new Integer(monthFinish) &&
            new Integer(yearStart) <= new Integer(yearFinish) &&
            count <=6 && (new Integer(yearFinish) - new Integer(yearStart)) <=1) {
            this.dateStart = dayStart+"/"+monthStart+"/"+yearStart ;
            this.dateEnd = dayFinish+"/"+monthFinish+"/"+yearFinish;

            return true;
        }
        return false;
    }
    public void countMount(String start , String end) {
        if (new Integer(start) < new Integer(end)) {
            count = (12 - new Integer(start)) + new Integer(end);
        } else if (new Integer(start) == new Integer(end)) {
            count = new Integer(end) - new Integer(start);
        }
    }






}
