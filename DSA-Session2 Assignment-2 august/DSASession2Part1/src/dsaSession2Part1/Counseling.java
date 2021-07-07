package dsaSession2Part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Counseling
{
    private static List<Student> studentList = new ArrayList<Student>();
    
    /**
     * Allocates program to each student
     */
    public void allocatePrograms()
    {
        Queue<Student> studentQueue = FileReadWrite.getListOfStudents();
        List<Program> programList = FileReadWrite.getListOfProgram();
         
        boolean isStudentQueueEmpty = studentQueue.isEmpty();
        
        while(! isStudentQueueEmpty)
        {
            Student student = studentQueue.remove();
            studentList.add(student);
            
            String[] prefernces=student.getPreferences();
            outer:for(int i=0; i<prefernces.length; i++)
            {
                for(Program program: programList)
                {
                    String programName=program.getName();
                    
                    if(programName.equals(prefernces[i]))
                    {
                        int numberOfAllocatedStudents = program.getNumberOfAllocatedStudents();
                        int capacityOfProgram = program.getCapacity();
                        
                        if(numberOfAllocatedStudents < capacityOfProgram)
                        {
                            student.setProgramAllocated(programName);
                            program.increaseNumberOfAllocatedStudents();
                            break outer;
                        }
                    }
                }
            }
            isStudentQueueEmpty = studentQueue.isEmpty();
        }
    }
    
    public List<Student> getStudentList()
    {
        return studentList;
    }
}
