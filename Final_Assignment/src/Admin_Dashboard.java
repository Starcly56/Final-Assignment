import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

public class Admin_Dashboard extends JFrame implements ActionListener{
	//adding required fields
	JMenuBar menubar;
	JMenu Questions,Student,Logout;
	JMenuItem Create_Questions,Delete_Questions;
	JLabel labelview;
	//instance of the database
	Database_Connection dc = new Database_Connection();
	//constructor
	public Admin_Dashboard(){
		setTitle("Admin Dashboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		setLayout(null);
		setResizable(false);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Admin_Dashboard.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//for menubar
		menubar = new JMenuBar();
		Questions= new JMenu("Questions");
		Student=new JMenu("Registered Students");
		Logout= new JMenu("Logout");
		Create_Questions= new JMenuItem("Create Questions");
		Delete_Questions= new JMenuItem("Delete Questions");
		menubar.add(Questions);
		menubar.add(Student);
		menubar.add(Logout);
		Questions.add(Create_Questions);
		Questions.add(Delete_Questions);
		add(menubar);
		setJMenuBar(menubar);
		
		JPanel panel = new JPanel();
		//creating panel for table
		panel.setBounds(0,0,600,400);
		panel.setBackground(null);
		
		 //for question
		labelview = new JLabel("Result of the Students");
    	labelview.setBounds(20, 40, 550, 20);  
        panel.add(labelview);
		//creating columns and rows
		Vector columnNames = new Vector();
		Vector data = new Vector();
		try {
			//getting the result data from database
			ResultSet resultSet = dc.viewResult();
			ResultSetMetaData metaData = resultSet.getMetaData();
			//defining columns 
			int columns = metaData.getColumnCount();
			//adding columns
			for (int i = 1; i <= columns; i++) {
				columnNames.addElement(metaData.getColumnName(i));
			}
			//adding data in as a row
			while (resultSet.next()) {
				Vector row = new Vector(columns);
				for (int i = 1; i <= columns; i++) {
					row.addElement(resultSet.getObject(i));
				}
				data.addElement(row);
			}
			resultSet.close();
			dc.fetchResult().close();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
		//defining the table and storing the defined data and columns
		JTable table = new JTable(data, columnNames);
		TableColumn column;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			column.setMaxWidth(250);
		}
		//adding scroll bar for table
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(500, 300));
		panel.add(scrollpane);           
		add(panel);    
			        
		//adding action listener
		Logout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				dispose();
				new Login_page().setVisible(true);
			}
		});
		Student.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	
				dispose();
				new Student_Record().setVisible(true);
			}
		});
		Create_Questions.addActionListener(this);
		Delete_Questions.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Create_Questions)) {
			dispose();
			//redirecting to page for creating question
			new Create_Question().setVisible(true);
		}
		if(e.getSource().equals(Delete_Questions)) {
			dispose();
			//redirecting to page for deleting question
			new Delete_Question().setVisible(true);
		}
	}
}
