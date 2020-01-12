import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
public class Signup_Page extends JFrame implements ActionListener{
	JTextField text_studentname,text_username,text_password,text_checkpassword;
	JComboBox batch_selection;
	JLabel labelsignup,label_studentname,label_username,label_password,label_checkPassword,label_batch;
	JButton button_signup,button_reset;
	public Signup_Page() {
		setTitle("Student Sign Up");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(500,100,600, 400);
		setLayout(null);
		//for headline
		labelsignup=new JLabel("Sign Up for Student");
		labelsignup.setFont(new Font("Arial",Font.ITALIC,20));
		labelsignup.setBounds(200, 0, 200, 20);
		add(labelsignup);
		//for student name
		 label_studentname= new JLabel("Name of Student"); 
		 label_studentname.setBounds(15,35,150,20);
		 text_studentname=new JTextField();
		 text_studentname.setBounds(150, 35, 150, 20);
		 add(label_studentname);
		 add(text_studentname);
		//for username
		 label_username= new JLabel("Username/Email"); 
		 label_username.setBounds(15,60,150,20);
		 text_username=new JTextField();
		 text_username.setBounds(150, 60, 150, 20);
		 add(label_username);
		 add(text_username);
		 //for password
		 label_password = new JLabel("Password");
		 label_password.setBounds(15,85,150,20);
		 text_password = new JTextField();
		 text_password.setBounds(150,85,150,20);
		 add(label_password);
		 add(text_password);
		 //for checkpassword
		 label_checkPassword = new JLabel("Verify Password");
		 label_checkPassword.setBounds(15,110,150,20);
		 text_checkpassword = new JTextField();
		 text_checkpassword.setBounds(150,110,150,20);
		 add(label_checkPassword);
		 add(text_checkpassword);
		 //for batch
		 label_batch=new JLabel("Batch");
		 label_batch.setBounds(15, 135, 150, 20);
		 batch_selection = new JComboBox();
		 batch_selection.addItem("24 A");
		 batch_selection.addItem("24 B");
		 batch_selection.addItem("25 A");
		 batch_selection.addItem("25 B");
		 batch_selection.addItem("25 C");
		 batch_selection.addItem("25 D");
		 batch_selection.setBounds(150, 135, 150, 20);
		 add(label_batch);
		 add(batch_selection);
		 //for buttons
		 button_signup = new JButton("Sign Up");
		 button_signup.setBounds(50,160,100,20);
		 button_reset = new JButton("Reset");
		 button_reset.setBounds(180,160,100,20);
		 add(button_signup);
		 add(button_reset);
		 button_signup.addActionListener(this);
		 button_reset.addActionListener(this);
	}
	public static void main(String[] args) {
		new Signup_Page().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_reset)) {
			text_studentname.setText(null);
			text_username.setText(null);
			text_password.setText(null);
			text_checkpassword.setText(null);
			batch_selection.setSelectedItem(null);
		}
		if(e.getSource().equals(button_signup)) {
			new Login_page().setVisible(true);
		}
	}

}
