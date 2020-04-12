package controller.Manager;

import Model.Project;
import database.AllWorkDB;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneNotification {
    AllWorkDB allWorkDB = new AllWorkDB();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String , String> id , name,nameEmployee,dateStart , dateFinish,department;
    @FXML
    private Button buttonNext ;
    @FXML
    private Label labelCount;

    private Map<String, Project> map = new TreeMap<>();
    private String selectId ;

    public void initialize() throws SQLException, ClassNotFoundException {
        allWorkDB.getAllWorkByStatus();
        map = allWorkDB.getResult();
        setTable();
        labelCount.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
    }

    public void setTable(){
        tableView.setItems(FXCollections.observableArrayList(map.keySet()));
        id.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        name.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getName()));
        nameEmployee.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getEngineerName()));
        dateStart.setCellValueFactory(p->new SimpleStringProperty(map.get(p.getValue()).getStartDate()));
        dateFinish.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getEndDate()));
        department.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getCustomerName()));
    }

    public void handleNextOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        if (selectId == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneCloseProject.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 694, 505));
            String data[] = allWorkDB.getWorkById(selectId);
            SceneCloseProject controller = loader.<SceneCloseProject>getController();
            controller.settingLabel(data[0], data[1], data[2], data[3]);

            stage.showAndWait();
            stage.setResizable(false);

            allWorkDB.getAllWorkByStatus();
            map = allWorkDB.getResult();
            setTable();
            labelCount.setText("รายการทั้งหมด " + tableView.getItems().size() + " รายการ");
            selectId = null;
        }
    }
    public void clickColumn(){
        selectId = tableView.getSelectionModel().selectedItemProperty().get()+"";

    }

}
