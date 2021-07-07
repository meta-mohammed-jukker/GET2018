package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class VirtualCommandPrompt 
{

    static List<Directory> listOfDirectory = new ArrayList<Directory>();
    static String path = ".\\";
    
    /**
     * Virtual Command Prompt window
     * @throws AssertionError
     */
    public static void prompt() throws AssertionError
    {
        Directory root = new Directory("R:", new Date());
        listOfDirectory.add(root);
        Scanner scanner = new Scanner(System.in);
        System.out.println("***Welcome to Virtual Command Prompt***");
        String signature = "R:\\";
        Directory currentDirectory = root;
        
        while(true)
        {
            System.out.print(signature + ">");
            String commandLine = scanner.nextLine();
            String[] commandWords = commandLine.split(" ");
            
            switch(commandWords[0])
            {
            
            case "mkdir" : 
                if(commandWords.length == 1)
                {
                    throw new AssertionError("Directory name not specified");
                }
                for(Directory subDirectory: currentDirectory.getListOfSubDirectory())
                {
                    if(subDirectory.getName().equals(commandWords[1]))
                    {
                        throw new AssertionError("Directory already exist");
                    }
                }
                Directory newDirectory = new Directory(commandWords[1], new Date());
                listOfDirectory.add(newDirectory);
                currentDirectory.getListOfSubDirectory().add(newDirectory);
                break;
                           
            case "cd": 
                if(isPresent(currentDirectory, commandWords[1]))
                {
                    for(Directory directory: listOfDirectory)
                    {
                        if(directory.getName().equals(commandWords[1]))
                        {
                            currentDirectory = directory;
                            if(signature.charAt(signature.length() - 1) != '\\')
                            {
                                signature += "\\";
                            }
                            signature += currentDirectory.getName();
                            break;
                            }
                        }
                    }
                else
                {
                    System.out.println(signature + "> No such directory exists");
                }
                break;
                           
            case "bk"     : 
                String[] directories = signature.split("\\\\");
                for(Directory directory: listOfDirectory)
                {
                    if(directory.getName().equals(directories[directories.length - 2]))
                    {
                        currentDirectory = directory;
                    }
                }
                signature = "R:";
                for(int i = 1; i < directories.length - 1; i++)
                {
                    signature += "\\" + directories[i];
                }
                break;
                            
            case "ls"     : 
                for(Directory subDirectory: currentDirectory.getListOfSubDirectory())
                {
                    System.out.println(subDirectory.getDateOfCreation() + "\t" + 
                                       subDirectory.getName());
                }
                System.out.println(currentDirectory.getListOfSubDirectory().size() + 
                                   " Folder(s)");
                break;
                            
            case "find"   : 
                path = ".\\";
                String directoryPath = findPath(currentDirectory, commandWords[1]);
                if(directoryPath != null)
                {
                    StringBuilder pathToFind = new StringBuilder(directoryPath);
                    pathToFind.deleteCharAt(pathToFind.length() - 1);
                    System.out.println(pathToFind);
                }
                else
                    System.out.println(signature + ">Directory not found");
                break;
                            
            case "tree":
                System.out.println(".");
                String spacing = "\t";
                printTree(currentDirectory, spacing);
                break;
        
            case "exit":
                System.exit(0);
                
            }
            
        }
        
        
    }
    
    /**
     * Checks if the directory is present in the sub-tree where current directory is root directory
     * @param currentDirectory current directory
     * @param directoryToBeSearched directory to be searched
     * @return true if directory is present, else false
     */
    public static boolean isPresent(Directory currentDirectory, String directoryToBeSearched)
    {
        boolean found = false;
        
        if(currentDirectory.getName().equals(directoryToBeSearched))
        {
            found = true;
        }
        else
        {
            for(Directory directory: currentDirectory.getListOfSubDirectory())
            {
                    if(isPresent(directory, directoryToBeSearched))
                    {
                        found = true;
                        break;
                    }
            }
            
        }
        return found;
    }
    
    /**
     * Finds the path of desired directory from root directory
     * @param currentDirectory current directory
     * @param directoryToBeSearched directory whose path is to be searched
     * @return path to desired directory, else null
     */
    public static String findPath(Directory currentDirectory, String directoryToBeSearched)
    {
        boolean found = false;
        System.out.println(currentDirectory.getName());
        if(currentDirectory.getName().equals(directoryToBeSearched))
        {
            found = true;
        }
        else
        {
            for(Directory directory: currentDirectory.getListOfSubDirectory())
            {
                path += directory.getName() + "\\";
                
                if(findPath(directory, directoryToBeSearched) != null)
                {
                    found = true;
                    break;
                }
                else
                {
                    String[] directories = path.split("\\\\");
                    path = ".\\";
                    for(int i = 1; i < directories.length - 2; i++)
                    {
                        path += "\\" + directories[i];
                    }
                }
            }
            
        }
        
        if(found)
        {
            return path;
        }
        else 
            return null;
    }
    
    /**
     * Prints tree with current directory as root directory 
     * @param currentDirectory current directory
     * @param spacing string to provide spacing for sub directories  
     */
    public static void printTree(Directory currentDirectory, String spacing)
    {
        for(Directory subDirectory: currentDirectory.getListOfSubDirectory())
        { 
            System.out.println(spacing + subDirectory.getName());
            printTree(subDirectory, spacing + "\t");
        }
        
    }
}
