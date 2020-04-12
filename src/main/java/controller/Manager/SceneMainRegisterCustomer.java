package controller.Manager;

import controller.AlertBox;
import database.RegisterCutomerDB;
import database.StateOnclickDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;


public class SceneMainRegisterCustomer {
    StateOnclickDB stateOnclickDB =new StateOnclickDB();

    @FXML
    private TextField textFieldDepartment;
    @FXML
    private TextField textFieldName;
    @FXML
    private TextField textFieldPhone;
    @FXML
    private TextField textFieldEmail;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonSave;
    @FXML
    private Label labelException;
    @FXML
    private Label labelDialog;

    RegisterCutomerDB registerCutomerDB = new RegisterCutomerDB();
    public void initialize(){
//        labelException.setText("");
        //labelDialog.setText("");

    }
    public String randomIdCustomer(){
        Random random = new Random();
        String id = "42";

        for (int i = 0; i < 3; i++) {
            int n = random.nextInt(9);
            id +=n;
        }
        return id;

    }

    public void handleCancelOnClick(ActionEvent actionEvent){
        textFieldDepartment.setText("");
        textFieldEmail.setText("");
        textFieldName.setText("");
        textFieldPhone.setText("");

    }

    public void handleSaveOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        if (textFieldDepartment.getText().isEmpty() == true || textFieldName.getText().isEmpty() == true || textFieldPhone.getText().isEmpty() == true || textFieldEmail.getText().isEmpty() == true){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotdata.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการลงทะเบียนลูกค้า");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {


                String department = textFieldDepartment.getText();
                String customerName = textFieldName.getText();
                String phone = textFieldPhone.getText();
                String email = textFieldEmail.getText();
                String id = randomIdCustomer();
                registerCutomerDB.insertCustomer(id, department, customerName, phone, email);

                textFieldDepartment.setText("");
                textFieldName.setText("");
                textFieldPhone.setText("");
                textFieldEmail.setText("");
                labelDialog.setText("บันทึกข้อมูลสำเร็จ");
            }
        }


    }

}
