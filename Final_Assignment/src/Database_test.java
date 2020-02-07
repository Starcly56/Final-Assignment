import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class Database_test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void insertStudentTest() {
		
		Database_Connection database_connection = new Database_Connection();
		String name="asda";
		String email="asd@gmail.com";
		String password="asdfgh";
		String batch ="";
		String phoneNumber="1234567890";
		String address="asdfre";
		String gender="m";
		String token="qwesrf";
		
		int expected_Result=0;
		int Actual_Result=database_connection.insertStudentDetails(name, email, password, batch, phoneNumber, address, gender, token);
		assertEquals(expected_Result, Actual_Result);
	}
	@Test
	public void insertQuestionTest() {
		Database_Connection database_connection = new Database_Connection();
		String subject_id="";
		String question="asd@gmail.com";
		String answer1="asdfgh";
		String answer2="1234567890";
		String answer3="asdfre";
		String answer4="m";
		
		int expected_Result=0;
		int Actual_Result=database_connection.insertQuestions(subject_id, question, answer1, answer2, answer3, answer4);
		assertEquals(expected_Result, Actual_Result);
	}
	@Test
	public void insertResultTest() {
		Database_Connection database_connection = new Database_Connection();
		int  Student_ID=0;
		String Student_Email="abc@gmail.com";
		int  Subject=0;
		int  Marks_Obtained=0;
		int expected_Result=0;
		int Actual_Result=database_connection.insertResult(Student_ID, Student_Email, Subject, Marks_Obtained);
		assertEquals(expected_Result, Actual_Result);
	}

}
