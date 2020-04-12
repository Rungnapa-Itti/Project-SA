package controller.Manager;

import Model.Project;
import database.AllWorkDB;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import java.util.TreeMap;

public class SceneAllWork {
    AllWorkDB allWorkDB = new AllWorkDB();

    @FXML
    private Button buttonNext;
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String,String> projectId , projectName , projectstate , employee , department , startDate , finishDate;
    @FXML
    private MenuButton menuButton;
    @FXML
    private MenuItem menuItemFinishWork;
    @FXML
    private MenuItem menuItemDoing;
    @FXML
    private MenuItem menuItemNotEmployee;
    @FXML
    private MenuItem menuItemAllWork;
    @FXML
    private MenuItem menuItemWaitVerify;
    @FXML
    private MenuItem menuItemEditProject;
    @FXML
    private Label labelCountRow;
    @FXML

    private Map<String, Project> mapListWork = new TreeMap<>();
    private String selectedIdWork;

    //ไม่เขียน
    public void setSelectedIdWork(String selectedIdWork){
        this.selectedIdWork = selectedIdWork;
    }

    public void initialize() throws SQLException, ClassNotFoundException{
        handleAllWorkMenuItemOnclick();


    }
    public  void setTableView(){
        tableView.setItems(FXCollections.observableArrayList(mapListWork.keySet()));
        projectId.setCellValueFactory(p -> new SimpleStringProperty(p.getValue()));
        projectName.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getName()));
        projectstate.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getState()));
        employee.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getEngineerName()));
        department.setCellValueFactory(p -> new SimpleStringProperty(mapListWork.get(p.getValue()).getCustomerName()));
        startDate.setCellValueFactory(p->new SimpleStringProperty(mapListWork.get(p.getValue()).getStartDate()));
        finishDate.setCellValueFactory(p->new SimpleStringProperty(mapListWork.get(p.getValue()).getEndDate()));

    }
    public void clickColumn(MouseEvent mouseEvent){

        selectedIdWork = tableView.getSelectionModel().selectedItemProperty().get();

//        setSelectedIdWork(selectedIdWork);
//        System.out.println(selectedIdWork);
    }
     public void handelNextOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
            if (selectedIdWork == null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(loader.load(), 400, 200));
                stage.show();
                stage.setResizable(false);
            }else {
                ;
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

    public void handleAllWorkMenuItemOnclick() throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemAllWork.getText());
        allWorkDB.getAllWork();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;

    }

    public void handleFinishWorkMenuItemOnclick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemFinishWork.getText());

        allWorkDB.getFinishWork();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;

    }

    public void handleDoingMenuItemOnclick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemDoing.getText());
        allWorkDB.getDoing();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;

    }

    public void handleNotEmployeeMenuItemOnclick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemNotEmployee.getText());
        allWorkDB.getNotEmployee();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;

    }

    public void handleWaitingVerify(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemWaitVerify.getText());
        allWorkDB.getWaitingVerify();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;
    }
    public void handleEditProject(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {

        menuButton.setText(menuItemEditProject.getText());
        allWorkDB.getEditProject();
        mapListWork = allWorkDB.getResult();
        setTableView();
        labelCountRow.setText("รายการทั้งหมด "+tableView.getItems().size()+" รายการ");
        selectedIdWork = null;

    }



}
