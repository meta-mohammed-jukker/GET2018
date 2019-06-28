package session3;

public class Marksheet
{
    /**
    * Calculates average grade of all students
    * @return average grade
    */
    float calculateAverageGrade(float[] grades) throws ArithmeticException
    {
        int numberOfStudents = grades.length;
        if(numberOfStudents == 0)
        {
            throw new ArithmeticException("No grades given");
        }
        float totalGrade = 0;
        for(int i=0; i<numberOfStudents; i++)
        {
            totalGrade += grades[i];
        }
        float averageGrade = totalGrade/numberOfStudents;
        return averageGrade; 
    }
    
    /**
    * Finds maximum grade among all students
    * @return maximum grade
    */
    float findMaximumGrade(float[] grades) throws ArithmeticException
    {
        int numberOfStudents = grades.length;
        if(numberOfStudents == 0)
        {
            throw new ArithmeticException("No grades given");
        }
        float maximumGrade = 0;
        for(int i=0; i<numberOfStudents; i++)
        {
            if(grades[i] > maximumGrade)
            {
                maximumGrade = grades[i];
            }
        }
        return maximumGrade;
    }
    
    /**
    * Finds minimum grade among all students
    * @return minimum grade
    */
    float findMinimumGrade(float[] grades) throws ArithmeticException
    {
        int numberOfStudents = grades.length;
        if(numberOfStudents == 0)
        {
            throw new ArithmeticException("No grades given");
        }
        float minimumGrade = 100;
        for(int i=0; i<numberOfStudents; i++)
        {
            if(grades[i] < minimumGrade)
            {
                minimumGrade = grades[i];
            }
        }
        return minimumGrade;
    }
    
    /**
    * Calculates percentage of students passed(grade >= 40)
    * @return percentage of students passed
    */
    float findPercentagePassed(float[] grades) throws ArithmeticException
    {
        int numberOfStudents = grades.length;
        if(numberOfStudents == 0)
        {
            throw new ArithmeticException("No grades given");
        }
        int studentsPassed = 0;
        for(int i=0; i<numberOfStudents; i++)
        {
            if(grades[i] >= 40.00)
            {
                studentsPassed += 1;
            }
        }
        return ((studentsPassed * 100)/numberOfStudents);
    }
}
