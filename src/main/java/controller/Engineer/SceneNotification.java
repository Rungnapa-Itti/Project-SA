package controller.Engineer;

import Model.Project;
import database.AllWorkDB;
import database.LoginDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneNotification {
    AllWorkDB allWorkDB = new AllWorkDB();
    LoginDB loginDB = new LoginDB();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String,String> idProject , nameProject , startDate , finishDate , department;

    private Map<String, Project> map = new TreeMap<>();
    @FXML
    private Button buttonOk;
    String id;

    public void initialize() throws SQLException, ClassNotFoundException {
        id = "";
        allWorkDB.getEditWork(loginDB.getId());
        map = allWorkDB.getResult();
        setTable();

    }
    public void setTable(){
        tableView.setItems(FXCollections.observableArrayList(map.keySet()));
        idProject.setCellValueFactory(p->new SimpleStringProperty(p.getValue()));
        nameProject.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getName()));
        startDate.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getStartDate()));
        finishDate.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getEndDate()));
        department.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getCustomerName()));
    }
    public void handleOkOnClik() throws IOException {
        if (id == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningOk.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }


    }
    public void clickColumn(MouseEvent mouseEvent){
        id  = tableView.getSelectionModel().selectedItemProperty().get()+"";
    }
}
