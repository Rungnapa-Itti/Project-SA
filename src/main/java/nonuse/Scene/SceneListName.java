package nonuse.Scene;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class SceneListName {
    @FXML
    private TableView<String> tableView;
    @FXML
    private TableColumn<String,String> id , name , phone ,  email , managerId , projectId;


    public void ShowAll(){
        

    }


}
