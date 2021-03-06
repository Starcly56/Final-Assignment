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
	//adding required fields
	JMenuBar menubar;
	JMenu Back;
	JButton delete_Question;
	
	//for columns of the table
	Vector columnNames = new Vector();
    Vector data = new Vector();
    
	//instance of the database
	Database_Connection dc=new Database_Connection();
	//constructor
	public Delete_Question() {
		setBounds(400,150,600,400); 
        setVisible(true); 
        setResizable(false);
		setTitle("Questions");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//for menubar
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		
		//for panel 
		JPanel panel = new JPanel();
		panel.setBounds(0,0,600,200);
		panel.setBackground(Color.decode("#1e90ff"));
		
		//for delete button
		delete_Question = new JButton("Delete Question");
		delete_Question.setBounds(0,0,130,20);
		delete_Question.setBackground(Color.red);
		panel.add(delete_Question);
		
		//for loading the questions in table
		loadQuestions();

		//creating table to store the data
		JTable table = new JTable(data, columnNames);
		//setting table size
		table.setSize(600, 100);
		//for table column
		TableColumn column;
		for (int i = 0; i < table.getColumnCount(); i++) {
			column = table.getColumnModel().getColumn(i);
			column.setMaxWidth(250);
		}
		//for scroll pane of table
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setPreferredSize(new Dimension(550, 300));
		panel.add(scrollpane);           
		add(panel);        
		//adding action listener 
		Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				//redirecting to the admin dashboard
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
							dispose();
							//redirecting to admin dashboard
							new Admin_Dashboard().setVisible(true);
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
	//method for loading the questions
	public void loadQuestions() {
		try {
			//getting questions from database
        	ResultSet resultSet = dc.fetchQuestion();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columns = metaData.getColumnCount();
            //setting column name
            for (int i = 1; i <= columns; i++) {
                columnNames.addElement(metaData.getColumnName(i));
            }
            //filling data in table
            while (resultSet.next()) {
                Vector row = new Vector(columns);
                for (int i = 1; i <= columns; i++) {
                    row.addElement(resultSet.getObject(i));
                }
                data.addElement(row);
            }
            //closing the connection and query
            resultSet.close();
            dc.fetchQuestion().close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
	}
}
