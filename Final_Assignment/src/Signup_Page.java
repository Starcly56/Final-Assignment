import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ButtonGroup;
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
	JTextField text_studentname,text_email,text_address,text_phonenumber,text_token;
	JPasswordField text_password;
	JComboBox batch_selection;
	JLabel labelsignup,label_studentname,label_email,label_password,label_address,label_phonenumber,label_batch,label_Gender,label_token;
	JRadioButton male,female;
	JButton button_signup,button_back_login;
	Database_Connection dc= new Database_Connection();
	public Signup_Page() {
		setTitle("Student Sign Up");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100,600, 400);
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		//for headline
		labelsignup=new JLabel("Sign Up for Student");
		labelsignup.setFont(new Font("Arial",Font.ITALIC,20));
		labelsignup.setBounds(200, 0, 200, 20);
		add(labelsignup);
		//for student name
		 label_studentname= new JLabel("Name of Student"); 
		 label_studentname.setBounds(150,50,150,20);
		 text_studentname=new JTextField();
		 text_studentname.setBounds(250, 50, 150, 20);
		 add(label_studentname);
		 add(text_studentname);
		//for email
		 label_email= new JLabel("Email"); 
		 label_email.setBounds(150,80,150,20);
		 text_email=new JTextField();
		 text_email.setBounds(250, 80, 150, 20);
		 add(label_email);
		 add(text_email);
		//for password
		 label_password= new JLabel("Password"); 
		 label_password.setBounds(150,110,150,20);
		 text_password=new JPasswordField();
		 text_password.setBounds(250, 110, 150, 20);
		 add(label_password);
		 add(text_password);
		 //for Gender
		 label_Gender=new JLabel("Gender");
		 label_Gender.setBounds(150, 140, 150, 20);
		 male=new JRadioButton("Male",true);
		 female= new JRadioButton("Female");
		 male.setBounds(250, 140, 80, 20);
		 male.setBackground(null);
		 female.setBounds(330, 140, 80, 20);
		 female.setBackground(null);
		 ButtonGroup bg= new ButtonGroup();
		 bg.add(male);
		 bg.add(female);
		 add(label_Gender);
		 add(male);
		 add(female);
		 //for address
		 label_address = new JLabel("Address");
		 label_address.setBounds(150,170,150,20);
		 text_address = new JTextField();
		 text_address.setBounds(250,170,150,20);
		 add(label_address);
		 add(text_address);
		 //for phone number
		 label_phonenumber = new JLabel("Phone Number");
		 label_phonenumber.setBounds(150,200,150,20);
		 text_phonenumber = new JTextField();
		 text_phonenumber.setBounds(250,200,150,20);
		 add(label_phonenumber);
		 add(text_phonenumber);
		 //for batch
		 label_batch=new JLabel("Batch");
		 label_batch.setBounds(150, 230, 150, 20);
		 batch_selection = new JComboBox();
		 batch_selection.addItem("24 A");
		 batch_selection.addItem("24 B");
		 batch_selection.addItem("25 A");
		 batch_selection.addItem("25 B");
		 batch_selection.addItem("25 C");
		 batch_selection.addItem("25 D");
		 batch_selection.setBounds(250, 230, 150, 20);
		 add(label_batch);
		 add(batch_selection);
		 //for buttons
		 button_signup = new JButton("Sign Up");
		 button_signup.setBounds(150,260,100,20);
		 button_signup.setForeground(Color.white);
		 button_signup.setBackground(Color.cyan);
		 button_back_login = new JButton("Back to Login");
		 button_back_login.setBounds(280,260,120,20);
		 button_back_login.setForeground(Color.blue);
		 button_back_login.setBackground(Color.green);
		 add(button_signup);
		 add(button_back_login);
		 
		//for tokennumber
		 label_token = new JLabel("Token");
		 label_token.setBounds(150,290,150,20);
		 text_token = new JTextField();
		 text_token.setBounds(250,290,150,20);
		 text_token.setEditable(false);
		 label_token.setVisible(false);
		 text_token.setVisible(false);
		 text_token.setText(dc.generateToken());
		 add(label_token);
		 add(text_token);
		 button_signup.addActionListener(this);
		 button_back_login.addActionListener(this);
	}
	public static void main(String[] args) {
		new Signup_Page().setVisible(true);
	}
//	public void insert() {
//		String name=text_studentname.getText();
//		String email=text_email.getText();
//		String address=text_address.getText();
//		String batch=batch_selection.getSelectedItem().toString();
//		String gender="";
//		if(male.isSelected()) {
//			gender=male.getText().toString();
//		}
//		else if(female.isSelected()){
//			gender=female.getText().toString();
//		}
//		String phonenumber=text_phonenumber.getText();
//		try{  
//			Class.forName("com.mysql.jdbc.Driver"); 
//			String SQL_INSERT = "insert into student (student_name,batch,Gender,Email,Address,Mobile) values (?,?,?,?,?,?)";
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq","root","");  
//			//here sonoo is database name, root is username and password  
//			PreparedStatement prep = con.prepareStatement(SQL_INSERT);
//			prep.setString(1, name);
//			prep.setString(2, batch);
//			prep.setString(3, gender);
//			prep.setString(4, email);
//			prep.setString(5, address);
//			prep.setString(6, phonenumber);
//			int rs = prep.executeUpdate();
//			if(rs==1) {
//				JOptionPane.showMessageDialog(null, "Account Created");
//			}else {
//				JOptionPane.showMessageDialog(null, "Failed");
//			}
//		}catch(Exception e) {
//			JOptionPane.showMessageDialog(null,"Fill all the data");
//		}	 
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name = text_studentname.getText();
		String email = text_email.getText();
		String password=text_password.getText();
		String address = text_address.getText();
		String batch = batch_selection.getSelectedItem().toString();
		String phonenumber = text_phonenumber.getText();
		String token=text_token.getText();
		String gender="";
		if(male.isSelected()) {
			gender=male.getText().toString();
		}
		else if(female.isSelected()){
			gender=female.getText().toString();
		}
		if(e.getSource().equals(button_signup)) {
			if(name.isEmpty()||email.isEmpty()||password.isEmpty()||address.isEmpty()||batch.isEmpty()||phonenumber.isEmpty()||gender.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please fill all the fields.");
			}
			else {
				try {
					
					int output=dc.insertStudentDetails(name, batch,gender, email,password, address,phonenumber,token);
					if(output>0) {
						JOptionPane.showMessageDialog(null, "You are logged in as"+email);
						label_token.setVisible(true);
						text_token.setVisible(true);
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
			new Login_page().setVisible(true);
		}
	}	
}