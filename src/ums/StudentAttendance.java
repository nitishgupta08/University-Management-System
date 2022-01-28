package ums;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class StudentAttendance  extends JFrame implements ActionListener {
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,id1,id2,id3,id4;
	 JButton b1,b2;

	 Choice c2,fh,sh;
	    
	 StudentAttendance(String st) {
	       
		 	setLayout(null);  
	        setSize(852,480);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        id1=new JLabel();
	        id1.setBounds(0,0,852,480);
	        id1.setLayout(null);
	        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ums/Images/sback.jpg"));
	        Image i3 = img.getImage().getScaledInstance(852, 480,Image.SCALE_DEFAULT);
	        ImageIcon icc3 = new ImageIcon(i3);
	        id1.setIcon(icc3);
	        add(id1);
	        
	        id2 = new JLabel("Student Attendance");
	        id2.setBounds(250,30,500,50);
	        id2.setFont(new Font("arial",Font.BOLD,35));
	        id2.setForeground(Color.black);
	        id1.add(id2);
	        
	        id4 = new JLabel("Your Subject");
	        id4.setBounds(200,350,500,50);
	        id4.setFont(new Font("arial",Font.BOLD,20));
	        id4.setForeground(Color.black);
	        id1.add(id4);
	        l9=new JLabel();
	        
	        
	        try{
	            Connect c = new Connect();
	            ResultSet rs = c.s.executeQuery("select * from teacher where Faculty_ID = '"+st+"'");
	            while(rs.next()){
	                l9.setText(rs.getString("Course"));    
	            }
	  
	       }
	        catch(Exception e){ }
	        l9.setBounds(350,350,150,50);
	        l9.setFont(new Font("arial",Font.PLAIN,20));
	        id1.add(l9);
	       
	        
	        id3 = new JLabel("Select Roll Number");
	        id3.setBounds(50,150,200,50);
	        id3.setFont(new Font("arial",Font.BOLD,20));
	        id1.add(id3);
		 	c2 = new Choice();
	        try{
	            Connect c = new Connect();
	            ResultSet rs = c.s.executeQuery("select * from student");
	            while(rs.next()){
	                c2.add(rs.getString("Roll_no"));    
	            }
	  
	       }
	        catch(Exception e){ }
	        c2.setBounds(300,150,150,40);
	        c2.setFont(new Font("arial",Font.PLAIN,20));
	        id1.add(c2);
	        
	        
	        String d1 = new java.util.Date().toString();
	        l8 = new JLabel(d1);
	        l8.setBounds(500,150,370,40);
	        l8.setFont(new Font("arial",Font.BOLD,20));
	        id1.add(l8);
	        
	        l1 = new JLabel("Attendance");
	        l1.setBounds(50,200,200,40);
	        l1.setFont(new Font("arial",Font.BOLD,20));
	        id1.add(l1);
	        
	        fh = new Choice();
	        fh.add("Present");
	        fh.add("Absent");
	        fh.setBounds(300,200,150,40);
	        fh.setFont(new Font("arial",Font.PLAIN,20));
	        id1.add(fh);
	        
	       
	        b1 =new JButton("Upload");
	        b1.setBackground(new Color(59, 89, 182));
	        b1.setBounds(530,350,120,50);
	        id1.add(b1);
	        
	        b2 = new JButton("Cancel");
	        b2.setBackground(new Color(59, 89, 182));
	        b2.setBounds(650,350,120,50);
	        id1.add(b2);
	        
	    
	        
	        b1.addActionListener(this);
	        b2.addActionListener(this);
	        setVisible(true);
	       
	    }
	    
	    public void actionPerformed(ActionEvent ae){
	       
	        String pa = fh.getSelectedItem();
	        String dt = new java.util.Date().toString();
	        String id=c2.getSelectedItem();
	        String sub=l9.getText();
	        String qry = "insert into student_attendance values('"+id+"','"+sub+"','"+dt+"','"+pa+"')";
	       if(ae.getSource() == b1) {
		        try{
		            Connect c1 = new Connect();
		            c1.s.executeUpdate(qry);
		            JOptionPane.showMessageDialog(null,"Attendance confirmed");
		        }catch(Exception ee){
		            ee.printStackTrace();
		        }
	       }
	       else if(ae.getSource() == b2) {
	    	   String w =TeacherLogin.t1.getText();
               new TeacherFrame(w).setVisible(true);
               setVisible(false);
	       }
	    }
}
