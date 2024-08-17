/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Baby
{
    private String name;
    private int age;

    //default constructor
    public Baby()
    {
        this.name = "Default Name";
        this.age = 1; //setting a default age
    }

    //constructor with parameters
    public Baby(String name, int age)
    {
        setName(name); //using the setter to enforce name validation
        setAge(age); //using the setter to enforce age validation
    }

    //setter for name
    public void setName(String name)
    {
        if (name != null && !name.trim().isEmpty())
        {
            this.name = name;
        }
        else
        {
            this.name = "Default Name"; //default name if input is invalid
        }
    }

    //setter for age
    public void setAge(int age)
    {
        if (age >= 1 && age <= 4)
        {
            this.age = age;
        }
        else
        {
            this.age = 1; //default age if input is out of range
        }
    }

    //getter for name
    public String getName()
    {
        return name;
    }

    //getter for age
    public int getAge()
    {
        return age;
    }

    //equals method
    public boolean equals(Baby otherBaby)
    {
        if (otherBaby == null)
        {
            return false;
        }
        return this.name.equalsIgnoreCase(otherBaby.getName()) && this.age == otherBaby.getAge();
    }
}
