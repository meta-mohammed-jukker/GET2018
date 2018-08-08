package viratProblem;

import java.util.ArrayList;
import java.util.List;

public class Match 
{
    private int totalBowl;
    private List<Bowler> bowlerList = new ArrayList<Bowler>();

    /**
     * Adds bowler
     * @param bowl
     * @param name
     */
    public void addBowler(int bowl, String name) 
    {
        bowlerList.add(new Bowler(bowl, name));
    }

    /**
     * Calculates total bowl bowlers' need to perform
     */
    public void totalBowl() 
    {
        for (Bowler bowler : bowlerList) 
        {
            totalBowl += bowler.getBowl();
        }
    }

    /**
     * ReturnS bowler order such that virat scores minimum
     * @return Bowler order
     */
    public List<Bowler> getViratMinimumRun()
    {
        List<Bowler> bowlerOrder = new ArrayList<Bowler>();
        while (totalBowl != 0) 
        {
            //provide index in list of bowlerList which has maximum balls
            int bolwerIndex = getMaxBowlBolwer();
            String bowlerName = bowlerList.get(bolwerIndex).getName();
            int orderSize = bowlerOrder.size();
            if (orderSize == 0) 
            {
                bowlerOrder.add(new Bowler(1, bowlerName));
            } 
            // if bowler on previous bowl is not same then add a new bowler to bowlerOrder
            else if (!(bowlerName.equals(bowlerOrder.get(orderSize - 1).getName())))  
            {
                bowlerOrder.add(new Bowler(1, bowlerName));
            } 
            // if bowler on previous bowl is same then increase number of bowl for that bowler by 1
            else 
            {
                bowlerOrder.get(bowlerOrder.size() - 1)
                    .setBowl(bowlerOrder.get(bowlerOrder.size() - 1).getBowl() + 1);
            }
            
            bowlerList.get(bolwerIndex).setBowl(bowlerList.get(bolwerIndex).getBowl() - 1);
            
            totalBowl--;
        }
        return bowlerOrder;
    }

    /**
     * Returns the index of bowler which have maximum balls
     * @return index of bowler in bowlerList
     */
    private int getMaxBowlBolwer() 
    {
        int numberOfBowlers = bowlerList.size();
        if (bowlerList.size() == 0) 
        {
            throw new NullPointerException("No bowlers available");
        }

        int maxBowls = bowlerList.get(0).getBowl();
        int index = 0;
        for (int i = 0; i < numberOfBowlers; i++) 
        {
            int bowls = bowlerList.get(i).getBowl();
            if (bowls > maxBowls) 
            {
                maxBowls = bowls;
                index = i;
            }
        }
        return index;
    }
}
