/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.table.DefaultTableModel;
/**
 * This class contains all methods that communicate with the SQL database.
 * @version 12/10/2020
 * @author Liam Fifield
 */
public class StudyTrackerReader 
{
    
    /**
     * getConnection establishes a connection to the SQL database
     * @return
     * @throws SQLException 
     */
    
    public static Connection getConnection() throws SQLException
    { 
       String url= "jdbc:mysql://localhost:3306/StudentTracker";
       String user= "Admin";
       String pass = "Studenttracker1!";
       Connection con = DriverManager.getConnection(url, user, pass);
       return con;
    }
    
    /**
     * addStudents adds a student, using user input, to the SQL database.
     * @param lName
     * @param fName
     * @param dob
     * @param age
     * @param colour 
     */
    public void addStudents(String lName, String fName, String dob, int age, String colour)
    {
        String sql = "INSERT INTO Students (LastName, FirstName, DateOfBirth, Age, ColourSixGroup, CompulsoryTests, OptionalTests, Badge) VALUES"
                + "('"+lName+"', '"+fName+"', '"+dob+"', '"+age+"', '"+colour+"', '0', '0', 'None');";
        String att ="INSERT INTO Attendance (LastName, FirstName) VALUES('"+lName+"', '"+fName+"');";
        Connection con =null;
        Statement stmt = null;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt.executeUpdate(sql);
            stmt.executeUpdate(att);
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("Student has been added to database\n");
    }
    /**
     * Allows a lesson column to be added to the attendance table in the SQL database.
     * @param lesson 
     */
    public void addLesson(String lesson)
    {
        Connection con =null;
        Statement stmt = null;
        String sql ="ALTER TABLE Attendance ADD `"+lesson+"` varchar(10);";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("Lesson created successfully.");
    }
    
    /**
     * Used for the searchMethod. Prints out all students that match user input.
     * @param input
     * @param query 
     */
    public void printStudents(String input, String query)
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        String sql ="SELECT*FROM Students WHERE "+input+ " LIKE '"+query+"';";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                Student student = new Student(null, null, null, 0, null,0,0,null);
                student.setLName(rs.getString("LastName"));
                student.setFName(rs.getString("FirstName"));
                student.setDOB(rs.getString("DateOfBirth"));
                student.setAge(rs.getInt("Age"));
                student.setColour(rs.getString("ColourSixGroup"));
                student.setoTest(rs.getInt("OptionalTests"));
                student.setcTest(rs.getInt("CompulsoryTests"));
                student.setBadge(rs.getString("Badge"));
                System.out.println(student.toString());
                count++;
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println(count+" results found.");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
    
