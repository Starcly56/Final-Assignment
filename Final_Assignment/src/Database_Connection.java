import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javax.swing.JOptionPane;

public class Database_Connection {
	public Connection connection;
	PreparedStatement prpdstmt;
	ResultSet rs;
	//Initialization of the database connection
	public Database_Connection() {
		try
			{  
				Class.forName("com.mysql.jdbc.Driver");  
				String url="jdbc:mysql://localhost:3306/dbstudentmcq";
				String username="root";
				String password="";
				connection=DriverManager.getConnection(url,username,password);  
			}
		catch(Exception e)
			{
				System.out.println(e);
			}  
		}
	//Sign Up for the Student
	public int insertStudentDetails(String name,String email,String password,String batch,String phoneNumber,String address,String gender,String token) {
		int output=0;
		try {
			prpdstmt=connection.prepareStatement("insert into student"
		+"(student_name,batch,Gender,Email,Password,Address,Mobile,Token) values (?,?,?,?,?,?,?,?)");
			prpdstmt.setString(1, name);
			prpdstmt.setString(2, email);
			prpdstmt.setString(3, password);
			prpdstmt.setString(4, batch);
			prpdstmt.setString(5, phoneNumber);
			prpdstmt.setString(6, address);
			prpdstmt.setString(7, gender);
			prpdstmt.setString(8, token);
			output=prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Email is already taken.");
		}
		return output;
	}
	//Updating the details of the student
	public boolean updateStudentDetails(int ID,String name,String email,String password,String batch,String phoneNumber,String address) {
		try {
			prpdstmt=connection.prepareStatement("update student set student_name=?, "
					+"batch=? ,Email=? ,Password=? ,Address=? ,Mobile=? where ID=?");
			prpdstmt.setString(1, name);
			prpdstmt.setString(2, batch);
			prpdstmt.setString(3, email);
			prpdstmt.setString(4, password);
			prpdstmt.setString(5, address);
			prpdstmt.setString(6, phoneNumber);
			prpdstmt.setInt(7,ID);
			prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return false;
		}
		return true;
	}
	//Deleting a student
	public boolean deleteStudent(int ID) {
		try {
			prpdstmt=connection.prepareStatement("delete from student where ID=?");
			prpdstmt.setInt(1, Login_page.USER_ID);
			prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return false;
		}
		return true;
	}
	//Fetching individual Student data for updating 
	public ResultSet studentTable() {
		try {
			prpdstmt=connection.prepareStatement("select ID,student_name,batch,Gender,Email,Password,Address,Mobile "
					+ "from student where ID=?");
			prpdstmt.setInt(1, Login_page.USER_ID);
			rs=prpdstmt.executeQuery();
		
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Fetching Student data for in admin dashboard 
	public ResultSet registeredStudent() {
		try {
			prpdstmt=connection.prepareStatement("select student_name,batch,Email,Address,Mobile "
					+ "from student");
			rs=prpdstmt.executeQuery();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Login of the Student
	public ResultSet studentLogin(String username,String password) {
		try {
			prpdstmt=connection.prepareStatement("select ID,Email,Password,Token from student where Email=? and Password=?");
			prpdstmt.setString(1, username);
			prpdstmt.setString(2, password);
			rs=prpdstmt.executeQuery();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Generation of the token
	public String generateToken() {
		String TokenSet;
		String token;
		TokenSet="asdfghjklqwertyuiopzxcvbnm1234567890";
		token="";
		
		for (int counter=0;counter<=6;counter++) {
			token += TokenSet.charAt(new Random().nextInt(TokenSet.length()));
		}
		return token;
	}
	//Generation of the token for student to attend the exam
	public ResultSet token() {
		try {
			prpdstmt=connection.prepareStatement("select ID,Token from student where Token=?");
			prpdstmt.setInt(1, Login_page.USER_ID);
			rs=prpdstmt.executeQuery();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Creating questions
	public int insertQuestions(String subject_id,String question,String answer1,String answer2,String answer3,String answer4) {
		int output=0;
		try {
			prpdstmt=connection.prepareStatement("insert into question_answer"
		+"(Subject_ID,Question,Answer1,Answer2,Answer3,Answer4) values (?,?,?,?,?,?)");
			prpdstmt.setString(1, subject_id);
			prpdstmt.setString(2, question);
			prpdstmt.setString(3, answer1);
			prpdstmt.setString(4, answer2);
			prpdstmt.setString(5, answer3);
			prpdstmt.setString(6, answer4);
            output=prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return output;
	}
	//Fetching all the questions
	public ResultSet fetchQuestion() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` ");
			rs=prpdstmt.executeQuery();
		
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Deleting the question
	public boolean deleteQuestion(int ID) {
		try {
			prpdstmt=connection.prepareStatement("delete from question_answer where Question_ID=?");
			prpdstmt.setInt(1, ID);
			prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
			return false;
		}
		return true;
	}
	//Fetching questions for STW201CS
	public ResultSet fetchQuestionfor201() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=201");
			rs=prpdstmt.executeQuery();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Fetching questions for STW210CT
	public ResultSet fetchQuestionfor210() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=210");
			rs=prpdstmt.executeQuery();

		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Fetching questions for STW205CDE
	public ResultSet fetchQuestionfor205() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=205");
			rs=prpdstmt.executeQuery();

		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Fetching questions for STW290COM
	public ResultSet fetchQuestionfor290() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=290");
			rs=prpdstmt.executeQuery();
		
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Saving the result of the examination of the particular student
	public int insertResult(int Student_ID,String Student_Email,int Subject,int Marks_Obtained) {
		int output=0;
		try {
			prpdstmt=connection.prepareStatement("insert into Result"
		+"(`Student_ID`, `Student_Email`, `Subject`, `Marks_Obtained`) values (?,?,?,?)");
			prpdstmt.setInt(1, Student_ID);
			prpdstmt.setString(2, Student_Email);
			prpdstmt.setInt(3, Subject);
			prpdstmt.setInt(4, Marks_Obtained);
            output=prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return output;
	}
	//Viewing the result in the Student Dashboard
	public ResultSet fetchResult() {
		try {
			prpdstmt=connection.prepareStatement("SELECT `Subject`, `Marks_Obtained` FROM `result` WHERE Student_ID=?");
			prpdstmt.setInt(1, Login_page.USER_ID);
			rs=prpdstmt.executeQuery();
		
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	//Viewing the result in the Student Dashboard
		public ResultSet viewResult() {
			try {
				prpdstmt=connection.prepareStatement("SELECT `Student_ID`, `Student_Email`, `Subject`, `Marks_Obtained` FROM `result`");
				rs=prpdstmt.executeQuery();
			
			}
			catch(Exception ex) {
				JOptionPane.showMessageDialog(null,ex);
			}
			return rs;
		}
	//calling Welcome page 
	public static void main(String []args) {
		new Welcome_page().setVisible(true);
	}
}