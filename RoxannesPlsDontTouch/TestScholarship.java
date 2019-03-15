import java.util.ArrayList;

public class TestScholarship{

	public static void main(String[] args) throws Exception{

		System.out.println("ok");

		Scholarship s1 = new Scholarship("test scholarship", true);
		
		s1.setAmount(23.3);
		
		s1.setRecipients(34);
		
		ArrayList<String> lvl = new ArrayList<String>();
		
		lvl.add("bach1");
		lvl.add("dr");
		
		s1.setLevels(lvl);
		
		Scholarship s2 = new Scholarship("Athletics Scholarship", false);
		
		
		s2.setName("New Ath SCholr");
		
		s2.setDueDate("12/09/2019");
		
		s2.setDueDate("cool");
		
		Scholarship s3 = new Scholarship("tester", false);
		
		System.out.println(s3.getRecipients());
		
		Application a1 = new Application("test", "cool name", false);
		
		a1.setPriority(1);
		
		System.out.println(a1.getGPA());
		
		System.out.println(s2);

		System.out.println(a1);


	}
}
