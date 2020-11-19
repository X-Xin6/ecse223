package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import ca.mcgill.ecse.flexibook.Controller.FlexibookController;
import ca.mcgill.ecse.flexibook.Controller.InvalidInputException;

public class AddServiceView {
	public static void main(String[] args) {
	JPanel panel = new JPanel();
	JFrame frame = new JFrame();
	JLabel Title = new JLabel();
	frame.setSize(550, 400);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(panel);
	
	
	panel.setLayout(null);
	
	JLabel slabel = new JLabel("Service Name");
	slabel.setBounds(70, 70, 80, 25);
	panel.add(slabel);
	
	JTextField sTest = new JTextField(70);
	sTest.setBounds(70,110,165,25);
	panel.add(sTest);
	
	JLabel dlabel = new JLabel("Service duration");
	dlabel.setBounds(70,150,120,25);
	panel.add(dlabel);
	
	JButton cbutton = new JButton("Create new Service");
	cbutton.setBounds(70, 250, 150, 25);
	panel.add(cbutton);
	
	JButton button = new JButton("Cancel");
	button.setBounds(330, 250, 80, 25);
	panel.add(button);
	frame.setVisible(true);
	
	}
}
