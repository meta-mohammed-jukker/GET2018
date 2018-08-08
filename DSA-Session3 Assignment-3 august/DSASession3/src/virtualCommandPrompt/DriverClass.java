package virtualCommandPrompt;

public class DriverClass
{

    public static void main(String[] args)
    {
        try
        {
            VirtualCommandPrompt.prompt();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
    }

}
