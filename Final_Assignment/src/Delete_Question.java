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

public class Delete_Question extends JFrame{
	JMenuBar menubar;
	JMenu Back;
	JButton delete_Question;
	Database_Connection dc=new Database_Connection();
//	public static void main(String [] args) {
//		new Delete_Question().setVisible(true);
//	}
	public Delete_Question() {
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		setBounds(400,150,600,400); 
        setVisible(true); 
        setResizable(false);
		setTitle("Questions");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,200);
		panel.setBackground(Color.decode("#1e90ff"));
		//for delete button
		delete_Question = new JButton("Delete Question");
		delete_Question.setBounds(0,0,130,20);
		delete_Question.setBackground(Color.red);
		panel.add(delete_Question);
		Vector columnNames = new Vector();
        Vector data = new Vector();
	        
	        try {
//	            Class.forName("com.mysql.jdbc.Driver").newInstance();
//	            Connection con = DriverManager.getConnection(
//	                    "jdbc:mysql://localhost:3306/dbstudentmcq", "root", "");
//	            String sql = "SELECT `Question_ID`, `Subject_ID`, `Question`, `Answer1`, `Answer2`, `Answer3`, `Answer4` FROM `question_answer`";
//	            PreparedStatement statement = con.prepareStatement(sql);
	            ResultSet resultSet = dc.fetchQuestion();
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
	            dc.fetchQuestion().close();
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        JTable table = new JTable(data, columnNames);
//	        table.setDefaultEditor(Object.class, null);
	        table.setSize(600, 100);
//	        table.getAutoResizeMode();
	        TableColumn column;
	        for (int i = 0; i < table.getColumnCount(); i++) {
	            column = table.getColumnModel().getColumn(i);
	            column.setMaxWidth(250);
	        }
	        JScrollPane scrollpane = new JScrollPane(table);
	        scrollpane.setPreferredSize(new Dimension(550, 300));
	        panel.add(scrollpane);           
	        add(panel);        
	        Back.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					new Admin_Dashboard().setVisible(true);

				}
			});
	        delete_Question.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int dialogButton=JOptionPane.showConfirmDialog(null,"Do you really want to delete the question?","Delete Question",JOptionPane.YES_NO_OPTION);
					try
					{
					if(dialogButton==JOptionPane.YES_OPTION)
					{
						boolean status=dc.deleteQuestion(table.getSelectedRow());
						if(status) {
							JOptionPane.showMessageDialog(null, "The selected question is deleted");
							dc.fetchQuestion();
						}
						else { 
							JOptionPane.showMessageDialog(null, "Cannot be deleted");
						}
					}
					}
					catch(Exception ae)
					{
						JOptionPane.showMessageDialog(null, ae);
					}
				}
			});
	}
}
