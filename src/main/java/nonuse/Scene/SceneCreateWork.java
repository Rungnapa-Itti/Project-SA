package nonuse.Scene;

import com.jfoenix.controls.JFXButton;
import nonuse.db.CreateWorkDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Date;

public class SceneCreateWork {
    public String date;
    public Date startDate;

    @FXML
    private TextField textFieldId;
    @FXML
    private TextField textFieldDepart;
    @FXML
    private TextField textFieldname;
    @FXML
    private JFXButton jfxButtonSelect;
    @FXML
    private TextArea textAreaDescription;
    @FXML
    private Button buttonSubmit;


    public void handleSumbitButtonOnClick(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {


        CreateWorkDB.insert(textFieldId.getText(),textFieldname.getText(),textAreaDescription.getText(),"02/09/2562","23/09/2562","รอดำเนินการ",textFieldDepart.getText(),"E001");
    }

}
