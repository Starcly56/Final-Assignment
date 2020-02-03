import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
public class Login_page extends JFrame implements ActionListener {
	//adding required fields 
	JTextField text_username;
	JPasswordField text_password;
	JLabel label_username,label_password,label_login;
	JButton button_login,button_cancel,button_createaccount;
	JCheckBox show_password;
	//Storing of the student ID, Email and Token during the login
	public static int USER_ID=0;
	public static  String USER_EMAIL="";
	public static  String USER_TOKEN="";
	//Instance of Database
	Database_Connection dc= new Database_Connection();
	ResultSet output;
	//constructor
	public Login_page() { 
		setTitle("Student Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Login_Image.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setResizable(false);
		setBounds(400,150,600,400);
		setLayout(null);

		//for title
		label_login=new JLabel("Welcome to Login Page");
		label_login.setFont(new Font("Arial",Font.BOLD,20));
		label_login.setForeground(Color.black);
		label_login.setBounds(170,5,350,25);
		add(label_login);

		//for username label
		label_username= new JLabel("Username:"); 
		label_username.setFont(new Font("Arial",Font.BOLD,15));
		label_username.setBounds(170,50,150,20);
		label_username.setForeground(Color.black);
		add(label_username);
		//for username textfield
		text_username=new JTextField();
		text_username.setFont(new Font("Arial",Font.BOLD,15));
		Border border = BorderFactory.createLineBorder(Color.white, 1);
		text_username.setBorder(border);
		text_username.setBounds(170, 80, 200, 20);
		add(text_username);
		
		//for label of password
		label_password = new JLabel("Password:");
		label_password.setFont(new Font("Arial",Font.BOLD,15));
		label_password.setBounds(170,110,150,20);
		label_password.setForeground(Color.black);
		add(label_password);
		//for password field 
		text_password = new JPasswordField();
		text_password.setFont(new Font("Arial",Font.BOLD,15));
		text_password.setBorder(border);
		text_password.setEchoChar('+');
		text_password.setBounds(170,140,200,20);
		add(text_password);
		//for show password
		show_password = new JCheckBox("Show Password");
		show_password.setBounds(170,170,250,20);
		show_password.setContentAreaFilled(false);
		add(show_password);
		//for label create account
		button_createaccount=new JButton("Don't have an account!! Click to create");
		button_createaccount.setBorderPainted( false );
		button_createaccount.setContentAreaFilled(false);
		button_createaccount.setForeground(Color.black);
		button_createaccount.setBounds(150,200,250,20);
		add(button_createaccount);
		
		//for login and cancel button
		button_login = new JButton("Login");
		button_login.setBounds(170,230,80,25);
		button_login.setBackground(Color.cyan);
		button_cancel = new JButton("Cancel");
		button_cancel.setBounds(270,230,80,25);
		button_cancel.setBackground(Color.red);
		add(button_login);
		add(button_cancel);
		//adding action listener in buttons 
		button_createaccount.addActionListener(this);
		button_cancel.addActionListener(this);
		button_login.addActionListener(this);
		
		//showing and hiding password 
		show_password.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				 if (e.getStateChange() == ItemEvent.SELECTED) {
					 	text_password.setEchoChar((char) 0);
			        } else {
			        	 text_password.setEchoChar('+');
			        }
				
			}
		});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		//storing username and password in variables
		String username=text_username.getText();
		String password=text_password.getText().toString();
		if(e.getSource().equals(button_cancel))
		{
			//disposing the login page
			dispose();
			//redirecting to welcome page
			new Welcome_page().setVisible(true);
		}
		if(e.getSource().equals(button_createaccount))
		{
			//disposing the login page
			dispose();
			//redirecting to sign up page
			new Signup_Page().setVisible(true);
		}
		if(e.getSource().equals(button_login)) {
			//login validation
			if(username.isEmpty()&&password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fields are empty");
			}
			else if(username.isEmpty()){
				JOptionPane.showMessageDialog(null, "Please input valid Email");
			}
			else if(password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please input valid Password.");
			}
			//admin login
			else if(username.equals("admin@gmail.com")&&password.equals("admin123"))
			{
				JOptionPane.showMessageDialog(null, "Logged in as admin");
				dispose();
				new Admin_Dashboard().setVisible(true);
			}
			//student login
			else
			{
				try {
					output=dc.studentLogin(username, password);
					if(output.next()) {
						//saving email, id and token of the logged in student
						USER_EMAIL = output.getString("Email");
						USER_ID = output.getInt("ID");
						USER_TOKEN=output.getString("Token");
						JOptionPane.showMessageDialog(null, "Logged in as "+USER_EMAIL);
						//disposing the login form
						dispose();
						//redirecting to student dashboard
						new Student_Dashboard().setVisible(true);
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
