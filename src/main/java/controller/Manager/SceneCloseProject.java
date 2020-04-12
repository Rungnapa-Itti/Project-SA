package controller.Manager;

import controller.AlertBox;
import database.ProjectDB;
import database.StateOnclickDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class SceneCloseProject {
    ProjectDB projectDB = new ProjectDB();
    StateOnclickDB stateOnclickDB = new StateOnclickDB();
    @FXML
    private Label labelId;
    @FXML
    private Label labelProjectName;
    @FXML
    private Label labelEmployeeName;
    @FXML
    private Label labelDetail;
    @FXML
    private Button buttonCloseProject;
    @FXML
    private Button buttonEditProject;
    @FXML
    private Button buttonBack ;

    public void settingLabel(String id, String projectName, String employeeName, String detail){
        labelId.setText(id);
        labelProjectName.setText(projectName);
        labelEmployeeName.setText(employeeName);
        labelDetail.setText(detail);
    }

    public void handleCloseProjectOnclick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 400, 200));

        AlertBox controller = loader.<AlertBox>getController();
        controller.settingLabel("ยืนยันการปิดงาน");
        stage.showAndWait();
        stage.setResizable(false);

        String state = stateOnclickDB.selectState();
        if (state.equals("true")){
            projectDB.updateStatus("ปิดงาน",labelId.getText());
            Stage stage1 = (Stage) labelDetail.getScene().getWindow();
            stage1.close();
            stateOnclickDB.deleteAll();
        }

    }

    public void handleEditOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException, IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 400, 200));

        AlertBox controller = loader.<AlertBox>getController();
        controller.settingLabel("ยืนยันแก้ไขงาน");

        stage.showAndWait();
        stage.setResizable(false);

        String state = stateOnclickDB.selectState();
        if (state.equals("true")){
            projectDB.updateStatus("แก้ไข",labelId.getText());
            Stage stage1 = (Stage) labelDetail.getScene().getWindow();
            stage1.close();
            stateOnclickDB.deleteAll();

        }

    }
    public void handleBackOnClick(){
        Stage stage1 = (Stage) labelDetail.getScene().getWindow();
        stage1.close();

    }




}
