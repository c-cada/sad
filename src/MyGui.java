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
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.table.DefaultTableModel;
public class MyGui extends JFrame implements ActionListener
{
    final StudyTrackerReader str = new StudyTrackerReader();
    private JFrame frame = new JFrame("StudentTracker");
    final ButtonListener listener = new ButtonListener();
    final int gap = 50;
    final JLabel blank= new JLabel("");
    private String[]column = {"Date","Topic","Staff"};
    private DefaultTableModel scheduleM = new DefaultTableModel(column,0);
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
    private JLabel notify = new JLabel ("",SwingConstants.CENTER);
    /**
     * addMethod
     */
    private JLabel add1;
    private JLabel error = new JLabel("", SwingConstants.CENTER);
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
    private JButton cancel = new JButton("Cancel");
    private JButton cancel2;
    /**
     * attendMethod
     */
    //set date
    JLabel attDat1;
    JLabel setAttDat;
    JTextField attDat420;
    JButton attNext;
    String date69 = "";
    //mark
    
    String x;
    String yarr[];
    String attName;
    int j=0;
    
    JLabel lastName1;
    JTextField last1;
    JLabel firstName1 = new JLabel("", SwingConstants.CENTER);
    JTextField first1;
    JLabel attDat;
    JTextField dat1;
    private JButton addAttend;
    private JButton addAbsent;
    String attList1;
    String[] attList2arr;
    List<String> attList2 = new ArrayList<>();
    List<String> y = new ArrayList<>();
    int z = 69;
    String[][] attList3;
    String attFName;
    String attLName;
    Boolean answer = true;
    Boolean flicker= null;
    Boolean slower = true;
    
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
    JLabel topDat1;
    JLabel setTopDat;
    JTextField topDat420;
    JLabel setTopTop;
    JTextField topTop420;
    JButton topNext;
    String topDate69;
    String topTop69;
    String topx;
    String topyarr[];
    String topName;
    List<String> topList2 = new ArrayList<>();
    List<String> topy = new ArrayList<>();
    JLabel tFirstName1 = new JLabel("", SwingConstants.CENTER);
    int k=0;
    Boolean topFlicker;
    
    JLabel top1;
    JLabel topDat;
    JTextField dat2;
    JLabel topNam;
    JTextField top2;
    JButton topMarkPass = new JButton("Passed");
    JButton topMarkFail = new JButton("Failure");
    String topList1;
    String[] topList2arr;
    
    String mark = "";  
    
    
    /**
     * Difficult
     */
    private JPanel difficultP= new JPanel(new GridLayout(20,0));
    
    /**
     * Leaderboard
     */

    private JLabel firstL;
    private JLabel secondL;
    private JLabel thirdL;
    
    /**
     * Edit method
     */
    private JLabel editL;
    private JLabel eLast;
    private JTextField eLastT;
    private JLabel eFirst;
    private JTextField eFirstT;
    private JButton eNext;
    private JButton lNameE;
    private JButton fNameE;
    private JButton dobE;
    private JButton ageE;
    private JButton colourE;
    private JButton compE;
    private JButton optE;
    private JTextField inpE;
    private JButton nextE;
    private String eQuery;
    private String eLastS;
    private String eFirstS;
    
    /**
     * Search method
     */
    private JButton confirmS;
    private JTextField iLast;
    private JTextField iFirst;
    private JTextField reply;
    
