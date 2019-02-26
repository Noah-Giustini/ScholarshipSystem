import java.util.Scanner;
import java.sql.Date;

public class Admin extends User{
    public void viewApplications() {
        //to be implemented
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
    public Scholarship createScholarship(String name, String dueDate, double amt, int recipients, ArrayList<String> levels) {
        Scanner scan = new Scanner(System.in);
        /* String name;
        String dueDate;
        double amt;
        int recipients;
        ArrayList<String> levels = new ArrayList<String>(); */

        //Updated code starts here 02/26/2019
        Scholarship s = new Scholarship(name);
        s.setDueDate(dueDate);
        s.setAmount(amt);
        s.setRecipients(recipients);
        s.setLevels(levels);
        return s;

        //old code from before 02/26/2019 is below: This code is no longer needed in this class and should be deleted after implementation in the Scholarshipsystem class
        /*
        System.out.println("What is the name of the scholarship you wish to create?");
        name = scan.nextLine();
        Scholarship scol = new Scholarship(name);
        int dateGood = 0;
        while (dateGood == 0){
            System.out.println("What will the due date of the scholarship be?");
            dueDate = scan.nextLine();
            if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", dueDate)){
                scol.setDueDate(dueDate);
                dateGood = 1;
            }
            else{
                System.out.println("Invalid format. must follow mm/dd/yyyy");
            }
        }
        int amtGood = 0;
        while (amtGood == 0){
            System.out.println("How much will the scholarship be worth");
            try{
                amt = Double.parseDouble(scan.nextLine());
                amtGood = 1;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Must be of type double");
            }
        }
        scol.setAmount(amt);
        int recGood = 0;
        while (recGood == 0){
            System.out.println("How many people can recieve this scholarship?");
            try{
                recipients = Integer.parseInt(scan.nextLine());
                recGood = 1;
            }
            catch(NumberFormatException e){
                System.out.println("Invalid input. Must be of type integer");
            }
        }
        scol.setRecipients(recipients);
        System.out.println("What levels is this scholarship available for?")
        while (sc.hasNextString()) {
            int i = scan.nextString();
            levels.add(i);
        }
        scol.setLevels(levels);
        return scol;
        */


    }
    public void modRemovScholarship() {
        //to be implemented
    }
    public void status() {
        //to be implemented
    }

}