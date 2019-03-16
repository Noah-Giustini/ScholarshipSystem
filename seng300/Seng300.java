/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import java.awt.event.ActionEvent;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Kaitlin
 */


public class Seng300 extends Application {
public static Stage mainStage;
    
    @Override
    public void start(Stage stage) throws Exception {
        Seng300.mainStage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("adminMainPage.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
		        launch(args);
    }
	
		
	/**
	* Looks through Scholarships folder and adds all scholarships to the 
	* arraylist scholarships
	 */	
	public void findScholarships()throws Exception{
		
		File dir = new File("Scholarships\\");
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File child : directoryListing) { 	
				String schname = child.getName();
				Scholarship s = new Scholarship(schname, true);
					scholarships.add(s);
				}
			}
		
		//for (int i = 0; i < scholarships.size(); i++){
		//	System.out.println(scholarships.get(i));
		//}	
	}
	
	/**
	* Looks through the ScholarshipDrafts folder and adds all scholarships to the 
	* arraylist ScholarshipSaves
	 */	
	public void findScholarshipDrafts()throws Exception{
		
		File dir = new File("ScholarshipDrafts\\");
		File[] directoryListing = dir.listFiles();
		
		if (directoryListing != null) {
			for (File child : directoryListing) { 	
				String schname = child.getName();
				Scholarship s = new Scholarship(schname, false);
					scholarshipdrafts.add(s);
				}
			}
		
		//for (int i = 0; i < scholarshipdrafts.size(); i++){
		//	System.out.println(scholarshipdrafts.get(i));
		//}	
	}
	
		
    
}
