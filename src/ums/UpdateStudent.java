package ums;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class UpdateStudent implements ActionListener {
	JFrame f;
    JLabel id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13,id14;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11;
    JButton b1,b2;
    @SuppressWarnings("rawtypes")
	JComboBox c1,c2;
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public UpdateStudent() {
        f = new JFrame("Update Student");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(1080,650);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        id1=new JLabel();
        id1.setBounds(0,0,1080,650);
        id1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ums/Images/sback.jpg"));
        Image i3 = img.getImage().getScaledInstance(1080, 650,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id1.setIcon(icc3);

        id2 = new JLabel("Update Student Details");
        id2.setBounds(300,30,500,50);
        id2.setFont(new Font("arial",Font.BOLD,40));
        id2.setForeground(Color.black);
        id1.add(id2);
        f.add(id1);

        id13= new JLabel("Enter Roll No. of the student you want to update");
        id13.setBounds(50,100,750,40);
        id13.setFont(new Font("arial",Font.BOLD,25));
        id1.add(id13);
        t11=new JTextField();   
        t11.setBounds(630,100,150,40);
        t11.setFont(new Font("arial",Font.BOLD,20));
        id1.add(t11);
 
        id3 = new JLabel("First Name");
        id3.setBounds(50,200,200,40);
        id3.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id3);
        t1=new JTextField();
        t1.setBounds(160,200,200,40);
        t1.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t1);
        
        id4 = new JLabel("Last Name");
        id4.setBounds(380,200,200,40);
        id4.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id4);
        t2=new JTextField();
        t2.setBounds(490,200,200,40);
        t2.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t2);
        
        
        id5 = new JLabel("Father's Name");
        id5.setBounds(700,200,200,40);
        id5.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id5);
        t3=new JTextField();
        t3.setBounds(850,200,200,40);
        t3.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t3);
        
        id6 = new JLabel("DOB(yyyy-mm-dd)");
        id6.setBounds(50,250,200,40);
        id6.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id6);
        t4=new JTextField();
        t4.setBounds(230,250,200,40);
        t4.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t4);
        
        id7= new JLabel("Email ID");
        id7.setBounds(470,250,100,40);
        id7.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id7);
        t5=new JTextField();
        t5.setBounds(560,250,490,40);
        t5.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t5);
        
        id8= new JLabel("Address");
        id8.setBounds(50,300,100,40);
        id8.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id8);
        t6=new JTextField();
        t6.setBounds(140,300,290,40);
        t6.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t6);
        
        id9= new JLabel("Phone");
        id9.setBounds(50,350,100,40);
        id9.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id9);
        t7=new JTextField();
        t7.setBounds(140,350,290,40);
        t7.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t7);
        
        id10= new JLabel("Class 10th(%)");
        id10.setBounds(470,300,150,40);
        id10.setFont(new Font("arial",Font.BOLD,20));    
        id1.add(id10);
        t8=new JTextField();
        t8.setBounds(610,300,130,40);
        t8.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t8);

        id11= new JLabel("Class 12th(%)");
        id11.setBounds(780,300,150,40);
        id11.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id11);
        t9=new JTextField();
        t9.setBounds(920,300,130,40);
        t9.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t9);
        
        id12= new JLabel("Aadhar No");
        id12.setBounds(470,350,100,40);
        id12.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id12);
        t10=new JTextField();
        t10.setBounds(580,350,200,40);
        t10.setFont(new Font("arial",Font.PLAIN,20));
        id1.add(t10);
        

        id13=new JLabel("Course");
        id13.setBounds(50,400,150,40);
        id13.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id13);
        String course[] = {"B.Tech","M.Tech","B.Tech-M.Tech","M.Sc","Ph.D"};
        c1 = new JComboBox(course);
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("arial",Font.PLAIN,20));
        c1.setBounds(120,400,200,40);
        id1.add(c1);

        id14=new JLabel("Branch");
        id14.setBounds(350,400,150,40);
        id14.setFont(new Font("arial",Font.BOLD,20));
        id1.add(id14);
        String branch[] = {"Communication and Computer Engineering","Computer Science and Engineering","Electronics and Communication Engineering","Mechanical Engineering"};
        c2 = new JComboBox(branch);
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("arial",Font.PLAIN,20));
        c2.setBounds(420,400,300,40);
        id1.add(c2);
        
        b1 = new JButton("Submit");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(730,500,120,50);
        id1.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(850,500,120,50);
        id1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
      
    	String fname = t1.getText();
        String lname = t2.getText();
        String fa_name = t3.getText();
        String dob = t4.getText();
        String eid = t5.getText();
        String addr = t6.getText();
        String ph = t7.getText();
        String cx = t8.getText();
        String cxii = t9.getText();
        String aadhar = t10.getText();
        String roll_no = t11.getText();
        String cour = (String)c1.getSelectedItem();
        String bran = (String)c2.getSelectedItem();
        
        if(ae.getSource() == b1){
            try{
                Connect cc = new Connect();
                String q = "update student set  First_name = '"+fname+"',Last_name='"+lname+"',Father_name='"+fa_name+"',Date_of_birth='"+dob+"',Phone_number='"+ph+"',Email='"+eid+"',Address='"+addr+"',Class_10='"+cx+"',Class_12='"+cxii+"',Degree='"+cour+"',Branch='"+bran+"',aadhar='"+aadhar+"' where Roll_no='"+roll_no+"'";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Student Details Updated Successfully");
                f.setVisible(false);
                new Mainframe().setVisible(true);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b2){
            f.setVisible(false);
            new Mainframe().setVisible(true);
            
        }
    }
    public static void main(String[ ] arg){
        new UpdateStudent().f.setVisible(true);
    }
}