    private void initialisation()
    {
        
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
    

    
    public void difficult (double percent, String topic, String date)
    {
        
        if(percent<60)
        {
            System.out.println(percent);
            JLabel j =new JLabel ("Only "+percent+"% of the class has completed "+topic+" "+date, SwingConstants.CENTER);
            difficultP.add(j);
            
            
        }
        frame.setContentPane(difficultP);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void difficultMethod ()
    {
        str.difficult();
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
    
    
    
    public void dataProcessSchedule(String date, String topic, String staff)
    {
        String[]data = {date,topic,staff};
        scheduleM.addRow(data);

    }
    
    public void schedule()
    {

        JTable jt = new JTable();
        jt.setModel(scheduleM);
        jt.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        jt.setFillsViewportHeight(true);
        JScrollPane scroll = new JScrollPane(jt);
        scroll.setHorizontalScrollBarPolicy(
        JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setVerticalScrollBarPolicy(
        JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
        JPanel s = new JPanel();
        s.add(scroll);
        frame.setContentPane(s);
        frame.pack();
        frame.setVisible(true);
    }
    

    
    private void editMethod()
    {
        JPanel editP = new JPanel (new GridLayout(8,0));
        
        editL = new JLabel("Please fill in the details of the student you would like to edit", SwingConstants.CENTER);
        eLast = new JLabel("Students last name:", SwingConstants.CENTER);
        eLastT = new JTextField("",  SwingConstants.CENTER);
        eFirst  = new JLabel("Students first name:", SwingConstants.CENTER);
        eFirstT = new JTextField("", SwingConstants.CENTER);
        eNext = new JButton("Continue");
        eNext.addActionListener(listener);
        

        error.setText("");
        editP.add(editL);
        editP.add(error);
        editP.add(eLast);
        editP.add(eLastT);
        editP.add(eFirst);
        editP.add(eFirstT);
        editP.add(eNext);
        editP.add(cancel);

        frame.setContentPane(editP);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void editMethod2()
    {
        JPanel editP2 = new JPanel (new GridLayout(13,0));
        JLabel choiceL = new JLabel("What would you like to edit?",SwingConstants.CENTER);
        JLabel choiceL2 = new JLabel("What would you like to change it to?",SwingConstants.CENTER);
        lNameE= new JButton("Last name");
        fNameE= new JButton("First name");
        dobE= new JButton("Date of birth");
        ageE= new JButton("Age");
        colourE= new JButton("ColourSixGroup");
        compE= new JButton("Compulsory tests");
        optE= new JButton("Optional tests");
        inpE= new JTextField("");
        lNameE.addActionListener(listener);
        fNameE.addActionListener(listener);
        dobE.addActionListener(listener);
        ageE.addActionListener(listener);
        colourE.addActionListener(listener);
        compE.addActionListener(listener);
        optE.addActionListener(listener);
        nextE= new JButton("Confirm change");
        nextE.addActionListener(listener);
                
        editP2.add(choiceL);
        editP2.add(error);
        editP2.add(lNameE);
        editP2.add(fNameE);
        editP2.add(dobE);
        editP2.add(ageE);
        editP2.add(colourE);
        editP2.add(compE);
        editP2.add(optE);
        editP2.add(choiceL2);
        editP2.add(inpE);
        editP2.add(nextE);
        editP2.add(cancel);
        
        frame.setContentPane(editP2);
        frame.pack();
        frame.setVisible(true);
    }
    
    public void leaderboard(String sFirst, int first, String sSecond, int second, String sThird, int third)
    {
        JPanel leaderboardP = new JPanel (new GridLayout(4,0));
        leaderboardP.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        firstL = new JLabel("First Place: "+sFirst+" with "+first+" tests completed!", SwingConstants.CENTER);
        secondL = new JLabel("Second Place: "+sSecond+" with "+second+" tests completed!", SwingConstants.CENTER);
        thirdL = new JLabel("Third Place: "+sThird+" with "+third+" tests completed!", SwingConstants.CENTER);
        
        leaderboardP.add(firstL);
        leaderboardP.add(secondL);
        leaderboardP.add(thirdL);
        //leaderboardP.add(cancel);
        
        frame.setContentPane(leaderboardP);
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
    
    private void inpTopicMark()
    {
        JPanel inpTopUser = new JPanel(new GridLayout(14,0));
        inpTopUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        error.setForeground(Color.RED);
        
        topDat1 = new JLabel("Insert date of topic:", SwingConstants.CENTER);
        error = new JLabel("", SwingConstants.CENTER);
        setTopDat = new JLabel ("Insert required date:", SwingConstants.CENTER);
        topDat420 = new JTextField("");
        setTopTop = new JLabel ("Insert required topic:", SwingConstants.CENTER);
        topTop420 = new JTextField("");
        topNext = new JButton("Next");
        
        inpTopUser.add(topDat1);
        inpTopUser.add(error);
        inpTopUser.add(setTopDat);
        inpTopUser.add(topDat420);
        inpTopUser.add(setTopTop);
        inpTopUser.add(topTop420);
        inpTopUser.add(topNext);
        topNext.addActionListener(listener);
        inpTopUser.add(cancel);
        
        topDate69 = topDat420.getText();
        topTop69 = topTop420.getText();
        
        frame.setContentPane(inpTopUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void markTopicMethod()
    {
        JPanel topUser = new JPanel(new GridLayout(14,0));
        topUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        
        
        error.setForeground(Color.RED);
        error = new JLabel("");

        topList1 = str.getTopic(topDat420.getText(), topTop420.getText());
        if(topList1.matches(""))
        {
            JOptionPane.showMessageDialog(null, "Topic not found or all students have completed this topic.");
            mainPage();
        }
        
        
        topList2arr = topList1.split("#");
        topList2 = Arrays.asList(topList2arr);
        
        top1 = new JLabel("Mark Pass or Fail", SwingConstants.CENTER);
        topUser.add(top1);
        topUser.add(error);
        topx = topList2.get(k);
        topyarr = topx.split("-");
        topy = Arrays.asList(topyarr);
        topName = topy.get(0) + " " + topy.get(1);
        tFirstName1 = new JLabel(topName, SwingConstants.CENTER);
        topMarkPass = new JButton("Topic completed");
        topMarkFail = new JButton("Topic not yet completed");
        topMarkPass.addActionListener(listener);
        topMarkFail.addActionListener(listener);
        
        topUser.add(tFirstName1);
        topUser.add(topMarkPass);
        topUser.add(topMarkFail);
        topUser.add(cancel);
        frame.setContentPane(topUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void searchMethod()
    {
        JPanel searchP = new JPanel(new GridLayout(9,0));
        searchP.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        JLabel searchL = new JLabel("Please fill in the following fields:", SwingConstants.CENTER);
        JLabel iLastL = new JLabel("Last name:", SwingConstants.CENTER);
        iLast = new JTextField("");
        JLabel iFirstL = new JLabel("First name:", SwingConstants.CENTER);
        iFirst = new JTextField("");
        confirmS = new JButton("Search");
        confirmS.addActionListener(listener);
        reply = new JTextField("");
        reply.setEditable(false);
        
        searchP.add(searchL);
        searchP.add(error);
        searchP.add(iLastL);
        searchP.add(iLast);
        searchP.add(iFirstL);
        searchP.add(iFirst);
        searchP.add(confirmS);
        searchP.add(reply);
        searchP.add(cancel);
        
        frame.setContentPane(searchP);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void setDateAtt()
    {
        JPanel attDatUser = new JPanel(new GridLayout(14,0));
        attDatUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        error.setForeground(Color.RED);
        
        attDat1 = new JLabel("Insert attendance date:", SwingConstants.CENTER);
        error = new JLabel("", SwingConstants.CENTER);
        setAttDat = new JLabel ("Insert required date:", SwingConstants.CENTER);
        attDat420 = new JTextField("");
        attNext = new JButton("Next");
        
        attDatUser.add(attDat1);
        attDatUser.add(error);
        attDatUser.add(setAttDat);
        attDatUser.add(attDat420);
        attDatUser.add(attNext);
        attNext.addActionListener(listener);
        
        date69 = attDat420.getText();
        
        frame.setContentPane(attDatUser);
        frame.pack();
        frame.setVisible(true);
    }
    
    private void attendMethod()
    {
        JPanel attUser = new JPanel(new GridLayout(14,0));
        attUser.setBorder(BorderFactory.createEmptyBorder(0, gap, gap, gap));
        
        
        
        error.setForeground(Color.RED);
        error = new JLabel("");
        attList1 = str.getAttend();
        attList2arr = attList1.split("#");
        attList2 = Arrays.asList(attList2arr);
        
        JLabel att1= new JLabel("Please mark the student as Attended or absent", SwingConstants.CENTER);
        x = attList2.get(0);
        yarr = x.split("-");
        y = Arrays.asList(yarr);
        attName = y.get(0) + " " + y.get(1);
        firstName1.setText(attName);
        attUser.add(att1);
        attUser.add(error);
        addAttend = new JButton("Attended");
        addAbsent = new JButton("Absent");
        addAttend.addActionListener(listener);
        addAbsent.addActionListener(listener);


           
        attUser.add(firstName1);
        attUser.add(addAttend);
        attUser.add(addAbsent);
        attUser.add(cancel);
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
                setDateAtt();
            }
            
            if (event.getSource() == topic) 
            {
                topicMethod();
            }
            if (event.getSource() == markTopic) 
            {
                inpTopicMark();
            }
            
            if (event.getSource() == search) 
            {
                searchMethod();
            }
            
            if (event.getSource() == edit) 
            {
                editMethod();
            }
            
            if (event.getSource() == schedule) 
            {
                str.printSchedule();
            }
            
            if (event.getSource() == uncompleted) 
            {
                str.difficult();
                //difficultMethod();
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
            
            /**
             * attend methods
             */
            if (event.getSource() == attNext)
            {
                String daate = attDat420.getText();
                Boolean good=true;
                try
                {
                    String[] parts = daate.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                if(attDat420.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                    good=false;
                }
                else if (daate.length() != 10)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                else if (daate.charAt(4) != '-' || daate.charAt(7) != '-')
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                } 
                else if (good)
                {
                    str.addAttendance(daate);
                    
                    attendMethod();
                }
                
            }
            if(event.getSource() == addAttend)
            {
                date69 = attDat420.getText();
                if(j==0)
                {
                    x = attList2.get(j);
                    yarr = x.split("-");
                    y = Arrays.asList(yarr);
                    attName = y.get(0) + " " + y.get(1);
                    str.markAttendance(date69, y.get(0), y.get(1), true);
                    j++;
                    System.out.println(j);
                }
                else
                {
                    j++;
                    System.out.println(j);
                    z = 71;
                    str.markAttendance(date69, y.get(0), y.get(1), true);
                    flicker = false;
                    z = 69;
                }
                if (j == attList2.size())
                {
                    mainPage();
                }
                System.out.println(j);
                System.out.println("yeet");
                flicker=true;
                x = attList2.get(j);
                yarr = x.split("-");
                y = Arrays.asList(yarr);
                attName = y.get(0) + " " + y.get(1);
                firstName1.setText(attName);
            }
            
            if(event.getSource() == addAbsent)
            {
                date69 = attDat420.getText();
                if(j==0)
                {
                    x = attList2.get(j);
                    yarr = x.split("-");
                    y = Arrays.asList(yarr);
                    attName = y.get(0) + " " + y.get(1);
                    str.markAttendance(date69, y.get(0), y.get(1), false);
                    j++;
                    System.out.println(j);
                }
                else
                {
                    j++;
                    System.out.println(j);
                    z = 71;
                    str.markAttendance(date69, y.get(0), y.get(1), false);
                    flicker = false;
                    z = 69;
                }
                if (j == attList2.size())
                {
                    mainPage();
                }
                System.out.println(j);
                System.out.println("yeet");
                flicker=true;
                x = attList2.get(j);
                yarr = x.split("-");
                y = Arrays.asList(yarr);
                attName = y.get(0) + " " + y.get(1);
                firstName1.setText(attName);
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
            
            if (event.getSource() == topNext)
            {
                String daate = topDat420.getText();
                Boolean good=true;
                try
                {
                    String[] parts = daate.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                }
                catch(ArrayIndexOutOfBoundsException e)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                if(topDat420.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                    good=false;
                }
                else if (daate.length() != 10)
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                }
                else if (daate.charAt(4) != '-' || daate.charAt(7) != '-')
                {
                    good=false;
                    error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                } 
                else if (good)
                {
                    //str.addAttendance(daate);
                    topList1 = str.getTopic(topDat420.getText(), topTop420.getText());
                    markTopicMethod();
                }
            }
            if(event.getSource() == topMarkPass)
            {
                topDate69 = topDat420.getText();
                if(k==0)
                {
                    topx = topList2.get(k);
                    topyarr = topx.split("-");
                    topy = Arrays.asList(topyarr);
                    topName = topy.get(0) + " " + topy.get(1);
                    str.markTopic(topDat420.getText(), topTop420.getText(), true);
                    k++;
                    System.out.println(k);
                }
                else
                {
                    k++;
                    System.out.println(k);
                    //z = 71;
                    str.markTopic(topDat420.getText(), topTop420.getText(), true);
                    topFlicker = false;
                    //z = 69;
                }
                if (k == topList2.size())
                {
                    mainPage();
                }
                System.out.println(k);
                System.out.println("yeet");
                topFlicker=true;
                topx = topList2.get(k);
                topyarr = topx.split("-");
                topy = Arrays.asList(topyarr);
                topName = topy.get(0) + " " + topy.get(1);
                tFirstName1.setText(topName);
            }
            
            if(event.getSource() == topMarkFail)
            {
                topDate69 = topDat420.getText();
                if(k==0)
                {
                    topx = topList2.get(k);
                    topyarr = topx.split("-");
                    topy = Arrays.asList(topyarr);
                    topName = topy.get(0) + " " + topy.get(1);
                    str.markTopic(topDat420.getText(), topTop420.getText(), false);
                    k++;
                    System.out.println(k);
                }
                else
                {
                    k++;
                    System.out.println(k);
                    //z = 71;
                    str.markTopic(topDat420.getText(), topTop420.getText(), false);
                    topFlicker = false;
                    //z = 69;
                }
                if (k == topList2.size())
                {
                    mainPage();
                }
                System.out.println(k);
                System.out.println("yeet");
                topFlicker=true;
                topx = topList2.get(k);
                topyarr = topx.split("-");
                topy = Arrays.asList(topyarr);
                topName = topy.get(0) + " " + topy.get(1);
                tFirstName1.setText(topName);
            }
            
             if (event.getSource() == eNext) 
            {
                if(eLastT.getText().equals("")||eFirstT.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                } 
                else
                {
                    eLastS=eLastT.getText();
                    eFirstS=eFirstT.getText();
                    editMethod2();
                    
                }
                
                
            }
            if (event.getSource() == lNameE) 
            {
                lNameE.setEnabled(false);
                fNameE.setEnabled(true);
                dobE.setEnabled(true);
                ageE.setEnabled(true);
                colourE.setEnabled(true);
                compE.setEnabled(true);
                optE.setEnabled(true);
                eQuery= "LastName";
            } 
            
            if (event.getSource() == fNameE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(false);
                dobE.setEnabled(true);
                ageE.setEnabled(true);
                colourE.setEnabled(true);
                compE.setEnabled(true);
                optE.setEnabled(true);
                eQuery= "FirstName";
            } 
            
            if (event.getSource() == dobE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(true);
                dobE.setEnabled(false);
                ageE.setEnabled(true);
                colourE.setEnabled(true);
                compE.setEnabled(true);
                optE.setEnabled(true);
                eQuery= "DateOfBirth";
            } 
            
            if (event.getSource() == ageE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(true);
                dobE.setEnabled(true);
                ageE.setEnabled(false);
                colourE.setEnabled(true);
                compE.setEnabled(true);
                optE.setEnabled(true);
                eQuery= "Age";
            } 
            
            if (event.getSource() == colourE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(true);
                dobE.setEnabled(true);
                ageE.setEnabled(true);
                colourE.setEnabled(false);
                compE.setEnabled(true);
                optE.setEnabled(true);
                eQuery= "ColourSixGroup";
            } 
            
            if (event.getSource() == compE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(true);
                dobE.setEnabled(true);
                ageE.setEnabled(true);
                colourE.setEnabled(true);
                compE.setEnabled(false);
                optE.setEnabled(true);
                eQuery= "CompulsoryTests";
            } 
            
            if (event.getSource() == optE) 
            {
                lNameE.setEnabled(true);
                fNameE.setEnabled(true);
                dobE.setEnabled(true);
                ageE.setEnabled(true);
                colourE.setEnabled(true);
                compE.setEnabled(true);
                optE.setEnabled(false);
                eQuery= "OptionalTests";
            }
            if (event.getSource() == nextE) 
            {
                String ans= inpE.getText();
                Boolean good=true;
                int parse=-2;
                switch(eQuery)
                {
                    case "LastName":
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        } 
                        else
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "FirstName":
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        } 
                        else
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "DateOfBirth":
                        try
                        {
                            String[] parts = ans.split("-");
                            String year = parts[0];
                            String month = parts[1];
                            String day = parts[2];
                        }
                        catch(ArrayIndexOutOfBoundsException e)
                        {
                            good=false;
                            error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                        }
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        }
                        else if (ans.length() != 10)
                        {
                            good=false;
                            error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                        }
                        else if (ans.charAt(4) != '-' || ans.charAt(7) != '-')
                        {
                            good=false;
                            error.setText("Please ensure date contains only integers seperated with - (yyyy-mm-dd)");
                        }         
                        else if (good)
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "Age":
                        try
                        {
                            parse= parseInt(ans);
                        }
                        catch(NumberFormatException e)
                        {
                            error.setText("Please input an integer for this field");
                        }
                
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        }
                        else if (parse<=0)
                        {
                            error.setText("Please input an integer higher than 0 for this field");
                        }
                        else if(good)
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "ColourSixGroup":
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        } 
                        else
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "CompulsoryTests":
                        try
                        {
                            parse= parseInt(ans);
                        }
                        catch(NumberFormatException e)
                        {
                            error.setText("Please input an integer for this field");
                        }
                
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        }
                        else if (parse<0)
                        {
                            error.setText("Please input an integer higher than 0 for this field");
                        }
                        else if(good)
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    case "OptionalTests":
                        try
                        {
                            parse= parseInt(ans);
                        }
                        catch(NumberFormatException e)
                        {
                            error.setText("Please input an integer for this field");
                        }
                
                        if(inpE.getText().equals(""))
                        {
                            error.setText("Please fill out all fields");
                        }
                        else if (parse<0)
                        {
                            error.setText("Please input an integer higher than 0 for this field");
                        }
                        else if(good)
                        {
                            str.getExists(eLastS, eFirstS, eQuery, ans);
                            notify.setText("If that student exists their details have been updated.");
                            mainPage();
                        }
                        break;
                        
                    default:
                        error.setText("Please select a field to edit");
                        break;
                }
            }
            if (event.getSource() == confirmS) 
            {
                if(iLast.getText().equals("")||iFirst.getText().equals(""))
                {
                    error.setText("Please fill out all fields");
                } 
                else
                {
                    String d=str.printStudents(iLast.getText(), iFirst.getText());
                    reply.setText(d);
                    
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
