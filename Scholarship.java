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

public class Scholarship{

	private String name = "--";
	private String schfile = "--";
	private String duedate = "--";
	private double amount = 0;
	private int recipients = 0;
	private int chosen = 0;
	private ArrayList<String> levels = new ArrayList<String>();

	/**
	* Constructor.
	* Scholarship constructor that creates a new scholarship object and file
	* or load an old scholarship if a scholarhip file with the given name already exists.
	* @param schname is the name of the scholarship given by the user
	 */
	public Scholarship(String schname) throws Exception{
		
		this.name = schname;
		
		this.schfile = "Scholarships\\" + schname + ".txt";
		
		File f = new File(this.schfile);
		if(f.exists() && !f.isDirectory()) { 
			loadScholarship();
		}
		else{
			newScholarship();
		}		
	}
	
	/**
	* Constructor.
	* Scholarship constructor used when loading in all scholarships to the ScholarshipSystem.
	 */
	public Scholarship() {		
	}

	//Getters
	/**
	* Returns the name of the scholarship
	* @return name of the scholarship
	 */
	public String getName(){
		
		return this.name;
	}
	
	/**
	* Returns the name of the scholarship
	* @return Name of the scholarship of type String
	 */
	public String getDueDate(){
		
		return this.duedate;
	}
	
	/**
	* Returns the amount of money awarded by the scholarship
	* @return Amount of type double
	 */
	public double getAmount(){
		
		return this.amount;
	}
	
	/**
	* Returns the number of recipients a scholarship has
	* @return Number of recipient of type int
	 */
	public int getRecipients(){
		
		return this.recipients;
	}
	
	/**
	* Returns the number of applicants chosen for a scholarship
	* @return Number of chosen applicants of type int
	 */
	public int getChosen(){
		
		return this.chosen;
	}
	
	/**
	* Returns eligible education levels for a scholarship
	* @return ArrayList of levels of type ArrayList<String>
	 */
	public ArrayList<String> getLevels(){
		
		return this.levels;
	}
	
	
	//Setters

	/**
	* Changes name of scholarship if new one is given
	* if blank name is given it will not be changed
	* @param newName should be a String to change name to
	 */
	public void setName(String newName) throws Exception{
		
		if (!(newName.trim().equals(""))){
			this.name = newName;
			String newschfile = this.name + ".txt";
			
			
			File f1 = new File(newschfile);
			File f2 = new File(this.schfile);
			boolean b = f2.renameTo(f1);
			File f = new File(this.schfile);
			f.delete();
			
			this.schfile = newschfile;
			
			overWriteLine("Name", this.name);
		}
	}
	
