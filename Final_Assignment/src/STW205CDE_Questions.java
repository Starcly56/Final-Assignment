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

public class STW205CDE_Questions extends JFrame implements ActionListener {
    JButton button_next, button_result;
    ButtonGroup bg;
    JLabel label_Question;
    JRadioButton option[] = new JRadioButton[5]; //for options of the question
    int score = 0;
//    long StartTime, EndTime, seconds, minutes, flag = 0;
    ArrayList questionAnswer = new ArrayList();
     int a=0;
//    public static ArrayList<int>;
     ResultSet rs1;
    int marks=0;
    public static void main (String [] args)
    {
    	new STW205CDE_Questions().setVisible(true);
    }
    public STW205CDE_Questions() {
    	label_Question = new JLabel();
        add(label_Question);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
        	option[i] = new JRadioButton();
            add(option[i]);
            bg.add(option[i]);
        }
        setTitle("STW205CDE Questions");
        setDefaultCloseOperation(HIDE_ON_CLOSE);
        button_next = new JButton("Next");
        button_result = new JButton("Result");
        button_next.addActionListener(this);
        button_result.addActionListener(this);
        add(button_next);
        add(button_result);
        set1();
        label_Question.setBounds(30, 40, 450, 20);  //labels question area
        button_next.setBounds(100, 240, 100, 30);
        button_result.setBounds(270, 240, 100, 30);
        setLayout(null);
        setVisible(true);
		setBounds(400,150,600,400);
        repaint();
        setResizable(false);
    }

   
    void set1() {
        System.out.println("This is Set");
        repaint();
        option[4].setSelected(true);
        try {
            PreparedStatement pst;
            ResultSet rs;
            Class.forName("com.mysql.jdbc.Driver");
            java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq", "root", "");
            String Subject_ID = "205";
            String sql = "Select * from question_answer where Subject_ID='" + Subject_ID + "'";
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery(sql);
            while (rs.next()) {
            	questionAnswer.add(rs.getString("Question_ID"));
            }
            for (int i = 0; i <10;i++) {
                try {
                    String sql1 = "select * from question_answer where Question_ID='" + questionAnswer.get(i) + "'";
                    pst = conn.prepareStatement(sql1);
                    ResultSet rs1 = pst.executeQuery();
                    pst = conn.prepareStatement(sql);
                    rs1 = pst.executeQuery(sql);
                    if (rs1.next()) {
                        String s1 = rs1.getString("Question");
                        String s2 = rs1.getString("Answer1");
                        String s3 = rs1.getString("Answer2");
                        String s4 = rs1.getString("Answer3");
                        String s5 = rs1.getString("Answer4");
                        label_Question.setText("Q" + s1);
//                        Collections.shuffle(id);
//                        for(int v=0; v<10; v++){
//                            int a = id.get(i);
//                            Questionid.add(a);
//                        }
//                        Collections.shuffle(Arrays.asList(jb));
                        option[0].setText(s2);
                        option[1].setText(s3);
                        option[2].setText(s4);
                        option[3].setText(s5);
                        question(questionAnswer);
                        label_Question.setBounds(30, 40, 450, 20);
                        for (int z = 0, j = 0; z <= 90; z += 30, j++)
                        	option[j].setBounds(50, 80 + z, 200, 20);
                    }
                }
                catch (Exception e) {
                }
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

            System.out.println(score);
            question(questionAnswer);
            score++;
            set1();
            if (score==9){
                System.out.println("stop");
                button_next.setEnabled(false);
                button_result.setText("Result");
            }
        }
        if (e.getActionCommand().equals("Result")) {
//            count++;
            if (option[0].isSelected()) {
                if(marks==10){
                    marks=marks;
                }
                else
                marks++;
            }
            JOptionPane.showMessageDialog(this, "correct ans=" + marks);
        }
    }

    void question(ArrayList id) {
            try {
                id = id;
                Class.forName("com.mysql.jdbc.Driver");
                java.sql.Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbstudentmcq", "root", "");
                PreparedStatement pst;
                String sql = "select * from question_answer where Question_ID='" + id.get(score) + "'";
                pst = con.prepareStatement(sql);
                ResultSet rs1 = pst.executeQuery();
                rs1.next();
                pst = con.prepareStatement(sql);
                rs1 = pst.executeQuery(sql);
                if (rs1.next()) {
                    String s1 = rs1.getString("Question");
                    String s2 = rs1.getString("Answer1");
                    String s3 = rs1.getString("Answer2");
                    String s4 = rs1.getString("Answer3");
                    String s5 = rs1.getString("Answer4");
                    label_Question.setText("Q: " + s1);
                    option[0].setText(s2);
                    option[1].setText(s3);
                    option[2].setText(s4);
                    option[3].setText(s5);
                    for (int z = 0, j = 0; z <= 90; z += 30, j++) {
                    	option[j].setBounds(50, 80 + z, 200, 20);
                    }
                    if (option[0].isSelected()) {
                        marks++;
                    }
                }
            }
            catch (Exception e) {

            }
    }

}
