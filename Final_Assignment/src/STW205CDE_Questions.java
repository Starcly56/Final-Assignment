import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import com.mysql.jdbc.Connection;
import com.sun.net.httpserver.Authenticator.Result;

public class STW205CDE_Questions extends JFrame implements ActionListener {
	JMenuBar menubar;
	JMenu Back;
    JButton button_next, button_result;
    JLabel label_Question,label_Timer;
    JRadioButton option[] = new JRadioButton[5]; //for options of the question
    int score = 0;
    static int interval;
    static Timer timer;
//    long StartTime, EndTime, seconds, minutes, flag = 0;
    // storing the Question_ID of the questions
    public static ArrayList<Integer> questionAnswer = new ArrayList<Integer>();
    //storing the Question and Answer
    public static ArrayList<Integer> qna = new ArrayList<Integer>();
     int a=0;
    int marks=0;
	Database_Connection dc = new Database_Connection();
	PreparedStatement prpdstmt;
	ResultSet resultset,resultset2;
//    public static void main (String [] args)
//    {
//    	new STW205CDE_Questions().setVisible(true);
//    }
    public STW205CDE_Questions() {
    	setTitle("STW205CDE Questions");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.decode("#f5f5f5"));
        setLayout(null);
		setBounds(400,150,600,400);
//        repaint();
        setResizable(false);
        menubar = new JMenuBar();
		Back = new JMenu("Back");
		menubar.add(Back);
		add(menubar);
		setJMenuBar(menubar);
		 //for timer
    	label_Timer = new JLabel();
    	label_Timer.setBounds(500, 0, 500, 20);  //labels question area
    	add(label_Timer);
        //for question
    	label_Question = new JLabel();
    	label_Question.setBounds(20, 40, 500, 20);  //labels question area
        add(label_Question);
        //for options
        ButtonGroup buttongroup = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
        	option[i] = new JRadioButton();
            add(option[i]);
            buttongroup.add(option[i]);
        }
        for (int y = 0, number = 0; y <= 90; y += 30, number++) {
        	option[number].setBounds(30, 70 + y, 250, 20);
        	option[number].setBackground(null);
        }
       //for next button
        button_next = new JButton("Next");
        button_next.setBounds(250, 240, 100, 20);
        add(button_next);
        //for submit button
        button_result = new JButton("Submit");
        button_result.setBounds(250, 240, 100, 20);
        add(button_result);
        button_next.addActionListener(this);
        button_result.addActionListener(this);
        fetching_question();
        question();
        Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
				new Select_Questions().setVisible(true);
			}
		});
        int secs=90;
        int delay = 1000;
        int period = 1000;
        timer = new Timer();
        interval =secs;
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
            	
            	label_Timer.setText(""+setInterval());
            	if(setInterval()==0)
            	{
            		JOptionPane.showMessageDialog(null, "Opps Time Up");
            		new Select_Questions().setVisible(true);
            	}

            }
        }, delay, period);
    }

    void fetching_question() {
        System.out.println("This is Set");
//        repaint();
        option[4].setSelected(true);
        try {
        	resultset=dc.fetchQuestionfor205();
            while (resultset.next()) {
            	int x=resultset.getInt("Question_ID");
            	questionAnswer.add(x);
            }
            Collections.shuffle(questionAnswer);
            for (int i = 0; i <10;i++) {
            	int y=questionAnswer.get(i);
            	qna.add(y);
            }
        }
        catch (Exception e) {
            System.out.println("setnext\n" + e);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button_next)
        {
        	score++;
            System.out.println(score);
            question();
            
            fetching_question();
            if (score==9){
                System.out.println("stop");
                button_next.setEnabled(false);
                button_next.setVisible(false);
            }
        }
        if (e.getActionCommand().equals("Submit")) {
            if (option[0].isSelected()) {
                if(marks==10){
                    marks=marks;
                }
                else
                marks++;
            }
            JOptionPane.showMessageDialog(this, "You got " + marks+" out of 10.");
            int output=dc.insertResult(Login_page.USER_ID, Login_page.USER_EMAIL, 205,marks);
            try {
            	if(output>0) {
					new Select_Questions().setVisible(true);
				}
				else { 
					JOptionPane.showMessageDialog(null, "Not Stored");
				}
            }
            catch(Exception ex) {
            	
            }
        }
    }

    void question() {
            try {
                 resultset = dc.fetchQuestionfor205();
                while (resultset.next()) {
                	int x=resultset.getInt("Question_ID");
                	questionAnswer.add(x);
                }
                Collections.shuffle(questionAnswer);
                for (int i = 0; i <10;i++) {
                	int y=questionAnswer.get(i);
                	qna.add(y);
                }
                ArrayList<Integer> forloop=new ArrayList<Integer>();
                for(int i=0;i<qna.size();i++)
                {
                	forloop.add(qna.get(i));
                }
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq", "root", "");
                String sqlstatement = "select * from question_answer where Question_ID='" + forloop.get(score) + "'";
                prpdstmt = con.prepareStatement(sqlstatement);
                resultset = prpdstmt.executeQuery();
                resultset.next();
                prpdstmt = con.prepareStatement(sqlstatement);
                resultset2 = prpdstmt.executeQuery(sqlstatement);
                if (resultset2.next()) {
                    String question = resultset2.getString("Question");
                    String answer1 = resultset2.getString("Answer1");
                    String answer2 = resultset2.getString("Answer2");
                    String answer3 = resultset2.getString("Answer3");
                    String answer4 = resultset2.getString("Answer4");
                    label_Question.setText((score+1)+" "+question);
                    option[0].setText(answer1);
                    option[1].setText(answer2);
                    option[2].setText(answer3);
                    option[3].setText(answer4);
                   
                    if (option[0].isSelected()) {
                        marks++;
                    }
                }
            }
            catch (Exception e) {
            }
    }
    private static final int setInterval() {
        if (interval == 1)
            timer.cancel();
        return --interval;
    }
}
