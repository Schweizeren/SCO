package assignment5;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author J_Wan
 */
public class Student extends Person
{
    ArrayList<GradeInfo> gradeReport = new ArrayList<GradeInfo>();
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
            double average = 0;
            for (GradeInfo gradeInfo : gradeReport)
            {
                gradeInfo.getGrade();
                average = average + gradeInfo.getGrade();
            }
            return average / gradeReport.size();
        }
       
        public int getGrade(String subject)
        {
            for (GradeInfo grade : gradeReport)
            {
                if (grade.getSubject() == subject)
                {
                    return grade.getGrade();
                }
            }
            return -1;
        }
        
        public void addGrade(GradeInfo grade)
        {
            
        }
}