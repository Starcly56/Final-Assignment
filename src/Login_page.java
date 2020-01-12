import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class Login_page extends JFrame implements ActionListener {
	JTextField text_username,text_password;
	JLabel label_username,label_password;
	JButton button_login,button_cancel,button_createaccount;
	JCheckBox check_password;
	JMenuBar menubar;
	JMenu File,Edit,Help;
	JMenuItem Cut,Copy,Paste;
	public static void main(String[] args) {
		//name specific no -->anonymous
//		new Adding_Two_Numbers().setVisible(true);
		new Login_page().setVisible(true);
	}
	public  Login_page() { 
		setTitle("Student Login");
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(500,100,600, 400);
//		Container container=getContentPane();
		setLayout(null);
		menubar = new JMenuBar();
		File= new JMenu("File");
		Edit= new JMenu("Edit");
		Help= new JMenu("Help");
		Cut= new JMenuItem("Cut");
		Copy= new JMenuItem("Copy");
		Paste= new JMenuItem("Paste");
		menubar.add(File);
		menubar.add(Edit);
		menubar.add(Help);
		Edit.add(Cut);
		Edit.add(Copy);
		Edit.add(Paste);
		add(menubar);
		setJMenuBar(menubar);
		//for username
		 label_username= new JLabel("Username"); 
		 label_username.setBounds(5,10,150,20);
		 text_username=new JTextField();
		 text_username.setBounds(100, 10, 150, 20);
		 add(label_username);
		 add(text_username);
		 //for password
		 label_password = new JLabel("Password");
		 label_password.setBounds(5,50,150,20);
		 text_password = new JTextField();
		 text_password.setBounds(100,50,150,20);
		 add(label_password);
		 add(text_password);
		 //for checkpassword
		 check_password=new JCheckBox("Remember password");
		 check_password.setBounds(5, 90, 150, 20);
		 add(check_password);
		 //for label create account
		 button_createaccount=new JButton("Create an account!!!!");
		 button_createaccount.setBackground(null);
		 button_createaccount.setBounds(160,90,150,20);
		 add(button_createaccount);
		 //for button
		 button_login = new JButton("Login");
		 button_login.setBounds(5,130,80,20);
		 button_cancel = new JButton("Cancel");
		 button_cancel.setBounds(100,130,100,20);
		 add(button_login);
		 add(button_cancel);
		 button_createaccount.addActionListener(this);
		 button_cancel.addActionListener(this);
		 button_login.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_cancel))
		{
			dispose();
		}
		if(e.getSource().equals(button_createaccount))
		{
			new Signup_Page().setVisible(true);
		}
		if(e.getSource().equals(button_login)) {
			new Select_Questions().setVisible(true);
		}
	}
}
