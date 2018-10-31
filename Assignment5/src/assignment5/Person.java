/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author J
 */
public class Person
{
    public int id;
    public String name;
    public String email;

    /**
     * constructs
     * @param id
     * @param name 
     */
    public Person(int id, String name)
    {
        this(id,name,"");
    }
    /**
     * constructs a person
     * @param id
     * @param name
     * @param email 
     */
    public Person(int id, String name, String email)
    {
        this.id = id;
        this.name = name;
        this.email = email;
    }
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Person:  id=" + id + ",   name=" + name + ",   email=" + email + '}';
    }
    
    
}
