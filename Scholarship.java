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
	 * Open FileReader stream
	 * @param inputFileName is the file name given by user on cmd line
	 */
	public Scholarship(String schname) throws Exception{
		
		this.name = schname;
		
		this.schfile = schname + ".txt";
		
		File f = new File(this.schfile);
		if(f.exists() && !f.isDirectory()) { 
			loadScholarship();
		}
		else{
			newScholarship();
		}		
	}
	
	//Getters
	public String getName(){
		
		return this.name;
	}
	
	public String getDueDate(){
		
		return this.duedate;
	}
	
	public double getAmount(){
		
		return this.amount;
	}
	
	public int getRecipients(){
		
		return this.recipients;
	}
	
	public int getChosen(){
		
		return this.chosen;
	}
	
	public ArrayList<String> getLevels(){
		
		return this.levels;
	}
	
	
	//Setters
	
	//will only change name if new one is given
	//if blank name given name is not changed
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
	
	//will only change due date if given in correct format: 00/00/0000
	public void setDueDate(String newDueDate)throws Exception{
		
		if (Pattern.matches("\\d\\d/\\d\\d/\\d\\d\\d\\d", newDueDate)){
			this.duedate = newDueDate;
			overWriteLine("Due Date", newDueDate);
		}
	
	}
	
	//will only change if amount given is a postive number
	public void setAmount(double newAmount)throws Exception{
		
		if (newAmount >= 0){
			this.amount = newAmount;
			String txt = Double.toString(newAmount);
			overWriteLine("Amount", txt);
		}

	}
	
	//will only change if number given is a natural number
	public void setRecipients(int newRecipients)throws Exception{
		
		if (newRecipients >= 0){
			this.recipients = newRecipients;
			String txt = Integer.toString(newRecipients);
			overWriteLine("Recipients", txt);
		}

	}
	
	//will only change if number given is a natural number
	public void setChosen(int newChosen)throws Exception{
		
		if (newChosen >= 0){
			this.chosen = newChosen;
			String txt = Integer.toString(newChosen);
			overWriteLine("Chosen", txt);
		}
	
	}
	
	//this needs to be revised!!!!
	public void setLevels(ArrayList<String> newLevels)throws Exception{
		
		this.levels = newLevels;
		
		String txt = "";
		for (int i = 0; i < this.levels.size(); i++){
			txt = txt + this.levels.get(i) + " ";
		}
		overWriteLine("Education Level", txt);
	}	
	
	
	private void overWriteLine(String tag, String newtext) throws Exception{
		
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(this.name + ".temp")));
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
		File f2 = new File(this.name + ".temp");
		b = f2.renameTo(f1);
		File f3 = new File(this.name + ".temp");
		b = f3.delete();
	}
	
	
	//load and generate scholarships
	
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
	
	public String toString(){
		
		String EduLvls = "";
		for (int i = 0; i < this.levels.size(); i++){
			EduLvls = EduLvls + this.levels.get(i);
			EduLvls = EduLvls + " ";
		}
		
		return "" + this.name + ": Due " + this.duedate + ", " + this.amount + "$" + ", " + this.recipients + " number of recipients, " + this.chosen + " number of recpients chosen, " + "Education levels " + EduLvls;
	}
	
}
	
	
