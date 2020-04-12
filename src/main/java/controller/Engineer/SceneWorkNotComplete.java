package controller.Engineer;

import Model.Customer;
import Model.Project;
import controller.Manager.SceneCreateWork;
import database.*;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneWorkNotComplete {
    ProjectDB projectDB = new ProjectDB();
    AllWorkDB allWorkDB = new AllWorkDB();
    LoginDB loginDB = new LoginDB();

    @FXML private TableView<String> tableView;
    @FXML private TableColumn<String, String> projectId, projectName, status, finishDate, startDate;
    @FXML AnchorPane anchorPane;
    private Map<String, Project> mapListProject = new TreeMap<String, Project>();
    private String id;

    public void initialize() throws SQLException, ClassNotFoundException{

        //1 select data , Next step going to filedatabase
        String id =loginDB.getId() ;
        allWorkDB.selectWorkNotComplete(id);
        //3 getMap
        mapListProject = allWorkDB.getResult();
        //4 set
        setTableView();

    }

    public  void setTableView(){
        //System.out.println("size"+mapListCustomer.size());
        tableView.setItems(FXCollections.observableArrayList(mapListProject.keySet()));
        //key of map
        projectId.setCellValueFactory(p->new SimpleStringProperty(p.getValue()));
        status.setCellValueFactory(p->new SimpleStringProperty(mapListProject.get(p.getValue()).getState()));

        projectName.setCellValueFactory(p -> new SimpleStringProperty(mapListProject.get(p.getValue()).getDetail()));
        startDate.setCellValueFactory(p->new SimpleStringProperty(mapListProject.get(p.getValue()).getStartDate()));
        finishDate.setCellValueFactory(p->new SimpleStringProperty(mapListProject.get(p.getValue()).getEndDate()));
    }

    public void clickColumn(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        id = tableView.getSelectionModel().selectedItemProperty().get();

    }

    public void handleOkOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        projectDB.selectProjectById(id);
        Stage stage1 = (Stage) tableView.getScene().getWindow();
        stage1.close();


    }




}
