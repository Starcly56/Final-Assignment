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
	ArrayList<Integer> qrr = new ArrayList<Integer>();
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
			JOptionPane.showMessageDialog(null, ex);
		}
		return output;
	}
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
	public ResultSet studentLogin(String username,String token) {
		try {
			prpdstmt=connection.prepareStatement("select ID,Email,Token from student where Email=? and Token=?");
			prpdstmt.setString(1, username);
			prpdstmt.setString(2, token);
			rs=prpdstmt.executeQuery();
			
			
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
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
	public ResultSet editQuestion() {
		try {
			prpdstmt=connection.prepareStatement("select Question_ID,Subject_ID,Question,Answer1,Answer2,Answer3,Answer4 "
					+ "from question_answer where Question_ID=?");
			prpdstmt.setInt(1, Login_page.USER_ID);
			rs=prpdstmt.executeQuery();
		
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
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
//	public ResultSet fetchQuestionfor210() {
//		try {
//			prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=210");
//			rs=prpdstmt.executeQuery();
//
//		}
//		catch(Exception ex) {
//			JOptionPane.showMessageDialog(null,ex);
//		}
//		return rs;
//	}
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
	
//	public ResultSet getRandomQuestionAnswer() {
//		ResultSet rss=null;
//		try {
//			PreparedStatement pss =connection.prepareStatement("SELECT `Question_ID` FROM `question_answer` WHERE Subject_ID=201");
//			 rss = pss.executeQuery();
//			if(rss.next()) {
//
//				JOptionPane.showMessageDialog(null,rss.getInt("Question_ID"));
//			}
//			return rss;
////			PreparedStatement prpdstmt2=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=201 and Question_ID=?");
////			 rs=prpdstmt.executeQuery();
////			ArrayList<Integer> qrr = new ArrayList<Integer>();
////			qrr.add(rs.getInt("Question_ID"));
////			Collections.shuffle(qrr);
////			JOptionPane.showMessageDialog(null, qrr.get(0));
////			rs=prpdstmt2.executeQuery();
//		}
//		catch(Exception ex) {
//			JOptionPane.showMessageDialog(null,ex);
//		}
//		return rss;
//	}
	
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
	public static void main(String []args) {
		new Welcome_page().setVisible(true);
//		ResultSet rs=prpdstmt.executeQuery("select * from student");  
//		while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+" "+rs.getString(7));   
	}
}



//try {
//	PreparedStatement ps=connection.prepareStatement("SELECT `Question_ID` FROM `question_answer` WHERE Subject_ID=201");
//	PreparedStatement pss=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=201 and Question_ID=?");
//	ResultSet rss = ps.executeQuery();
//	while(rss.next()) {
//		
//		qrr.add(rss.getInt("Question_ID"));
//		Collections.shuffle(qrr);
//		pss.setInt(1,rss.getInt("Question_ID"));
//		rs=pss.executeQuery();
//		System.out.println();
////		JOptionPane.showMessageDialog(null, qrr.get(0));		
//		
//	}
//	return rs;
////	ArrayList<Integer> qrr = new ArrayList<Integer>();
////	qrr.add(rs.getInt("Question_ID"));
////	Collections.shuffle(qrr);
////	JOptionPane.showMessageDialog(null, qrr.get(0));
////	rs=prpdstmt2.executeQuery();
//	
//	
//	
////	prpdstmt=connection.prepareStatement("SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer` WHERE Subject_ID=201");
////	rs=prpdstmt.executeQuery();
//}
//catch(Exception ex) {
//	JOptionPane.showMessageDialog(null,ex);
//}
//return rs;