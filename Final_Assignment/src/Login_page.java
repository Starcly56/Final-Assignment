import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;
public class Login_page extends JFrame implements ActionListener {
	JTextField text_username;
	JPasswordField text_password;
	JLabel label_username,label_password,label_login;
	JButton button_login,button_cancel,button_createaccount;
	public static void main(String[] args) {
		//name specific no -->anonymous
//		new Adding_Two_Numbers().setVisible(true);
		new Login_page().setVisible(true);
	}
	public  Login_page() { 
		setTitle("Student Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		setBounds(500,100,600, 400);
//		Container container=getContentPane();
		setLayout(null);
		//for title
		label_login=new JLabel("Welcome to Login Page");
		label_login.setFont(new Font("Arial",Font.ITALIC,20));
		label_login.setForeground(Color.white);
		label_login.setBounds(170,5,350,25);
		 add(label_login);
		//for username
		 label_username= new JLabel("Username"); 
		 label_username.setBounds(150,50,150,20);
		 text_username=new JTextField();
		 text_username.setBounds(250, 50, 150, 20);
		 add(label_username);
		 add(text_username);
		 //for password
		 label_password = new JLabel("Token Password");
		 label_password.setBounds(150,100,150,20);
		 text_password = new JPasswordField();
		 text_password.setBounds(250,100,150,20);
		 add(label_password);
		 add(text_password);
		 //for label create account
		 button_createaccount=new JButton("Create an account!!!!");
		 button_createaccount.setBorderPainted( false );
		 button_createaccount.setBackground(null);
		 button_createaccount.setBounds(150,150,150,20);
		 add(button_createaccount);
		 //for button
		 button_login = new JButton("Login");
		 button_login.setBounds(150,200,80,20);
		 button_login.setBackground(Color.cyan);
		 button_cancel = new JButton("Cancel");
		 button_cancel.setBounds(250,200,100,20);
		 button_cancel.setBackground(Color.red);
		 add(button_login);
		 add(button_cancel);
		 button_createaccount.addActionListener(this);
		 button_cancel.addActionListener(this);
		 button_login.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String username=text_username.getText();
		String token=text_password.getText().toString();
		System.out.println(token);
		if(e.getSource().equals(button_cancel))
		{
			dispose();
		}
		if(e.getSource().equals(button_createaccount))
		{
			new Signup_Page().setVisible(true);
		}
		if(e.getSource().equals(button_login)) {
			if(username.isEmpty()||token.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please input valid Email Or Password");
			}
			else if(username.equals("admin@gmail.com")&&token.equals("admin123"))
			{
				JOptionPane.showMessageDialog(null, "Logged in as admin");
				new Admin_Dashboard().setVisible(true);
			}
			else
			{
				try {
					Database_Connection dc= new Database_Connection();
					ResultSet output=dc.studentLogin(username, token);
					if(output.next()) {
						JOptionPane.showMessageDialog(null, "Logged in as "+username);
						new Select_Questions().setVisible(true);
					}
					else {
						JOptionPane.showMessageDialog(null, "Wrong Credentials");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, " Sys Error");
				}
			}
		}
	}
}
