import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import com.sun.jdi.event.EventQueue;

public class Delete_Question extends JFrame {
	  static JTable table;
	  Database_Connection dc = new Database_Connection();
	public static void main(String[] args) {
           new Delete_Question().setVisible(true);
	}
	public Delete_Question() {
		setTitle(" Deleting Question");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(400,150,600,400);
		setLayout(new BorderLayout());
		displayTable();
//		table.setVisible(true);
//		 DefaultTableModel model = new DefaultTableModel();
//	        model.setColumnIdentifiers(columnNames);
//	        table = new JTable();
//	        table.setModel(model);
//	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
//	        table.setFillsViewportHeight(true);
//	        JScrollPane scroll = new JScrollPane(table);
//	        scroll.setHorizontalScrollBarPolicy(
//	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//	        scroll.setVerticalScrollBarPolicy(
//	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
//	        dc.editQuestion();
		//for Subject Code
//				label_Subject_Code= new JLabel("Subject Code"); 
//				label_Subject_Code.setBounds(15,35,150,20);
//				text_Subject_Code=new JTextField();
//				text_Subject_Code.setBounds(150, 35, 150, 20);
//				 add(label_Subject_Code);
//				 add(text_Subject_Code);
//				//for Question
//				 label_Question= new JLabel("Question"); 
//				 label_Question.setBounds(15,60,150,20);
//				 text_Question=new JTextField();
//				 text_Question.setBounds(150, 60, 150, 20);
//				 add(label_Question);
//				 add(text_Question);
//				 //for Answer1
//				 label_Answer1 = new JLabel("Correct Answer");
//				 label_Answer1.setBounds(15,85,150,20);
//				 text_Answer1 = new JTextField();
//				 text_Answer1.setBounds(150,85,150,20);
//				 add(label_Answer1);
//				 add(text_Answer1);
//				 //for Answer2
//				 label_Answer2 = new JLabel("Second Answer");
//				 label_Answer2.setBounds(15,110,150,20);
//				 text_Answer2 = new JTextField();
//				 text_Answer2.setBounds(150,110,150,20);
//				 add(label_Answer2);
//				 add(text_Answer2);
//				 //for Answer3
//				 label_Answer3 = new JLabel("Third Answer");
//				 label_Answer3.setBounds(15,135,150,20);
//				 text_Answer3 = new JTextField();
//				 text_Answer3.setBounds(150,135,150,20);
//				 add(label_Answer3);
//				 add(text_Answer3);
//				 //for Answer4
//				 label_Answer4 = new JLabel("Fourth Answer");
//				 label_Answer4.setBounds(15,160,150,20);
//				 text_Answer4 = new JTextField();
//				 text_Answer4.setBounds(150,160,150,20);
//				 add(label_Answer4);
//				 add(text_Answer4);
//				 //for buttons
//				 Edit_Question_Answer = new JButton("Update");
//				 Edit_Question_Answer.setBounds(50,185,100,20);
//				 Reset = new JButton("Reset");
//				 Reset.setBounds(180,185,100,20);
//				 add(Edit_Question_Answer);
//				 add(Reset);
//				 Edit_Question_Answer.addActionListener(this);
//				 Reset.addActionListener(this);
	}
	public void displayTable() {
		JScrollPane scrollpane = new JScrollPane();
		scrollpane.setBounds(10,10,800,500);
		add(scrollpane);
		String[] columns = {"Question_ID","Subject ID","Question","Answer1","Answer2","Answer3","Answer4"};
//		questionData = new JTable();
	
	}
}
