package controller.Engineer;

import Model.Project;
import controller.Manager.SceneDescriptionWork;
import database.AllWorkDB;
import database.LoginDB;
import database.ProjectDB;
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

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneAllWorkEngineer {
    AllWorkDB allWorkDB = new AllWorkDB();
    ProjectDB projectDB = new ProjectDB();
    LoginDB loginDB = new LoginDB();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String,String> id, nameProject  , department ,startDate , finishDate , status;
    private Map<String, Project> map = new TreeMap<String, Project>();
    private Button buttonDetail;
    private String selectedIdWork;
    public void initialize() throws SQLException, ClassNotFoundException{
        allWorkDB.getAllWorkEngineerById(loginDB.getId());
        map = allWorkDB.getResult();
        System.out.println(map.size());
        setTableView();


    }
    public  void setTableView(){


        tableView.setItems(FXCollections.observableArrayList(map.keySet()));
        id.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        nameProject.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getDetail()));
        department.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getCustomerName()));
        startDate.setCellValueFactory(p -> new SimpleStringProperty(map.get(p.getValue()).getStartDate()));
        finishDate.setCellValueFactory(p->new SimpleStringProperty(map.get(p.getValue()).getEndDate()));
        status.setCellValueFactory(p->new SimpleStringProperty(map.get(p.getValue()).getState()));

    }
    public void handleShowDetailOnClick() throws IOException, SQLException, ClassNotFoundException {
        if (selectedIdWork == null){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneDescriptionWork.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 694, 505));
            String data[] = allWorkDB.getWorkById(selectedIdWork);
            SceneDescriptionWork controller = loader.<SceneDescriptionWork>getController();
            controller.settingLabel(data[0], data[1], data[2], data[3]);

            stage.show();
            stage.setResizable(false);
        }


    }
    public void clickColumn(MouseEvent mouseEvent){
        selectedIdWork = selectedIdWork = tableView.getSelectionModel().selectedItemProperty().get()+"";
    }

}
