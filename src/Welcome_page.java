import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 *
 *@author Ujjwal
 *
 */

import javax.swing.*;
public class Welcome_page extends JFrame implements ActionListener {
	JLabel label_welcome;
	JButton button_go;
	public Welcome_page() {
		setTitle("Welcome");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100,600,400);
		setLayout(null);
		//for welcome 
		 label_welcome= new JLabel("Welcome to Online MCQ Examination"); 
		 label_welcome.setFont(new Font("Arial",Font.ITALIC,20));
		 label_welcome.setBounds(120,10,350,20);
		 add(label_welcome);
		 //for welcome button 
		 button_go=new JButton("Go");
		 button_go.setBounds(250, 200, 100, 20);
		 add(button_go);
		 setVisible(true);
		 button_go.addActionListener(this);
	}
	public static void main(String[] args) {
		new Welcome_page();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_go))
		{
			new Login_page().setVisible(true);
		}
	}

}
