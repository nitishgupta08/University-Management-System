package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TeacherPassword implements ActionListener{
	JFrame f;
	JLabel id1,id2,id3,id4;
    JTextField t1,t2;
    JButton b1,b2;

    
     
    public TeacherPassword()  {
        f = new JFrame("Change Password");
        f.setLayout(null);
        f.setSize(640,360);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        id1=new JLabel();
        id1.setBounds(0,0,640,360);
        id1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ums/Images/sback.jpg"));
        Image i3 = img.getImage().getScaledInstance(640, 360,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id1.setIcon(icc3);
        
        id2 = new JLabel("Enter New Password");
        id2.setBounds(150,50,350,30);
        id2.setFont(new Font("opensans",Font.BOLD,30));
        id2.setForeground(Color.black);
        id1.add(id2);
        f.add(id1);
        
        t2=new JPasswordField();
        t2.setBounds(220,125,150,40);
        t2.setFont(new Font("opensans",Font.PLAIN,20));
        id1.add(t2);
        
      
        b1 = new JButton("Submit");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(150,200,120,50);
        id1.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(300,200,120,50);
        id1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
      
        String sname = t2.getText();
        String st = TeacherLogin.t1.getText();
        
        if(ae.getSource() == b1){
            try{
                Connect cc = new Connect();
                String q = "update teacher set password = '"+sname+"' where  Faculty_ID = '"+st+"'";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Password Updated");
                f.setVisible(false);
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b2){
            f.setVisible(false);
            new TeacherFrame(st).setVisible(true);
            
        }
    }
    public static void main(String[ ] arg){
        new TeacherPassword().f.setVisible(true);
    }
}


