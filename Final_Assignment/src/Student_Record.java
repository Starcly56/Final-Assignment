import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.TableColumn;

public class Student_Record extends JFrame{
	JMenuBar menubar;
	JMenu Back;
	public Student_Record() {
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		 setBounds(400,150,600,400); 
	        setVisible(true); 
	        setResizable(false);
			setTitle("Registered Examinees");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			JPanel panel = new JPanel();
			panel.setBackground(Color.decode("#1e90ff"));
		  Vector columnNames = new Vector();
	        Vector data = new Vector();
	        
	        try {
	            Class.forName("com.mysql.jdbc.Driver").newInstance();
	            Connection con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/dbstudentmcq", "root", "");
	            String sql = "SELECT ID, student_name,Email,batch FROM student";
	            PreparedStatement statement = con.prepareStatement(sql);
	            ResultSet resultSet = statement.executeQuery(sql);
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
	            statement.close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        JTable table = new JTable(data, columnNames);
	        table.setDefaultEditor(Object.class, null);
	        table.getAutoResizeMode();
	        TableColumn column;
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            column.setMaxWidth(250);
	        }
	        JScrollPane scrollPane = new JScrollPane(table);        
	        panel.add(scrollPane);               
	        add(panel);        
	        Back.addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					new Admin_Dashboard().setVisible(true);

				}
			});
	}
}
