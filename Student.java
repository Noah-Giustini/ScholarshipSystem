import java.util.Scanner;
import java.util.*;

//import javafx.application.Application;

public class Student extends User{

    /**
     * All the applications the student has made
     */
    private ArrayList<Application> applications;        //TODO make method to get this list of applications
    private boolean hasGottenScholarship = false;
    private String eduLvl = "Undergrad";
    private String name;
    private double GPA;


    public Student(String name, String eduLvl, double GPA){
        this.name = name;
        this.eduLvl = eduLvl;
        this.GPA = GPA;
    }

    /**
     * @return the applications
     */
    public ArrayList<Application> getApplications() {
        return applications;
    }

    /**
     * @return the hasGottenScholarship
     */
    public boolean isHasGottenScholarship() {
        return hasGottenScholarship;
    }


    /**
     * @return the eduLvl
     */
    public String getEduLvl() {
        return eduLvl;
    }

    /**
     * @param eduLvl the eduLvl to set
     */
    public void setEduLvl(String eduLvl) {
        this.eduLvl = eduLvl;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gPA
     */
    public double getGPA() {
        return GPA;
    }

    /**
     * @param gPA the gPA to set
     */
    public void setGPA(double gPA) {
        GPA = gPA;
    }



    /**
     * Will let the student apply for a certain scholarship
     * @param scholarship the scholarship the student will apply for
     * @return the new application of the student
     */
    public void apply(Scholarship scholarship) {
        Scanner scan = new Scanner(System.in);
        Application app = new Application(scholarship.getName(), this.name);
        try {
            app.setPriority(scan.nextInt());
        } catch (Exception e) {
            System.out.println("invalid priority, set to 1");
            app.setPriority(1);
        }
        app.setGPA(this.GPA);
        app.setDate("01/02/2019");
        app.setStatus("pending");
        app.setEducationLevel(this.eduLvl);
        


        
    }


    /**
     * Will let the student edit an application
     * @param app application to edit
     */
    public void editApplication(Application app) {
        Scanner scan = new Scanner(System.in);
        String choice;
        boolean tryAgain = true;

        while(tryAgain){
            System.out.println("What would you like to edit?");
            System.out.println("Press      Placeholder \n  Enter \"e\" to exit");
            choice = scan.nextLine();
            switch (choice){
                case "e":   tryAgain = false; 
                    break;

                case "g":   this.editGPA(app);
                    break;

                case "l":   this.editLevel(app);
                    break;

                case "p":   this.fixPriority();
                    break;

                default:    System.out.println("Please enter a valid command");
                    break;
            }
            scan.nextLine();
        }
        scan.close();
    }



    /**
     * List all the applications the student has made
     */
    public void viewApplications() {
        for(Application a : applications){
            System.out.println(a.toString());
        }

    }


    /**
     * Will let the student withdraw an application
     * @param app application that will be withdrawn
     */
    public void withdrawApplication(Application app) {
        this.applications.remove(app);
        Scholarship sch = new Scholarship(app.getScholarship());
        //not sure how to tell scholarship application was withdrawn
        //sch.deleteApplication(app); 
        this.fixPriority();
        System.out.println("Application has been sucessfully withdrawn. ");
    }


    /**
     * Will show all scholarships the student is eligible for 
     */
    public void viewScholarships(ArrayList<Scholarship> scholars){
        for (Scholarship s : scholars){
            s.toString();
        }


    }
    
    /**
     * will give the user a command prompt to verify that he really wants to accept it
     * If the student wished to accept it all application will be withdrawn and other scholarship offers will be declined
     * @param scholarship scholarship the student will accept
     */
    public void acceptScholarship(Scholarship scholarship) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you sure you want to accept this scholarship. Enter \"y\" for yes or enter anything else to exit");
        String choice = scan.nextLine();
        if(choice.equals("y")){
            //scholarship.accept(this); just a placeholder for now
            this.hasGottenScholarship = true;
            this.rejectAll();
        }
        
        scan.close();
    }


    /**
     * Will give the user a command prompt to verify that he really wants to decline it.
     * If declined the student will no longer be able to accept this scholarship
     * @param scholarship scholarship to be declined 
     */
    public void declineScholarship(Scholarship scholarship) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you sure you want to decline this scholarship. Enter \"y\" for yes or enter anything else to exit");
        String choice = scan.nextLine();
        if(choice.equals("y")){
            //scholarship.decline(this); // just a placeholder for now
        }
        scan.close();
    
    }

    /**
     * Will fix the priority of the applications. Not sure how to be implemeted yet
     */
    private void fixPriority(){

    }

    /**
     * will get an arraylist of all eligble scholarships for this student
     * @return arraylist of scholarships the student is eligible for
     */
    public ArrayList<Scholarship> getEligbleScholarships(){
        return null;
    }

    private void rejectAll(){

    }

    private void editGPA(Application app){
        System.out.println("Your current gpa in the application is: " + app.getGPA());
        Scanner scan = new Scanner(System.in);
        double newGPA;
        boolean tryAgain = true;
        
        while(tryAgain){
            try {
                System.out.println("What would you like to change it to? ");
                newGPA = scan.nextDouble();
                if(newGPA < 0.0 || newGPA > 4.0){
                    System.out.println("Please enter a valid number");   
                }
                else{
                    tryAgain = false;
                }

            } catch (Exception e) {
                System.out.println("Please enter a valid number");
            }
            scan.next();
        }
        app.setGPA(newGPA);
        scan.close();
    }



    private void editLevel(Application app){
        System.out.println("Your current level is: " + app.getEducationLevel());
        Scanner scan = new Scanner(System.in);
        boolean tryAgain = true;
        System.out.println("What is your current education level?");
        newEdu = scan.nextLine();
        scan.close();
        app.setEducationLevel(newEdu);    
    }



}