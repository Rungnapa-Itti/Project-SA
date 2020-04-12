package nonuse.Scene;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import nonuse.classp.Assignment;

public class SceneState {
    private Assignment assignment;
    @FXML
    private TableView<String> tableView = new TableView<String>();
    @FXML
    private TableColumn<String,String> id,name,detail,startDate,finishDate,status,department,employeeId;

    public void ShowAll(){
       //tableView.getColumns().addAll(id,name);



    }
}
