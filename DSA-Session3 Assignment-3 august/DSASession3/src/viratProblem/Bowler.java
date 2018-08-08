package viratProblem;

public class Bowler 
{
    int bowl;
    String name;
    
    public Bowler(int bowl, String name) 
    {
        if(bowl == 0) 
        {
            throw new NullPointerException("Bowler not allowed with zero bowl");
        }
        
        if(name == null) 
        {
            throw new NullPointerException("Bowler name can not be null");
        }
        this.bowl = bowl;
        this.name = name;
    }
    
    public void setBowl(int bowl) 
    {
        if(bowl >= 0) 
        {
            this.bowl = bowl;
        }
    }
    
    public int getBowl() 
    {
        return bowl;
    }
    
    public String getName() 
    {
        return name;
    }
}
