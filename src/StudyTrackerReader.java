

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.swing.JOptionPane;
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
     * Used for the searchMethod.Prints out all students that match user input.
     * @param last
     * @param first
     */
    public String printStudents(String last, String first)
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        String lName;
        String fName;
        String date;
        String age;
        String colour;
        String comp;
        String opt;
        String badge;
        String search="";
        String sql ="SELECT*FROM Students WHERE LastName='"+last+"' AND FirstName='"+first+"';";
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            if (rs.next())
            {
                lName = rs.getString("LastName");
                fName = rs.getString("FirstName");
                date = rs.getString("DateOfBirth");
                age = rs.getString("Age");
                colour = rs.getString("ColourSixGroup");
                comp= rs.getString("CompulsoryTests");
                opt= rs.getString("OptionalTests");
                badge = rs.getString("Badge");
                search = "Student: "+fName+" "+lName+"   DateOfBirth: "+ date+ "   Age: "+ age 
                        + "   ColourSixGroup: "+colour+ "   CompulsoryTests: "+comp+"   OptionalTests: "
                        +opt+"   Badge: "+badge;
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Student not found");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
        return search;
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
     * @param query 
     * @param ans 
     */
    public void getExists (String delNameLast, String delNameFirst, String query, String ans)
    {
        Connection con =null;
        Statement stmt = null;
        ResultSet rs = null;
        Statement stmt2 = null;
        String load ="SELECT*FROM Students WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
        MyGui m = new MyGui();
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            rs=stmt.executeQuery(load);
            if (rs.next())
            {
                String choice="UPDATE Students SET "+query+"='"+ans+"' WHERE LastName = '"+delNameLast+"' AND FirstName = '"+ delNameFirst+"';";
                con=getConnection();
                stmt2= con.createStatement();
                stmt2.executeUpdate(choice);
                stmt2.close();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Student not Found");
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
     * This method allows the user to mark attendance in the Attendance table.
     * @param date 
     * @return  
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
                list = list+(first + "-" + last + "#");
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
    
    public void addAttendance(String date)
    {
        Connection con =null;
        Statement stmt = null;
        String sql= "ALTER TABLE Attendance ADD `"+date+"` varchar(10);";
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
    }
    
    public void markAttendance(String date, String fName, String lName, Boolean a)
    {
        Connection con =null;
        Statement stmt = null;
        String sql;
        MyGui mg = new MyGui();
        String absent;
        if (a) sql ="UPDATE Attendance SET `"+date+"`= 'Attended' WHERE LastName= '"+lName+"' AND FirstName= '"+fName+"';";
        else sql ="UPDATE Attendance SET `"+date+"`= 'Absent' WHERE LastName= '"+lName+"' AND FirstName= '"+fName+"';";
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
        MyGui m= new MyGui();
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
                m.dataProcessSchedule(date, topic, staff);
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        m.schedule();
    }
    

    
    public String getTopic(String date, String topic)
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
        String list = "";
        Boolean compulsory=null;
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
                list = list + (first + "-" + last + "#");
                System.out.println("Test");
            }
            rs.close();
            stmt.close();
            con.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return list;
    }
    
    public void markTopic(String date, String topic, Boolean a)
    {
        Connection con =null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;
        String sql ="SELECT*FROM Topics WHERE Topic='"+topic+
                "' AND Date='"+date+"';";
        String update;
        String last;
        String first;
        String ans;
        MyGui mg = new MyGui();
        Boolean compulsory=null;
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
                if (a)
                {
                    sql ="UPDATE Topics SET Completed='yes' WHERE LastName= '"+last+"' AND FirstName= '"+first+"' AND Date='"+date+"' AND Topic='"+topic+"';";
                    stmt2.executeUpdate(sql);
                    testCounter(last,first,compulsory);
                }
            }
            rs.close();
            stmt2.close();
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
        MyGui m = new MyGui();
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
                            badge= "Diamond";
                            JOptionPane.showMessageDialog(null, first+" "+last+" has just earned a "+badge+" badge!");
                        }
                        break;
                        
                    case "Diamond":
                        if(opt>=9&&comp>=21)
                        {
                            String upd="UPDATE Students SET Badge='Super Platinum' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(upd);
                            badge= "Super Platinum";
                            JOptionPane.showMessageDialog(null, first+" "+last+" has just earned a "+badge+" badge!");
                        }
                        break;
                        
                    case "Super Platinum":
                        
                        break;
                        
                    default:
                        if(opt>=3&&comp>=7)
                        {
                            String upd="UPDATE Students SET Badge='Gold' WHERE LastName = '"+last+"' AND FirstName = '"+ first+"';";
                            stmt2.executeUpdate(upd);
                            badge= "Gold";
                            JOptionPane.showMessageDialog(null, first+" "+last+" has just earned a "+badge+" badge!");
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
        int exists=0;
        MyGui m = new MyGui();
        try
        {
            con=getConnection();
            stmt= con.createStatement();
            stmt2= con.createStatement();
            rs=stmt.executeQuery(sql);
            
            
            while (rs.next())
            {
                exists++;
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
                m.difficult(percent, topic, date);
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
            if (exists==0)JOptionPane.showMessageDialog(null, "No topics were found in the system.");

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
        MyGui m = new MyGui();
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
                    second=first;
                    sSecond=sFirst;
                    first=tmp2;
                    fName=rs.getString("FirstName");
                    lName=rs.getString("LastName");
                    sFirst=fName+" "+lName;
                    
                }
                else if(tmp2>second)
                {
                    third=second;
                    sThird=sSecond;
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
            m.leaderboard(sFirst, first, sSecond, second, sThird, third);
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }  
    }
}
