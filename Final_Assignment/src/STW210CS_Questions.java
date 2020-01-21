import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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

public class STW210CS_Questions extends JFrame implements ActionListener{
	
		JMenuBar menubar;
		JMenu Back;
		JButton button_prev,button_next;
		JLabel label_Question,label_Answer;
		JRadioButton option1,option2,option3;
		public static void main(String[] args) {
			//name specific no -->anonymous
			new STW210CS_Questions().setVisible(true);
	}
		public STW210CS_Questions()  {
			setTitle("Questions for STW210 CS");
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setBounds(500,100,600, 400);
			setLayout(null);
			menubar = new JMenuBar();
			Back= new JMenu("Back");
			menubar.add(Back);
			add(menubar);
			setJMenuBar(menubar);
			//adding question
			 label_Question= new JLabel("Username"); 
			 label_Question.setBounds(50,10,150,20);
			 add(label_Question);
			 //adding radio button
			 label_Answer=new JLabel("Answers:");
			 label_Answer.setBounds(50, 30, 150, 20);
			 option1=new JRadioButton("1");
			 option2= new JRadioButton("2");
			 option3=new JRadioButton("3");
			 option1.setBounds(100, 60, 100, 20);
			 option2.setBounds(100, 90, 100, 20);
			 option3.setBounds(100, 120, 100, 20);
			 ButtonGroup bg= new ButtonGroup();
			 bg.add(option1);
			 bg.add(option2);
			 bg.add(option3);
			 add(label_Answer);
			 add(option1);
			 add(option2);
			 add(option3);
			 //for button
			 button_prev=new JButton("Previous");
			 button_prev.setBounds(50, 200, 100, 20);
			 add(button_prev);
			 button_next=new JButton("Next");
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
		}
		@Override
		public void actionPerformed(ActionEvent e) {
		}

}
