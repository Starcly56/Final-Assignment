import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class Create_Question extends JFrame implements ActionListener{
	JLabel create_question,info,info1,info2,info3,info4;
	JLabel label_Subject_Code,label_Question,label_Answer1,label_Answer2,label_Answer3,label_Answer4;
	JTextField text_Subject_Code,text_Answer1,text_Answer2,text_Answer3,text_Answer4;
	JTextField text_Question;
	JButton Add_Question_Answer, Reset;
	public Create_Question() {
		setTitle(" Adding Question");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.GRAY);
		setBounds(500,100,600, 400);
		setLayout(null);
		//for headline
		create_question=new JLabel("Creating questions");
		create_question.setFont(new Font("Arial",Font.ROMAN_BASELINE,20));
		create_question.setBounds(200, 0, 200, 25);
		create_question.setForeground(Color.blue);
		add(create_question);
		//for info
		info=new JLabel("Subject Code");
		info.setBounds(380, 35, 200, 20);
		add(info);
		info1=new JLabel("201=Communication Skills");
		info1.setBounds(380, 55, 200, 20);
		add(info1);
		info2=new JLabel("210=Data Structures & Algorithms");
		info2.setBounds(380, 75, 200, 20);
		add(info2);
		info3=new JLabel("205=Modern Web");
		info3.setBounds(380, 95, 200, 20);
		add(info3);
		info4=new JLabel("290=Technology Ethics");
		info4.setBounds(380, 115, 200, 20);
		add(info4);
		//for Subject Code
		label_Subject_Code= new JLabel("Subject Code"); 
		label_Subject_Code.setBounds(15,35,150,20);
		text_Subject_Code=new JTextField();
//		text_Subject_Code.addFocusListener(new FocusListener() {
//			
//			@Override
//			public void focusLost(FocusEvent e) {
//				if(text_Subject_Code.getText().isEmpty()) {
//					text_Subject_Code.setText("Enter Subject Code");
//				}
//			}
//			@Override
//			public void focusGained(FocusEvent e) {
//				if(text_Subject_Code.getText().equals("Enter Subject Code")) {
//					text_Subject_Code.setText("");
//				}
//			}
//		});
		text_Subject_Code.setBounds(150, 35, 150, 20);
		text_Subject_Code.setBorder(null);
		 add(label_Subject_Code);
		 add(text_Subject_Code);
		//for Question
		 label_Question= new JLabel("Question"); 
		 label_Question.setBounds(15,60,150,20);
		 text_Question=new JTextField();
		 text_Question.setBounds(150, 60, 150, 20);
		 text_Question.setBorder(null);
		 add(label_Question);
		 add(text_Question);
		 //for Answer1
		 label_Answer1 = new JLabel("Correct Answer");
		 label_Answer1.setBounds(15,85,150,20);
		 text_Answer1 = new JTextField();
		 text_Answer1.setBounds(150,85,150,20);
		 text_Answer1.setBorder(null);
		 add(label_Answer1);
		 add(text_Answer1);
		 //for Answer2
		 label_Answer2 = new JLabel("Second Answer");
		 label_Answer2.setBounds(15,110,150,20);
		 text_Answer2 = new JTextField();
		 text_Answer2.setBounds(150,110,150,20);
		 text_Answer2.setBorder(null);
		 add(label_Answer2);
		 add(text_Answer2);
		 //for Answer3
		 label_Answer3 = new JLabel("Third Answer");
		 label_Answer3.setBounds(15,135,150,20);
		 text_Answer3 = new JTextField();
		 text_Answer3.setBounds(150,135,150,20);
		 text_Answer3.setBorder(null);
		 add(label_Answer3);
		 add(text_Answer3);
		 //for Answer4
		 label_Answer4 = new JLabel("Fourth Answer");
		 label_Answer4.setBounds(15,160,150,20);
		 text_Answer4 = new JTextField();
		 text_Answer4.setBounds(150,160,150,20);
		 text_Answer4.setBorder(null);
		 add(label_Answer4);
		 add(text_Answer4);
		 //for buttons
		 Add_Question_Answer = new JButton("Add");
		 Add_Question_Answer.setBounds(15,185,100,20);
		 Reset = new JButton("Reset");
		 Reset.setBounds(150,185,100,20);
		 add(Add_Question_Answer);
		 add(Reset);
		 Add_Question_Answer.addActionListener(this);
		 Reset.addActionListener(this);
	}

	public static void main(String[] args) {
		new Create_Question().setVisible(true);
	}
//	public void insert() {
//		String subject = text_Subject_Code.getText();
//		String question=text_Question.getText();
//		String answer1=text_Answer1.getText();
//		String answer2=text_Answer2.getText();
//		String answer3=text_Answer3.getText();
//		String answer4=text_Answer4.getText();
//		try{  
//			Class.forName("com.mysql.jdbc.Driver"); 
//			String SQL_INSERT = "insert into question_answer (Subject_ID,Question,Answer1,Answer2,Answer3,Answer4) values (?,?,?,?,?,?)";
//			Connection con=DriverManager.getConnection(  
//			"jdbc:mysql://localhost:3306/dbstudentmcq","root","");  
//			//here dbstudentmcq is database name, root is username and password  
//			PreparedStatement prep = con.prepareStatement(SQL_INSERT);
//			prep.setString(1, subject);
//			prep.setString(2, question);
//			prep.setString(3, answer1);
//			prep.setString(4, answer2);
//			prep.setString(5, answer3);
//			prep.setString(6, answer4);
//			int rs = prep.executeUpdate();
//			if(rs==1) {
//				JOptionPane.showMessageDialog(null, "Question Created");
//			}else {
//				JOptionPane.showMessageDialog(null, "Failed");
//			}
//		}catch(Exception e) {
//			JOptionPane.showMessageDialog(null,"Please fill all the fields");
//		}	 
//	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String subject_id = text_Subject_Code.getText();
		String question = text_Question.getText();
		String answer1 = text_Answer1.getText();
		String answer2 = text_Answer2.getText();
		String answer3 = text_Answer3.getText();
		String answer4 = text_Answer4.getText();
		if(e.getSource().equals(Add_Question_Answer)) {
			if(subject_id.isEmpty()||question.isEmpty()||answer1.isEmpty()||answer2.isEmpty()||answer3.isEmpty()||answer4.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Please provide questions and answers.");
			}
			else {
				try 
				{
					Database_Connection dc= new Database_Connection();
					int output=dc.insertQuestions(subject_id, question, answer1, answer2, answer3, answer4);
					if(output>0) {
						JOptionPane.showMessageDialog(null, "Question is added Successfully");
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(null, "Question cannot be added");
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, " Sys Error");
				}
				
			}
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