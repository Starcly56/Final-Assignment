import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Admin_Dashboard extends JFrame implements ActionListener{
	JMenuBar menubar;
	JMenu Questions,Logout;
	JMenuItem Create_Questions,Delete_Questions;
	
	public Admin_Dashboard(){
		setTitle("Admin Dashboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		setLayout(null);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Admin_Dashboard.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menubar = new JMenuBar();
		Questions= new JMenu("Questions");
		Logout= new JMenu("Logout");
		Create_Questions= new JMenuItem("Create Questions");
		Delete_Questions= new JMenuItem("Delete Questions");
		menubar.add(Questions);
		menubar.add(Logout);
		Questions.add(Create_Questions);
		Questions.add(Delete_Questions);
		add(menubar);
		setJMenuBar(menubar);
		Logout.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {	
				new Login_page().setVisible(true);
			}
		});
		Create_Questions.addActionListener(this);
		Delete_Questions.addActionListener(this);
	}
	public static void main(String[] args) {
		new Admin_Dashboard().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Create_Questions)) {
			new Create_Question().setVisible(true);
		}
		if(e.getSource().equals(Delete_Questions)) {
			new Delete_Question().setVisible(true);
		}
	}
}
