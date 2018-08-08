package virtualCommandPrompt;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Directory 
{

    private final String name;
    private final Date dateOfCreation;
    private List<Directory> listOfSubDirectory;
    
    /**
     * Initializes directory with name and date of creation
     * @param name
     * @param dateOfCreation
     */
    public Directory(String name, Date dateOfCreation) 
    {
        this.dateOfCreation = dateOfCreation;
        this.name = name;
        this.listOfSubDirectory = new ArrayList<Directory>();
    }
    
    /**
     * Returns list of sub directories
     * @return
     */
    public List<Directory> getListOfSubDirectory() 
    {
        return listOfSubDirectory;
    }
    
    /**
     * Sets list of sub directories
     * @param listOfSubDirectory
     */
    public void setListOfSubDirectory(List<Directory> listOfSubDirectory) 
    {
        this.listOfSubDirectory = listOfSubDirectory;
    }
    
    /**
     * Returns name of the directory
     * @return
     */
    public String getName() 
    {
        return name;
    }
    
    /**
     * Returns date of creation of the directory
     * @return
     */
    public Date getDateOfCreation() 
    {
        return dateOfCreation;
    }
    
    
}
