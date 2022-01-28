package ums;
import java.sql.*;
import javax.swing.*;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

@SuppressWarnings("serial")
public class MyAttendance extends JFrame implements ActionListener {
	JTable j1;
	JLabel l1,l2,id3;
    JButton b1,b2;
	JTextField t3,t4;
    String h[]={"Roll Number","Subject","DateTime","Attendance"};
    String d[][]=new String[50][4];  
    String m;
    int i=0,j=0,p,q=0;
    float frac;
    Choice c2;
    
    MyAttendance(String st,String w){
        super("My Attendence");
        setSize(640,360);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        id3 = new JLabel("Select Subject");
        id3.setBounds(10,10,150,40);
        id3.setFont(new Font("arial",Font.BOLD,20));
        add(id3);
	 	c2 = new Choice();
        try{
            Connect c = new Connect();
            ResultSet rs = c.s.executeQuery("select * from subject");
            while(rs.next()){
                c2.add(rs.getString("subcode"));    
            }
  
        }catch(Exception e){ }
    	try{
            String q="select * from student_attendance where Roll_no = '"+st+"' and subcode = '"+w+"'";
            Connect c1=new Connect();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("Roll_no");
                d[i][j++]=rs.getString("subcode");
                d[i][j++]=rs.getString("DATE");
                d[i][j++]=rs.getString("P_A"); 
                i++;
                j=0;
            }       
            j1=new JTable(d,h);

        }catch(Exception e){}
        JScrollPane sp = new JScrollPane(j1);
        sp.setBounds(10,50,620,200);
        add(sp);
        

        c2.setBounds(200,10,150,40);
        c2.setFont(new Font("arial",Font.PLAIN,20));
        add(c2);
        try{
            String q1="select P_A,count(*) as cnt from student_attendance where Roll_no = '"+st+"' and subcode = '"+w+"' group by P_A order by P_A";
            Connect c2=new Connect();
            ResultSet rs1=c2.s.executeQuery(q1);
            while(rs1.next()) {
            	p = rs1.getInt(2);
            	q = q+p;
            }
           

        }catch(Exception e){
        	System.out.println(e);
        }
        frac = (p*100.00f/q);
        float roundOff = (float) (Math.round(frac * 100.0) / 100.0);
        m = Float.toString(roundOff);
        l2 = new JLabel(m+"%");
        l2.setBounds(300,250,150,30);
        l2.setFont(new Font("opensans",Font.BOLD,20));
        l2.setVisible(true);
        add(l2);
        
        
        l1 = new JLabel("Attendance Percentage");
        l1.setBounds(10,250,300,30);
        l1.setFont(new Font("opensans",Font.BOLD,20));
        l1.setVisible(true);
        add(l1);
        
        
        
        b1 =new JButton("Go");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(400,10,100,40);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(500,10,100,40);
        add(b2);
        b2.addActionListener(this);
        
 
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == b1) {
	        try{
	        	String st = StudentLogin.t1.getText();
	        	String w = c2.getSelectedItem();
	        	new MyAttendance(st,w).setVisible(true);
	            setVisible(false);
	           
	            
	        }catch(Exception e){JOptionPane.showMessageDialog(null,"Data not found");}
    	}
    	else if(ae.getSource() == b2) {
    		 setVisible(false);
    		 String w = StudentLogin.t1.getText();
             new StudentFrame(w).setVisible(true);
    	}
    }
    
    public static void main(String args[]) {
    	new  MyAttendance("st","w").setVisible(true);
    }
}
