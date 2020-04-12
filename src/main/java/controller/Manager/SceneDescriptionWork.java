package controller.Manager;

import Model.Project;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Map;

public class SceneDescriptionWork {
    @FXML
    private Label labelId;
    @FXML
    private Label labelName;
    @FXML
    private Label labelEmployee;
    @FXML
    private Label labelDescription;
    @FXML
    private Button buttonNext;
    private String selectedIdWork;


    public void initialize(){

    }

    public void setSelectedIdWork(String selectedIdWork){
        this.selectedIdWork = selectedIdWork;

    }
    public void handleNextOnClick(){
        Stage stage1 = (Stage) labelId.getScene().getWindow();
        stage1.close();
    }

    public void settingLabel(String id , String name , String employee , String description){

        labelId.setText(id);
        labelName.setText(name);
        labelEmployee.setText(employee);
        labelDescription.setText(description);
    }





}
