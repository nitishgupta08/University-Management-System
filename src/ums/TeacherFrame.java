package ums;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TeacherFrame extends JFrame implements ActionListener {
	TeacherFrame(String st){
		super("Teacher Control Panel");
        
        setSize(852,480);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ic =  new ImageIcon(ClassLoader.getSystemResource("ums/Images/t1.jpg"));
        Image i3 = ic.getImage().getScaledInstance(852,480,Image.SCALE_DEFAULT);
        ImageIcon ic3 = new ImageIcon(i3);
        JLabel l1 = new JLabel(ic3);
        add(l1);
        JLabel lab = new JLabel("Welcome "+st);
        lab.setFont(new Font("opensans",Font.BOLD,30));
        lab.setForeground(Color.BLACK);
        lab.setBounds(10,370,800,35);
        l1.add(lab);
        
        JMenuBar mb  = new JMenuBar();

          
        JMenu attendance = new JMenu("Attendance");
        JMenuItem a2 = new JMenuItem("Student Attendance");
        attendance.setBackground(Color.WHITE);      
        a2.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon25 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/ta.png"));
        Image image26 = icon25.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        a2.setIcon(new ImageIcon(image26));
        a2.setMnemonic('N');
        a2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, ActionEvent.CTRL_MASK));
        a2.setBackground(Color.WHITE);
        attendance.add(a2);
        a2.addActionListener(this);
        

        JMenu exam = new JMenu("Examination");
        JMenuItem c1 = new JMenuItem("Upload Result");
        exam.setForeground(Color.BLUE);
        c1.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon30 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/ed.jpg"));
        Image image31 = icon30.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        c1.setIcon(new ImageIcon(image31));
        c1.setMnemonic('Q');
        c1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        c1.setBackground(Color.WHITE);
        exam.add(c1);
        c1.addActionListener(this);

        JMenu exit = new JMenu("Logout");
        JMenuItem ex = new JMenuItem("Sure?");
        exit.setForeground(Color.WHITE);
        ex.setFont(new Font("opensans",Font.BOLD,16));
        ImageIcon icon11 = new ImageIcon(ClassLoader.getSystemResource("ums/Images/abu.jpg"));
        Image image11 = icon11.getImage().getScaledInstance(25, 25,Image.SCALE_DEFAULT);
        ex.setIcon(new ImageIcon(image11));
        ex.setMnemonic('Z');
        ex.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        ex.setBackground(Color.WHITE);
        ex.addActionListener(this);
        
        JMenu pass = new JMenu("Password");
        JMenuItem pa = new JMenuItem("Change Password");
        pass.setForeground(Color.WHITE);
        pa.setFont(new Font("opensans",Font.BOLD,16));
        pa.setMnemonic('P');
        pa.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        pa.setBackground(Color.WHITE);
        pa.addActionListener(this);

        pass.add(pa);

        exit.add(ex); 
        mb.add(attendance);
        mb.add(exam);
        mb.add(pass);
        mb.add(exit);
        setJMenuBar(mb);    
        setFont(new Font("opensans",Font.BOLD,18));
        setLayout(new FlowLayout());
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
    	
        String msg = ae.getActionCommand();
        
    
        if(msg.equals("Student Attendance")){
        	String w = TeacherLogin.t1.getText();
            new StudentAttendance(w).setVisible(true);
            setVisible(false);
        }
      
        else if(msg.equals("Upload Result")) {
        	String w = TeacherLogin.t1.getText();
            new UploadResult(w).setVisible(true);
            setVisible(false);
           
        }
        else if(msg.equals("Change Password")) {
        	new TeacherPassword().f.setVisible(true);
        	setVisible(false);
        }
        else if(msg.equals("Sure?"))	{
        	new Splash().f.setVisible(true);
        	setVisible(false);
        }       
    }   

}
