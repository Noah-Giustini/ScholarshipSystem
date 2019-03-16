/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seng300;

import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import Essentials.*;

/**
 *
 * @author Kaitlin
 */

public class Seng300 extends Application {

    public static Stage mainStage;

    private static ArrayList<Scholarship> sch = new ArrayList<Scholarship>();

    @Override
    public void start(Stage stage) throws Exception {
        Seng300.mainStage = stage;
        Seng300.startUp();
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

    public static void addScholarship(Scholarship newSch) {
        sch.add(newSch);
    }

    public static ArrayList<Scholarship> getScholarships() {
        return sch;
    }

    public static void startUp() {
        File folder = new File("ScholarshipSystem" + File.separator + "Scholarships");
        File[] listOfFiles = folder.listFiles();
        for (File a : listOfFiles) {
            if (a.isFile()) {
                String name = a.getName().substring(0, (a.getName().length() - 4));
                try {
                    Scholarship newSch = new Scholarship(name, true);

                    Seng300.addScholarship(newSch);
                } catch (Exception e) {
                    System.out.println("Something done fucked up loading scholarships");
                }
            }
        }
    }
}
