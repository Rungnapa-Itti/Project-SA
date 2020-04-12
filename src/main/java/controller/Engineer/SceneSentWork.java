package controller.Engineer;

import Model.Progress;
import controller.AlertBox;
import controller.Manager.SceneDescriptionWork;
import database.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SceneSentWork {
    StateOnclickDB stateOnclickDB = new StateOnclickDB();
    AllWorkDB allWorkDB = new AllWorkDB();
    ProjectDB projectDB = new ProjectDB();
    ProgressDB progressDB = new ProgressDB();
    LoginDB loginDB = new LoginDB();
    @FXML
    private Label labelId;
    @FXML
    private  Label labelName;
    @FXML
    private Label labelDate;
    @FXML
    private TextArea textAreaData;
    @FXML
    private Button buttonSelect;
    @FXML
    private Button buttonCancel;
    @FXML
    private Button buttonSave;
    @FXML
    private Button buttonSent;


    public void initialize() throws SQLException, ClassNotFoundException {
        projectDB.deleteAll();
    }
    public void handleselectProjectOnClick() throws IOException, SQLException, ClassNotFoundException {
       projectDB.deleteAll();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/Engineer/sceneWorkNotCompleteForSent.fxml"));
        Stage stage = new Stage();
        stage.setScene(new Scene(loader.load(), 694, 505));
        stage.showAndWait();
        stage.setResizable(false);
        String[] data = projectDB.getNameProject();
        labelId.setText(data[4]);
        labelName.setText(data[0]);
        labelDate.setText(data[2]+data[3]);



    }

    public void handleSentWorkOnClick() throws SQLException, ClassNotFoundException, IOException {
        if (labelId.getText() == "" || labelName.getText() == "" || labelDate.getText() == "" ){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotData.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }
       else {
            stateOnclickDB.deleteAll();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการส่ง");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                projectDB.upDateSentWorkById(labelId.getText());
                labelId.setText("");
                labelName.setText("");
                labelDate.setText("");
                textAreaData.setText("");
            }
        }

    }
    public void handleSaveOnClick() throws SQLException, ClassNotFoundException, IOException {
        if (labelId.getText() == "" || labelName.getText() == "" || labelDate.getText() == "" ){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotData.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        }
        else {
            stateOnclickDB.deleteAll();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการบันทึก");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date date = new Date(System.currentTimeMillis());
                //System.out.println(dateFormat.format(date));;
                progressDB.insertWork(loginDB.getId(), labelId.getText(), textAreaData.getText(), dateFormat.format(date));
            }
        }
    }
    public void handleCancelOnClick() throws SQLException, ClassNotFoundException, IOException {
        if (labelId.getText() == "" || labelName.getText() == "" || labelDate.getText() == "") {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/warningNotData.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));
            stage.show();
            stage.setResizable(false);
        } else {
            stateOnclickDB.deleteAll();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/scene/alert.fxml"));
            Stage stage = new Stage();
            stage.setScene(new Scene(loader.load(), 400, 200));

            AlertBox controller = loader.<AlertBox>getController();
            controller.settingLabel("ยืนยันการยกเลิก");

            stage.showAndWait();
            stage.setResizable(false);
            String state = stateOnclickDB.selectState();
            if (state.equals("true")) {
                labelId.setText("");
                labelDate.setText("");
                labelName.setText("");
                textAreaData.setText("");
            }

        }
    }

}
