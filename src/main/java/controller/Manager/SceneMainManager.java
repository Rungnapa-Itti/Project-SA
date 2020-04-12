package controller.Manager;

import com.jfoenix.controls.JFXButton;
import database.LoginDB;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import nonuse.classp.Manager;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SceneMainManager {
    LoginDB loginDB = new LoginDB();
    private Manager manager;
    private Date date;

    @FXML
    JFXButton createWork;
    @FXML
    JFXButton state;
    @FXML
    JFXButton notification;
    @FXML
    JFXButton listName;
    @FXML
    AnchorPane anchorPane;
    @FXML
    Label labelUser;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();


    public void  handleNotificationOnClick(ActionEvent actionEvent)throws  IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/manager/sceneNotification.fxml"));
        anchorPane.getChildren().setAll(state);
    }

    public void handleStateButtonOnclick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {

        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/sceneState.fxml"));
        anchorPane.getChildren().setAll(state);
    }
    public  void handleCreateWorkOnClick(ActionEvent actionEvent)throws IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/manager/sceneCreateWork.fxml"));
        anchorPane.getChildren().setAll(state);
    }
    public  void handleAllWorkOnClick(ActionEvent actionEvent)throws IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/manager/sceneAllWork.fxml"));
        anchorPane.getChildren().setAll(state);
    }

    public  void handleAssignmentOnClick(ActionEvent actionEvent)throws IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/manager/sceneAssignment.fxml"));
        anchorPane.getChildren().setAll(state);
    }

    public void handleRegisterCustomer(ActionEvent actionEvent) throws IOException {
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/manager/sceneMainRegisterCustomer.fxml"));
        anchorPane.getChildren().setAll(state);
    }

    public void handleLogOutOnClick(ActionEvent actionEvent) throws IOException, SQLException, ClassNotFoundException {
        Parent scenceMainParent = FXMLLoader.load(getClass().getResource("/scene/scenelogin.fxml"));
        Scene sceneMain = new Scene(scenceMainParent);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        loginDB.updateStateLogout(loginDB.getId(),dtf.format(now));
        window.setScene(sceneMain);
        window.show();
    }








}
