package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class warningNotSelect {
    @FXML
    private Button buttonOk;

    public void handleOkOnClick(){
        Stage stage1 = (Stage) buttonOk.getScene().getWindow();
        stage1.close();
    }
}