	/**
	* Changes due date if given in correct format: 00/00/0000
	* @param newDueDate should be a String in correct format: 00/00/0000
	 */
	public void setDueDate(String newDueDate)throws Exception{
		
		if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDueDate)){
			this.duedate = newDueDate;
			overWriteLine("Due Date", newDueDate);
		}
	
	}
	
	//will only change if amount given is a postive number
	/**
	* Changes amount if it is a positive number
	* @param newAmount should be a postive double
	 */
	public void setAmount(double newAmount)throws Exception{
		
		if (newAmount >= 0){
			this.amount = newAmount;
			String txt = Double.toString(newAmount);
			overWriteLine("Amount", txt);
		}

	}
	
	/**
	* Changes number of recipients if given a natural number
	* @param newRecipients should be a natural number of type int
	 */
	public void setRecipients(int newRecipients)throws Exception{
		
		if (newRecipients >= 0){
			this.recipients = newRecipients;
			String txt = Integer.toString(newRecipients);
			overWriteLine("Recipients", txt);
		}

	}
	
	/**
	* Changes number of recipients chosen if given a natural number
	* @param newChosen should be a natural number of type int
	 */
	public void setChosen(int newChosen)throws Exception{
		
		if (newChosen >= 0){
			this.chosen = newChosen;
			String txt = Integer.toString(newChosen);
			overWriteLine("Chosen", txt);
		}
	
	}
	
	//this needs to be revised!!!!
	/**
	* Replaces ArrapList in levels to new education levels
	* @param newLevels of type ArrayList<String>
	 */
	public void setLevels(ArrayList<String> newLevels)throws Exception{
		
		this.levels = newLevels;
		
		String txt = "";
		for (int i = 0; i < this.levels.size(); i++){
			txt = txt + this.levels.get(i) + " ";
		}
		overWriteLine("Education Level", txt);
	}	
	
	/**
	* Changes a line in scholarship file given the name of the parameter that needs to be 
	* changed and the new value for that parameter
	* @param tag is a String of the name of the parameter to be changed
	* @param newtext is a String of the value to change to parameter's value to
	 */
	private void overWriteLine(String tag, String newtext) throws Exception{
		
		String tmpfile = "Scholarships\\" + this.name + ".temp";
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(tmpfile)));
		BufferedReader br = new BufferedReader(new FileReader(this.schfile));
		
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
		
		File f = new File(this.schfile);
		boolean b = f.delete();
		File f1 = new File(this.schfile);
		File f2 = new File(tmpfile);
		b = f2.renameTo(f1);
		File f3 = new File(tmpfile);
		b = f3.delete();
	}
	
	
	//load and generate scholarships
	
	/**
	* Loads scholarship from a file into a scholarship object
	 */
	private void loadScholarship() throws Exception{
		
		BufferedReader br = new BufferedReader(new FileReader(this.schfile));
		String line;
		
		while ((line = br.readLine()) != null) {
			if (line.equals("Due Date")){
				line = br.readLine();
				setDueDate(line);
			}
			else if (line.equals("Amount")){
				line = br.readLine();
				double newAmount = Double.parseDouble(line);
				setAmount(newAmount);
			}
			else if (line.equals("Recipients")){
				line = br.readLine();
				int newRecipients = Integer.parseInt(line);
				setRecipients(newRecipients);
			}
			else if (line.equals("Recipients Chosen")){
				line = br.readLine();
				int newChosen = Integer.parseInt(line);
				setChosen(newChosen);
			}
			else if (line.equals("Education Level")){
				line = br.readLine();
				String[] tmpLevels = line.split(" ");
				ArrayList<String> newLevels = new ArrayList(Arrays.asList(tmpLevels));
				setLevels(newLevels);
			}
		}
		
		br.close();	
	}
	
	/**
	* Create a new file for a scholarship. Names file the given name of the scholarship and sets 
	* basic file format. 
	 */
	private void newScholarship() throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.schfile)));
		int counter = 0;
		
		writer.println("Name");
		writer.println(this.name);
		writer.println();
		writer.println("Due Date");
		writer.println(this.duedate);
		writer.println();
		writer.println("Amount");
		writer.println(this.amount);
		writer.println();
		writer.println("Recipients");
		writer.println(this.recipients);
		writer.println();
		writer.println("Recipients Chosen");
		writer.println(this.chosen);
		writer.println();
		writer.println("Education Level");
		for (int i = 0; i < this.levels.size(); i++){
			writer.write(this.levels.get(i));
			writer.write(" ");
		}
		writer.println();
		writer.println();

		writer.close();
		
	}
	
	/**
	* Overrides toString method. For use in the command line implementation of Scholarship System
	* @return Information from scholarship in type String
	 */
	public String toString(){
		
		String EduLvls = "";
		for (int i = 0; i < this.levels.size(); i++){
			EduLvls = EduLvls + this.levels.get(i);
			if (i != this.levels.size() -1){
				EduLvls = EduLvls + ", ";
			}
		}
		
		return this.name + ", Due: " + this.duedate + ", Amount: " + this.amount + "$, Recipient(s): " + this.recipients + ", Recipient(s) Chosen: " + this.chosen + ", Education Levels: " + EduLvls;
	}
	
	/**
	* Reads in all scholarships and adds them to the scholarshipList in the ScholarshipSystem
	 */
	public static void startUp(){
		File folder = new File("Scholarships");
		File[] listOfFiles = folder.listFiles();
		for(File a : listOfFiles){
			if(a.isFile()){
				String name = a.getName().substring(0, (a.getName().length() - 4));
				try {
					//TODO: handle exception
				Scholarship sch = new Scholarship(name);
				ScholarshipSystem.scholarshipList.add(sch);
				}
				catch (Exception e){

				}
			}	
		}
	}
	
}
	
	
