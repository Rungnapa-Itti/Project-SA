package controller.Manager;

import Model.Project;
import apple.laf.JRSUIUtils;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.Map;
import java.util.TreeMap;

public class SceneState {
    Map<String, Project> map = new TreeMap<>();
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String , String> id,employee,name,customer,startDate,finishDate,status;


}
