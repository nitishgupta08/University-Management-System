package ums;
import java.sql.*; 

public class Connect {
	Connection c;
    Statement s;
    public Connect() {  
        try{  
            Class.forName("com.mysql.jdbc.Driver");  
            c = DriverManager.getConnection("jdbc:mysql:///university_management","root","1618033abc");    
            s = c.createStatement();  
        }
        catch(ClassNotFoundException | SQLException e) { 
            System.out.println(e);
        }  
    }  
}
