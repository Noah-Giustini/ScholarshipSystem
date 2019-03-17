/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import seng300.Seng300;

public class AdminViewScholarshipController implements Initializable {
    @FXML
    private Button viewScholarshipBackBtn;
    @FXML
    private TextField viewScholarshipNameTextField;
    @FXML
    private TextField viewScholarshipDueDateTextField;
    @FXML
    private TextField viewScholarshipAmountTextField;
    @FXML
    private TextField viewScholarshipRecipientsTextField;
    @FXML
    private TextField viewScholarshipRecipientsChosenTextField;
    @FXML
    private TextField viewScholarshipEducationLevelTextField;


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void backToMain(ActionEvent event) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }
}