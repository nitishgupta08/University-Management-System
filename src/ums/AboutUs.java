package ums;
import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class AboutUs extends JFrame{
	 JPanel contentPane;

    public AboutUs() {
        
        super("About Us");
        setSize(800,420);
        setLocationRelativeTo(null);
	
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel l3 = new JLabel("University Mangement System");
        l3.setForeground(new Color(59, 89, 182));
        l3.setFont(new Font("opensans", Font.BOLD, 35));
        l3.setBounds(50, 15, 600, 55);
        contentPane.add(l3);

        JLabel l6 = new JLabel("Developed By: ");
        l6.setFont(new Font("opensans", Font.BOLD, 25));
        l6.setBounds(50, 100, 600, 35);
        contentPane.add(l6);

        JLabel l7 = new JLabel("Aryan Seth (19UCC132)");
        l7.setFont(new Font("opensans", Font.BOLD, 20));
        l7.setBounds(50, 150, 600, 34);
        contentPane.add(l7);
        
        JLabel l8 = new JLabel("Dhruv Tripathi (19UCC076)");
        l8.setFont(new Font("opensans", Font.BOLD, 20));
        l8.setBounds(50, 200, 600, 34);
        contentPane.add(l8);
        
        JLabel l9 = new JLabel("Sanjana Bansal (19UCC135)");
        l9.setFont(new Font("opensans", Font.BOLD, 20));
        l9.setBounds(50, 250, 600, 34);
        contentPane.add(l9);
        
        JLabel l10 = new JLabel("Nitish Kumar Gupta (19UCC131)");
        l10.setFont(new Font("opensans", Font.BOLD, 20));
        l10.setBounds(50, 300, 600, 34);
        contentPane.add(l10);
   
        contentPane.setBackground(Color.WHITE);
    }
    public static void main(String[] args) {
        new AboutUs().setVisible(true);			
}

}
