package assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J_Wan
 */
public class Student extends Person
{
    ArrayList<GradeInfo> GradeInfo = new ArrayList<>;
    private String education;
    
    public Student(String education, int id, String name, String email) {
        super(id, name, email);
        this.education = education;
    }
        
        public List<GradeInfo> getGradeReport() 
        {
            return gradeReport;
        }

        public String getEducation() 
        {
            return education;  
        }
        
        public double getAverageGrade()
        {
            return AverageGrade;
        }
       
        public int getGrade(grade : GradeInfo)
        {
            return Grade;
        }
        
        public void addGrade(grade : GradeInfo)
        {
            gradeReport.add(GradeInfo);
            
        }

        
        
        
        
    }
    
    
}
