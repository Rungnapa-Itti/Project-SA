package controller.Manager;

import Model.Customer;
import database.CreateWorkDB;
import database.CustomerDB;
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

public class SceneListCustomer {
    CustomerDB customerDB = new CustomerDB();
    CreateWorkDB createWorkDB = new CreateWorkDB();
    SceneCreateWork createWork = new SceneCreateWork();

    private Map<String, Customer> mapListCustomer = new TreeMap<String, Customer>();
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String,String> name , department , phone , email;
    @FXML
    private Button buttonOK;
    @FXML
    private Button buttonRegisterCustomer;
    @FXML
    private Button buttonBack;
    private String id;






    public void initialize() throws SQLException, ClassNotFoundException{
        createWorkDB.getNameCustomer();
        mapListCustomer = createWorkDB.getResult();
        setTableView();

    }


    public  void setTableView(){
        //System.out.println("size"+mapListCustomer.size());
        tableView.setItems(FXCollections.observableArrayList(mapListCustomer.keySet()));
        name.setCellValueFactory(p -> new SimpleStringProperty(mapListCustomer.get(p.getValue()).getName()));
        department.setCellValueFactory(p -> new SimpleStringProperty(mapListCustomer.get(p.getValue()).getNameCompany()));
        phone.setCellValueFactory(p -> new SimpleStringProperty(mapListCustomer.get(p.getValue()).getPhone()));
        email.setCellValueFactory(p -> new SimpleStringProperty(mapListCustomer.get(p.getValue()).getEmail()));

    }

    public void clickColumn(MouseEvent mouseEvent) throws SQLException, ClassNotFoundException {
        id = tableView.getSelectionModel().selectedItemProperty().get();

    }

    public void handleOkOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        if (id == null) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotSelect.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            customerDB.selectCustomerById(id);

            Stage stage1 = (Stage) tableView.getScene().getWindow();
            stage1.close();
        }


    }

    public void handleRegisterCustomerOnClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneRegisterCustomer.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(),694,506));
        stage.show();
        stage.setResizable(false);

        Stage stage1 = (Stage) tableView.getScene().getWindow();
        stage1.close();


    }
     public void handleBackOnClick(ActionEvent actionEvent){
         Stage stage1 = (Stage) tableView.getScene().getWindow();
         stage1.close();
     }



}

