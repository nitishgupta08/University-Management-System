package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class StudentDetails extends JFrame implements ActionListener {

	JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3,b4;
    JTextField t2;
    String x[] = {"Roll_no", "First_name", "Last_name", "Father_name", "Date_of_birth", "Phone_number", "Email", "Address", "Class_10", "Class_12", "Degree", "Branch", "aadhar"};
    String y[][] = new String[20][15];
    int i=0, j=0;
    StudentDetails(){
        super("Student Details");
        setSize(1250,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        l1 = new JLabel("Enter roll number to delete Student: ");
        l1.setBounds(50,400,400,40);
        l1.setFont(new Font("opensans",Font.BOLD,20));
        add(l1);
        
        t2 = new JTextField();
        t2.setBounds(450,400,200,40);
        t2.setFont(new Font("opensans",Font.BOLD,20));
        add(t2);
        
        b1 = new JButton("Delete");
        b1.setBackground(new Color(59, 89, 182));
        b1.setFont(new Font("opensans",Font.BOLD,20));
        b1.setBounds(700, 400, 100 ,40);
        add(b1);
            
      
        b2 = new JButton("Add Student");
        b2.setBackground(new Color(59, 89, 182));
        b2.setFont(new Font("opensans",Font.BOLD,20));
        b2.setBounds(50, 500, 200 ,70);
        add(b2);
        
        b3 = new JButton("Update Student");
        b3.setBackground(new Color(59, 89, 182));
        b3.setFont(new Font("opensans",Font.BOLD,20));
        b3.setBounds(350, 500, 200 ,70);
        add(b3);
        
        b4 = new JButton("Cancel");
        b4.setBackground(new Color(59, 89, 182));
        b4.setFont(new Font("opensans",Font.BOLD,20));
        b4.setBounds(650, 500, 200 ,70);
        add(b4);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        
        
        try{
        	Connect c1  = new Connect();
            String s1 = "select * from student";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("Roll_no");
                y[i][j++]=rs.getString("First_name");
                y[i][j++]=rs.getString("Last_name");
                y[i][j++]=rs.getString("Father_name");
                y[i][j++]=rs.getString("Date_of_birth");
                y[i][j++]=rs.getString("Phone_number");
                y[i][j++]=rs.getString("Email");
                y[i][j++]=rs.getString("Address");
                y[i][j++]=rs.getString("Class_10");
                y[i][j++]=rs.getString("Class_12");
                y[i][j++]=rs.getString("Degree");
                y[i][j++]=rs.getString("Branch");
                y[i][j++]=rs.getString("aadhar");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp = new JScrollPane(t1);
        sp.setBounds(20,20,1200,330);
        add(sp);
        
        getContentPane().setBackground(Color.WHITE);
        
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent ae){
        
        Connect c1 = new Connect();
    
        if(ae.getSource() == b1){
            try{
                String a = t2.getText();
                String q = "delete from student where Roll_no = '"+a+"'";
                c1.s.executeUpdate(q);
                this.setVisible(false);
                new StudentDetails().setVisible(true);
            }catch(Exception e){}
    
        }else if(ae.getSource() == b2){
            new AddStudent().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new UpdateStudent().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b4){
            new Mainframe().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new StudentDetails().setVisible(true);
    }  
}

