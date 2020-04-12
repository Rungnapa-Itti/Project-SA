package controller.Engineer;

import com.jfoenix.controls.JFXButton;
import database.LoginDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SceneMainEmployee {
    LoginDB loginDB = new LoginDB();
    @FXML private JFXButton notification;
    @FXML private JFXButton notComplete;
    @FXML private JFXButton sendWork;
    @FXML private JFXButton allWork;
    @FXML private JFXButton logout;
    @FXML AnchorPane anchorPane;
    @FXML
    Label labelUser;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    LocalDateTime now = LocalDateTime.now();


    public void handleWorkNotCompleteButtonOnclick(ActionEvent actionEvent) throws IOException {
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/Engineer/sceneWorkNotComplete.fxml"));
        anchorPane.getChildren().setAll(state);
    }
    public void  handleNotificationOnClick(ActionEvent actionEvent)throws  IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/Engineer/sceneNotification.fxml"));
        anchorPane.getChildren().setAll(state);
    }

    public  void handleAllWorkOnClick(ActionEvent actionEvent)throws IOException{
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/Engineer/sceneAllWorkEngineer.fxml"));
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




    public void handleSentWorkOnClick(ActionEvent actionEvent) throws IOException {
        AnchorPane state = FXMLLoader.load(getClass().getResource("/scene/Engineer/sceneSentWork.fxml"));
        anchorPane.getChildren().setAll(state);
    }

}
