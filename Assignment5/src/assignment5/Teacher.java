/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J
 */
public class Teacher extends Person
{
    static ArrayList<String> subjects = new ArrayList<String>();
    private String initials;
    private double salary;

    public Teacher(int id, String name, String email, String initials, ArrayList<String> subjects)
    {
        super(id, name, email);
        this.initials = initials;
    }
    
    
    
    public List<String> getSubjects()
    {
        return subjects;
    }

    public String getInitials()
    {
        return initials;
    }

    public double getSalary()
    {
        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    
    public void addSubject(String subject)
    {
        subjects.add(subject);
        
        
    }

    @Override
    public String toString()
    {
        return "Teacher: id= " + id + " name= " + name + " email= " + email + " initials= " + initials + " subjects= " + subjects;
    }

    
    

    

    
    
    
    
    
    
}
