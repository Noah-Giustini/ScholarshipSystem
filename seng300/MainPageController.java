/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Essentials.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Kaitlin
 */
public class MainPageController implements Initializable {

    @FXML
    private ScrollPane currentScholarshipScrollPane;
    @FXML
    private ScrollPane historyScrollPane;
    @FXML
    private Button adminMainPageLogoutButton;
    @FXML
    private Button createNewScholarshipButton;
    @FXML
    private Button viewApplicationsButton;

    @FXML
    private Label sch1Label;
    @FXML
    private Label sch2Label;
    @FXML
    private Label sch3Label;
    @FXML
    private Label sch4Label;

    @FXML
    private Button sch1Button;
    @FXML
    private Button sch2Button;
    @FXML
    private Button sch3Button;
    @FXML
    private Button sch4Button;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ArrayList<Scholarship> sch = Seng300.getScholarships();
        String buttonText = "View";
        sch1Label.setText(sch.get(0).getName());
        sch2Label.setText(sch.get(1).getName());
        sch3Label.setText(sch.get(2).getName());
        sch4Label.setText(sch.get(3).getName());
        sch1Button.setText(buttonText);
        sch2Button.setText(buttonText);
        sch3Button.setText(buttonText);
        sch4Button.setText(buttonText);
        
    }

    @FXML
    private void handleCreateNewScholarshipButtonAction(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/CreateScholarshipFXML.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
        s.setTitle("Create Scholarship");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void openApplicationsWindow(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdditionalScenes/applications.fxml"));
        Scene sc = new Scene(root);
        Stage s = Seng300.mainStage;
        s.setTitle("Create Scholarship");
        s.setScene(sc);
        s.show();
    }

    @FXML
    private void openScholarship1(javafx.event.ActionEvent event) throws IOException {

    }

    @FXML
    private void openScholarship2(javafx.event.ActionEvent event) throws IOException {
        
    }
    @FXML
    private void openScholarship3(javafx.event.ActionEvent event) throws IOException {
        
    }
    @FXML
    private void openScholarship4(javafx.event.ActionEvent event) throws IOException {
        
    }

}