    /**
     * Prints all students in the SQL database.
     */
    public void loadStudents()
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql ="SELECT*FROM Students;";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                Student student = new Student(null, null, null, 0, null, 0, 0,null);
                student.setLName(rs.getString("LastName"));
                student.setFName(rs.getString("FirstName"));
                student.setDOB(rs.getString("DateOfBirth"));
                student.setAge(rs.getInt("Age"));
                student.setColour(rs.getString("ColourSixGroup"));
                student.setoTest(rs.getInt("OptionalTests"));
                student.setcTest(rs.getInt("CompulsoryTests"));
                student.setBadge(rs.getString("Badge"));
                System.out.println("\n"+student.toString());
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    
    /**
     * This method returns whether or not a student exists.
     * @param delNameLast
     * @param delNameFirst 
     */
    public void getExists (String delNameLast, String delNameFirst)
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        String lName="";
        String fName="";
        String load ="SELECT*FROM Students;";
        Boolean exists = false;
        StudyTrackerMain stm = new StudyTrackerMain();
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(load);
            while (rs.next())
            {
                
                lName=(rs.getString("LastName"));
                fName=(rs.getString("FirstName"));
                
                
                if ((lName.matches(delNameLast))&&(fName.matches(delNameFirst)))
                {
                    exists=true;
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        if (exists==true)
        {
            System.out.println("\nWhat would you like to edit?");
            System.out.println("[1] Last Name");
            System.out.println("[2] First Name");
            System.out.println("[3] Date of Birth");
            System.out.println("[4] Age");
            System.out.println("[5] ColourSixGroup");
            System.out.println("[6] Compulsory tests completed");
            System.out.println("[7] Optional tests completed");
            System.out.println("[8] Cancel");
            int choices = 0;
            String choice;
            Scanner s = new Scanner(System.in);
            while((choices!=1)&&(choices!=2)&&(choices!=3)&&(choices!=4)&&(choices!=5)&&(choices!=6)&&(choices!=7)&&(choices!=8))
            {    
                            
                try
                {
                    choices=s.nextInt();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Please input a number from 1-8.");
                    choices=s.nextInt();
                }
                if(choices<1||choices>8)
                {
                    System.out.println("Please enter a value between 1-8");
                }
            }
            String query;
            System.out.println("\nPlease input change:");
            while (choices!=8)
            {
                switch(choices)
                {
                    case 1:
                        try
                        {
                            s.nextLine();
                            String input=s.nextLine();
                            choice="UPDATE Students SET LastName='"+input+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        }
                        choices=8;
                        break;
                                
                    case 2:
                        try
                        {
                            s.nextLine();
                            String input=s.nextLine();
                            choice="UPDATE Students SET FirstName='"+input+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                                
                    case 3:
                        try
                        {
                            while(true)
                            {
                                System.out.println("Please enter a date of birth (yyyy-mm-dd format)");
                                s.nextLine();
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
                            choice="UPDATE Students SET DateOfBirth='"+query+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                                
                    case 4:
                        try
                        {   
                            int inp;
                            while(true)
                            {
                                try
                                {
                                    inp=s.nextInt();
                                    if (inp>0)break;
                                    else System.out.println("Please enter a valid integer");
                                }
                                catch (InputMismatchException e)
                                {
                                    System.out.println("Please enter an integer");
                                }
                                
                            }
                            
                            choice="UPDATE Students SET Age='"+inp+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                                
                    case 5:
                        try
                        {
                            String input=s.nextLine();
                            choice="UPDATE Students SET ColourSixGroup='"+input+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                        
                    case 6:
                        try
                        {
                            int inp;
                            while(true)
                            {
                                try
                                {
                                    inp=s.nextInt();
                                    if (inp>=0)break;
                                    else System.out.println("Please enter a valid integer");
                                }
                                catch (InputMismatchException e)
                                {
                                    System.out.println("Please enter an integer");
                                }
                                
                            }
                            choice="UPDATE Students SET CompulsoryTests='"+inp+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                        
                    case 7:
                        try
                        {
                            int inp;
                            while(true)
                            {
                                try
                                {
                                    inp=s.nextInt();
                                    if (inp>=0)break;
                                    else System.out.println("Please enter a valid integer");
                                }
                                catch (InputMismatchException e)
                                {
                                    System.out.println("Please enter an integer");
                                }
                                
                            }
                            choice="UPDATE Students SET OptionalTests='"+inp+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                            con=getConnection();
                            stmt= con.createStatement();
                            stmt.executeUpdate(choice);
                            stmt.close();
                            con.close();
                        }
                        catch(SQLException e)
                        {
                            System.out.println(e);
                        } 
                        choices=8;
                        break;
                }
            }
        }
        else
        {
            System.out.println("That student doesnt exist");
        }
    }
    
    /**
     * This method allows the user to mark attendance in the Attendance table.
     * @param date 
     */
    public String getAttend()
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        Scanner s = new Scanner(System.in);
        String last;
        String first;
        String list = "";
        String here;
        
        String absent;
        String sql ="SELECT*FROM Students;";
        try
        {   
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                last=(rs.getString("LastName"));
                first=(rs.getString("FirstName"));
                list = last + "-" + last + "+";
                System.out.println("Has "+first+" "+last+ " attended? [yes] [no]");
            }
            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public void markAttendance(String date)
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        Scanner s = new Scanner(System.in);
        String ans;
        String last;
        String first;
        String here;
        int key=0;
        String absent;
        String sql ="SELECT*FROM Students;";
        try
        {   
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                last=(rs.getString("LastName"));
                first=(rs.getString("FirstName"));
                System.out.println("Has "+first+" "+last+ " attended? [yes] [no]");
                key=0;
                while(key!=1)
                {
                    ans=s.nextLine();
                    ans=ans.toLowerCase();
                    switch(ans)
                    {
                        case "yes":
                            here="UPDATE Attendance SET "+date+"='Attended' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(here);  
                            key=1;
                            break;
                        
                        case"no":
                            absent="UPDATE Attendance SET "+date+"='Absent' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(absent);
                            key=1;
                            break;
                            
                        default:
                            System.out.println("Please enter [yes] or [no].");
                            break;
                    }
                    
                }
            }
            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("The roll has been marked.");
    }
    
    
    /**
     * This method updates the schedule table in the SQL database.
     * @param date
     * @param topic
     * @param staff
     * @param compulsory 
     */
    public void updateSchedule(String date, String topic, String staff, Boolean compulsory)
    {
        String sql = "INSERT INTO Schedule (Date, Topic, Staff) VALUES"
                + "('"+date+"', '"+topic+"', '"+staff+"');";
        String top;
        String read="SELECT*FROM Students;";
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String first;
        String last;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            stmt.executeUpdate(sql);
            
            rs=stmt2.executeQuery(read);
            while(rs.next())
            {
                last=(rs.getString("LastName"));
                first=(rs.getString("FirstName"));
                top="INSERT INTO Topics (LastName, FirstName, Topic, Date, Completed, Compulsory) VALUES ('"+last+"', '"+first+"', '" +topic+"', '"+date+"', 'No', '"+compulsory+"');";
                stmt.executeUpdate(top);
            }
            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        System.out.println("Topic has been recorded\n");
    }
    
    /**
     * This method prints out the schedule from the SQL database.
     */
    public void printSchedule()
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        String sql ="SELECT*FROM Schedule;";
        String date;
        String topic;
        String staff;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                date=rs.getString("Date");
                topic=rs.getString("Topic");
                staff=rs.getString("Staff");
                System.out.println("Date: "+date+"\tTopic: "+topic+
                        "\t\tCoordinating Supervisor: "+staff);
            }

            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * This method allows topics to be marked (in the Topics table in SQL)
     * using user input.
     * @param date
     * @param topic 
     */
    public void markTopic(String date, String topic)
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String sql ="SELECT*FROM Topics WHERE Topic='"+topic+
                "' AND Date='"+date+"' AND Completed='No'" +";";
        String update;
        String last;
        String first;
        String ans;
        Boolean compulsory=null;
        Scanner s= new Scanner(System.in);
        int key;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                last=(rs.getString("LastName"));
                first=(rs.getString("FirstName"));
                compulsory=rs.getBoolean("Compulsory");
                key=0;
                while(key!=1)
                {
                    System.out.println("Has "+first+" "+last+ " completed this task? [yes] [no]");
                    ans=s.nextLine();
                    ans=ans.toLowerCase();
                    switch(ans)
                    {
                        case "yes":
                            update="UPDATE Topics SET Completed='Yes' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"'AND Topic='"+topic+"' AND Date='"+date+"';";
                            stmt2.executeUpdate(update);
                            testCounter(last, first, compulsory);
                            key=1;
                            break;
                        
                        case"no":
                            key=1;
                            break;
                            
                        default:
                            System.out.println("Please enter [yes] or [no].");
                            break;
                    }
                }
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * This method increases the tests completed variables 
     * whenever a test is completed.
     * @param last
     * @param first
     * @param compulsory 
     */
    public void testCounter(String last, String first, Boolean compulsory)
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String sql ="SELECT*FROM Students WHERE LastName='"+last+"' AND FirstName='"+first+"';";
        String tests;
        int comp;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            
            while (rs.next())
            {
                if (compulsory)
                {
                    comp=rs.getInt("CompulsoryTests");
                    comp++;
                    tests="UPDATE Students SET CompulsoryTests='"+comp+ "'WHERE LastName = '"
                            +last+"' AND FirstName = '"+ first+"';";
                    stmt2.executeUpdate(tests);
                }
                else
                {
                    comp=rs.getInt("OptionalTests");
                    comp++;
                    tests="UPDATE Students SET OptionalTests='"+comp
                            + "'WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                    stmt2.executeUpdate(tests);
                }
            }

            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /**
     * This method checks to see if any users have completed a badge. If they have
     * it notifies the user.
     */
    public void badge()
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        int opt;
        int comp;
        String last;
        String first;
        String badge;
        String sql ="SELECT*FROM Students;";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                last=rs.getString("LastName");
                first=rs.getString("FirstName");
                opt=rs.getInt("OptionalTests");
                comp=rs.getInt("CompulsoryTests");
                badge=rs.getString("Badge");
                if (badge==null)
                {
                    badge="";
                }
                switch(badge)
                {
                    case "Gold":
                        if(opt>=6&&comp>=14)
                        {
                            String upd="UPDATE Students SET Badge='Diamond' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(upd);
                            System.out.println("\n"+first+" "+last+" has just completed a badge!");
                        }
                        break;
                        
                    case "Diamond":
                        if(opt>=9&&comp>=21)
                        {
                            String upd="UPDATE Students SET Badge='Super Platinum' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(upd);
                            System.out.println("\n"+first+" "+last+" has just completed a badge!");
                        }
                        break;
                        

                        
                    default:
                        if(opt>=3&&comp>=7)
                        {
                            String upd="UPDATE Students SET Badge='Gold' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(upd);
                            System.out.println("\n"+first+" "+last+" has just completed a badge!");
                        }
                        break;
                }
            }
            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
    
    /**
     * This method searches for any topic that has not been widely completed.
     */
    public void difficult()
    {
        String sql ="SELECT Topic, Date FROM Schedule;";
        String set;
         Connection con;
        Statement stmt;
        Statement stmt2;
        ResultSet rs;
        ResultSet rs2 =null;
        double yes=0;
        String completed;
        String topic;
        String date;
        double count=0;
        double percent;
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            
            while (rs.next())
            {
                topic=rs.getString("Topic");
                date=rs.getString("Date");
                set="SELECT Topic, Completed FROM Topics WHERE Topic='"+topic+"';";
                rs2=stmt2.executeQuery(set);
                while(rs2.next())
                {
                    completed=rs2.getString("Completed");
                    count++;
                    if(completed.matches("Yes"))
                    {
                        yes++;
                    }
                }
                percent=(yes/count)*100;
                if(percent<60)
                {
                    System.out.println("\nOnly "+percent+"% of the class has completed "+topic+" "+date+".");
                    System.out.println("This should be considered a focus at the upcoming meeting.");
                }
                else
                {
                    System.out.println(topic+" is tracking well.");
                }
                count=0;
                yes=0;
                rs2.close();
            }
            

            rs.close();
            stmt.close();
            stmt2.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
    }
    
    /** 
     * This method updates the student leaderboard.
     */
    public void leaderboard()
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        int first=0;
        int second=0;
        int third=0;
        String fName;
        String lName;
        String sFirst="";
        String sSecond="";
        String sThird="";
        int tmp;
        int tmp2;
        String sql ="SELECT CompulsoryTests, OptionalTests, FirstName, LastName FROM Students;";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            while (rs.next())
            {
                tmp=rs.getInt("CompulsoryTests");
                tmp2=tmp+rs.getInt("OptionalTests");
                if(tmp2>first)
                {
                    first=tmp2;
                    fName=rs.getString("FirstName");
                    lName=rs.getString("LastName");
                    sFirst=fName+" "+lName;
                    
                }
                else if(tmp2>second)
                {
                    second=tmp2;
                    fName=rs.getString("FirstName");
                    lName=rs.getString("LastName");
                    sSecond=fName+" "+lName;
                }
                else if(tmp2>third)
                {
                    third=tmp2;
                    fName=rs.getString("FirstName");
                    lName=rs.getString("LastName");
                    sThird=fName+" "+lName;
                }
            }
            rs.close();
            stmt.close();
            con.close();
            System.out.println("First place: "+sFirst+"\t"+first+" tests completed.");
            System.out.println("Second place: "+sSecond+"\t"+second+" tests completed.");
            System.out.println("Third place: "+sThird+"\t\t"+third+" tests completed.");
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
}