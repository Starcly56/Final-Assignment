import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
public class Signup_Page extends JFrame implements ActionListener{
	//adding required fields
	JTextField text_studentname,text_email,text_address,text_phonenumber,text_token;
	JPasswordField text_password;
	JComboBox batch_selection;
	JLabel labelsignup,label_studentname,label_email,label_password,label_address,label_phonenumber,label_batch,label_Gender,label_token;
	JRadioButton male,female;
	JButton button_signup,button_back_login;
	//instance of the database
	Database_Connection dc= new Database_Connection();
	ResultSet resultset;
	//constructor
	public Signup_Page() {
		setTitle("Student Sign Up");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400,150,600,400);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Signup_Page.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setLayout(null);
		
		//for headline
		labelsignup=new JLabel("Sign Up for Student");
		labelsignup.setFont(new Font("Arial",Font.BOLD,20));
		labelsignup.setBounds(200, 0, 200, 25);
		add(labelsignup);
		
		//for student name
		 label_studentname= new JLabel("Name of Student:"); 
		 label_studentname.setBounds(160,50,150,20);
		 text_studentname=new JTextField();
		 text_studentname.setBounds(260, 50, 150, 20);
		 add(label_studentname);
		 add(text_studentname);
		 
		//for email
		 label_email= new JLabel("Email:"); 
		 label_email.setBounds(160,80,150,20);
		 text_email=new JTextField();
		 text_email.setBounds(260, 80, 150, 20);
		 add(label_email);
		 add(text_email);
		 
		//for password
		 label_password= new JLabel("Password:"); 
		 label_password.setBounds(160,110,150,20);
		 text_password=new JPasswordField();
		 text_password.setBounds(260, 110, 150, 20);
		 add(label_password);
		 add(text_password);
		 
		 //for Gender
		 label_Gender=new JLabel("Gender:");
		 label_Gender.setBounds(160, 140, 150, 20);
		 male=new JRadioButton("Male",true);
		 female= new JRadioButton("Female");
		 male.setBounds(260, 140, 80, 20);
		 male.setContentAreaFilled(false);
		 female.setBounds(340, 140, 80, 20);
		 female.setContentAreaFilled(false);
		 ButtonGroup bg= new ButtonGroup();
		 bg.add(male);
		 bg.add(female);
		 add(label_Gender);
		 add(male);
		 add(female);
		 
		 //for address
		 label_address = new JLabel("Address:");
		 label_address.setBounds(160,170,150,20);
		 text_address = new JTextField();
		 text_address.setBounds(260,170,150,20);
		 add(label_address);
		 add(text_address);
		 
		 //for phone number
		 label_phonenumber = new JLabel("Phone Number:");
		 label_phonenumber.setBounds(160,200,150,20);
		 text_phonenumber = new JTextField();
		 text_phonenumber.setBounds(260,200,150,20);
		 add(label_phonenumber);
		 add(text_phonenumber);
		 
		 //for batch
		 label_batch=new JLabel("Batch:");
		 label_batch.setBounds(160, 230, 150, 20);
		 batch_selection = new JComboBox();
		 batch_selection.addItem("24 A");
		 batch_selection.addItem("24 B");
		 batch_selection.addItem("25 A");
		 batch_selection.addItem("25 B");
		 batch_selection.addItem("25 C");
		 batch_selection.addItem("25 D");
		 batch_selection.setBounds(260, 230, 150, 20);
		 add(label_batch);
		 add(batch_selection);
		 
		 //for buttons
		 button_signup = new JButton("Sign Up");
		 button_signup.setBounds(170,260,100,20);
		 button_signup.setForeground(Color.white);
		 button_signup.setBackground(Color.decode("#D4AF37"));
		 button_back_login = new JButton("Back to Login");
		 button_back_login.setBounds(280,260,120,20);
		 button_back_login.setForeground(Color.blue);
		 button_back_login.setBackground(Color.green);
		 add(button_signup);
		 add(button_back_login);
		 
		//for tokennumber
		 label_token = new JLabel("Token");
		 label_token.setBounds(160,290,150,20);
		 text_token = new JTextField();
		 text_token.setBounds(260,290,150,20);
		 text_token.setEditable(false);
		 label_token.setVisible(false);
		 text_token.setVisible(false);
		 text_token.setText(dc.generateToken());
		 add(label_token);
		 add(text_token);
		 button_signup.addActionListener(this);
		 button_back_login.addActionListener(this);
		 //allowing only digits in the phone number field 
		 text_phonenumber.addKeyListener(new KeyAdapter() {
		        public void keyTyped(KeyEvent e) {
		        char c = e.getKeyChar();
		        if (!Character.isDigit(c))
		        		{
		             e.consume();
		              JOptionPane.showMessageDialog(null, "Only numbers are allowed!");
		           }
		         }
		       });
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//saving the data in variables 
		String name = text_studentname.getText();
		String email = text_email.getText();
		String password=text_password.getText();
		String address = text_address.getText();
		String batch = batch_selection.getSelectedItem().toString();
		String phonenumber = text_phonenumber.getText();
		String token=text_token.getText();
		String gender="";
		//for gender
		if(male.isSelected()) {
			gender=male.getText().toString();
		}
		else if(female.isSelected()){
			gender=female.getText().toString();
		}
		//for sign up button
		if(e.getSource().equals(button_signup)) {
			//validation for fields
			if(name.isEmpty()||email.isEmpty()||password.isEmpty()||address.isEmpty()||batch.isEmpty()||phonenumber.isEmpty()||gender.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all the fields.");
			}
			else if(!email.contains("@"))
			{
				JOptionPane.showMessageDialog(null, "Email must contain '@'.");
			}
			else if(!(password.length()>=6)) {
				JOptionPane.showMessageDialog(null, "Password must be of 6 characters.");
			}
			else if(!(phonenumber.length()==10)) {
				JOptionPane.showMessageDialog(null, "Enter a valid phone number for eg;1234567890.");
			}
			else { 
				try {
					//inserting the details of the student
					int output=dc.insertStudentDetails(name, batch,gender, email,password, address,phonenumber,token);
					if(output>0) {
						JOptionPane.showMessageDialog(null, "Your account is created with "+email+" as username.");
						label_token.setVisible(true);
						text_token.setVisible(true);
						dispose();
						//redirecting to login page
						new Login_page().setVisible(true);
					}
					else { 
						JOptionPane.showMessageDialog(null, "Student details not registered");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, " Sys Error");
				}
			}
		}

		if(e.getSource().equals(button_back_login)) {
			dispose();
			//redirecting to the login page
			new Login_page().setVisible(true);
		}
	}	
}