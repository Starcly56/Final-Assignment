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

public class Select_Questions extends JFrame implements ActionListener {
	JMenuBar menubar;
	JMenu Course,Manage_Account,Logout;
	JMenuItem STW210CT,STW205CDE,STW290COM,STW201CS;
	Database_Connection dc= new Database_Connection();
	public static String User_token="";
	String token;
//	public static void main(String [] args) {
//		new Select_Questions().setVisible(true);
//	}
	public Select_Questions() {
		setTitle("Student Dashboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		getContentPane().setBackground(Color.decode("#ffa500"));
		setLayout(null);
		setResizable(false);
		menubar = new JMenuBar();
		Course= new JMenu("Attend Exam");
		Manage_Account= new JMenu("Manage Account");
		Logout= new JMenu("Logout");
		STW210CT= new JMenuItem("STW210 CT");
		STW205CDE= new JMenuItem("STW205 CDE");
		STW290COM= new JMenuItem("STW290 COM");
		STW201CS= new JMenuItem("STW210 CS");
		menubar.add(Course);
		menubar.add(Manage_Account);
		menubar.add(Logout);
		Course.add(STW210CT);
		Course.add(STW205CDE);
		Course.add(STW290COM);
		Course.add(STW201CS);
		add(menubar);
		setJMenuBar(menubar);
		STW210CT.addActionListener(this);
		STW205CDE.addActionListener(this);
		STW201CS.addActionListener(this);
		STW290COM.addActionListener(this);
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,400);
		panel.setBackground(null);
		Vector columnNames = new Vector();
        Vector data = new Vector();
	        
	        try {
	            ResultSet resultSet = dc.fetchResult();
	            ResultSetMetaData metaData = resultSet.getMetaData();
	            int columns = metaData.getColumnCount();
	            for (int i = 1; i <= columns; i++) {
	                columnNames.addElement(metaData.getColumnName(i));
	            }
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
	            System.out.println(e);
	        }
	        JTable table = new JTable(data, columnNames);
	        TableColumn column;
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            column.setMaxWidth(250);
	        }
	        JScrollPane scrollpane = new JScrollPane(table);
	        scrollpane.setPreferredSize(new Dimension(500, 300));
	        panel.add(scrollpane);           
	        add(panel);        
	        Manage_Account.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
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
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
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
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
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
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
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
				ResultSet output=dc.token();
				String token=JOptionPane.showInputDialog(null, "Enter this '"+Login_page.USER_TOKEN+"' token");
				if(token.equals(Login_page.USER_TOKEN)) {
					JOptionPane.showMessageDialog(null, "Attempt Your Test");
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
