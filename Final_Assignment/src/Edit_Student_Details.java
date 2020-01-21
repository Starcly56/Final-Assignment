import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Edit_Student_Details extends JFrame  {
	JTextField text_ID,text_studentname,text_email,text_address,text_phonenumber,text_password;
	JComboBox batch_selection;
	JLabel labelupdate,label_ID,label_studentname,label_email,label_password,label_address,label_phonenumber,label_batch,label_Gender;
	JRadioButton male,female;
	JButton button_update,button_reset;
	Database_Connection dc= new Database_Connection();
	public Edit_Student_Details() {
		setTitle("Edit Your Details");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100,600, 400);
		getContentPane().setBackground(Color.gray);
		setLayout(null);
		//for headline
		labelupdate=new JLabel("Edit your Details");
		labelupdate.setFont(new Font("Arial",Font.ITALIC,20));
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
		 button_update = new JButton("Update");
		 button_update.setBounds(150,260,100,20);
		 button_update.setForeground(Color.white);
		 button_update.setBackground(Color.cyan);
		 button_reset = new JButton("Reset");
		 button_reset.setBounds(300,260,100,20);
		 add(button_update);
		 add(button_reset);
		 button_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int id=0;
				String name = text_studentname.getText();
				String email = text_email.getText();
				String password=text_password.getText();
				String address = text_address.getText();
				String batch = batch_selection.getSelectedItem().toString();
				String phonenumber = text_phonenumber.getText();
				String gender="";
				if(male.isSelected()) {
					gender=male.getText().toString();
				}
				else if(female.isSelected()){
					gender=female.getText().toString();
				}
				try {
					int output=dc.updateStudentDetails(id,name, email, password, batch, phonenumber, address, gender);
					if(output>0) {
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
	}
	public static void main(String[] args) {
		new Edit_Student_Details().setVisible(true);
	}

}
