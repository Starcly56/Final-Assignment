import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.*;
public class Select_Questions extends JFrame implements ActionListener {
	JMenuBar menubar;
	JMenu Course,Manage_Account,Logout;
	JMenuItem STW210CT,STW205CDE,STW290COM,STW210CS;

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
		STW210CS= new JMenuItem("STW210 CS");
		menubar.add(Course);
		menubar.add(Manage_Account);
		menubar.add(Logout);
		Course.add(STW210CT);
		Course.add(STW205CDE);
		Course.add(STW290COM);
		Course.add(STW210CS);
		add(menubar);
		setJMenuBar(menubar);
		STW210CT.addActionListener(this);
		STW205CDE.addActionListener(this);
		STW210CS.addActionListener(this);
		STW290COM.addActionListener(this);
		Manage_Account.addMouseListener(new MouseListener() {
			
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
				new Manage_Student_Details().setVisible(true);
				
			}
		});
		Logout.addMouseListener(new MouseListener() {
			
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
				dispose();
				new Login_page().setVisible(true);
				
			}
		});
	}
	public static void main(String[]args)
	{
		new Select_Questions().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(STW210CT))
		{
			new STW210CT_Questions().setVisible(true);
		}
		if(e.getSource().equals(STW205CDE))
		{
			new STW205CDE_Questions().setVisible(true);
		}
		if(e.getSource().equals(STW290COM))
		{
			new STW290COM_Questions().setVisible(true);
		}
		if(e.getSource().equals(STW210CS))
		{
			new STW201CS_Questions().setVisible(true);
		}
		
	}
}
