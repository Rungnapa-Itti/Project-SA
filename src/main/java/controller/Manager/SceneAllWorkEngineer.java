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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneAllWorkEngineer {
    AllWorkDB allWorkDB = new AllWorkDB();
    @FXML
    private Button buttonBack;
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String, String>  projectid , nameProject , state , dapartment ;
    private Map<String, Project> mapListWork = new TreeMap<>();
    private String selectId;


    public void initialize() throws SQLException, ClassNotFoundException {
       allWorkDB.getId();

        mapListWork = allWorkDB.getMapStorage();
        setTableView();


    }


    public void setTableView(){
        tableView.setItems(FXCollections.observableArrayList(mapListWork.keySet()));
        projectid.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        nameProject.setCellValueFactory(p-> new SimpleStringProperty(mapListWork.get(p.getValue()).getName()));
        state.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getState()));
        dapartment.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getCustomerName()));
    }

    public void handleBackOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneListEmployee.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(),694,505));
        stage.showAndWait();
        stage.setResizable(false);
        String data[] = allWorkDB.getWorkById(selectId);


        Stage stage1 = (Stage) buttonBack.getScene().getWindow();
        stage1.close();
        SceneDescriptionWork controller = loader.<SceneDescriptionWork>getController();
        controller.settingLabel(data[0],data[1],data[2],data[3]);

    }









}
