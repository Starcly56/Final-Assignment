import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
public class Login_page extends JFrame implements ActionListener {
	JTextField text_username;
	JPasswordField text_password;
	JLabel label_username,label_password,label_login;
	JButton button_login,button_cancel,button_createaccount;
	public static int USER_ID=0;
	public static  String USER_EMAIL="";
	public static  String USER_TOKEN="";

	Database_Connection dc= new Database_Connection();
	ResultSet output;
	public  Login_page() { 
		setTitle("Student Login");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.decode("#1e90ff"));
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Login_Image.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setBounds(400,150,600,400);
//		Container container=getContentPane();
		setLayout(null);
		//for title
		label_login=new JLabel("Welcome to Login Page");
		label_login.setFont(new Font("Arial",Font.BOLD,20));
		label_login.setForeground(Color.black);
		label_login.setBounds(170,5,350,25);
		 add(label_login);
		//for username
		 label_username= new JLabel("Username:"); 
		 label_username.setFont(new Font("Arial",Font.BOLD,15));
		 label_username.setBounds(170,50,150,20);
		 label_username.setForeground(Color.black);
		 text_username=new JTextField();
//		 text_username.setBackground(Color.black);
//		 text_username.setForeground(Color.white);
		 text_username.setFont(new Font("Arial",Font.BOLD,15));
		 Border border = BorderFactory.createLineBorder(Color.white, 1);
	        // set the border of this component
		 text_username.setBorder(border);
		 text_username.setBounds(170, 80, 200, 20);
		 add(label_username);
		 add(text_username);
		 //for password
		 label_password = new JLabel("Password:");
		 label_password.setFont(new Font("Arial",Font.BOLD,15));
		 label_password.setBounds(170,110,150,20);
		 label_password.setForeground(Color.black);
		 text_password = new JPasswordField();
//		 text_password.setBackground(Color.black);
//		 text_password.setForeground(Color.white);
		 text_password.setFont(new Font("Arial",Font.BOLD,15));
//		 Border border = BorderFactory.createLineBorder(Color.white, 1);

		 text_password.setBorder(border);
		 text_password.setBounds(170,140,200,20);
		 add(label_password);
		 add(text_password);
		 //for label create account
		 button_createaccount=new JButton("Don't have an account!! Click to create");
		 button_createaccount.setBorderPainted( false );
		 button_createaccount.setContentAreaFilled(false);
		 button_createaccount.setForeground(Color.black);

		 button_createaccount.setBounds(150,170,250,20);
		 add(button_createaccount);
		 //for button
		 button_login = new JButton("Login");
		 button_login.setBounds(170,200,80,25);
		 button_login.setBackground(Color.cyan);
		 button_cancel = new JButton("Cancel");
		 button_cancel.setBounds(270,200,80,25);
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
		String password=text_password.getText().toString();
		if(e.getSource().equals(button_cancel))
		{
			new Welcome_page().setVisible(true);
		}
		if(e.getSource().equals(button_createaccount))
		{
			new Signup_Page().setVisible(true);
		}
		if(e.getSource().equals(button_login)) {
			if(username.isEmpty()&&password.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Fields are empty");
			}
			else if(username.isEmpty()){
				JOptionPane.showMessageDialog(null, "Please input valid Email");
				}
			else if(password.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please input valid Token.");
				}
				
			
			else if(username.equals("admin@gmail.com")&&password.equals("admin123"))
			{
				JOptionPane.showMessageDialog(null, "Logged in as admin");
				new Admin_Dashboard().setVisible(true);
			}
			else
			{
				try {
					output=dc.studentLogin(username, password);
					if(output.next()) {
						USER_EMAIL = output.getString("Email");
						USER_ID = output.getInt("ID");
						USER_TOKEN=output.getString("Token");
						
						JOptionPane.showMessageDialog(null, "Logged in as "+USER_EMAIL);
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
