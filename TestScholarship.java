import java.util.ArrayList;

public class TestScholarship{

	public static void main(String[] args) throws Exception{

		System.out.println("ok");

		Scholarship s1 = new Scholarship("test scholarship");
		
		s1.setAmount(23.3);
		
		s1.setRecipients(34);
		
		ArrayList<String> lvl = new ArrayList<String>();
		
		lvl.add("bach1");
		lvl.add("dr");
		
		s1.setLevels(lvl);
		
		Scholarship s2 = new Scholarship("Athletics Scholarship");
		
		
		s2.setName("New Ath SCholr");
		
		s2.setDueDate("12/09/2019");
		
		s2.setDueDate("cool");
		
		Scholarship s3 = new Scholarship("tester");
		
		System.out.println(s3.getRecipients());
		
		



	}
}
