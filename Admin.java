import java.util.Scanner;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

//The Admin class is used to contain the methods that can be used only by an administrator of the system
public class Admin extends User{
    /**
	 * view the current applications in the system
	 * @param allApplications is an ArrayList with type Application that contains the applications in the system
     * @return void
	 */
    public void viewApplications(Arraylist<Application> allApplications) {
        for (i=0; i < allApplications.length; i++){
            System.out.println(i.toString());
        }
    }
    /**
	 * confirm an application
	 * @param s is of type Scholarship and is the scholarship that the students application is associated with
     * @param a is of type Application and is the application to be confirmed
     * @return void
	 */
    public void confirmAward(Scholarship s, Application a) {
        a.setStatus("Awarded");
        s.setChosen = s.getChosen()+1;      //we may want to remove this later as it could be better implemented when the student accepts their award
        String name = s.getName;
        String student = a.getStudent();
        System.out.println("The scholarship " + name + " has been granted to student " + student + " and is awaiting their acceptance.");
    }
    /**
	 * reject an application
	 * @param s is of type Scholarship and is the scholarship that the students application is associated with
     * @param a is of type Application and is the application to be rejected
     * @return void
	 */
    public void rejectApplication(Scholarship s, Application a) {
        a.setStatus("Rejected");
        String name = s.getName;
        String student = a.getStudent();
        System.out.println("The application from student" + student + " has been rejected for the scholarship " + scholarship);
    }
    /**
	 * Create a new scholarship to be entered in the system
	 * @param name is the file name given by user 
     * @param dueDate is the due date of the new scholarship
     * @param amt is the amount that the scholarship is worth
     * @param recipients is the integer number of recipients that the scholarship can go out to
     * @param levels an array list of the levels that can recieve the scholarship
     * @return The newly created scholarship is returned as an output
	 */
    public Scholarship createScholarship(String name, String dueDate, double amt, int recipients, ArrayList<String> levels) throws Exception{
    
        Scholarship s = new Scholarship(name);
        s.setDueDate(dueDate);
        s.setAmount(amt);
        s.setRecipients(recipients);
        s.setLevels(levels);
        return s;
    

    }
    public void modRemovScholarship() {
        //to be implemented
    }
    /**
	 * Check the status of a scholarship
	 * @param s is of type Scholarship and is the scholarship we wish to check the status of
     * @return status is returned with type boolean. True us returned indicating the scholarship is closed,
     * false is returned indicating the scholarship is still pending
	 */
    public boolean status(Scholarship s) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String cd = dateFormat.format(date);
        String[] parts = cd.split("/");
        int cdDay = Integer.parseInt(parts[0]); //current day
        int cdMonth = Integer.parseInt(parts[1]); //current month
        int cdYear = Integer.parseInt(parts[2]); //current year
        String sd = s.getDueDate();
        String[] parts2 = cd.split("/");
        int sdDay = Integer.parseInt(parts2[0]); //due date day
        int sdMonth = Integer.parseInt(parts2[1]); //due date month
        int sdYear = Integer.parseInt(parts2[2]); //due date year
        boolean status = false;

        if (sdYear < cdYear){
            status = true; //closed
        }
        else if (sdYear == cdYear){
            if (sdMonth < cdMonth){
            status = true; //closed
            }
            else if (sdMonth == cdMonth){
                if (sdDay < cdDay){
                status = true; //closed
                }
                else{
                    status = false; // open
                }
            }
            else{
                status = false; // open
            }
        }
        else{
            status = false; //open
        }
        return status;
    }

}