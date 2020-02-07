import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
/*
*
@author Ujjwal Humagain
*
*/
public class Welcome_page extends JFrame implements ActionListener {
	//adding required fields
	JLabel label_welcome,label_background;
	JButton button_go;
	
	//constructor
	public Welcome_page() {
		setTitle("Welcome");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		setResizable(false);
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Welcome.jpg")))));
		} catch (IOException e) {
			e.printStackTrace();
		}

		//for welcome 
		label_welcome= new JLabel("Welcome to College MCQ Examination");	
		label_welcome.setForeground(Color.white);
		label_welcome.setFont(new Font("Arial",Font.BOLD,20));
		label_welcome.setBounds(110,50,380,25);
		add(label_welcome);

		//for welcome button 
		button_go=new JButton("Begin Your Test");
		button_go.setForeground(Color.cyan);
		button_go.setContentAreaFilled(false);
		button_go.setBorderPainted(false);
		button_go.setBorder(null);
		button_go.setBounds(250, 200, 100, 20);
		add(button_go);
		
		//adding action listener 
		button_go.addActionListener(this);
	}

	public static void main(String[] args) {
		
		//displaying the main form
		new Welcome_page().setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_go))
		{
			//disposing the welcome page
			dispose();
			//redirecting to login page
			new Login_page().setVisible(true);
		}
	}
}
