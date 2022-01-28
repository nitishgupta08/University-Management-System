package ums;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class TeacherLogin extends JFrame implements ActionListener {
	JLabel l1,l2;
    static JTextField t1;
    JPasswordField t2;
    JButton b1,b2;

    TeacherLogin(){

        super("Faculty Login");

        setBackground(Color.white);
        setLayout(null);

        l1 = new JLabel("FacultyID:");
        l1.setBounds(170,140,100,30);
        l1.setFont(new Font("opensans",Font.BOLD,15));
        add(l1);
        
        l2 = new JLabel("Password:");
        l2.setBounds(170,190,100,30);
        l2.setFont(new Font("opensans",Font.BOLD,15));
        add(l2);
 
        t1=new JTextField();
        t1.setBounds(250,140,150,30);
        add(t1);

        t2=new JPasswordField();
        t2.setBounds(250,190,150,30);
        add(t2);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/login.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(270,20,100,100);
        add(l3);


        b1 = new JButton("Login");
        b1.setBounds(190,250,120,30);
        b1.setFont(new Font("opensans",Font.BOLD,15));
        b1.addActionListener(this);
        b1.setBackground(new Color(59, 89, 182));
        add(b1);

        b2=new JButton("Exit");
        b2.setBounds(320,250,120,30);
        b2.setFont(new Font("opensans",Font.BOLD,15));
        b2.addActionListener(this);
        b2.setBackground(new Color(59, 89, 182));
        add(b2);

        setVisible(true);
        setSize(640,360);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1) {
            
            try {
                Connect c1 = new Connect();
                String u = t1.getText();
                @SuppressWarnings("deprecation")
				String v = t2.getText();
                String q = "select * from teacher where Faculty_ID = '"+u+"' and password = '"+v+"'";
                ResultSet rs = c1.s.executeQuery(q); 

                if(rs.next()) {
                	String w = rs.getString("First_name");
                    new TeacherFrame(w).setVisible(true);
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid login");
                }
            }
            catch(HeadlessException | SQLException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b2) {
            System.exit(0);
        }
    }
    
    public static void main(String[] arg){
    	@SuppressWarnings("unused")
		TeacherLogin l = new TeacherLogin();
    }

}
