import java.sql.*;
import java.util.Random;

import javax.swing.JOptionPane;

public class Database_Connection {
	public Connection connection;
	PreparedStatement prpdstmt;
	ResultSet rs;
	public Database_Connection() {
		try
			{  
				Class.forName("com.mysql.jdbc.Driver");  
				String url="jdbc:mysql://localhost:3306/dbstudentmcq";
				String username="root";
				String password="";
				connection=DriverManager.getConnection(url,username,password);  
//				connection.close();
				//here dbstudentmcq is database name, root is username and password 
//				ResultSet rs=stmt.executeQuery("select * from student");  
//				while(rs.next())  
//				System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+" "+rs.getString(7));   
			}
		catch(Exception e)
			{
				System.out.println(e);
			}  
		}
	public int insertStudentDetails(String name,String email,String password,String batch,String phoneNumber,String address,String gender,String token) {
		int output=0;
		try {
			prpdstmt=connection.prepareStatement("insert into student (student_name,batch,Gender,Email,Password,Address,Mobile,Token) values (?,?,?,?,?,?,?,?)");
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
	public int updateStudentDetails(int ID,String name,String email,String password,String batch,String phoneNumber,String address,String gender) {
		int output=0;
		try {
			prpdstmt=connection.prepareStatement("update student set student_name=?, batch=? ,Gender=? ,Email=? ,Password=? ,Address=? ,Mobile=? where ID=?");
			prpdstmt.setString(1, name);
			prpdstmt.setString(2, email);
			prpdstmt.setString(3, password);
			prpdstmt.setString(4, batch);
			prpdstmt.setString(5, phoneNumber);
			prpdstmt.setString(6, address);
			prpdstmt.setString(7, gender);
			prpdstmt.setInt(8,ID);
			output=prpdstmt.executeUpdate();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, ex);
		}
		return output;
	}
	public ResultSet studentTable(int id,String name,String email,String password,String batch,String phoneNumber,String address,String gender) {
		try {
			prpdstmt=connection.prepareStatement("select ID,student_name,batch,Gender,Email,Password,Address,Mobile from student where ID=? and student_name=? and batch=? and Gender=? and Email=? and Password=? and Address=? and Mobile=?");
			prpdstmt.setInt(1, id);
			prpdstmt.setString(2, name);
			prpdstmt.setString(3, email);
			prpdstmt.setString(4, password);
			prpdstmt.setString(5, batch);
			prpdstmt.setString(6, phoneNumber);
			prpdstmt.setString(7, address);
			prpdstmt.setString(8, gender);
			rs=prpdstmt.executeQuery();
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null,ex);
		}
		return rs;
	}
	public ResultSet studentLogin(String username,String token) {
		try {
			prpdstmt=connection.prepareStatement("select Email,Token from student where Email=? and Token=?");
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
			prpdstmt=connection.prepareStatement("insert into question_answer (Subject_ID,Question,Answer1,Answer2,Answer3,Answer4) values (?,?,?,?,?,?)");
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
//		ResultSet rs=prpdstmt.executeQuery("select * from student");  
//		while(rs.next())  
//		System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+" "+rs.getString(7));   
	}
}