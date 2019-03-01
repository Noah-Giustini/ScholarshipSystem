import java.util.*;
import java.io.*;

// User class is designed to create a file with basic information about user
// This includes storing the type of user, their username and password
public class User {
    private String username;
    private String password;
    private String storingFile  = "loginsOrPasswords";
    private String type;
    // constructor takes two strings when in signup for username and password
    // type is automatically set to generic
    public User(String user, String password){
        this.username = user;
        this.password = password;
        this.type = "Generic";
        this.storingFile += this.username + ".txt";

    }
    // checks to see if what is entered is the same as what we know exists
    public boolean login (String userGiven, String pswdGiven){
      return this.username.equals(userGiven) && this.password.equals(pswdGiven);

    }
    //creates a login file containing data for the individual
    public void storeData() {
      try{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(storingFile)));

        writer.println( this.username + "," + this.password + "," + this.type);
      } catch (Exception e){
        System.out.println("Something went wrong");

      }
    }








}
