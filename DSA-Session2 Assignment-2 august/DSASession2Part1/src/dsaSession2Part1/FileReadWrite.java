package dsaSession2Part1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

public class FileReadWrite
{
    private static Queue<Student> studentQueue = new LinkedList<Student>();
    private static List<Program> programList = new ArrayList<Program>();
    
    /**
     * Returns queue of student, after reading from file 
     * @return queue containing student objects
     * @throws AssertionError
     */
    public static Queue<Student> getListOfStudents() throws AssertionError
    {
        String fileName = "C:/Users/Mohammed/workspace/DSASession2Part1/bin/students.txt";
        List<String> listOfEntries = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) 
        {

            //br returns as stream and convert it into a List
            listOfEntries = br.lines().collect(Collectors.toList());

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        for(String entry: listOfEntries)
        {
            String[] listOfAttributes = entry.split(" ");
            
            if(listOfAttributes.length > 7)
            {
                throw new AssertionError("Number of attributes not equal to required");
            }
            int id = Integer.parseInt(listOfAttributes[0]);
            String name = listOfAttributes[1];
            String[] preferences = {listOfAttributes[2], 
                                    listOfAttributes[3], 
                                    listOfAttributes[4], 
                                    listOfAttributes[5], 
                                    listOfAttributes[6]};
            Student student = new Student(id, name, preferences);
            studentQueue.add(student);
            
        }     
        return studentQueue;
    }
    
    /**
     * Returns list of programs, after reading from file
     * @return list of programs
     * @throws AssertionError
     */
    public static List<Program> getListOfProgram() throws AssertionError
    {
        String fileName = "C:/Users/Mohammed/workspace/DSASession2Part1/bin/programs.txt";
        List<String> listOfEntries = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) 
        {

            //br returns as stream and convert it into a List
            listOfEntries = br.lines().collect(Collectors.toList());

        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        
        for(String entry:listOfEntries)
        {
            String[] listOfAttributes = entry.split(" ");
            
            if(listOfAttributes.length < 2)
            {
                throw new AssertionError("Number of attributes not equal to required");
            }
            
            String name = listOfAttributes[0];
            int capacity = Integer.parseInt(listOfAttributes[1]);
            
            Program program = new Program(name, capacity);
            programList.add(program);
        }
        
        return programList;
    }
    
    /**
     * Create a result file and adds result in it
     */
    public static void displayResult()
    {
        Counseling counseling = new Counseling();
        List<Student> studentList = counseling.getStudentList();
        
        try
        {
            PrintWriter writer = new PrintWriter
                    ("C:/Users/Mohammed/workspace/DSASession2Part1/bin/result.txt", "UTF-8");
            for(Student student: studentList)
            {
                writer.println(student.getId() + "\t" + 
                             student.getName() + "\t" + 
                             student.getProgramAllocated());
            }
            writer.close();
            
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }   
    }
}
