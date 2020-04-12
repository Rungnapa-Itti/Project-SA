package controller.Manager;

import controller.AlertBox;
import database.CreateWorkDB;
import database.CustomerDB;
import database.StateOnclickDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;


public class SceneCreateWork {
    CustomerDB customerDB = new CustomerDB();
    CreateWorkDB createWorkDB = new CreateWorkDB();
    StateOnclickDB stateOnclickDB = new StateOnclickDB();
    ArrayList<String> character = new ArrayList<>();

    @FXML
    private Label labelId;

    @FXML
    private TextField textFieldName;

    @FXML
    private TextArea textAreaDescription;

    @FXML
    private Label labelShowName;

    @FXML
    private Label labelException;

    @FXML
    private Button buttonSelectCustomer;

    @FXML
    private Button buttonSave;

    @FXML
    private Label labelShowDepartment;
    @FXML
    private Label labelShowPhone;
    @FXML
    private Button buttonCancel;
    private String array[];

    public void initialize() throws SQLException, ClassNotFoundException {
        labelId.setText(randomIdCustomer());
        customerDB.delectAll();
        character.add("~");
        character.add("%");
        character.add("`");
        character.add("-");
        character.add("!");
        character.add("+");
        character.add("@");
        character.add("/");
        character.add("#");
        character.add("_");
        character.add("$");
        character.add("^");
        character.add("&");
        character.add("฿");
        character.add("*");
        character.add("(");
        character.add(")");
        character.add("=");
        character.add("|");
        character.add("\"");
        character.add("]");
        character.add("[");
        character.add("}");
        character.add("{");
        character.add(";");
        character.add(":");
        character.add("'");
        character.add(".");
        character.add(",");
        character.add("<");
        character.add(">");
        character.add("?");



    }

    public String randomIdCustomer(){
        Random random = new Random();
        String id = "11";

        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(9);
            id +=n;
        }
        return id;

    }

    public void handleCencalOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (labelShowName.getText() != "" && labelShowDepartment.getText() != "" && labelShowPhone.getText() != "" && textAreaDescription.getText() != "" && textFieldName.getText() != "") {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการยกเลิก");

            stage.showAndWait();
            stage.setResizable(false);

            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                labelShowPhone.setText("");
                labelShowDepartment.setText("");
                labelShowName.setText("");
                textAreaDescription.setText("");
                textFieldName.setText("");
            }
        }

    }

    public void handleShowListCustomerOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException, InvocationTargetException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/manager/sceneListCustomer.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(),694,505));
        stage.showAndWait();
        stage.setResizable(false);


        settingLabel();
    }

    public void handleSaveOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        if (textFieldName.getText().isEmpty() == true || textAreaDescription.getText().isEmpty() == true || labelShowName.getText().isEmpty() == true ){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotData.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการสร้างงาน");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                System.out.println(array[0]);
                createWorkDB.createProject(labelId.getText(), textFieldName.getText(), array[0], textAreaDescription.getText());
                customerDB.delectAll();
                labelId.setText(randomIdCustomer());
                stateOnclickDB.deleteAll();
                textFieldName.setText("");
                labelShowName.setText("");
                textAreaDescription.setText("");
                labelShowPhone.setText("");
                labelShowDepartment.setText("");
            }

        }

    }
    public void settingLabel() throws SQLException, ClassNotFoundException {
        array = customerDB.getCustomer();
        labelShowName.setText(array[1]);
        labelShowDepartment.setText(array[3]);
        labelShowPhone.setText(array[4]);
    }

    public Boolean checkString(String data){
        System.out.println(textFieldName.getText());
        for (char ch: data.toCharArray()) {
            if (character.contains(ch) == true){

                return true;
            }
        }
        System.out.println("false");
        return false;
    }



}
