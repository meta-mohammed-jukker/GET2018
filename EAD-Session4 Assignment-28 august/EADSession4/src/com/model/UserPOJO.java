package com.model;

import java.math.BigInteger;
import java.util.Date;

public class UserPOJO
{
    int id;
    String firstName;
    String lastName;
    int age;
    Date dateOfBirth;
    String contactNumber;
    String organization;
    String imageURL;
    String email;
    String password;
    
    public UserPOJO()
    {
        this.firstName = null;
        this.lastName = null;
        this.age = -1;
        this.dateOfBirth = null;
        this.contactNumber = null;
        this.email = null;
        this.password = null;
        this.organization = null;
    }
    
    public UserPOJO(String firstName, String lastName, int age, 
            Date dateOfBirth, String contactNumber, String organization,  
            String email, String password)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
        this.organization = organization;
    }
    
    public UserPOJO(int id, String firstName, String lastName, int age, 
            Date dateOfBirth, String contactNumber, String organization,  
            String email, String password)
    {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.email = email;
        this.password = password;
        this.organization = organization;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public Date getDateOfBirth()
    {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth)
    {
        this.dateOfBirth = dateOfBirth;
    }

    public String getContactNumber()
    {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber)
    {
        this.contactNumber = contactNumber;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getOrganization()
    {
        return organization;
    }

    public void setOrganization(String organization)
    {
        this.organization = organization;
    }
    
    public String getImageURL()
    {
        return imageURL;
    }

    public void setImageURL(String imageURL)
    {
        this.imageURL = imageURL;
    }
}
