package ums;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
public class UploadResult  extends JFrame implements ActionListener  {
	 JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,id1,id2,id3,id4,id5;
	 JButton b1,b2;
	 JTextField t1,t2;
	 Choice c2,fh,sh;
	 @SuppressWarnings("rawtypes")
	JComboBox comboBox_2;
	    
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	UploadResult(String st) {
	       
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
	        
	        id2 = new JLabel("Upload Marks");
	        id2.setBounds(100,30,500,50);
	        id2.setFont(new Font("arial",Font.BOLD,35));
	        id2.setForeground(Color.black);
	        id1.add(id2);
	        
	        id4 = new JLabel("Marks obtained in ");
	        id4.setBounds(50,200,300,25);
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
	        l9.setBounds(230,200,150,25);
	        l9.setFont(new Font("arial",Font.BOLD,20));
	        id1.add(l9);
	       
	        t1 = new JTextField();
	        t1.setBounds(300,200,150,25);
	        t1.setFont(new Font("arial",Font.BOLD,20));
	        t1.setForeground(Color.black);
	        id1.add(t1);
	        
	        id5 = new JLabel("Maximum Marks ");
	        id5.setBounds(50,250,300,25);
	        id5.setFont(new Font("arial",Font.BOLD,20));
	        id5.setForeground(Color.black);
	        id1.add(id5);
	        t2 = new JTextField();
	        t2.setBounds(300,250,150,25);
	        t2.setFont(new Font("arial",Font.BOLD,20));
	        t2.setForeground(Color.black);
	        id1.add(t2);
	        
	        id3 = new JLabel("Select Roll Number");
	        id3.setBounds(50,100,200,50);
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
	        c2.setBounds(250,100,150,50);
	        c2.setFont(new Font("arial",Font.PLAIN,20));
	        id1.add(c2);
	        
	        JLabel l5 = new JLabel("Semester");
	    	l5.setForeground(Color.black);
	    	l5.setFont(new Font("opensans", Font.BOLD, 20));
	    	l5.setBounds(420, 100, 150, 50);
	    	id1.add(l5);
	    	comboBox_2 = new JComboBox();
	    	comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
	    	comboBox_2.setFont(new Font("opensans", Font.BOLD, 14));
	    	comboBox_2.setForeground(Color.BLACK);
	    	comboBox_2.setBounds(520, 100, 150, 50);
	    	id1.add(comboBox_2);
	        
	        
	        
	       
	        
	       
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
	    	
	    	if(ae.getSource() == b1) {
		    	String mar = t1.getText();
		        String max = t2.getText();
		        String sem = (String) comboBox_2.getSelectedItem();
		        String id=c2.getSelectedItem();
		        String sub=l9.getText();
		        int p = Integer.valueOf(mar);
		        int q = Integer.valueOf(max);
		        float per = (p*100.00f/q);
		        String perc = String.valueOf(per);
		        String qry = "insert into marks values('"+id+"','"+sub+"','"+sem+"','"+mar+"','"+max+"','"+perc+"')";
		       
		        try{
		            Connect c1 = new Connect();
		            c1.s.executeUpdate(qry);
		            JOptionPane.showMessageDialog(null,"Marks uploaded");
		        }catch(Exception ee){
		            ee.printStackTrace();
		        }
	    	}
	    	else if (ae.getSource() == b2) {
	    		String w =TeacherLogin.t1.getText();
	            new TeacherFrame(w).setVisible(true);
	    		setVisible(false);
	    	}
	    }
}

