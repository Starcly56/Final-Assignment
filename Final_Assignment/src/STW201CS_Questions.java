import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class STW201CS_Questions extends JFrame implements ActionListener {

	JMenuBar menubar;
	JMenu Back;
	JButton button_prev, button_next;
	JLabel label_Question, label_Answer;
	JRadioButton option1, option2, option3, option4;
	Database_Connection dc = new Database_Connection();
	ResultSet rs;
	ArrayList<String> arrquestion = new ArrayList<String>();
	ArrayList<String> arranswer = new ArrayList<String>();
	public static void main(String[] args) {
		// name specific no -->anonymous
		new STW201CS_Questions().setVisible(true);
	}
	public STW201CS_Questions() {
		setTitle("Questions for STW210 CS");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.gray);
		setResizable(false);
		setBounds(400,150,600,400);
		setLayout(null);
		menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		// adding question
		label_Question = new JLabel();
		label_Question.setBounds(50, 10, 500, 20);
		add(label_Question);
		// adding radio button
		label_Answer = new JLabel("Answers:");
		label_Answer.setBounds(50, 30, 150, 20);
		option1 = new JRadioButton("");
		option2 = new JRadioButton();
		option3 = new JRadioButton();
		option4 = new JRadioButton();
		option1.setBounds(50, 60, 500, 20);
		option1.setBackground(null);
		option2.setBounds(50, 90, 500, 20);
		option2.setBackground(null);
		option3.setBounds(50, 120, 500, 20);
		option3.setBackground(null);
		option4.setBounds(50, 150, 500, 20);
		option4.setBackground(null);
		ButtonGroup bg = new ButtonGroup();
		bg.add(option1);
		bg.add(option2);
		bg.add(option3);
		bg.add(option4);
		add(label_Answer);
		add(option1);
		add(option2);
		add(option3);
		add(option4);
		// for button
		button_prev = new JButton("Previous");
		button_prev.setBounds(50, 200, 100, 20);
		add(button_prev);
		button_next = new JButton("Next");
		button_next.setBounds(250, 200, 100, 20);
		add(button_next);
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
				new Select_Questions().setVisible(true);

			}
		});

		rs = dc.fetchQuestionfor201();
		
		try {
			while (rs.next()) {
				arrquestion.add(rs.getString("Question"));
				arranswer.add(rs.getString("Answer1"));
				arranswer.add(rs.getString("Answer2"));
				arranswer.add(rs.getString("Answer3"));
				arranswer.add(rs.getString("Answer4"));
//				Collections.shuffle(arranswer);
				label_Question.setText(arrquestion.get(0));
				option1.setText(arranswer.get(1));
				option2.setText(arranswer.get(2));
				option3.setText(arranswer.get(3));
				option4.setText(arranswer.get(0));
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_next)) {

		}
	}
	
//	public void randomQuestionsGenerator() {
//		ArrayList<String> arrquestion = new ArrayList<String>();
//		ArrayList<String> arranswer = new ArrayList<String>();
//	    for(int i=0; i<arrquestion.size(); i++)   {
//			rs = dc.fetchQuestionfor201();
//				
//				try {
//					if (rs.next()) {
//						arrquestion.add(rs.getInt(i));
//						Collections.shuffle(arrquestion);
//						label_Question.setText(arrquestion.get(0));
//						arranswer.add(0, rs.getString("Answer1"));
//						arranswer.add(1, rs.getString("Answer2"));
//						arranswer.add(2, rs.getString("Answer3"));
//						arranswer.add(3, rs.getString("Answer4"));
//						Collections.shuffle(arranswer);
//						option1.setText(arranswer.get(1));
//						option2.setText(arranswer.get(2));
//						option3.setText(arranswer.get(3));
//						option4.setText(arranswer.get(0));
//					}
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//		}
//	}

}
