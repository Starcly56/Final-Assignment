import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.Border;

public class Create_Question extends JFrame implements ActionListener{
	JMenuBar menubar;
	JMenu Back;
	JLabel create_question;
	JEditorPane Info;
	JLabel label_Subject_Code,label_Question,label_Answer1,label_Answer2,label_Answer3,label_Answer4;
	JTextField text_Answer1,text_Answer2,text_Answer3,text_Answer4;
	JTextArea text_Question;
	JComboBox Subject_Code;
	JButton Add_Question_Answer, Reset;
	public Create_Question() {
		setTitle(" Adding Question");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		getContentPane().setBackground(Color.GRAY);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Welcome_page.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setBounds(400,150,600,400);
		setLayout(null);
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		//for headline
		create_question=new JLabel("Creating questions");
		create_question.setFont(new Font("Arial",Font.BOLD,20));
		create_question.setBounds(200, 0, 200, 25);
		create_question.setForeground(Color.black);
		add(create_question);
		//for info
		Info=new JEditorPane();
		Info.setContentType("text");
		Info.setBounds(380, 35, 190, 85);
		Info.setText("Subject Code\n201-Communication Skills\n210-Data Structures & Algorithms\n205-Modern Web\n290-Technology Ethics");
		Info.setEditable(false);
		Info.setBackground(Color.decode("#ffa500"));
		add(Info);
		//for Subject Code
		label_Subject_Code= new JLabel("Subject Code"); 
		label_Subject_Code.setBounds(15,35,150,20);
		Subject_Code=new JComboBox();
		Subject_Code.addItem("201");
		Subject_Code.addItem("210");
		Subject_Code.addItem("205");
		Subject_Code.addItem("290");
		Subject_Code.setBounds(150, 35, 150, 20);
		Subject_Code.setBorder(null);
		 add(label_Subject_Code);
		 add(Subject_Code);
		//for Question
		 label_Question= new JLabel("Question"); 
		 label_Question.setBounds(15,60,150,20);
		 text_Question=new JTextArea();
		 text_Question.setBounds(150, 60, 200, 50);
		 text_Question.setBorder(null);
		 add(label_Question);
		 add(text_Question);
		 //for Answer1
		 label_Answer1 = new JLabel("First Answer");
		 label_Answer1.setBounds(15,120,150,20);
		 text_Answer1 = new JTextField();
		 text_Answer1.setBounds(150,120,150,20);
		 text_Answer1.setBorder(null);
		 add(label_Answer1);
		 add(text_Answer1);
		 //for Answer2
		 label_Answer2 = new JLabel("Second Answer");
		 label_Answer2.setBounds(15,150,150,20);
		 text_Answer2 = new JTextField();
		 text_Answer2.setBounds(150,150,150,20);
		 text_Answer2.setBorder(null);
		 add(label_Answer2);
		 add(text_Answer2);
		 //for Answer3
		 label_Answer3 = new JLabel("Third Answer");
		 label_Answer3.setBounds(15,180,150,20);
		 text_Answer3 = new JTextField();
		 text_Answer3.setBounds(150,180,150,20);
		 text_Answer3.setBorder(null);
		 add(label_Answer3);
		 add(text_Answer3);
		 //for Answer4
		 label_Answer4 = new JLabel("Fourth Answer");
		 label_Answer4.setBounds(15,210,150,20);
		 text_Answer4 = new JTextField();
		 text_Answer4.setBounds(150,210,150,20);
		 text_Answer4.setBorder(null);
		 add(label_Answer4);
		 add(text_Answer4);
		 //for buttons
		 Add_Question_Answer = new JButton("Add");
		 Add_Question_Answer.setBounds(15,270,100,30);
		 Add_Question_Answer.setBackground(Color.decode("#D4AF37"));
		 Reset = new JButton("Reset");
		 Reset.setBounds(150,270,100,30);
		 Reset.setForeground(Color.white);
		 Reset.setBackground(Color.black);
		 add(Add_Question_Answer);
		 add(Reset);
		 Add_Question_Answer.addActionListener(this);
		 Reset.addActionListener(this);
		 Back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Admin_Dashboard().setVisible(true);;
				}
			});
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
		String subject_id = Subject_Code.getSelectedItem().toString();
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
						new Admin_Dashboard().setVisible(true);
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
			text_Question.setText(null);
			text_Answer1.setText(null);
			text_Answer2.setText(null);
			text_Answer3.setText(null);
			text_Answer4.setText(null);
		}
	}
}