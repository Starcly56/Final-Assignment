import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Student_Dashboard extends JFrame implements ActionListener {
		//adding required fields
		JMenuBar menubar;
		JMenu Course,Manage_Account,Logout;
		JMenuItem STW210CT,STW205CDE,STW290COM,STW201CS;
		//instance of database
		Database_Connection dc= new Database_Connection();
		//constructor
	public Student_Dashboard() {
		setTitle("Student Dashboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		getContentPane().setBackground(Color.decode("#ffa500"));
		setLayout(null);
		setResizable(false);
		
		//for menubar
		menubar = new JMenuBar();
		Course= new JMenu("Attend Exam");
		Manage_Account= new JMenu("Manage Account");
		Logout= new JMenu("Logout");
		STW210CT= new JMenuItem("STW210 CT");
		STW205CDE= new JMenuItem("STW205 CDE");
		STW290COM= new JMenuItem("STW290 COM");
		STW201CS= new JMenuItem("STW201 CS");
		menubar.add(Course);
		menubar.add(Manage_Account);
		menubar.add(Logout);
		Course.add(STW210CT);
		Course.add(STW205CDE);
		Course.add(STW290COM);
		Course.add(STW201CS);
		add(menubar);
		setJMenuBar(menubar);
		
		//adding action listener for menu items
		STW210CT.addActionListener(this);
		STW205CDE.addActionListener(this);
		STW201CS.addActionListener(this);
		STW290COM.addActionListener(this);
		//creating panel for table
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,400);
		panel.setBackground(null);
		//creating columns and rows
		Vector columnNames = new Vector();
        Vector data = new Vector();
	        try {
	        	//getting the result data from database
	            ResultSet resultSet = dc.fetchResult();
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
	        
	        //action listener for menu item
	        Manage_Account.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Manage_Student_Details().setVisible(true);
				}
			});
			Logout.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					dispose();
					new Login_page().setVisible(true);
				}
			});
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(STW210CT))
		{	
			try {
				//getting token from database
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
					dispose();
					//Attempting test for STW210CT
					new STW210CT_Questions().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please input the token correctly");
				}
			} catch (Exception e1) {
			}
			
		}
		if(e.getSource().equals(STW205CDE))
		{
			try {
				//getting token for test
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
					dispose();
					//Attempting test for STW205CDE
					new STW205CDE_Questions().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please input the token correctly");
				}
			} catch (Exception e1) {
			}
		}
		if(e.getSource().equals(STW290COM))
		{
			try {
				//getting token 
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
					dispose();
					//Attempting test for STW290COM
					new STW290COM_Questions().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please input the token correctly");
				}
			} catch (Exception e1) {
			}
		}
		if(e.getSource().equals(STW201CS))
		{
			try {
				//getting token 
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
					dispose();
					//Attempting test for STW201CS
					new STW201CS_Questions().setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Please input the token correctly");
				}
			} catch (Exception e1) {
			}
		}
	}
}
