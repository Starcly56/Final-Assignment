import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Edit_Question extends JFrame implements ActionListener {
	JLabel label_Subject_Code,label_Question,label_Answer1,label_Answer2,label_Answer3,label_Answer4;
	JTextField text_Subject_Code,text_Question,text_Answer1,text_Answer2,text_Answer3,text_Answer4;
	JButton Edit_Question_Answer, Reset;
	public Edit_Question() {
		setTitle(" Editing Question");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100,600, 400);
		setLayout(null);
		//for Subject Code
				label_Subject_Code= new JLabel("Subject Code"); 
				label_Subject_Code.setBounds(15,35,150,20);
				text_Subject_Code=new JTextField();
				text_Subject_Code.setBounds(150, 35, 150, 20);
				 add(label_Subject_Code);
				 add(text_Subject_Code);
				//for Question
				 label_Question= new JLabel("Question"); 
				 label_Question.setBounds(15,60,150,20);
				 text_Question=new JTextField();
				 text_Question.setBounds(150, 60, 150, 20);
				 add(label_Question);
				 add(text_Question);
				 //for Answer1
				 label_Answer1 = new JLabel("Correct Answer");
				 label_Answer1.setBounds(15,85,150,20);
				 text_Answer1 = new JTextField();
				 text_Answer1.setBounds(150,85,150,20);
				 add(label_Answer1);
				 add(text_Answer1);
				 //for Answer2
				 label_Answer2 = new JLabel("Second Answer");
				 label_Answer2.setBounds(15,110,150,20);
				 text_Answer2 = new JTextField();
				 text_Answer2.setBounds(150,110,150,20);
				 add(label_Answer2);
				 add(text_Answer2);
				 //for Answer3
				 label_Answer3 = new JLabel("Third Answer");
				 label_Answer3.setBounds(15,135,150,20);
				 text_Answer3 = new JTextField();
				 text_Answer3.setBounds(150,135,150,20);
				 add(label_Answer3);
				 add(text_Answer3);
				 //for Answer4
				 label_Answer4 = new JLabel("Fourth Answer");
				 label_Answer4.setBounds(15,160,150,20);
				 text_Answer4 = new JTextField();
				 text_Answer4.setBounds(150,160,150,20);
				 add(label_Answer4);
				 add(text_Answer4);
				 //for buttons
				 Edit_Question_Answer = new JButton("Update");
				 Edit_Question_Answer.setBounds(50,185,100,20);
				 Reset = new JButton("Reset");
				 Reset.setBounds(180,185,100,20);
				 add(Edit_Question_Answer);
				 add(Reset);
				 Edit_Question_Answer.addActionListener(this);
				 Reset.addActionListener(this);
	}
	public static void main(String[] args) {
		new Edit_Question().setVisible(true);
	}
	public void update() {
		String subject = text_Subject_Code.getText();
		String question=text_Question.getText();
		String answer1=text_Answer1.getText();
		String answer2=text_Answer2.getText();
		String answer3=text_Answer3.getText();
		String answer4=text_Answer4.getText();
		try{  
			Class.forName("com.mysql.jdbc.Driver"); 
			String SQL_UPDATE = "update question_answer set Subject_ID=?,set Question=?,set Answer1=?,set Answer2=?,set Answer3=?,set Answer4=?) values where Question_ID=?)";
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/dbstudentmcq","root","");  
			//here sonoo is database name, root is username and password  
			PreparedStatement prep = con.prepareStatement(SQL_UPDATE);
			prep.setString(1, subject);
			prep.setString(2, question);
			prep.setString(3, answer1);
			prep.setString(4, answer2);
			prep.setString(5, answer3);
			prep.setString(6, answer4);
			int rs = prep.executeUpdate();
			if(rs==1) {
				JOptionPane.showMessageDialog(null, "Question Edited");
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null,"e.printStackTrace()");
		}	 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Edit_Question_Answer)) {
			try {
				update();
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, " Sys Error");
			}
			dispose();
	}
	if(e.getSource().equals(Reset)) {
		text_Subject_Code.setText(null);
		text_Question.setText(null);
		text_Answer1.setText(null);
		text_Answer2.setText(null);
		text_Answer3.setText(null);
		text_Answer4.setText(null);
	}
		
	}
}
