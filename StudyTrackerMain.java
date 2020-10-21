/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Liam Fifield
 * @version 12/10/2020
 */

import java.util.*;
public class StudyTrackerMain 
{
    /**
     * Initialization of choice variables 
     */
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
    
    /**
     * runApp is the method that essentially runs all the main methods.
     * It features a basic switch that will run various other methods
     * that do different things.
     */
    public void runApp()
    {
        System.out.println("Welcome to the StudyTracker Application!");
        int option = CONTINUE;
        while (option!=EXIT)
        {   
            str.badge();
            System.out.println("\nPlease select what you would like to do");
            System.out.println("[1] Add a student to the database");
            System.out.println("[2] Record attendance");
            System.out.println("[3] Add or mark parts, topics, or tests");
            System.out.println("[4] Search the database for a specific student");
            System.out.println("[5] Edit the details of an existing student");
            System.out.println("[6] Print schedule");
            System.out.println("[7] Search for topics that havent been widely completed");
            System.out.println("[8] Lookup the student leaderboard");
            System.out.println("[9] Exit"); 
            try{
                Scanner s = new Scanner(System.in);
                option = s.nextInt();
                switch(option)
                {
                    case ADD:
                        addMethod();
                        break;
                 
                    case ATTENDANCE:
                        attendMethod();
                        break;
                    
                    case TOPIC:
                        topicMethod();
                        break;
                    
                    case SEARCH:
                        searchMethod();
                        break;
                
                    case EDIT:
                        editMethod();
                        break;
                    
                    case SCHEDULE:
                        str.printSchedule();
                        break;
                        
                    case DIFFICULT:
                        str.difficult();
                        break;
                        
                    case LEADERBOARD:
                        str.leaderboard();
                        break;
                        
                    case EXIT:
                        System.out.println("Goodbye!");
                        break;
                    
                    default:
                        System.out.println("Please enter a valid option [1-4]");
                        break;
                    
                }
            }
        
            catch(InputMismatchException e)
            {
                System.out.println("To pick an option, type the corresponding integer");
            }
        }
    }
    /**
     * addMethod is a method that will add a new student to the database.
     * 

     */
    public void addMethod()
    {
        Scanner s =new Scanner(System.in);
        System.out.println("Please enter their first name");
        String fName = s.nextLine();
        
        System.out.println("Please enter their last name");
        String lName = s.nextLine();
        String dob;
                              
        while (true)
        {
            System.out.println("Please enter their date of birth in this format:\n yyyy-mm-dd");
            dob = s.nextLine();
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
        int age = s.nextInt();
                        
        System.out.println("Please enter their colour six group");
        s.nextLine();
        String colour = s.nextLine();
                        
        System.out.println("\n\n");
        int key = 1;
        while(key==1)
        {
            System.out.println("Are the following details correct?\n [yes] [no]");
            System.out.println("Name: "+fName+" "+lName 
                + "\nDate of Birth: "+dob+ "\nAge: "+age+"\nColour six group: " + colour);
            String ans = s.nextLine();
            String correct=ans.toLowerCase();
            switch(correct)
            {
                case "yes":
                    str.addStudents(lName, fName, dob, age, colour);
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
    
    
    /**
     * attendMethod is a method that is used to mark attendance.
     */
    public void attendMethod()
    {
        Scanner s =new Scanner(System.in);        
        String lesson;
        while (true)
        {
            System.out.println("Please enter the date of the lesson in the following format: ");
            System.out.println("yyyy-mm-dd");
            lesson = s.nextLine();
            if (lesson.length() == 10)
            {
                if (lesson.charAt(4) == '-' && lesson.charAt(7) == '-')
                {
                    String[] parts = lesson.split("-");
                    String year = parts[0];
                    String month = parts[1];
                    String day = parts[2];
                    if(year.matches("[a-zA-Z]+") == false && month.matches("[a-zA-Z]+") == false && day.matches("[a-zA-Z]+") == false)
                    {
                        break;
                    }
                    else
                    {
                        System.out.println("please insert only numbers");
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
        int key2 = 1;
        while(key2==1)
        {
            System.out.println("Is this date correct?\n [yes] [no]");
            System.out.println(lesson);
            String ans = s.nextLine();
            String correct=ans.toLowerCase();
            switch(correct)
            {
                case "yes":
                    str.addLesson(lesson);
                    String cLesson="`"+lesson+"`";
                    str.markAttendance(cLesson);
                    key2=2;
                    break;
                                
                case "no":
                    System.out.println("Lesson not saved.\n");
                    key2=2;
                    break;
                                
                default:
                    System.out.println("Please enter [yes] or [no]\n");
                    break;
            }
        }
    }
    
    /**
     * topicMethod is a method that allows the staff member to add topics
     * to different dates. 
     */
    public void topicMethod()
    {
        Scanner s =new Scanner(System.in);
        System.out.println("\nWhat would you like to do?");
        System.out.println("[1] Add a new topic, part, or test?");
        System.out.println("[2] Mark a topic, part, or test?");
        int choices = 0;
        while((choices!=1)&&(choices!=2))
        {                
            try
            {
                choices=s.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter [1] or [2].");
                choices=s.nextInt();
            }
            if(choices<1||choices>2)
            {
                System.out.println("Please enter [1] or [2].");
            }
        }
        
        while (choices!=6)
        {
            switch(choices)
            {
                case 1:
                    String date;
                    s.nextLine();
                    while (true)
                    {
                        System.out.println("Please enter the date of the topic/part/test in the following format: ");
                        System.out.println("yyyy-mm-dd");
                        date = s.nextLine();
                        if (date.length() == 10)
                        {
                            if (date.charAt(4) == '-' && date.charAt(7) == '-')
                            {
                                String[] parts = date.split("-");
                                String year = parts[0];
                                String month = parts[1];
                                String day = parts[2];
                                if(year.matches("[a-zA-Z]+") == false && month.matches("[a-zA-Z]+") == false && day.matches("[a-zA-Z]+") == false)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("please insert only numbers");
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
                    
                    System.out.println("Please enter a name for the topic/test/part:");
                    String topic = s.nextLine();
                    
                    System.out.println("Please enter the full name of the coordinating supervisor:");
                    String name = s.nextLine();
                    String comp="";
                    Boolean compulsory=null;
                    int key3=1;
                    while (key3==1)
                    {
                        System.out.println("Is this topic/test/part compulsory?[yes][no]");
                        comp=s.nextLine();
                        comp=comp.toLowerCase();
                        switch(comp)
                        {
                            case "yes":
                                compulsory=true;
                                key3=2;
                                break;
                                
                            case "no":
                                compulsory=false;
                                key3=2;
                                break;
                                
                            default:
                                System.out.println("Please enter [yes] or [no]");
                                break;
                        }
                    }
                    int key2 = 1;
                    while(key2==1)
                    {
                        System.out.println("Are the following details correct?\n [yes] [no]");
                        System.out.println("Date: "+date);
                        System.out.println("Topic: "+topic);
                        System.out.println("Coordinating supervisor: "+ name);
                        System.out.println("Compulsory: "+comp);
                        String ans = s.nextLine();
                        String correct=ans.toLowerCase();
                        switch(correct)
                        {
                            case "yes":
                                str.updateSchedule(date, topic, name, compulsory);
                                key2=2;
                                break;
                                
                            case "no":
                                System.out.println("Topic not saved.\n");
                                key2=2;
                                break;
                                
                            default:
                                System.out.println("Please enter [yes] or [no]\n");
                                break;
                        }
                    }
                    choices=6;
                    break;
                    
                case 2:
                    str.printSchedule();
                    s.nextLine();
                    while (true)
                    {
                        System.out.println("Please enter the date of the topic/part/test in the following format: ");
                        System.out.println("yyyy-mm-dd");
                        date = s.nextLine();
                        if (date.length() == 10)
                        {
                            if (date.charAt(4) == '-' && date.charAt(7) == '-')
                            {
                                String[] parts = date.split("-");
                                String year = parts[0];
                                String month = parts[1];
                                String day = parts[2];
                                if(year.matches("[a-zA-Z]+") == false && month.matches("[a-zA-Z]+") == false && day.matches("[a-zA-Z]+") == false)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("please insert only numbers");
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
                    System.out.println("Please enter the name of the topic");
                    topic=s.nextLine();
                    
                    key2 = 1;
                    while(key2==1)
                    {
                        System.out.println("Are the following details correct?\n [yes] [no]");
                        System.out.println("Date: "+date);
                        System.out.println("Topic: "+topic);
                        String ans = s.nextLine();
                        String correct=ans.toLowerCase();
                        switch(correct)
                        {
                            case "yes":
                                str.markTopic(date, topic);
                                key2=2;
                                break;
                                
                            case "no":
                                key2=2;
                                break;
                                
                            default:
                                System.out.println("Please enter [yes] or [no]\n");
                                break;
                        }
                    }
                    choices=6;
                    break;
            }
        }
    }
    
    
    /**
     * searchMethod is a method that allows staff member to search for different
     * students over a range of criteria.
     */
    public void searchMethod()
    {
        Scanner s =new Scanner(System.in);
        System.out.println("\nWhat criteria would you like to search by?");
        System.out.println("[1]Last Name");
        System.out.println("[2]First Name");
        System.out.println("[3]Date of Birth");
        System.out.println("[4]Age");
        System.out.println("[5]ColourSixGroup");
        System.out.println("[6]Exit search menu");
                        
        int choices = 0;
        while((choices!=1)&&(choices!=2)&&(choices!=3)&&(choices!=4)&&(choices!=5)&&(choices!=6))
        {    
                            
            try
            {
                choices=s.nextInt();
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please input a number from 1-6.");
                choices=s.nextInt();
            }
            if(choices<1||choices>6)
            {
                System.out.println("Please enter a value between 1-6");
            }
        }
        String query;
        s.nextLine();
        while (choices!=6)
        {
            switch(choices)
            {
                case 1:
                    System.out.println("Please enter a last name");
                    query=s.nextLine();
                    str.printStudents("LastName", query);
                    choices=6;
                    break;
                                
                case 2:
                    System.out.println("Please enter a first name");
                    query=s.nextLine();
                    str.printStudents("FirstName", query);
                    choices=6;
                    break;
                                
                case 3:
                    while(true)
                    {
                        System.out.println("Please enter a date of birth (yyyy-mm-dd format)");
                        query=s.nextLine();
                        if (query.length() == 10)
                        {
                            if (query.charAt(4) == '-' && query.charAt(7) == '-')
                            {
                                String[] parts = query.split("-");
                                String year = parts[0];
                                String month = parts[1];
                                String day = parts[2];
                                if(year.matches("[a-zA-Z]+") == false && month.matches("[a-zA-Z]+") == false && day.matches("[a-zA-Z]+") == false)
                                {
                                    break;
                                }
                                else
                                {
                                    System.out.println("please insert only numbers");
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
                    str.printStudents("DateOfBirth", query);
                    choices=6;
                    break;
                                
                case 4:
                    System.out.println("Please enter an age");
                    query=s.nextLine();
                    str.printStudents("Age", query);
                    choices=6;
                    break;
                                
                case 5:
                    System.out.println("Please enter a ColourSixGroup");
                    query=s.nextLine();
                    str.printStudents("ColourSixGroup", query);
                    choices=6;
                    break;
            }
        }
    }
    

    /**
     * editMethod is a method that allows the students information to be edited.
     * It works by loading the student information, allowing the user to choose input,
     * and if the user exists the data is changed.
     */
    
    public void editMethod()
    {
        String delNameLast;
        String delNameFirst;
        Scanner s =new Scanner(System.in);
        System.out.println("Loading in student information");
        str.loadStudents();
        System.out.println("\nEnter the last name of the student that you wish to edit.");
        
        delNameLast=s.nextLine();
        System.out.println("\nEnter the first name of the student that you wish to edit.");
        delNameFirst=s.nextLine();
        str.getExists(delNameLast, delNameFirst);
    }
    

    
    
    public static void main(String[] args) 
    {
        StudyTrackerMain s = new StudyTrackerMain();
        s.runApp();
    }
    
}