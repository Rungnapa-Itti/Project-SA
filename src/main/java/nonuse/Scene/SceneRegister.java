package nonuse.Scene;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneRegister {
    private Button buttonRegister;

    public void handleRegisterButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scenceRegisterParant = FXMLLoader.load(getClass().getResource("/scene/manager/sceneMainManager.fxml"));
        Scene sceneRegister = new Scene(scenceRegisterParant);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneRegister);
        window.show();
    }

    public void handleCancelButtonOnClick(ActionEvent actionEvent) throws IOException {
        Parent scenceCancelParant = FXMLLoader.load(getClass().getResource("/scene/scenelogin.fxml"));
        Scene sceneRegister = new Scene(scenceCancelParant);
        Stage window = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();

        window.setScene(sceneRegister);
        window.show();
    }
}
