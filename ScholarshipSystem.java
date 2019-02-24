import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class drives the "on rails" text based interface.
 */
public class ScholarshipSystem {


/**
 * The main method controls the experience
 */
    public static void main(String[] args) {
        //asks for login information and validates that input
        System.out.println("Welcome to the UC Scholarship system! Words that appear in <pointed braces> are commands that you can enter\n(do not type the braces)."
                            + "\n\nWould you like to log in as <student> or <admin>? (Please enter student or admin without the pointed braces)");

        String loginChoice = "";
        Scanner scan = new Scanner(System.in);

        while(!(loginChoice.equals("student") || loginChoice.equals("admin"))) {
            loginChoice = scan.nextLine().toLowerCase();

            //invalid login choice (not student or admin)
            if(!(loginChoice.equals("student") || loginChoice.equals("admin"))) {
                System.out.println("Invalid login. Please enter student or admin to log in.");
            }
        }

        System.out.println("\nWelcome to the " + loginChoice + " portal of the UC Scholarship System!");

        if(loginChoice.equals("student")) {
            String userInput = "";
            System.out.println("You may <view scholarships> or <manage applications>\n");

            while(!(userInput.equals("view scholarships") || userInput.equals("manage applications"))) {
                userInput = scan.nextLine().toLowerCase();
    
                //invalid login choice (not student or admin)
                if(!(userInput.equals("view scholarships") || userInput.equals("manage applications"))) {
                    System.out.println("Invalid command. Please enter view scholarships or manage applications");
                }
            }

            switch(userInput) {
                case "manage applications":  
                    //Student currentStudent = new Student();
                    studentManageApplicationPortal(/*currentStudent,*/scan);
                    break;
            }
        }
        else if (loginChoice.equals("admin")) {

        }
        //if something horrible and unexpected happens with the above login choice, this should catch it
        else {
            System.out.println("Fatal Error: Invalid Login");
        }
        scan.close();
    }

    /**
     * Steps the student into their application portal where they can view and manage their applications.
     * 
     * PARTS COMMENTED OUT TO ALLOW FOR TESTING WITHOUT NEEDING A WORKING STUDENT CLASS
     */
    private static void studentManageApplicationPortal(/*Student currentStudent,*/ Scanner scan) {

        printFakeApplication(); //TODO: REMOVE THIS LINE WHEN STUDENT AND APPLICATION CLASS WORK

        System.out.println("\nYou can <view>, <edit>, <withdraw>, <accept> or <decline> an application.");

        String userInput = "";
        Boolean isValidCommand = false;

        //while loop used to validate user input
        while(isValidCommand ==  false) {
            userInput = scan.nextLine().toLowerCase();

            if(userInput.equals("view")) {
                isValidCommand = true;
                //currentStudent.viewApplications();

            } else if(userInput.equals("edit")) {
                isValidCommand = true;

                //if student has no applications, end
                if(currentStudent.getApplications().isEmpty()) {
                    System.out.println("You have no applications.");
                    System.exit(0);
                }

                System.out.print("Enter the name of the application you wish to edit: ");
                Boolean validApplication = false;
                String applicationToEditName = "";

                while(validApplication == false) {
                    applicationToEditName = scan.nextLine().toLowerCase();

                    for (Application app : currentStudent.getApplications()) {  //TODO Need this method in Student class
                        if(applicationToEditName.equals(app.getScholarship().toLowerCase())) {
                            //currentStudent.editApplication(app);
                        }
                    }
                }


            } else if(userInput.equals("withdraw")) {
                isValidCommand = true;
            } else if(userInput.equals("accept")) {
                isValidCommand = true;
            } else if(userInput.equals("decline")) {
                isValidCommand = true;
            } else {
                System.out.println(userInput + " is not a valid command. Please try again.");
            }

        }

    }

    /**
     * Helps test the above manage application portal. Makes fake applications for scholarships and prints them in a list format
     */
    private static void printFakeApplication() {
        try {
            ArrayList<Application> fakeList= new ArrayList<>();

            Application fake1 = new Application("Music", "Jim");
            Application fake2 = new Application("Science", "Jim");
            Application fake3 = new Application("Mathematics", "Jim");
            Application fake4 = new Application("Athletics", "Jim");
            Application fake5 = new Application("Conscious Citizen", "Jim");
            Application fake6 = new Application("Award of Excellence", "Jim");

            fakeList.add(fake1);
            fakeList.add(fake2);
            fakeList.add(fake3);
            fakeList.add(fake4);
            fakeList.add(fake5);
            fakeList.add(fake6);

            System.out.println("Your Applications:\n");

            for (Application app : fakeList) {
                System.out.println("Scholarship Name: " + app.getScholarship() + " \t|Status: " + app.getStatus() + " |Priority: " + app.getPriority() + " |Date: " + app.getDate());
            }

        } catch (Exception e) {
            System.out.println("Exception caught in Fake Application method");
        }
        
    }
}