import java.util.*;
import java.text.*;

class Marksheet
{
    int numberOfStudents;
    float[] grades;
    
    /**
    * Setter function for numberOfStudents.
    * @param numberOfStudents
    */
    void setNumberOfStudents(int numberOfStudents)
    {
        this.numberOfStudents = numberOfStudents;
    }
    
    /**
    * Add grades for each student.
    * Grades should be between 0 and 100.
    */
    void setGrades() throws ArithmeticException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        setNumberOfStudents(scan.nextInt());
        if (numberOfStudents == 0)
        {
            throw new ArithmeticException("Number of students cannot be zero");
        }
        this.grades = new float[this.numberOfStudents];
        System.out.println("Enter grades: ");
        for(int i=0; i<this.numberOfStudents; i++)
        {
            System.out.println("Enter grade for student " + (i + 1) + " : ");
            grades[i] = scan.nextFloat();
            if(grades[i] > 100.00 || grades[i] < 0.00)
            {
                throw new ArithmeticException("Grades should be between 0 and 100.");
            }
        }
    }
    
    /**
    * Calculate average grade of all students
    * @return average grade
    */
    float averageGrade() throws ArithmeticException
    {
        float totalGrade = 0;
        for(int i=0; i<this.numberOfStudents; i++)
        {
            totalGrade += grades[i];
        }
        float averageGrade = totalGrade/numberOfStudents;
        return averageGrade; 
    }
    
    /**
    * Calculate maximum grade amoung all students
    * @return maximum grade
    */
    float maximumGrade() throws ArithmeticException
    {
        float maximumGrade = 0;
        for(int i=0; i<this.numberOfStudents; i++)
        {
            if(grades[i] > maximumGrade)
            {
                maximumGrade = grades[i];
            }
        }
        return maximumGrade;
    }
    
    /**
    * Calculate minimum grade amoung all students
    * @return minimum grade
    */
    float minimumGrade() throws ArithmeticException
    {
        float minimumGrade = 100;
        for(int i=0; i<this.numberOfStudents; i++)
        {
            if(grades[i] < minimumGrade)
            {
                minimumGrade = grades[i];
            }
        }
        return minimumGrade;
    }
    
    /**
    * Calculate percentage of students passed(grade >= 40)
    * @return percentage of students passed
    */
    float percentagePassed() throws ArithmeticException
    {
        int studentsPassed = 0;
        for(int i=0; i<this.numberOfStudents; i++)
        {
            if(grades[i] >= 40.00)
            {
                studentsPassed += 1;
            }
        }
        return ((studentsPassed * 100)/numberOfStudents);
    }
}

class MarksheetMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        DecimalFormat f = new DecimalFormat("##.00");
        Marksheet m = new Marksheet();
        Area area = new Area();
        while(true)
		{
			System.out.println("Enter operation:");
            System.out.println("1. add grades");
            System.out.println("2. compute average grade");
            System.out.println("3. compute maximum grade");
            System.out.println("4. compute maximum grade");
            System.out.println("5. percentage of students passed");
            System.out.println("6. exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
                    try
                    {
                        m.setGrades();
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 2:
                    try
                    {
                        System.out.println("Average grade: " + f.format(m.averageGrade()));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 3:
                    try
                    {
                        System.out.println("Maximum grade: " + f.format(m.maximumGrade()));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 4:
                    try
                    {
                        System.out.println("Minimum grade: " + f.format(m.minimumGrade()));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 5:
                    try
                    {
                        System.out.println("Percentage of students passed: " + f.format(m.percentagePassed()));
                    }
                    catch(ArithmeticException arithmeticException)
                    {
                        System.out.println("Error : " + arithmeticException.getMessage());
                    }
                    break;
                case 6:
                    System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
            }
        }
    }
}