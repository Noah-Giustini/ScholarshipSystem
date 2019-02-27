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
	 * Open FileReader stream
	 * @param inputFileName is the file name given by user on cmd line
	 */
	public Application(String nmscholarship, String nmstudent) throws Exception{
		
		this.scholarship = nmscholarship;
		this.student = nmstudent;
		
		this.appfile = this.scholarship + " " + this.student + ".txt";
		
		File f = new File(this.appfile);
		if(f.exists() && !f.isDirectory()) { 
			loadApplication();
		}
		else{
			newApplication();
		}		
	}
	
	//Getters
	public String getScholarship(){
		
		return this.scholarship;
	}
	
	public String getStudent(){
		
		return this.student;
	}
	
	public String getDate(){
		
		return this.date;
	}
	
	public double getGPA(){
		
		return this.gpa;
	}
	
	public String getEducationLevel(){
		
		return this.edulvl;
	}
	
	public String getStatus(){
		
		return this.status;
	}
	
	public int getPriority(){
		
		return this.priority;
	}
	
	
	//Setters
	
	//will only change date if given in correct format: 00/00/0000
	public void setDate(String newDate)throws Exception{
		
		if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDate)){
			this.date = newDate;
			overWriteLine("Date", newDate);
		}
	
	}
	
	//will only change if gpa given is a postive number and is 4.0 or less
	public void setGPA(double newGPA)throws Exception{
		
		if ((newGPA >= 0) && (newGPA <= 4.0)){
			this.gpa = newGPA;
			String txt = Double.toString(newGPA);
			overWriteLine("GPA", txt);
		}

	}
	
	public void setEducationLevel(String newEduLvl)throws Exception{
		
		this.edulvl = newEduLvl;
		overWriteLine("Education Level", newEduLvl);
	}
	
	public void setStatus(String newStatus)throws Exception{
		
		this.status = newStatus;
		overWriteLine("Status", newStatus);
	}
	
	//will only change if number given is a natural number
	public void setPriority(int newPriority)throws Exception{
		
		if (newPriority >= 0){
			this.priority = newPriority;
			String txt = Integer.toString(newPriority);
			overWriteLine("Priority", txt);
		}
	
	}
	
	
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
	
	public String toString(){
		 
		return this.scholarship + ": " + this.student + ", Date Submitted: " + this.date + ", GPA: " + this.gpa + ", Education Level: " + this.edulvl + ", Priority: " + this.priority + ", Status: " + this.status;
	}
	
}
