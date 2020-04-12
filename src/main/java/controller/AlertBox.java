package controller;

import database.StateOnclickDB;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.sql.SQLException;


public class AlertBox {
    StateOnclickDB stateOnclickDB = new StateOnclickDB();
    @FXML
    private Label labelMessage;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonOk;
    private Boolean buttonClick;

    public void initialize(){
        buttonClick = false;
    }
    public void settingLabel(String message){
        System.out.println(message);
        labelMessage.setText(message);
    }

    public void handleCancelOnClick() throws SQLException, ClassNotFoundException {
        stateOnclickDB.deleteAll();
        stateOnclickDB.insertState("false");;
        Stage stage1 = (Stage) labelMessage.getScene().getWindow();
        stage1.close();
    }
    public void handleOkOnClick() throws SQLException, ClassNotFoundException {
        stateOnclickDB.deleteAll();
        stateOnclickDB.insertState("true");
        Stage stage1 = (Stage) labelMessage.getScene().getWindow();
        stage1.close();

    }
    public Boolean getButtonClick(){
        return buttonClick;
    }

}
