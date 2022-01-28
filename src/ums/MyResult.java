package ums;
import java.sql.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
@SuppressWarnings("serial")
public class MyResult extends JFrame implements ActionListener {

	JTable j1;
	JLabel l1,l2,id3;
    JButton b1,b2;
	JTextField t3,t4;
    String h[]={"Roll Number","Subject","Semester","Marks Scored","Total Marks","Percentage"};
    String d[][]=new String[50][6];  
    String m;
    int i=0,j=0,p,q=0;
    float frac;
    @SuppressWarnings("rawtypes")
	JComboBox comboBox_2;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	MyResult(String st,String w){
        super("My Result");
        setSize(852,420);
        setLocationRelativeTo(null);
        setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        
        id3 = new JLabel("Select Semester");
        id3.setBounds(10,10,200,40);
        id3.setFont(new Font("arial",Font.BOLD,20));
        add(id3);
	 	comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
		comboBox_2.setFont(new Font("opensans", Font.BOLD, 20));
		comboBox_2.setForeground(Color.BLACK);
		comboBox_2.setBounds(180, 10, 200, 40);
		add(comboBox_2);

    	try{
            String q="select * from marks where Roll_no = '"+st+"' and semester = '"+w+"'"; 
            Connect c1=new Connect();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next()){
                d[i][j++]=rs.getString("Roll_no");
                d[i][j++]=rs.getString("subcode");
                d[i][j++]=rs.getString("semester");
                d[i][j++]=rs.getString("marks_scored");
                d[i][j++]=rs.getString("total_marks");
                d[i][j++]=rs.getString("percentage"); 
                i++;
                j=0;
            }       
            j1=new JTable(d,h);

        }catch(Exception e){}
        JScrollPane sp = new JScrollPane(j1);
        sp.setBounds(10,50,832,200);
        add(sp);
        

       
        try{
            String q1="select subcode,marks_scored,total_marks from marks where Roll_no = '"+st+"' and semester = '"+w+"' order by subcode";
            Connect c2=new Connect();
            ResultSet rs1=c2.s.executeQuery(q1);
            while(rs1.next()) {
            	p = p + rs1.getInt(2);
            	q = q + rs1.getInt(3);
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
        
        
        l1 = new JLabel("Semester Percentage");
        l1.setBounds(10,250,300,30);
        l1.setFont(new Font("opensans",Font.BOLD,20));
        l1.setVisible(true);
        add(l1);
        
        
        
        b1 =new JButton("Go");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(600,10,100,40);
        add(b1);
        b1.addActionListener(this);
        
        b2=new JButton("Cancel");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(700,10,100,40);
        add(b2);
        b2.addActionListener(this);
 
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource() == b1) {
	        try{
	        	String st = StudentLogin.t1.getText();
	        	String w = (String) comboBox_2.getSelectedItem();
	        	new MyResult(st,w).setVisible(true);
	            setVisible(false);
	           
	            
	        }catch(Exception e){
	        	JOptionPane.showMessageDialog(null,"Data not found");
	        	}
    	}
    	else if(ae.getSource() == b2) {
   		 setVisible(false);
   		 String w = StudentLogin.t1.getText();
         new StudentFrame(w).setVisible(true);
    	}
    }
    public static void main(String args[]) {
    	new  MyResult("st","w").setVisible(true);
    }
}
