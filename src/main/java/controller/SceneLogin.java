package controller;

import com.jfoenix.controls.JFXButton;
import controller.Manager.SceneMainManager;
import database.LoginDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nonuse.classp.Manager;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class SceneLogin {
   LoginDB loginDB = new LoginDB();
    @FXML
    Button buttonlLogin;
    @FXML
    Button buttonRegister;
    @FXML
    JFXButton jfxButtonForgot;
    @FXML
     Label labelException;
    @FXML
    TextField textFieldUsername;
    @FXML
     TextField textFieldPassword;



    @FXML
    protected void handleLoginButtonOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
                String id = loginDB.login(textFieldUsername.getText(),textFieldPassword.getText());
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDateTime now = LocalDateTime.now();
            System.out.println(dtf.format(now));

                if ((id.charAt(0)+""+id.charAt(1)).equals("70")) {
                    loginDB.updateStateLogin(id,dtf.format(now));

                    Parent scenceMainParent = FXMLLoader.load(getClass().getResource("/scene/manager/sceneMainManager.fxml"));
                    Scene sceneMain = new Scene(scenceMainParent);
                    Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                    window.setScene(sceneMain);
                    window.show();
                    window.setResizable(false);

                }else if ((id.charAt(0)+""+id.charAt(1)).equals("53")){
                    loginDB.updateStateLogin(id,dtf.format(now));
                    Parent scenceMainParent = FXMLLoader.load(getClass().getResource("/scene/engineer/sceneMainEngineer.fxml"));
                    Scene sceneMain = new Scene(scenceMainParent);
                    Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

                    window.setScene(sceneMain);
                    window.show();
                    window.setResizable(false);

                }else if (id.equals("null")){
                    labelException.setText("ไม่พบข้อมูลของคุณ");
                }






    }

    public void handleRegisterButtonOnClick(ActionEvent actionEvent){

        Parent scenceRegisterParent = null;
        try {
            scenceRegisterParent = FXMLLoader.load(getClass().getResource("/scene/manager/sceneMainManager.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene sceneRegister = new Scene(scenceRegisterParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneRegister);
        window.show();
        window.setResizable(false);
    }

    public void handleForgotpassButtonOnClick(ActionEvent actionEvent){
        Parent scenceForgotParent = null;
        try {
            scenceForgotParent = FXMLLoader.load(getClass().getResource("/scenenonuse/sceneResetPassword.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene sceneForgot = new Scene(scenceForgotParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneForgot);
        window.show();
        window.setResizable(false);
    }

}
