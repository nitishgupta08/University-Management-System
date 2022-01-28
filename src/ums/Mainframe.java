package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class Mainframe extends JFrame implements ActionListener {

	Mainframe(){
        super("Admin Control Panel");
        
        setSize(852,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("ums/Images/ap.jpg"));
        Image i3 = ic.getImage().getScaledInstance(852,480,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(ic3);
        add(l1);
        JLabel lab = new JLabel("Welcome Admin");
        lab.setFont(new Font("opensans",Font.BOLD,35));
        lab.setForeground(Color.BLACK);
        lab.setBounds(10,370,300,35);
        l1.add(lab);
        
        JMenuBar mb  = new JMenuBar();
        JMenu admin = new JMenu("ADMIN");
        JMenuItem m1 = new JMenuItem("Add Teacher");
        JMenuItem m2 = new JMenuItem("Add Student");
        JMenuItem m3 = new JMenuItem("Add Subject");
        admin.setForeground(Color.GREEN);
        m1.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/teach.png"));
        Image image1 = icon1.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        m1.setIcon(new ImageIcon(image1));
        m1.setForeground(Color.BLACK);
        m1.setBackground(Color.WHITE);  
        m2.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/stud.png"));
        Image image2 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m2.setIcon(new ImageIcon(image2));
        m2.setForeground(Color.BLACK);
        m2.setBackground(Color.WHITE);
        m3.setFont(new Font("opensans",Font.BOLD,16));
		@SuppressWarnings("unused")
		ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/stud.png"));
        @SuppressWarnings("unused")
		Image image3 = icon2.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        m3.setIcon(new ImageIcon(image2));
        m3.setForeground(Color.BLACK);
        m3.setBackground(Color.WHITE); 
        m1.addActionListener(this);
        m2.addActionListener(this);
        m3.addActionListener(this);

  
        JMenu user = new JMenu("Details");
        JMenuItem u1 = new JMenuItem("Student Details");
        JMenuItem u2 = new JMenuItem("Teacher Details");
        user.setBackground(Color.WHITE);
        u1.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon4 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/sd.png"));
        Image image4 = icon4.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u1.setIcon(new ImageIcon(image4));
        u1.setForeground(Color.BLACK);
        u1.setBackground(Color.WHITE);
        u2.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/td.png"));
        Image image5 = icon5.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        u2.setIcon(new ImageIcon(image5));
        u2.setBackground(Color.WHITE);
        u2.setForeground(Color.BLACK);
        u1.addActionListener(this);
        u2.addActionListener(this);
        
        JMenu report = new JMenu("Update Details");
        JMenuItem r1 = new JMenuItem("Update Students");
        JMenuItem r2 = new JMenuItem("Update Teachers");
        report.setBackground(Color.WHITE);      
        r1.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon7 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/update.png"));
        Image image7 = icon7.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r1.setIcon(new ImageIcon(image7));    
        r1.setBackground(Color.WHITE); 
        r1.setForeground(Color.BLACK);
        r1.addActionListener(this);
        r2.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon iconn = new ImageIcon(ClassLoader.getSystemResource("ums/Images/update.png"));
        Image imagee = iconn.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        r2.setIcon(new ImageIcon(imagee));
        r2.setBackground(Color.WHITE);
        r2.setForeground(Color.BLACK);
        r2.addActionListener(this);
        
      
        JMenu fee = new JMenu("Fee Details");
        JMenuItem s2 = new JMenuItem("Student Fee Form");
        fee.setBackground(Color.WHITE); 
        s2.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon16 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/ff.png"));
        Image image17 = icon16.getImage().getScaledInstance(20, 20,Image.SCALE_DEFAULT);
        s2.setIcon(new ImageIcon(image17)); 
        s2.setBackground(Color.WHITE);
        s2.setForeground(Color.BLACK);
        s2.addActionListener(this);
        

        JMenu about = new JMenu("About");
        JMenuItem aboutus = new JMenuItem("About Us");
        about.setBackground(Color.WHITE);      
        aboutus.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon21 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/abu.jpg"));
        Image image22 = icon21.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        aboutus.setIcon(new ImageIcon(image22)); 
        aboutus.setBackground(Color.WHITE);
        aboutus.setForeground(Color.BLACK);
        about.add(aboutus);
        aboutus.addActionListener(this);
        
        
        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Sure?");
        ex.setForeground(Color.BLACK);
        ex.setFont(new Font("opensans",Font.BOLD,16));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        
      
        
        

        admin.add(m1);
        admin.add(m2);
        admin.add(m3);
        
        user.add(u1);
        user.add(u2);
        
        report.add(r1);
        report.add(r2);
        
        fee.add(s2);
        exit.add(ex);
         
        mb.add(admin);
        mb.add(user);
        mb.add(report);
        mb.add(fee);
        mb.add(exit);
        mb.add(about);
        mb.add(exit);
  
        
        setJMenuBar(mb);    
        setFont(new Font("opensans",Font.BOLD,18));
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    	
        String msg = ae.getActionCommand();
        
        if(msg.equals("Add Student")) {
        	new AddStudent().f.setVisible(true);
            setVisible(false);
            
        }
        else if(msg.equals("Add Teacher")) {
            new AddTeacher().f.setVisible(true);
            setVisible(false);
        }
        else if(msg.equals("Add Subject")) {
            new AddSubject().f.setVisible(true);
            setVisible(false);
        }
        else if(msg.equals("Update Students")) {
            new UpdateStudent().f.setVisible(true);
            setVisible(false);
        }
        else if(msg.equals("Update Teachers")) {
            new UpdateTeacher().f.setVisible(true);
            setVisible(false);
        }
       
        else if(msg.equals("Student Details")) {
            new StudentDetails().setVisible(true);
            setVisible(false);
            
        }
        else if(msg.equals("Teacher Details")) {
            new TeacherDeatails().setVisible(true);
            setVisible(false);
        }
        else if(msg.equals("Student Fee Form")) {
            new StudentFee("a").setVisible(true);
            setVisible(false);
           
        }
        else if(msg.equals("About Us")) {
            new AboutUs().setVisible(true);
        }
        else if(msg.equals("Sure?"))	{
        	new Splash().f.setVisible(true);
        	setVisible(false);
        }       
    }
    
    
    public static void main(String[] args){
        new Mainframe().setVisible(true);
        
    }
}
