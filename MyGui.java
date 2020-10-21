

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Fifield
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.KeyListener;

import java.util.*;
import java.lang.*;
import static java.lang.Integer.parseInt;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
public class MyGui extends JPanel implements ActionListener
{
    final StudyTrackerReader str = new StudyTrackerReader();
    private JFrame frame;
    final ButtonListener listener = new ButtonListener();
    final int gap = 50;
    final JLabel blank= new JLabel("");
    /**
     * Main
     */
    private JButton add;
    private JButton attend;
    private JButton topic;
    private JButton search;
    private JButton edit;
    private JButton schedule;
    private JButton uncompleted;
    private JButton leaderboard;
    private JButton exit;
    private JLabel mainLabel;
    private JLabel mainLabel2;
    private JLabel notify;
    /**
     * addMethod
     */
    private JLabel add1;
    private JLabel error;
    private JLabel lastName;
    private JTextField last;
    private JLabel firstName;
    private JTextField first;
    private JLabel dobL;
    private JTextField dobT;
    private JLabel ageL;
    private JTextField ageT;
    private JLabel colourL;
    private JTextField colourT;
    private JButton addEnter;
    private JButton cancel;
    private JButton cancel2;
    /**
     * attendMethod
     */
    JLabel att1;
    JLabel lastName1;
    JTextField last1;
    JLabel firstName1;
    JTextField first1;
    JLabel attDat;
    JTextField dat1;
    JButton addAttend;
    JButton addAbsent;
    String attList1;
    String[] attList2;
    String[][] attList3;
    String attFName;
    String attLName;
    String answer = "";
    /**
     * Topic Method
     */
    private JLabel topM;
    private JButton addTopic;
    private JButton markTopic;
    private JPanel topicCreate;
    private JPanel topicMark;
    //Create
    private JLabel tPageL;
    private JLabel dotL;
    private JTextField dotT;
    private JLabel topicL;
    private JTextField topicT;
    private JLabel coordL;
    private JTextField coordT;
    private JButton nextTopic;
    private JButton compB;
    private JLabel compL;
    private Boolean comp = true;
     //Mark
     
