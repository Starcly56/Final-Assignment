import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Student_Record extends JFrame{
	//adding required fields
	JMenuBar menubar;
	JMenu Back;
	//instance of database
	Database_Connection dc = new Database_Connection();
	//for columns and data to be stored in table
	Vector columnNames = new Vector();
    Vector data = new Vector();
	//constructor
	public Student_Record() {
		setBounds(400,150,600,400); 
        setVisible(true); 
        setResizable(false);
		setTitle("Registered Examinees");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//for menu bar
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		 
		//for panel
		JPanel panel = new JPanel();
		panel.setBackground(Color.decode("#1e90ff"));
		
	    RegisteredStudent(); 
		JTable table = new JTable(data, columnNames);
		table.setDefaultEditor(Object.class, null);
		table.getAutoResizeMode();
		TableColumn column;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			column.setMaxWidth(250);
		}
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(480, 300));
		panel.add(scrollpane);               
		add(panel);        
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Admin_Dashboard().setVisible(true);

			}
		});
	}
	public void RegisteredStudent() {
		try {
			//for getting data from database
            ResultSet resultSet = dc.registeredStudent();
            ResultSetMetaData metaData = resultSet.getMetaData();
            //for columns
            int columns = metaData.getColumnCount();
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            //for data
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            resultSet.close();
            dc.registeredStudent().close();
        } catch (Exception e) {
            System.out.println(e);
        }
	}
}
