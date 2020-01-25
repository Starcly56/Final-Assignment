import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;

import javax.imageio.ImageIO;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Manage_Student_Details extends JFrame  {
	JTextField text_ID,text_studentname,text_email,text_address,text_phonenumber,text_password;
	JComboBox batch_selection;
	JLabel labelupdate,label_ID,label_studentname,label_email,label_password,label_address,label_phonenumber,label_batch;
	JButton button_update,button_delete;
	Database_Connection dc= new Database_Connection();
	public Manage_Student_Details() {
		setTitle("Your Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
//		getContentPane().setBackground(Color.gray);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Edit_Student.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setResizable(false);
		setLayout(null);
		//for headline
		labelupdate=new JLabel("Manage Your Account");
		labelupdate.setFont(new Font("Arial",Font.BOLD,15));
		labelupdate.setBounds(200, 0, 200, 20);
		add(labelupdate);
		//for ID
		label_ID= new JLabel("Your ID"); 
		label_ID.setBounds(150,20,150,20);
		text_ID=new JTextField();
		text_ID.setBounds(250, 20, 150, 20);
		 add(label_ID);
		 add(text_ID);
		//for student name
		 label_studentname= new JLabel("Your Name"); 
		 label_studentname.setBounds(150,50,150,20);
		 text_studentname=new JTextField();
		 text_studentname.setBounds(250, 50, 150, 20);
		 add(label_studentname);
		 add(text_studentname);
		//for email
		 label_email= new JLabel("Your Email"); 
		 label_email.setBounds(150,80,150,20);
		 text_email=new JTextField();
		 text_email.setBounds(250, 80, 150, 20);
		 add(label_email);
		 add(text_email);
		//for password
		 label_password= new JLabel("Your Password"); 
		 label_password.setBounds(150,110,150,20);
		 text_password=new JTextField();
		 text_password.setBounds(250, 110, 150, 20);
		 add(label_password);
		 add(text_password);
		 //for address
		 label_address = new JLabel("Address");
		 label_address.setBounds(150,140,150,20);
		 text_address = new JTextField();
		 text_address.setBounds(250,140,150,20);
		 add(label_address);
		 add(text_address);
		 //for phone number
		 label_phonenumber = new JLabel("Phone Number");
		 label_phonenumber.setBounds(150,170,150,20);
		 text_phonenumber = new JTextField();
		 text_phonenumber.setBounds(250,170,150,20);
		 add(label_phonenumber);
		 add(text_phonenumber);
		 //for batch
		 label_batch=new JLabel("Batch");
		 label_batch.setBounds(150, 200, 150, 20);
		 batch_selection = new JComboBox();
		 batch_selection.addItem("24 A");
		 batch_selection.addItem("24 B");
		 batch_selection.addItem("25 A");
		 batch_selection.addItem("25 B");
		 batch_selection.addItem("25 C");
		 batch_selection.addItem("25 D");
		 batch_selection.setBounds(250, 200, 150, 20);
		 add(label_batch);
		 add(batch_selection);
		 //for buttons
		 button_update = new JButton("Update Details");
		 button_update.setBounds(150,230,130,20);
		 button_update.setForeground(Color.white);
		 button_update.setBackground(Color.cyan);
		 button_delete = new JButton("Delete Account");
		 button_delete.setBounds(300,230,130,20);
		 button_delete.setBackground(Color.red);
		 add(button_update);
		 add(button_delete);
		 loadStudentProfile();
		 button_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = text_studentname.getText();
				String email = text_email.getText();
				String password=text_password.getText();
				String address = text_address.getText();
				String batch = batch_selection.getSelectedItem().toString();
				String phonenumber = text_phonenumber.getText();
				try {
					boolean status=dc.updateStudentDetails(Login_page.USER_ID,name, email, password, batch, phonenumber, address );
					if(status) {
						JOptionPane.showMessageDialog(null, "Your details is updated.");
						new Select_Questions().setVisible(true);
					}
					else { 
						JOptionPane.showMessageDialog(null, "Cannot be updated");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, " Sys Error");
				}
			}
		});
		 button_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					boolean status=dc.deleteStudent(Login_page.USER_ID);
					if(status) {
						JOptionPane.showMessageDialog(null, "Your account is deleted");
						new Welcome_page().setVisible(true);
					}
					else { 
						JOptionPane.showMessageDialog(null, "Cannot be deleted");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, " Sys Error");
				}
			}
		});
	}
	private void loadStudentProfile() {
		try {
			Database_Connection dc= new Database_Connection();
			ResultSet rs=dc.studentTable();
			if(rs.next()) {
				text_ID.setText(rs.getString("ID"));
				text_studentname.setText(rs.getString("student_name"));
				text_email.setText(rs.getString("Email"));
				text_phonenumber.setText(rs.getString("Mobile"));
				text_password.setText(rs.getString("Password"));
				batch_selection.setSelectedItem(rs.getString("batch"));
				text_address.setText(rs.getString("Address"));
			}
			else {
				JOptionPane.showMessageDialog(null, "Wrong Credentials");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR ");
			
		}
	}


}
