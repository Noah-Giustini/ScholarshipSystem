import java.util.Scanner;

import javafx.application.Application;

public class Student implements User{

    /**
     * All the applications the student has made
     */
    private ArrayList<Application> applications;        //TODO make method to get this list of applications
    private boolean hasGottenScholarship = false;




    /**
     * Will let the student apply for a certain scholarship
     * @param scholarship the scholarship the student will apply for
     * @return the new application of the student
     */
    public Application apply(Scholarship scholarship) {

        return null;
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
                case "e": tryAgain = false; 
                    break;
                default:  app.edit();  //generic name 
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
        this.fixPriority();
        System.out.println("Application has been sucessfully withdrawn. ");
    }


    /**
     * Will show all scholarships the student is eligible for 
     */
    public void viewScholarships(){
        ArrayList<Scholarship> scholars = this.getEligbleScholarships();
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
        if(choice == "y"){
            scholarship.accept(this); // just a placeholder for now
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
        if(choice == "y"){
            scholarship.decline(this); // just a placeholder for now
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


}