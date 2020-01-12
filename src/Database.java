import java.sql.*;

public class Database {

	public static void main(String[] args) {
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq","root","");
//		 Statement st = con.createStatement();
//		 ResultSet rs=st.executeQuery("Select * from emp");
//		 while(rs.next())
//		System.out.println(rs.getInt(1)+" "+rs.getString(""));
//		 }catch(Exception e) {
//			 System.out.println(e);
//			 
//		 }
		try {
			//1. Get a connection to database
			Connection myconnection=DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq","root","");
			Statement myStatement = myconnection.createStatement();
			ResultSet myresult=myStatement.executeQuery("select * from student");
			while (myresult.next()) {
				System.out.println(myresult.getString("last_name")+","+myresult.getString("first_name"));
			}
		}catch(Exception e) {
			
		}
	}

}
