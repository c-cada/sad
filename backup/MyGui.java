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
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
public class MyGui extends JPanel implements ActionListener
{
    final StudyTrackerReader str = new StudyTrackerReader();
    private JFrame frame;
    final ButtonListener listener = new ButtonListener();
    final int gap = 50;
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
    /**
     * addMethod
     */
    JLabel add1;
    JLabel error;
    JLabel lastName;
    JTextField last;
    JLabel firstName;
    JTextField first;
    JLabel dobL;
    JTextField dobT;
    JLabel ageL;
    JTextField ageT;
    JLabel colourL;
    JTextField colourT;
    JButton addEnter;
    JButton addCancel;
    /**
     * addMethod
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
    private void initialisation()
    {
        frame = new JFrame("StudentTracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1000,800));
        mainPage();
    }
    
    private void mainPage()
    {
        //Mainpage panel
        JPanel main = new JPanel(new GridLayout(11,0));
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
    
    private void addMethod()
    {
        JPanel addUser = new JPanel(new GridLayout(14,0));
        addUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        add1 = new JLabel("Insert students details", SwingConstants.CENTER);
        error = new JLabel("", SwingConstants.CENTER);
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
        addCancel = new JButton("Cancel");
        addEnter.addActionListener(listener);
        addCancel.addActionListener(listener);
        error.setForeground(Color.RED);
        
        
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
        addUser.add(addCancel);
        
        frame.setContentPane(addUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void attendMethod()
    {
        JPanel attUser = new JPanel(new GridLayout(14,0));
        attUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        
        att1 = new JLabel("Insert attendance details", SwingConstants.CENTER);
        error = new JLabel("", SwingConstants.CENTER);
        lastName1 = new JLabel("Last name:", SwingConstants.CENTER);
        //last1 = new JTextField("");
        firstName1 = new JLabel("First name:", SwingConstants.CENTER);
        //first1 = new JTextField("");
        attDat = new JLabel("Date in yyyy-mm-dd format:", SwingConstants.CENTER);
        dat1 = new JTextField("");
        
        addAttend = new JButton("Student Attended");
        addAbsent = new JButton("Student Abcentted");
        addCancel = new JButton("Cancel");
        addAttend.addActionListener(listener);
        addAbsent.addActionListener(listener);
        addCancel.addActionListener(listener);
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
        attUser.add(addCancel);
        
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
                
            }
            
            if (event.getSource() == search) 
            {
                
            }
            
            if (event.getSource() == edit) 
            {
                
            }
            
            if (event.getSource() == schedule) 
            {
                
            }
            
            if (event.getSource() == uncompleted) 
            {
                
            }
            
            if (event.getSource() == leaderboard ) 
            {
                
            }
            
            if (event.getSource() == exit) 
            {
                System.exit(1);
            }
            
            /**
             * Add method
             */
            
            if (event.getSource() == addCancel) 
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
                    System.out.println("Student "+fName+" "+lName+ " has been added to the database.");
                    mainPage();
                }
                
            }
            if (event.getSource() == addAttend) 
            {
                String lName = last.getText();
                String fName = first.getText();
                String date = dat1.getText();
                Boolean good=true;
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
                if(last.getText().equals("")||first.getText().equals("")||
                        dobT.getText().equals("")||ageT.getText().equals("")||
                        colourT.getText().equals(""))
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
                    
                }
                
            }
        }

    }
     
    public static void main(String[] args) 
    {
        MyGui m = new MyGui();
        m.initialisation();
    }
}
