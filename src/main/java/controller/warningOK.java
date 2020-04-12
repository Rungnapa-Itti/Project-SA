package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;

public class warningOK {
    @FXML
    Button buttonOK;

    public void handleOkOnclick(){
        Stage stage1 = (Stage) buttonOK.getScene().getWindow();
        stage1.close();
    }
}
