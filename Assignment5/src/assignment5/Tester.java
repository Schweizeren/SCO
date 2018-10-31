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
public class Tester
{
    
    
    public void assignmentOneTest()
    {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person(1, "Jesper", "pga@easv.dk"));
        persons.add(new Person(2, "Mads", "pgo@easv.dk"));
        persons.add(new Person(3, "Mathias", "pgv@easv.dk"));
        for (Person person : persons)
        {
            System.out.println(person.toString());
        }
        
    }
    
    public void assignmentTwoTest()
    {
        ArrayList<String> subjects = new ArrayList<String>();
        subjects.add("Danish");
        subjects.add("English");
        subjects.add("History");
                
        
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher("bjp",201,"BjarneJP@email.dk","Bjarne JP", English));
        teachers.add(new Teacher("bjt",202,"BjarneJP@email.dk","Bjarne JT", History));
        teachers.add(new Teacher("bjn",203,"BjarneJP@email.dk","Bjarne JN", Danish));
        
        for (Teacher teacher : teachers)
        {
            System.out.println(teacher.toString());
        }
    }   
    
}