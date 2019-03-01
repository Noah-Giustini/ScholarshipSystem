import java.util.Scanner;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Admin{
    public void viewApplications(Arraylist<Application> allApplications) {
        for (i=0; i < allApplications.length; i++){
            System.out.println(i.toString());
        }
    }
    public void confirmAward() {
        //to be implemented
    }
    public void rejectApplication() {
        //to be implemented
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
    //returns type int. 1 = closed, 0 = open
    public int status(Scholarship s) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        String cd = dateFormat.format(date);
        String[] parts = cd.split("/");
        int cdDay = Integer.parseInt(parts[0]);
        int cdMonth = Integer.parseInt(parts[1]);
        int cdYear = Integer.parseInt(parts[2]);
        String sd = s.getDueDate();
        String[] parts2 = cd.split("/");
        int sdDay = Integer.parseInt(parts2[0]);
        int sdMonth = Integer.parseInt(parts2[1]);
        int sdYear = Integer.parseInt(parts2[2]);
        int status = 0;

        if (sdYear < cdYear){
            status = 1; //closed
        }
        else if (sdYear == cdYear){
            if (sdMonth < cdMonth){
            status = 1; //closed
            }
            else if (sdMonth == cdMonth){
                if (sdDay < cdDay){
                status = 1; //closed
                }
                else{
                    status = 0; // open
                }
            }
            else{
                status = 0; // open
            }
        }
        else{
            status = 0; //open
        }
        return status;
    }

}