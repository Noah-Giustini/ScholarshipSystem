/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AdditionalScenes;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import seng300.Seng300;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class CreateScholarshipFXMLController implements Initializable {

    @FXML
    private Button buttonBack;
    @FXML
    private Font x1;
    @FXML
    private Button buttonSaveProgress;
    @FXML
    private Button buttonSubmitScholarship;
    @FXML
    private TextField txtEnterSchName;
    @FXML
    private Label statustxt
    @FXML
    private TextArea txtSchDescription;
    @FXML
    private CheckBox chkGPA;
    @FXML
    private DatePicker dateGetter;
    @FXML
    private TextField txtAmount;
    @FXML
    private TextField txtNumRecipients;
    @FXML
    private CheckBox chkbach;
    @FXML
    private CheckBox chkmaster;
    @FXML
    private CheckBox chkDoctorate;
    @FXML
    private TextArea txtCustom1;
    @FXML
    private TextArea txtCustom2;
    @FXML
    private TextArea txtCustom3;
    @FXML
    private Color x4;
    @FXML
    private Font x3;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleSaveScholarship(MouseEvent event) {
		
		String name = txtEnterSchName.getText().trim();
		
		If (name.equals("")){
			statustxt.setText("Unable to Save: Scholarship Requires Name"); 
			return
		}
		
		LocalDate date = dateGetter.getValue();
		int day = date.getDayofMonth();
		int month = date.getMonthValue();
		int year = date.getYe8  ar();
		String strDay;
		String strMonth;
		String strYear = Integer.toString(year);
		
		
		if (day < 10){
			strDay = "0" + Integer.toString(day);
		}
		else {
			strDay = Integer.toString(day);
		}
		
		if (month < 10){
			strMonth = "0" + Integer.toString(month);
		}
		else {
			strMonth = Integer.toString(month);
		}
		
		String duedate = strDay + "/" + strMonth + "/" + strYear;
		
		if 
		
		double amount = 
		
		int recipients
		
		ArrayList<String> levels
			
		
    }

    @FXML
    private void handleSubmitScholarship(MouseEvent event) {
    }

    @FXML
    private void backFromScholarshipCreator(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/seng300/adminMainPage.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage; 
        s.setTitle("Home");
        s.setScene(sc);
        s.show();
    }
    
}
