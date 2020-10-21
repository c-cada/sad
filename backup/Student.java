/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class runs the student method allowing a simpler version to print out
 * student details.
 * @version 12/10/2020 
 * @author Liam Fifield
 */

public class Student 
{
    /**
     * Initialization of variables.
     */
    private String fName;
    private String lName;
    private String DOB;
    private String colour;
    private int age;
    private int cTest;
    private int oTest;
    private String badge;
    
    /**
     * Creates a student object.
     * @param fName
     * @param lName
     * @param DOB
     * @param age
     * @param colour
     * @param cTest
     * @param oTest
     * @param badge 
     */
    public Student(String fName, String lName, String DOB, int age, String colour, int cTest, int oTest, String badge)
    {
        this.fName=fName;
        this.lName=lName;
        this.DOB=DOB;
        this.age=age;
        this.colour=colour;
        this.cTest=cTest;
        this.oTest=oTest;
        this.badge=badge;
    }
    
    /**
     * All getter and setter methods for each variable.
     * @return 
     */
    public String getBadge() {
        return badge;
    }

    public void setBadge(String badge) {
        this.badge = badge;
    }

    
    
    public int getcTest() {
        return cTest;
    }

    public int getoTest() {
        return oTest;
    }

    public void setcTest(int cTest) {
        this.cTest = cTest;
    }

    public void setoTest(int oTest) {
        this.oTest = oTest;
    }
    

    
    public String getFName()
    {
        return fName;
    }
    
    public String getLName()
    {
        return lName;
    }
     
    public String getDOB()
     {
        return DOB;
     }
    
    public int getAge()
    {
        return age;
    }
     
    public String getColour()
    {
        return colour;
    }
    
    public void setFName(String fName)
    {
        this.fName=fName;
    }
    
    public void setLName(String lName)
    {
        this.lName=lName;
    }
    
    public void setDOB(String DOB)
    {
        this.DOB=DOB;
    }
    
    public void setAge(int age)
    {
        this.age=age;
    }
    
    public void setColour(String colour)
    {
        this.colour=colour;
    }
    
    /**
     * Simple toString. Prints out all students details.
     * @return 
     */
    @Override
    public String toString() {
        return "Student{" + "Name = " +  fName+" " + lName + ", DOB = " + DOB + 
                ", ColourSixGroup = " + colour + ", Age = " + age + ", \n\tCompulsoryTests Completed = " + cTest + 
                ", OptionalTests Completed = " + oTest + ", Badge="+badge+'}';
    }
   
}