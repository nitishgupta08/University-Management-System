package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddSubject implements ActionListener {
	JFrame f;
    JLabel id1,id2,id3,id4;
    JTextField t1,t2;
    JButton b1,b2;

    
     
    public AddSubject()  {
        f = new JFrame("Add Subject");
        f.setLayout(null);
        f.setSize(852,480);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        id1=new JLabel();
        id1.setBounds(0,0,852,480);
        id1.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("ums/Images/sback.jpg"));
        Image i3 = img.getImage().getScaledInstance(852, 480,Image.SCALE_DEFAULT);
        ImageIcon icc3 = new ImageIcon(i3);
        id1.setIcon(icc3);

        id2 = new JLabel("New Subject Details");
        id2.setBounds(200,30,500,50);
        id2.setFont(new Font("opensans",Font.BOLD,45));
        id2.setForeground(Color.black);
        id1.add(id2);
        f.add(id1);

 
        id3 = new JLabel("SUBCODE");
        id3.setBounds(50,150,200,40);
        id3.setFont(new Font("opensans",Font.BOLD,20));
        id1.add(id3);
        t1=new JTextField();
        t1.setBounds(200,150,200,40);
        t1.setFont(new Font("opensans",Font.PLAIN,20));
        id1.add(t1);
        
        id4 = new JLabel("Subject Name");
        id4.setBounds(50,200,200,40);
        id4.setFont(new Font("opensans",Font.BOLD,20));
        id1.add(id4);
        t2=new JTextField();
        t2.setBounds(200,200,520,40);
        t2.setFont(new Font("opensans",Font.PLAIN,20));
        id1.add(t2);
        
      
        b1 = new JButton("Submit");
        b1.setBackground(new Color(59, 89, 182));
        b1.setBounds(480,300,120,50);
        id1.add(b1);

        b2=new JButton("Cancel");   
        b2.setBackground(new Color(59, 89, 182));
        b2.setBounds(600,300,120,50);
        id1.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
       
    }
    
    public void actionPerformed(ActionEvent ae){
        
      
    	String subcode = t1.getText();
        String sname = t2.getText();
        
        
        if(ae.getSource() == b1){
            try{
                Connect cc = new Connect();
                String q = "insert into subject values('"+subcode+"','"+sname+"')";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Subject Successfully Added");
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b2){
            f.setVisible(false);
            new Mainframe().setVisible(true);
            
        }
    }
    public static void main(String[ ] arg){
        new AddSubject().f.setVisible(true);
    }
}
