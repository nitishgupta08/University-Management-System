package ums;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;

@SuppressWarnings("serial")
public class StudentFee extends JFrame implements ActionListener {
	JPanel contentPane;
	JTextField t1,t2,t3,t4,t5,t6;
	@SuppressWarnings("rawtypes")
	JComboBox  comboBox_2;
    JButton b1,b2,b3;
    Choice c1;

    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public StudentFee(String w) {
    super("Student Fee Form");
	setBounds(0,0, 852, 480);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
	c1 = new Choice();
    c1.setForeground(Color.BLACK);
	c1.setFont(new Font("opensans", Font.BOLD, 15));
	
	try {
		Connect c = new Connect();
        ResultSet rs = c.s.executeQuery("select * from student");
        while(rs.next()){
        	c1.add(rs.getString("Roll_no"));
        }
    }
	catch(Exception e) { }
	c1.setBounds(175, 50, 150, 30);
	contentPane.add(c1);
        
	JLabel l1 = new JLabel("Select Roll No");
	l1.setForeground(new Color(25, 25, 112));
	l1.setFont(new Font("opensans", Font.BOLD, 15));
	l1.setBounds(60, 50, 150, 30);
	contentPane.add(l1);

	JLabel l2 = new JLabel("First Name");
	l2.setForeground(new Color(25, 25, 112));
	l2.setFont(new Font("opensans", Font.BOLD, 15));
	l2.setBounds(60, 100, 150, 30);
	contentPane.add(l2);
	t2 = new JTextField();
	t2.setForeground(Color.BLACK);
	t2.setFont(new Font("opensans", Font.BOLD, 15));
	t2.setBounds(175, 100, 150, 30);
	t2.setEditable(false);
	contentPane.add(t2);
	
	JLabel l8 = new JLabel("Last Name");
	l8.setForeground(new Color(25, 25, 112));
	l8.setFont(new Font("opensans", Font.BOLD, 15));
	l8.setBounds(400, 100, 150, 30);
	contentPane.add(l8);
	t6 = new JTextField();
	t6.setForeground(Color.BLACK);
	t6.setFont(new Font("opensans", Font.BOLD, 15));
	t6.setBounds(500, 100, 150, 30);
	t6.setEditable(false);
	contentPane.add(t6);


	JLabel l3 = new JLabel("Father's Name");
	l3.setForeground(new Color(25, 25, 112));
	l3.setFont(new Font("opensans", Font.BOLD, 15));
	l3.setBounds(60, 150, 150, 30);
	contentPane.add(l3);
	t3 = new JTextField();
	t3.setForeground(Color.BLACK);
	t3.setFont(new Font("opensans", Font.BOLD, 15));
	t3.setBounds(175, 150, 150, 30);
	t3.setEditable(false);
	contentPane.add(t3);

	
	JLabel l4 = new JLabel("Branch");
	l4.setForeground(new Color(25, 25, 112));
	l4.setFont(new Font("opensans", Font.BOLD, 15));
	l4.setBounds(60, 250,100, 30);
	contentPane.add(l4);
	t4 = new JTextField();
	t4.setForeground(Color.BLACK);
	t4.setFont(new Font("opensans", Font.BOLD, 15));
	t4.setColumns(10);
	t4.setBounds(125,250,400, 30);
	t4.setEditable(false);
	contentPane.add(t4);
	
	
	JLabel l9 = new JLabel("Degree");
	l9.setForeground(new Color(25, 25, 112));
	l9.setFont(new Font("opensans", Font.BOLD, 15));
	l9.setBounds(60, 200, 150, 30);
	contentPane.add(l9);
	t5 = new JTextField();
	t5.setForeground(Color.BLACK);
	t5.setFont(new Font("opensans", Font.BOLD, 14));
	t5.setColumns(10);
	t5.setBounds(175, 200, 150, 30);
	t5.setEditable(false);
	contentPane.add(t5);

	JLabel l5 = new JLabel("Semester");
	l5.setForeground(new Color(25, 25, 112));
	l5.setFont(new Font("opensans", Font.BOLD, 15));
	l5.setBounds(400, 200, 150, 30);
	contentPane.add(l5);
	comboBox_2 = new JComboBox();
	comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "1st", "2nd", "3rd", "4th", "5th", "6th", "7th", "8th" }));
	comboBox_2.setFont(new Font("opensans", Font.BOLD, 14));
	comboBox_2.setForeground(Color.BLACK);
	comboBox_2.setBounds(500, 200, 150, 30);
	contentPane.add(comboBox_2);

	JLabel l6 = new JLabel("Total Payable");
	l6.setForeground(new Color(25, 25, 112));
	l6.setFont(new Font("opensans", Font.BOLD, 30));
	l6.setBounds(60, 350, 300,50);
	contentPane.add(l6);
    t1 = new JTextField();
	t1.setForeground(Color.BLACK);
	t1.setFont(new Font("opensans", Font.BOLD, 30));
	t1.setColumns(10);
	t1.setBounds(280, 350, 150, 50);
	contentPane.add(t1);
	
	try{
        Connect c = new Connect();
        ResultSet rs = c.s.executeQuery("select * from student where Roll_no = '"+w+"'");
        while(rs.next()){
            t2.setText(rs.getString("First_name"));
            t6.setText(rs.getString("Last_name"));
            t3.setText(rs.getString("Father_name"));
            t4.setText(rs.getString("Branch"));
            t5.setText(rs.getString("Degree"));
        }
    }
	catch(Exception e){}
        
	b1 = new JButton("Pay");
	b1.addActionListener(this);
	b1.setFont(new Font("opensans", Font.BOLD, 30));
	b1.setBounds(500, 350, 150, 50);
    b1.setBackground(Color.BLACK); 
	contentPane.add(b1);
	
	b3 = new JButton("Go");
	b3.addActionListener(this);
	b3.setFont(new Font("opensans", Font.BOLD, 25));
	b3.setBounds(325, 50, 150, 30);
    b3.setBackground(Color.BLACK); 
	contentPane.add(b3);

	b2 = new JButton("Cancel");
	b2.addActionListener(this);
	b2.setFont(new Font("opensans", Font.BOLD, 30));
	b2.setBounds(650, 350, 150, 50);
    b2.setBackground(Color.BLACK);    
	contentPane.add(b2);

	
	JPanel panel = new JPanel();
	panel.setBorder(new TitledBorder(new LineBorder(new Color(59, 89, 182), 2, true), "Form", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 89, 182)));
	panel.setBackground(new Color(211, 211, 211));
	panel.setBounds(10, 10, 830, 430);
    contentPane.setBackground(Color.WHITE);
    panel.setBackground(Color.WHITE);     
	contentPane.add(panel);

    }
    public void actionPerformed(ActionEvent ae) {
        try {
        	if(ae.getSource() == b1){
	            try {
	            Connect con = new Connect();
	            String sql = "insert into fee(Roll_no, First_name, Last_name, Semester, Amount_Paid) values(?, ?, ?, ?, ?)";
				PreparedStatement st = con.c.prepareStatement(sql);
				st.setString(1, c1.getSelectedItem());
				st.setString(2, t2.getText());
				st.setString(3, t6.getText());
				st.setString(4, (String) comboBox_2.getSelectedItem());
				st.setString(5, t1.getText());
	
				int i = st.executeUpdate();
				if (i > 0) {
					JOptionPane.showMessageDialog(null, "Successfully Paid");
				}
				else
					JOptionPane.showMessageDialog(null, "error");
		        }catch(Exception e){
		          e.printStackTrace();
		        }
		    }
            
        	else if(ae.getSource() == b2){
            	new Mainframe().setVisible(true);
                this.setVisible(false);
            }
        	else if(ae.getSource() == b3){
        		String w = c1.getSelectedItem();
	        	new StudentFee(w).setVisible(true);
	            setVisible(false);
                this.setVisible(false);
            }
        }catch(Exception e){
            
        }
    }
    public static void main(String[] args) {
        new StudentFee("w").setVisible(true);
    }
}

