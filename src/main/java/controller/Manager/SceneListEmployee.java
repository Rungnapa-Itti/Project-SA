package controller.Manager;

import Model.Employee;
import controller.AlertBox;
import database.AllWorkDB;
import database.EmployeeDB;
import database.StateOnclickDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneListEmployee {
    StateOnclickDB stateOnclickDB = new StateOnclickDB();

    EmployeeDB employeeDB = new EmployeeDB();
    AllWorkDB allWorkDB = new AllWorkDB();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String,String> id , name,email,phone,position, countProject;
    @FXML
    private Button buttonSelect;
    @FXML
    private Button buttonCountProject;
    @FXML
    private Label labelException;

    private String idProject;
    private Map<String, Employee> mapListName = new TreeMap<>();

    public void initialize() throws SQLException, ClassNotFoundException {
        employeeDB.getListName();
        mapListName = employeeDB.getResult();
        setTableView();

    }
    public  void setTableView(){

        tableView.setItems(FXCollections.observableArrayList(mapListName.keySet()));
        id.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        name.setCellValueFactory(p -> new SimpleStringProperty(mapListName.get(p.getValue()).getName()));
        email.setCellValueFactory(p -> new SimpleStringProperty(mapListName.get(p.getValue()).getEmail()));
        phone.setCellValueFactory(p -> new SimpleStringProperty(mapListName.get(p.getValue()).getPhone()));
        position.setCellValueFactory(p -> new SimpleStringProperty(mapListName.get(p.getValue()).getPosition()));
        countProject.setCellValueFactory(p->new SimpleStringProperty(mapListName.get(p.getValue()).getCount()));

    }

    public void handleSelectOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        if (idProject == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยัน");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                allWorkDB.deleteAll();
                employeeDB.deleteAll();
                employeeDB.selectProjectById(idProject);
                Stage stage1 = (Stage) tableView.getScene().getWindow();
                stage1.close();
            }
        }
    }
    public void handleCountProjectOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if (idProject == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            allWorkDB.deleteAll();
            Integer count = employeeDB.checkCountProjectById(idProject);
            if (count == 0) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotCount.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load(), 400, 200));
                stage.show();
                stage.setResizable(false);
            } else {
                //System.out.println(count);
                allWorkDB.insertAllWorkEngineerById(idProject);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneAllWorkEngineer.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load(), 694, 505));
                stage.show();
                stage.setResizable(false);
                Stage stage1 = (Stage) tableView.getScene().getWindow();
                stage1.close();
            }
        }

    }

    public void clickColoumn (MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        idProject = tableView.getSelectionModel().selectedItemProperty().get()+"";


    }

}
