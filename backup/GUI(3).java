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

public class GUI extends JPanel implements ActionListener
{
    final int CONTINUE = 0;
    final int ADD = 1;
    final int ATTENDANCE = 2;
    final int TOPIC = 3;
    final int SEARCH = 4;
    final int EDIT = 5;
    final int SCHEDULE = 6;
    final int DIFFICULT=7;
    final int LEADERBOARD=8;
    final int EXIT = 9;    
    final StudyTrackerReader str = new StudyTrackerReader();
    
    
    String fName = "";
                String lName = "";
                String dob = "";
                String age = "";
                int intAge = 0;
                String colour = "";
                
                
    private int count = 0;
    private JLabel label;
    private JFrame frame;
    private JPanel sData;
    private JPanel sAttend;
    private JPanel sTopic;
    private JPanel sSearch;
    private JTextField input = new JTextField("Input here");
    
    private JButton button1 = new JButton("Data");
    private JButton button2 = new JButton("Attend");
    private JButton button3 = new JButton("Topics");
    private JButton button4 = new JButton("Search");
    private JButton enter = new JButton("Enter");
    
    public GUI()
    {
        frame = new JFrame();
        
        ButtonListener listener = new ButtonListener();
        ButtonListener eListener = new ButtonListener();
        
        button1.addActionListener(listener);
        button2.addActionListener(listener);
        button3.addActionListener(listener);
        button4.addActionListener(listener);
        enter.addActionListener(eListener);
        
        
        label = new JLabel("Data Input");
        //clicky box - Student Data input
        sData = new JPanel();
                                                      //top  L   B    R
        sData.setBorder(BorderFactory.createEmptyBorder(10, 10, 100, 100));
        sData.setLayout(new GridLayout(0,1));
        sData.add(label);
        sData.add(button1);
        
        label = new JLabel("Mark Attendance");
        //clicky box - Student Mark Attendance
        sAttend = new JPanel();
                                                        //top  L   B    R
        sAttend.setBorder(BorderFactory.createEmptyBorder(10, 100, 10, 100));
        sAttend.setLayout(new GridLayout(0,1));
        sAttend.add(label);
        sAttend.add(button2);
        
        label = new JLabel("Add Topic");
        //clicky box - Student Add Topic
        sTopic = new JPanel();
                                                       //top  L   B    R
        sTopic.setBorder(BorderFactory.createEmptyBorder(100, 10, 10, 100));
        sTopic.setLayout(new GridLayout(0,1));
        sTopic.add(label);
        sTopic.add(button3);
        
        label = new JLabel("Search");
        //clicky box - Student Search
        sSearch = new JPanel();
                                                        //top   L   B    R
        sSearch.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));
        sSearch.setLayout(new GridLayout(0,1));
        sSearch.add(label);
        sSearch.add(button4);
        
        //main window
        frame.add(sData, BorderLayout.NORTH);
        frame.add(sAttend, BorderLayout.SOUTH);
        frame.add(sTopic, BorderLayout.EAST);
        frame.add(sSearch, BorderLayout.WEST);
        frame.add(input, BorderLayout.CENTER);
        label = new JLabel("please add the students first name");
        frame.add(label, BorderLayout.EAST);
        label.setVisible(false);
        input.setVisible(false);
        frame.add(enter, BorderLayout.WEST);
        enter.setVisible(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Study Tracker");
        frame.repaint();
        frame.setVisible(true);
        frame.repaint();
        
        frame.setSize(500, 500);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    private class ButtonListener implements ActionListener
    {
        public void actionPerformed (ActionEvent event)
        {
            if (event.getSource() == button1) //for fast moving left
            {
                label.setVisible(true);
                input.setVisible(true);
                enter.setVisible(true);
                frame.repaint();
            }
            
            
            if (event.getSource() == enter)
            {
                
                String lab = label.getText();
                
                
                if (lab == "please add the students first name")
                {
                    fName = input.getText();
                    System.out.println("F Name " + fName);
                    input.setText("");
                    label.setText("please add the students last name");
                    label.repaint();
                    frame.repaint();
                }
                if (lab == "please add the students last name")
                {
                    lName = input.getText();
                    System.out.println("L Name " + lName);
                    input.setText("");
                    label.setText("please add the students DOB");
                    label.repaint();
                    frame.repaint();
                }
                if (lab == "please add the students DOB")
                {
                    dob = input.getText();
                    System.out.println("F Name " + dob);
                    input.setText("");
                    label.setText("please add the students age");
                    frame.repaint();
                }
                if (lab == "please add the students age")
                {
                    age = input.getText();
                    intAge = Integer.parseInt(age) ;
                    System.out.println("L Name " + intAge);
                    input.setText("");
                    label.setText("please add the students colour");
                    frame.repaint();
                }
                if (lab == "please add the students colour")
                {
                    colour = input.getText();
                    System.out.println("L Name " + colour);
                    input.setText("");
                    label.setVisible(false);
                    input.setVisible(false);
                    
                    frame.repaint();
                    
                }
                if (!fName.matches("") && !lName.matches("") && !dob.matches("") && !colour.matches(""))
                {
                    addMethod(fName, lName, dob, intAge, colour);
                    System.out.println("i hate myself");
                    label.setVisible(true);
                }
                
            }
                
        }
    }
      
     public void addMethod(String fName, String lName, String dob, int age, String colour)
    {
        Scanner s =new Scanner(System.in);
        System.out.println("Please enter their first name");
        //fName = s.nextLine();
        
        
        System.out.println("Please enter their last name");
        //lName = s.nextLine();
                              
        while (true)
        {
            System.out.println("Please enter their date of birth in this format:\n yyyy-mm-dd");
            //dob = s.nextLine();
            if (dob.length() == 10)
            {
                if (dob.charAt(4) == '-' && dob.charAt(7) == '-')
                {
                    String[] parts = dob.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                    if(year.matches("[a-zA-Z]+") == false && month.matches("[a-zA-Z]+") == false && day.matches("[a-zA-Z]+") == false)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("Please insert only numbers");
                    }
                }
                else
                {
                    System.out.println("Incorrect Formatting");
                }
            }
            else
            {
                System.out.println("Incorrect Formatting");
            }
        }            
        System.out.println("Please enter their age");
        //age = s.nextInt();
                        
        System.out.println("Please enter their colour six group");
        //s.nextLine();
        //colour = s.nextLine();
                        
        System.out.println("\n\n");
        int key = 1;
        while(key==1)
        {
            System.out.println("Are the following details correct?\n [yes] [no]");
            String stu = "Name: "+fName+" "+lName + "\nDate of Birth: "+dob+ "\nAge: "+age+"\nColour six group: " + colour;
            label.setText(stu);
            label.repaint();
            System.out.println("Name: "+fName+" "+lName + "\nDate of Birth: "+dob+ "\nAge: "+age+"\nColour six group: " + colour);
            String ans = s.nextLine();
            String correct=ans.toLowerCase();
            switch(correct)
            {
                case "yes":
                    //str.addStudents(lName, fName, dob, age, colour);
                    key=2;
                    break;
                                
                case "no":
                    System.out.println("Student information not saved.\n");
                    key=2;
                    break;
                                
                default:
                    System.out.println("Please enter [yes] or [no]\n");
                    break;
            }
        }
    }
    
    /*@Override
    public void actionPerformed(ActionEvent e)
    {
        test();
        
        StudyTrackerMain s = new StudyTrackerMain();
        Scanner sc = new Scanner(System.in);
        label.setVisible(false);
        
        String Input = sc.nextLine();
                input.getText();
        
        
        s.addMethod("","",false);
    }**/
    
    public static void main(String[] args)
    {
        new GUI();
    }
}