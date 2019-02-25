import java.util.Scanner;

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
    public Scholarship createScholarship() {
        Scanner scan = new Scanner(System.in);
        String name;
        String dueDate;
        double amt;
        int recipients;
        ArrayList<String> levels = new ArrayList<String>();

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



    }
    public void modRemovScholarship() {
        //to be implemented
    }
    public void status() {
        //to be implemented
    }
    public void chooseWinner() {
        //to be implemented
    }

}