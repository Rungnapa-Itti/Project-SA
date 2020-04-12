package controller.Manager;

import Model.Project;
import controller.AlertBox;
import database.AllWorkDB;
import database.ProjectDB;
import database.StateOnclickDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
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

public class SceneProjectNotEmployee {
     AllWorkDB allWorkDB = new AllWorkDB();
     ProjectDB projectDB = new ProjectDB();
     StateOnclickDB stateOnclickDB = new StateOnclickDB();
    @FXML
    private TableView tableView;
    @FXML
    private TableColumn<String , String> id ,name , department,status;
    @FXML
    private Button buttonSelected;
    @FXML
    private Button buttonProjectDetail;
    private Map<String, Project> mapProjectNotAssign  = new TreeMap<>();
    private String idProject;

    public void initialize() throws SQLException, ClassNotFoundException{

       allWorkDB.getNotEmployee();
       mapProjectNotAssign = allWorkDB.getResult();
       setTableView();


    }
    public  void setTableView(){
        tableView.setItems(FXCollections.observableArrayList(mapProjectNotAssign.keySet()));
        id.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        name.setCellValueFactory(p -> new SimpleStringProperty(mapProjectNotAssign.get(p.getValue()).getEngineerName()));
        department.setCellValueFactory(p -> new SimpleStringProperty(mapProjectNotAssign.get(p.getValue()).getCustomerName()));
        status.setCellValueFactory(p->new SimpleStringProperty(mapProjectNotAssign.get(p.getValue()).getState()));

    }

    public void handleSelectedProjectOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (idProject == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยัน");

            stage.showAndWait();
            stage.setResizable(false);

            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                projectDB.deleteAll();
                projectDB.selectProjectById(idProject);
                Stage stage1 = (Stage) tableView.getScene().getWindow();
                stage1.close();
            }
        }
    }

    public void handleDetialProjectOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if (idProject == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneDescriptionWork.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 694, 505));
            String data[] = allWorkDB.getWorkByIdNotEmployee(idProject);
            SceneDescriptionWork controller = loader.<SceneDescriptionWork>getController();
            controller.settingLabel(data[0], data[1], data[2], data[3]);
            stage.show();
            stage.setResizable(false);
            idProject = null;
        }
    }

    public void clickColumn(MouseEvent mouseEvent){
        idProject = tableView.getSelectionModel().selectedItemProperty().get()+"";
        System.out.println(idProject);
    }


}
