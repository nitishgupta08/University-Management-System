package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

@SuppressWarnings("serial")
public class TeacherDeatails extends JFrame implements ActionListener {
	JLabel l1,l2,l3;
    JTable t1;
    JButton b1,b2,b3,b4;
    JTextField t2;
    String x[] = {"Faculty_ID", "First_name", "Last_name", "Father_name", "Date_of_birth", "Phone_number", "Email", "Address", "Department", "Subject", "Marital status", "aadhar"};
    String y[][] = new String[20][15];
    int i=0, j=0;
    TeacherDeatails(){
        super("Teacher Details");
        setSize(1250,720);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        l1 = new JLabel("Enter Faculty_ID to delete Teacher: ");
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
            
      
        b2 = new JButton("Add Teacher");
        b2.setBackground(new Color(59, 89, 182));
        b2.setFont(new Font("opensans",Font.BOLD,20));
        b2.setBounds(50, 500, 200 ,70);
        add(b2);
        
        b3 = new JButton("Update Teacher");
        b3.setBackground(new Color(59, 89, 182));
        b3.setFont(new Font("opensans",Font.BOLD,20));
        b3.setBounds(400, 500, 200 ,70);
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
            String s1 = "select * from teacher";
            ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("Faculty_ID");
                y[i][j++]=rs.getString("First_name");
                y[i][j++]=rs.getString("Last_name");
                y[i][j++]=rs.getString("Father_name");
                y[i][j++]=rs.getString("Date_of_birth");
                y[i][j++]=rs.getString("Phone_number");
                y[i][j++]=rs.getString("Email");
                y[i][j++]=rs.getString("Address");
                y[i][j++]=rs.getString("Department");
                y[i][j++]=rs.getString("Course");
                y[i][j++]=rs.getString("Maritial_status");
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
                String q = "delete from teacher where Faculty_ID = '"+a+"'";
                c1.s.executeUpdate(q);
                this.setVisible(false);
                new TeacherDeatails().setVisible(true);
            }catch(Exception e){}
    
        }else if(ae.getSource() == b2){
            new AddTeacher().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b3){
            new UpdateTeacher().f.setVisible(true);
            this.setVisible(false);
        }else if(ae.getSource() == b4){
            new Mainframe().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args){
        new TeacherDeatails().setVisible(true);
    }  
}


