package ums;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Splash implements ActionListener {
	JFrame f;
    JLabel id1,id2;
    JButton b1,b2,b3;

    public Splash() {
        f = new JFrame("University Management System");
        f.setBackground(Color.white);
        f.setLayout(null);
        f.setSize(640,360);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        id1=new JLabel();
        id1.setBounds(0,0,640,360);
        id1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ums/Images/uni.jpg"));
        Image i3 = img.getImage().getScaledInstance(640, 360,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id1.setIcon(icc3);

        id2 = new JLabel("Who are You?");
        id2.setBounds(100,50,600,50);
        id2.setFont(new Font("opensans",Font.BOLD,65));
        id2.setForeground(Color.black);
        id1.add(id2);
        f.add(id1); 
       
        b1 = new JButton("Admin");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(100,200,120,50);
        b1.setFont(new Font("opensans",Font.BOLD,20));
        id1.add(b1);

        b2=new JButton("Faculty");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(240,200,120,50);
        b2.setFont(new Font("opensans",Font.BOLD,20));
        id1.add(b2);
        
        b3=new JButton("Student");   
        b3.setBackground(new Color(59, 89, 182));
        b3.setBounds(390,200,120,50);
        b3.setFont(new Font("opensans",Font.BOLD,20));
        id1.add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        
       
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1) {
            
            try {
                    new Login().setVisible(true);
                    f.setVisible(false);
            }
            catch(HeadlessException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b2) {
            try {
                    new TeacherLogin().setVisible(true);
                    f.setVisible(false);
            }
            catch(HeadlessException e) {
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == b3) {
            try {
                    new StudentLogin().setVisible(true);
                    f.setVisible(false);
            }
            catch(HeadlessException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] arg){
    	 new Splash().f.setVisible(true);
    }
}
