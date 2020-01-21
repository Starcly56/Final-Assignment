import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Admin_Dashboard extends JFrame implements ActionListener{
	JMenuBar menubar;
	JMenu Questions,Logout;
	JMenuItem Create_Questions,Edit_Questions;
	
	public Admin_Dashboard(){
		setTitle("Admin Dashboard");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500,100,600, 400);
		setLayout(null);
		menubar = new JMenuBar();
		Questions= new JMenu("Questions");
		Logout= new JMenu("Logout");
		Create_Questions= new JMenuItem("Create Questions");
		Edit_Questions= new JMenuItem("Edit Questions");
		menubar.add(Questions);
		menubar.add(Logout);
		Questions.add(Create_Questions);
		Questions.add(Edit_Questions);
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
		Edit_Questions.addActionListener(this);
	}
	public static void main(String[] args) {
		new Admin_Dashboard().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Create_Questions)) {
			new Create_Question().setVisible(true);
		}
		if(e.getSource().equals(Edit_Questions)) {
			new Edit_Question().setVisible(true);
		}
	}
}
