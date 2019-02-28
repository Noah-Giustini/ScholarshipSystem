import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class drives the "on rails" text based interface.
 */
public class ScholarshipSystem {
    
    public static ArrayList<Scholarship> scholarshipList = new ArrayList<Scholarship>(); //temporary place to store scholarships. Must be initialized on start up
    public static ArrayList<Application> applicationList = new ArrayList<Application>();

/**
 * The main method controls the experience
 */
    public static void main(String[] args) {
        Scholarship.startUp();
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
    
                //invalid command
                if(!(userInput.equals("view scholarships") || userInput.equals("manage applications"))) {
                    System.out.println("Invalid command. Please enter view scholarships or manage applications");
                }
            }

            //create student object to be able to pass information to the student portal and access student methods
            Student currentStudent = new Student("PLACEHOLDER", "bach1", 3.0);     //TODO how did we want to handle this? Should student name, eduLevel and gpa be inputted
            switch(userInput) {                         // or for iteration 1 should it be some default value?
                case "manage applications":  
                    studentManageApplicationPortal(currentStudent,scan);
                    break;

                case "view scholarships":
                    studentScholarshipPortal(currentStudent, scan);
                    break;
            }
        }
        else if (loginChoice.equals("admin")) {
            String userInput = "";
            System.out.println("You may <view scholarships> or <create scholarship>");

            while(!(userInput.equals("view scholarships") || userInput.equals("create scholarship"))) {
                userInput = scan.nextLine().toLowerCase();
    
                //invalid command
                if(!(userInput.equals("view scholarships") || userInput.equals("create scholarship"))) {
                    System.out.println("Invalid command. Please enter view scholarships or create scholarship");
                }
            }

            Admin currentAdmin = new Admin();
            switch(userInput) {
                case "view scholarships":
                    adminManageScholarshipPortal(currentAdmin, scan);
                    break;

                case "create scholarship":
                    adminCreateScholarshipPortal(currentAdmin, scan);
                    break;
            }
        }
        //if something horrible and unexpected happens with the above login choice, this should catch it
        else {
            System.out.println("Fatal Error: Invalid Login");
        }
        scan.close();
    }

    /**
     * Steps the student into their application portal where they can view and manage their applications.
     * @param currentStudent the student currently logged in
     * @param scan The input scanner
     */
    private static void studentManageApplicationPortal(Student currentStudent, Scanner scan) {

        //printFakeApplication(); //TODO: REMOVE THIS LINE WHEN STUDENT AND APPLICATION CLASS WORK

        System.out.println("\nYou can <view>, <edit>, <withdraw>, <accept> or <decline> an application.");

        String userInput = "";
        Boolean isValidCommand = false;

        //while loop used to validate user input
        while(isValidCommand ==  false) {
            userInput = scan.nextLine().toLowerCase();

            if(userInput.equals("view")) {
                isValidCommand = true;
                currentStudent.viewApplications();

            } else if(userInput.equals("edit") || userInput.equals("withdraw")) {
                isValidCommand = true;

                //if student has no applications, end
                if(currentStudent.getApplications().isEmpty()) {
                    System.out.println("You have no applications.");
                    System.exit(0);
                }

                System.out.print("Enter the name of the application you wish to " + userInput + ": ");
                Boolean validApplication = false;
                String applicationName = "";

                //while loop checks to make sure user entered an application that exists
                while(validApplication == false) {
                    applicationName = scan.nextLine().toLowerCase();

                    for (Application app : currentStudent.getApplications()) {  //TODO Need this method in Student class
                        if(applicationName.equals(app.getScholarship().toLowerCase())) {
                            validApplication = true;

                            if(userInput.equals("edit")) {
                                currentStudent.editApplication(app);
                            } else if(userInput.equals("withdraw")) {
                                currentStudent.withdrawApplication(app);
                            }
                            
                            System.out.println("Your application has been updated successfully!");
                            System.exit(0);         //For iteration 1 since we won't have backtracking
                        }
                    }

                    System.out.println("Invalid application name. Please try again.");
                }


            } else if(userInput.equals("accept") || userInput.equals("decline")) {
                isValidCommand = true;

                //if student has no applications, end
                if(currentStudent.getApplications().isEmpty()) {
                    System.out.println("You have no applications.");
                    System.exit(0);
                }

                //TODO FINISH ADMIN PORTAL BEFORE PROGRESSING FURTHER

            } else {
                System.out.println(userInput + " is not a valid command. Please try again.");
            }

        }

    }

    /**
     * Puts the student into a portal where they can view all scholarships they are eligible for and apply to them
     * @param currentStudent the student currently logged in
     * @param scan The input scanner
     */
    private static void studentScholarshipPortal(Student currentStudent, Scanner scan) {
        try {
        currentStudent.viewScholarships(scholarshipList);

        System.out.print("\nEnter the name of the scholarship you wish to select: ");

        Boolean isValidScholarship = false;
        String desiredScholarshipName = "";
        Scholarship desiredScholarship =  new Scholarship("PLACEHOLDER");   //maybe make a default/placeholder scholarship or change code here
        //check that the name the user entered is an existing scholarship
        while(isValidScholarship == false) {
            desiredScholarshipName = scan.nextLine().toLowerCase();

            for (Scholarship sch : currentStudent.getEligbleScholarships()) {
                if(sch.getName().toLowerCase().equals(desiredScholarshipName)) {
                    desiredScholarship = sch;
                    isValidScholarship = true;
                }
            }
            if(isValidScholarship == false) {
                System.out.println("Please enter a valid scholarship name.");
            }
        }

        //student can now apply for that scholarship
        System.out.println("You may <apply> to the " + desiredScholarshipName + " Scholarship.");
        String userInput = "";

        //command validation
        while(!(userInput.equals("apply"))) {
            userInput = scan.nextLine().toLowerCase();
    
               //invalid command
              if(!(userInput.equals("apply"))) {
                  System.out.println("Invalid command. Please enter remove, edit or view applications");
              }
        }

        switch(userInput) {     //placed in switch in case we want to expand the student's commands here later
            case "apply":
                currentStudent.apply(desiredScholarship);
                break;
        }
     } catch (Exception e) {
         System.out.println("ERROR");
         System.exit(0);
     }
        
    }

    /**
     * The portal where the admin can view and manage existing scholarships and applications to them
     * @param currentAdmin the admin currently logged in
     * @param scan The input scanner
     */
    private static void adminManageScholarshipPortal(Admin currentAdmin, Scanner scan) {
        System.out.println("Scholarships:");

        //prints every scholarship in the list
        for (Scholarship sch : scholarshipList) {
            System.out.println("Name: " + sch.getName() + " |Amount: " + sch.getAmount() + " |Deadline: " + sch.getDueDate());
        }

        System.out.print("\nEnter the name of the scholarship you wish to select and manage: ");

        Boolean isValidScholarship = false;
        String desiredScholarship = "";
        //check that the name the user entered is an existing scholarship
        while(isValidScholarship == false) {
            desiredScholarship = scan.nextLine().toLowerCase();

            for (Scholarship sch : scholarshipList) {
                if(sch.getName().toLowerCase().equals(desiredScholarship)) {
                    desiredScholarship = sch.getName();
                    isValidScholarship = true;
                }
            }
            if(isValidScholarship == false) {
                System.out.println("Please enter a valid scholarship name.");
            }
        }

        System.out.println("You may <remove>, <edit> or <view applications> on the chosen " + desiredScholarship + " Scholarship.");

        String userInput = "";

        //command validation
        while(!(userInput.equals("remove") || userInput.equals("view") || userInput.equals("view applications"))) {
            userInput = scan.nextLine().toLowerCase();
    
               //invalid command
              if(!(userInput.equals("remove") || userInput.equals("view") || userInput.equals("view applications"))) {
                  System.out.println("Invalid command. Please enter remove, edit or view applications");
              }
        }

        switch(userInput) {
            case "remove":
                System.out.println("ENTERED REMOVE. FUNCTIONALITY NOT YET FINISED!");
                //currentAdmin.modRemovScholarship(desiredScholarship); //TODO allow system to pass scholarship name to remove it and update scholarship list
                break;
            case "edit":
                System.out.println("ENTERED EDIT. FUNCTIONALITY NOT YET FINISED!");
                //currentAdmin.editScholarship(desiredScholarship);   //TODO add this edit method to admin class
                break;
            case "view applications":
                adminApplicationAwardPortal(currentAdmin, scan, desiredScholarship);
                break;

        }

    }

    /**
     * This method allows the admin to view all applications on the desired scholarship and see detailed views of an application
     * @param currentAdmin The admin object which holds many useful methods
     * @param scan The scanner for user input
     * @param desiredScholarship The name of the scholarship the user has selected and wants to manage
     */
    private static void adminApplicationAwardPortal(Admin currentAdmin, Scanner scan, String desiredScholarship) {
        //currentAdmin.viewApplications(desiredScholarship);      //TODO implement this method in admin class
        currentAdmin.viewApplications();
        //TODO allow admin to see a brief view of an application (student name, grade, level?) and choose to see a detailed view (full application)
    }

    /**
     * The portal where the admin can create new scholarships
     * @param currentAdmin the admin currently logged in
     * @param scan The input scanner
     */
    private static void adminCreateScholarshipPortal(Admin currentAdmin, Scanner scan) {
        String scholarshipName, scholarshipDescription, scholarshipDeadline;
        ArrayList<String> scholarshipRequirements = new ArrayList<>();
        Double reward;
        int numberOfRecipients;
        ArrayList<String> scholarshipEducationLevels = new ArrayList<>();

        System.out.print("Please enter the name of the scholarship (case sensitive): ");
        scholarshipName = scan.nextLine();

        System.out.print("\nPlease enter the monetary reward of the scholarship: ");
        reward = Double.parseDouble(scan.nextLine());

        System.out.print("\nPlease enter the brief description of the scholarship (as a single line): ");
        scholarshipDescription = scan.nextLine();
        //scan.next();

        System.out.print("\nPlease enter the deadline of the scholarship (as numbers, MMDDYYYY): ");
        scholarshipDeadline = scan.nextLine();
        //scan.next();

        System.out.print("\nPlease enter the number of recipients of the scholarship: ");
        numberOfRecipients = Integer.parseInt(scan.nextLine());
        //scan.next();
        //scan.reset();

        System.out.println("\nPlease enter the education levels that are required for the scholarship as one line each (lowercase). Type end when you are finished. ");
        //TODO Run a loop and check inputs to ensure valid levels are entered here
        String singleLevel = scan.nextLine();
        while(!singleLevel.toLowerCase().equals("end")) {
            switch(singleLevel) {
                case "bach1": case "bach2": case "bach3": case "bach4": case "ms": case "phd":
                    scholarshipEducationLevels.add(singleLevel);
                    break;

                default:
                    System.out.println("\nInvalid education level. Must be at least one of {bach1, bach2, bach3, bach4, ms, phd}. Please try again.");
                    break;
            }

            singleLevel = scan.nextLine();
            
        }


        System.out.println("\nPlease enter the requirements as one line each. Type end when you are finished.");
        String singleRequirement = scan.nextLine();
        while(!singleRequirement.toLowerCase().equals("end")) {
            scholarshipRequirements.add(singleRequirement);

            singleRequirement = scan.nextLine();
        }

        
        
        try {
            currentAdmin.createScholarship(scholarshipName, scholarshipDeadline, reward, numberOfRecipients, scholarshipEducationLevels);
            scholarshipList.add(new Scholarship(scholarshipName));
        } catch (Exception e) {
            System.out.println("ERROR: Unable to create scholarship. Closing system.....");
            System.exit(0);
        }     
        //scholarshipList.add(new Scholarship(scholarshipName, scholarshipDeadline, reward, numberOfRecipients, scholarshipEducationLevels));
        //TODO create a list of all existing scholarships that can be updated 

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