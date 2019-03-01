import java.util.*;
import java.io.*;


public class User {
    private String username;
    private String password;
    private String storingFile  = "loginsOrPasswords";
    private String type;

    public User(String user, String password){
        this.username = user;
        this.password = password;
        this.type = "Generic";
        this.storingFile += this.username + ".txt";

    }

    public boolean login (String userGiven, String pswdGiven){
      return this.username.equals(userGiven) && this.password.equals(pswdGiven);

    }

    public void storeData() {
      try{
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(storingFile)));

        writer.println( this.username + "," + this.password + "," + this.type);
      } catch (Exception e){
        System.out.println("Something went wrong");

      }
    }








}
