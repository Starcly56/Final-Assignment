import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
/*
*
@author Ujjwal
*
*/
public class Welcome_page extends JFrame implements ActionListener {
	JLabel label_welcome,label_background;
	JButton button_go;
	public Welcome_page() {
//		 ImageIcon ic= new ImageIcon("mosaic.jpg");
//		 setContentPane(new JLabel().ic);
		setTitle("Welcome");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(400,150,600,400);
		setResizable(false);
		setLayout(null);
//		getContentPane().setBackground(Color.decode("#ffa500"));
		try {
			setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images//Welcome.jpg")))));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//for welcome 
		 label_welcome= new JLabel("Welcome to College MCQ Examination");	
		 label_welcome.setForeground(Color.cyan);
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
		 setVisible(true);
		 button_go.addActionListener(this);
		 setLayout(new BorderLayout());
		
			//setLayout(new FlowLayout());
	    }

	public static void main(String[] args) {
		new Welcome_page();
		new Select_Questions();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(button_go))
		{
			new Login_page().setVisible(true);
		}
	}
}
