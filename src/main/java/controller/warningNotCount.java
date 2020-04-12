package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.awt.*;

public class warningNotCount {
    @FXML
    private Button buttonok;

    public void handleOkOnClick(){
        Stage stage1 = (Stage) buttonok.getScene().getWindow();
        stage1.close();
    }
}
