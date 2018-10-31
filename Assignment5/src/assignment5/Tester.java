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
        Teacher.subjects.add("danish");
        Teacher.subjects.add("History");
        Teacher.subjects.add("danish");
                
        
        List<Teacher> teachers = new ArrayList<>();
        teachers.add(new Teacher(201,"Bjarne JP","BjarneJP@email.dk","BJP",Teacher.subjects));
        teachers.add(new Teacher(202,"Bjarne JT","BjarneJT@email.dk","BJT",Teacher.subjects));
        teachers.add(new Teacher(203,"Bjarne JN","BjarneJN@email.dk","BJN",Teacher.subjects));
        
        for (Teacher teacher : teachers)
        {
            System.out.println(teacher.toString());
        }
    } 
}

    