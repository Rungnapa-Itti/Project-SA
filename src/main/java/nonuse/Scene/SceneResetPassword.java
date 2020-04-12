package nonuse.Scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


import java.io.IOException;

public class SceneResetPassword {
    @FXML
    private Label labelId;
    @FXML
    private Label labeNewPassword;
    @FXML
    private Label labelConfirmPassword;
    @FXML
    private Label labelException;
    @FXML
    private Button buttonReset;
    @FXML
    private Button buttonCancel;

    public void handleResetButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scenceResetParant = FXMLLoader.load(getClass().getResource("/scene/scenelogin.fxml"));
        Scene sceneReset = new Scene(scenceResetParant);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneReset);
        window.show();
    }

    public void handleCancelButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scenceCancelParant = FXMLLoader.load(getClass().getResource("/scene/scenelogin.fxml"));
        Scene sceneCancel = new Scene(scenceCancelParant);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneCancel);
        window.show();
    }
}
