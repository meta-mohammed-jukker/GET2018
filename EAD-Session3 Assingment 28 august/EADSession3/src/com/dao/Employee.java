package com.dao;

public class Employee
{
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Employee(String firstName, String lastName, String email, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    
    public Employee(int id, String firstName, String lastName, String email, int age)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }
    
    /**
     * Returns employee ID
     * @return
     */
    public int getId()
    {
        return id;
    }

    /**
     * Sets employee ID
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Returns employee first name
     * @return
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * Sets employee first name
     * @param firstName
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * Returns employee last name
     * @return
     */
    public String getLastName()
    {
        return lastName;
    }

    /**
     * Sets employee last name
     * @param lastName
     */
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    /**
     * Returns employee email ID
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     * Sets employee email ID
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getAge()
    {
        return age;
    }

    /**
     * Sets employee age
     * @param age
     */
    public void setAge(int age)
    {
        this.age = age;
    }
}