    private void initialisation()
    {
        frame = new JFrame("StudentTracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,800));
        cancel = new JButton("Cancel");
        cancel.addActionListener(listener);
        cancel2 = new JButton("Cancel");
        cancel2.addActionListener(listener);
        error = new JLabel("", SwingConstants.CENTER);
        error.setForeground(Color.RED);
        notify = new JLabel ("",SwingConstants.CENTER);
        mainPage();
    }
    
    private void mainPage()
    {
        //Mainpage panel
        JPanel main = new JPanel(new GridLayout(12,0));
        main.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        //Initialisation of main buttons + label
        add = new JButton("Add a student to the database");
        attend = new JButton("Record attendance");
        topic = new JButton("Add or mark parts, topics, or tests");
        search = new JButton("Search the database for a specific student");
        edit = new JButton("Edit the details of an existing student");
        schedule = new JButton("Print schedule");
        uncompleted = new JButton("Search for topics that havent been widely completed");
        leaderboard = new JButton("Lookup the student leaderboard");
        exit = new JButton("Exit");
        mainLabel = new JLabel("Welcome to the Student Tracker App!", SwingConstants.CENTER);
        mainLabel2 = new JLabel("What would you like to do?", SwingConstants.CENTER);
        
        //Set button size
       
        
        //Adding listeners to each button
        
        add.addActionListener(listener);
        attend.addActionListener(listener);
        topic.addActionListener(listener);
        search.addActionListener(listener);
        edit.addActionListener(listener);
        schedule.addActionListener(listener);
        uncompleted.addActionListener(listener);
        leaderboard.addActionListener(listener);
        exit.addActionListener(listener);
        
        str.badge();
        
        main.add(notify);
        main.add(mainLabel);
        main.add(mainLabel2);
        main.add(add);
        main.add(attend);
        main.add(topic);
        main.add(search);
        main.add(edit);
        main.add(schedule);
        main.add(uncompleted);
        main.add(leaderboard);
        main.add(exit);
        
        frame.setContentPane(main);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void badge(String first, String last, String badge)
    {
        notify.setText(first+" "+ last + " has just earned a "+badge+ "!");
        
    }
    
    private void addMethod()
    {
        JPanel addUser = new JPanel(new GridLayout(14,0));
        addUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        add1 = new JLabel("Insert students details", SwingConstants.CENTER);
        lastName = new JLabel("Last name:", SwingConstants.CENTER);
        last = new JTextField("");
        firstName = new JLabel("First name:", SwingConstants.CENTER);
        first = new JTextField("");
        dobL = new JLabel("Date of Birth in yyyy-mm-dd format:", SwingConstants.CENTER);
        dobT = new JTextField("");
        ageL = new JLabel("Age:", SwingConstants.CENTER);
        ageT = new JTextField("");
        colourL = new JLabel("ColourSixGroup:", SwingConstants.CENTER);
        colourT = new JTextField("");
        
        addEnter = new JButton("Continue");
        addEnter.addActionListener(listener);
        
        error.setText("");
        addUser.add(add1);
        addUser.add(error);
        addUser.add(lastName);
        addUser.add(last);
        addUser.add(firstName);
        addUser.add(first);
        addUser.add(dobL);
        addUser.add(dobT);
        addUser.add(ageL);
        addUser.add(ageT);
        addUser.add(colourL);
        addUser.add(colourT);
        addUser.add(addEnter);
        addUser.add(cancel);
        
        frame.setContentPane(addUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void topicMethod()
    {
        JPanel topicMain = new JPanel(new GridLayout(4,0));
        topicMain.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        topicCreate = new JPanel(new GridLayout(13,0));
        topicCreate.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        topicMark = new JPanel(new GridLayout(14,0));
        topicMark.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        //Topic main
        topM = new JLabel("What would you like to do?", SwingConstants.CENTER);
        addTopic = new JButton("Add a new topic, part, or test?");
        markTopic = new JButton("Mark a topic, part, or test?");
        addTopic.addActionListener(listener);
        markTopic.addActionListener(listener);
        
        topicMain.add(topM);
        topicMain.add(addTopic);
        topicMain.add(markTopic);
        topicMain.add(cancel);
        
        //Topic create buttons
        tPageL = new JLabel("Please fill in the following fields:", SwingConstants.CENTER);
        dotL = new JLabel("Please enter the date of the topic/part/test in yyyy-mm-dd format:", SwingConstants.CENTER);
        dotT = new JTextField("");
        topicL = new JLabel("Please enter a name for the topic/test/part:", SwingConstants.CENTER);
        topicT = new JTextField("");
        coordL = new JLabel("Please enter the full name of the coordinating supervisor:", SwingConstants.CENTER);
        coordT = new JTextField("");
        nextTopic = new JButton("Continue");
        nextTopic.addActionListener(listener);
        compL = new JLabel("Press to change to optional:", SwingConstants.CENTER);
        compB= new JButton("Compulsory");
        compB.addActionListener(listener);
        
        error.setText("");
        
        topicCreate.add(tPageL);
        topicCreate.add(error);
        topicCreate.add(dotL);
        topicCreate.add(dotT);
        topicCreate.add(topicL);
        topicCreate.add(topicT);
        topicCreate.add(coordL);
        topicCreate.add(coordT);
        topicCreate.add(compL);
        topicCreate.add(compB);
        topicCreate.add(blank);
        topicCreate.add(nextTopic);
        topicCreate.add(cancel2);
        
        frame.setContentPane(topicMain);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void attendMethod()//DefaultTableModel table)
    {
        JPanel attUser = new JPanel(new GridLayout(14,0));
        attUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        DefaultTableModel t = new DefaultTableModel();
        
        JTable jt = new JTable();
        jt.setModel(t);
        JPanel pan1 = new JPanel();
        pan1.add(jt);
        JPanel pan2 = new JPanel();
        pan2.add(blank);
        pan2.add(blank);
        pan2.add(blank);
        pan2.add(cancel);
        
        attUser.add(pan1);
        attUser.add(pan2);
        
        attList1 = str.getAttend();
        attList2 = attList1.split("+");
        
        att1 = new JLabel("Insert attendance details", SwingConstants.CENTER);
        error = new JLabel("", SwingConstants.CENTER);
        attDat = new JLabel("Date in yyyy-mm-dd format:", SwingConstants.CENTER);
        dat1 = new JTextField("");
        String x = "";
        String[] y;
        String attName;
        for (int i = 0; i < attList2.length; i++)
        {
            x = attList2.get(i);
            y = x.split("-");
            attName = y.get(0) + " " + y.get(1);
            firstName1 = new JLabel(attName, SwingConstants.CENTER);
            addAttend = new JButton("Student Attended");
            addAbsent = new JButton("Student Abcentted");
        }
        
        str.markAttendance(dat1.getText());
       
        
        /**
        
        
        
        //first1 = new JTextField("");
        
        
        
        cancel = new JButton("Cancel");
        addAttend.addActionListener(listener);
        addAbsent.addActionListener(listener);
        cancel.addActionListener(listener);
        error.setForeground(Color.RED);
        
        
        attUser.add(att1);
        attUser.add(error);
        attUser.add(attDat);
        attUser.add(dat1);
        attUser.add(lastName1);
        attUser.add(last1);
        attUser.add(firstName1);
        attUser.add(first1);
        attUser.add(addAttend);
        attUser.add(addAbsent);
        attUser.add(cancel);
        **/
        frame.setContentPane(attUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            /**
             * Main page buttons
             */
            if (event.getSource() == add) 
            {
                addMethod();
            }
            
            if (event.getSource() == attend) 
            {
                attendMethod();
            }
            
            if (event.getSource() == topic) 
            {
                topicMethod();
            }
            
            if (event.getSource() == search) 
            {
                
            }
            
            if (event.getSource() == edit) 
            {
                
            }
            
            if (event.getSource() == schedule) 
            {
                //HAVE TO ADAPT
                str.printSchedule();
            }
            
            if (event.getSource() == uncompleted) 
            {
                //HAVE TO ADAPT
                str.difficult();
            }
            
            if (event.getSource() == leaderboard ) 
            {
                //HAVE TO ADAPT
                str.leaderboard();
            }
            
            if (event.getSource() == exit) 
            {
                System.exit(1);
            }
            
            /**
             * Add method
             */
            
            if (event.getSource() == cancel) 
            {
                mainPage();
            }
            
            if (event.getSource() == cancel2) 
            {
                mainPage();
            }
            
            if (event.getSource() == addEnter) 
            {
                String lName = last.getText();
                String fName = first.getText();
                String dob = dobT.getText();
                Boolean good=true;
                int age=0;
                try
                {
                    String[] parts = dob.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                try
                {
                    age = parseInt(ageT.getText());
                }
                catch(NumberFormatException e)
                {
                    error.setText("Please input an integer for field age");
                    good=false;
                }
                String colour = colourT.getText();
                if(last.getText().equals("")||first.getText().equals("")||
                        dobT.getText().equals("")||ageT.getText().equals("")||
                        colourT.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                    good=false;
                }
                else if (dob.length() != 10)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                else if (dob.charAt(4) != '-' || dob.charAt(7) != '-')
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }         
                 else if (age<=0)
                {
                    error.setText("Please input an integer higher than 0 for field age");
                    good=false;
                }
                else if (good)
                {
                    str.addStudents(lName, fName, dob, age, colour);
                    notify.setText("Student has been added to database.");
                    mainPage();
                }
                
            }
            
            if(event.getSource() == addAttend)
            {
                answer = "yes";
            }
            
            if(event.getSource() == addAttend)
            {
                answer = "no";
            }
            
            /**
             * Topic methods
             */
            if (event.getSource() == addTopic) 
            {
                frame.setContentPane(topicCreate);
                frame.pack();
                frame.setVisible(true);
            }
            
            if (event.getSource() == compB) 
            {
                if(comp)
                {
                    compL.setText("Press to change to compulsory:");
                    compB.setText("Optional");
                    comp=false;
                }
                else
                {
                    compL.setText("Press to change to optional:");
                    compB.setText("Compulsory");
                    comp=true;
                }
            }
            
            if (event.getSource() == nextTopic) 
            {
                Boolean good = true;
                String date = dotT.getText();
                String topic = topicT.getText();
                String name = coordT.getText();
                try
                {
                    String[] parts = date.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                if(dotT.getText().equals("")||topicT.getText().equals("")||
                        coordT.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                    good=false;
                }
                else if (date.length() != 10)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                else if (date.charAt(4) != '-' || date.charAt(7) != '-')
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }         
                else if (good)
                {
                    str.updateSchedule(date, topic, name, comp);
                    notify.setText("Topic has been added to database.");
                    mainPage();
                }
            }
            
            if (event.getSource() == markTopic) 
            {
                frame.setContentPane(topicMark);
                frame.pack();
                frame.setVisible(true);
            }
            
        }

    }
     
    public static void main(String[] args) 
    {
        MyGui m = new MyGui();
        m.initialisation();
    }
}