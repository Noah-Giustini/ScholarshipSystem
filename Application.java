import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.util.regex.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Application{
	
	private String scholarship = "--";
	private String student = "--";
	private String appfile = "--";
	private String date = "--";
	private double gpa = 0;
	private String edulvl = "--";
	private String status = "--";
	private int priority = 0;

	

	/**
	 * Constructor.
	 * Loads an application for given scholarship and student if the file exists
	 * or generates a new application if a file for that application does not exist.
	 * Names file the student's name followed by the scholarship name.
	 * @param mnscholarship name of scholarship of type String
	 * @param mnstudent name of student of type String
	 */
	public Application(String nmscholarship, String nmstudent)throws Exception{
		try{
		this.scholarship = nmscholarship;
		this.student = nmstudent;
		
		this.appfile = "Application/Student" + File.separator + nmstudent + File.separator + this.scholarship + " " + this.student + ".txt";
		
		File f = new File(this.appfile);
		if(f.exists() && !f.isDirectory()) { 
			loadApplication();
		}
		else{
			newApplication();
		}} catch (Exception e){


		}		
	}
	
	//Getters
	
	/**
	 * Returns name of scholarship being applied for
	 * @return Name or scholarship of type String
	 */
	public String getScholarship(){
		
		return this.scholarship;
	}
	
	/**
	 * Returns name of student applying for scholarship
	 * @return Name or student of type String
	 */
	public String getStudent(){
		
		return this.student;
	}
	
	/**
	 * Returns date application was last edited
	 * @return Date of type String
	 */
	public String getDate(){
		
		return this.date;
	}
	
	/**
	 * Returns gpa of scholarship applicant
	 * @return GPA of type double
	 */
	public double getGPA(){
		
		return this.gpa;
	}
	
	/**
	 * Returns education level of scholarship applicant
	 * @return Education level of type String
	 */
	public String getEducationLevel(){
		
		return this.edulvl;
	}
	
	/**
	 * Returns status of application; pending, accepted, rejected.
	 * @return Status of type String
	 */
	public String getStatus(){
		
		return this.status;
	}
	
	/**
	 * Returns priority student has selected for the scholarship
	 * @return Priority of type int
	 */
	public int getPriority(){
		
		return this.priority;
	}
	
	
	//Setters
	
	/**
	 * Changes date if given in correct format: 00/00/0000
	 * @param newDate of type String
	 */
	public void setDate(String newDate)throws Exception{
		
		if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDate)){
			this.date = newDate;
			overWriteLine("Date", newDate);
		}
	
	}

	/**
	 * Changes gpa given is a postive number and is 4.0 or less
	 * @param newGPA of type double
	 */
	public void setGPA(double newGPA)throws Exception{
		
		if ((newGPA >= 0) && (newGPA <= 4.0)){
			this.gpa = newGPA;
			String txt = Double.toString(newGPA);
			overWriteLine("GPA", txt);
		}

	}
	
	/**
	 * Changes education level
	 * @param newEduLvl of type String
	 */
	public void setEducationLevel(String newEduLvl)throws Exception{
		
		this.edulvl = newEduLvl;
		overWriteLine("Education Level", newEduLvl);
	}
	
	/**
	 * Changes status of application
	 * @param newStatus of type String
	 */
	public void setStatus(String newStatus)throws Exception{
		
		this.status = newStatus;
		overWriteLine("Status", newStatus);
	}
	
	/**
	 * Changes priority if natural number is given
	 * @param newPriority of type int
	 */
	public void setPriority(int newPriority)throws Exception{
		
		if (newPriority >= 0){
			this.priority = newPriority;
			String txt = Integer.toString(newPriority);
			overWriteLine("Priority", txt);
		}
	
	}
	
	/**
	* Changes a line in scholarship file given the name of the parameter that needs to be 
	* changed and the new value for that parameter
	* @param tag is a String of the name of the parameter to be changed
	* @param newtext is a String of the value to change to parameter's value to
	 */
	public void overWriteLine(String tag, String newtext) throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.scholarship +  " " + this.student + ".temp")));
		BufferedReader br = new BufferedReader(new FileReader(this.appfile));
		
		String line;
		
		while ((line = br.readLine()) != null) {
			if (line.equals(tag)) {
				writer.println(line);
				line = br.readLine();
				line = newtext;
			}
		
			writer.println(line);
		}
		
		br.close();
		writer.close();	
		
		File f = new File(this.appfile);
		boolean b = f.delete();
		File f1 = new File(this.appfile);
		File f2 = new File(this.scholarship +  " " + this.student + ".temp");
		b = f2.renameTo(f1);
		File f3 = new File(this.scholarship +  " " + this.student + ".temp");
		b = f3.delete();
	}
	
	
	//load and generate applications
	
	/**
	* Loads application from a file into a application object
	 */
	private void loadApplication() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(this.appfile));
		String line;
		
		while ((line = br.readLine()) != null) {
			if (line.equals("Date")){
				line = br.readLine();
				setDate(line);
			}
			else if (line.equals("GPA")){
				line = br.readLine();
				double newGPA = Double.parseDouble(line);
				setGPA(newGPA);
			}
			else if (line.equals("Education Level")){
				line = br.readLine();
				setEducationLevel(line);
			}
			else if (line.equals("Status")){
				line = br.readLine();
				setStatus(line);
			}
			else if (line.equals("Priority")){
				line = br.readLine();
				int newPriority = Integer.parseInt(line);
				setPriority(newPriority);
			}
		}
		br.close();	
	}
	
	
	/**
	* Create a new file for an application. Names file the given name of the application and sets 
	* basic file format. 
	 */
	private void newApplication() throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.appfile)));
		int counter = 0;
		
		writer.println("Scholarship");
		writer.println(this.scholarship);
		writer.println();
		writer.println("Student");
		writer.println(this.student);
		writer.println();
		writer.println("GPA");
		writer.println(this.gpa);
		writer.println();
		writer.println("Education Level");
		writer.println(this.edulvl);
		writer.println();
		writer.println("Date");
		writer.println(this.date);
		writer.println();
		writer.println("Status");
		writer.println(this.status);
		writer.println();
		writer.println("Priority");
		writer.println(this.priority);
		writer.println();

		writer.close();
		
	}
	
	/**
	* Overrides toString method. For use in the command line implementation of Scholarship System
	* @return Information from application in type String
	 */
	public String toString(){
		 
		return this.scholarship + ": " + this.student + ", Date Submitted: " + this.date + ", GPA: " + this.gpa + ", Education Level: " + this.edulvl + ", Priority: " + this.priority + ", Status: " + this.status;
	}

	/**
	 * Loads all application files into the applicationList in ScholarshipSystem class
	 */
	public static void startUp() {
		File folder = new File("Applications");
		File[] listOfFiles = folder.listFiles();
		for(File a : listOfFiles){
			if(a.isFile()){
				String name = a.getName().substring(0, (a.getName().length() - 4));	//takes away the .txt
				
				String schName = name.substring(0, name.length() - 3);	//gets scholarship name
				name = name.substring(name.length() - 3);	//gets jim
				try {
					//TODO: handle exception
				Application app = new Application(schName, name);
				ScholarshipSystem.applicationList.add(app);
				}
				catch (Exception e){

				}
			}	
		}
}
