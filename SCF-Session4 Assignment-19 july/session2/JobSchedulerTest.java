package session2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class JobSchedulerTest
{
    int completionTime;
    int turnAroundTime;
    int waitingTime;
    int processNumber;
    
    JobScheduler jobScheduler = new JobScheduler();
    
    @Parameters
    public static Collection data()
    {
        return Arrays.asList( new Object[ ][ ]
                {{10, 10, 0, 1},
                 {30, 24, 4, 2},
                 {70, 10, 0, 3},
                 {115, 5, 0, 4}});
    }
    
    
    public JobSchedulerTest
    (int completionTime, int turnAroundTime, int waitingTime, int processNumber)
    {
        this.completionTime = completionTime;
        this.turnAroundTime = turnAroundTime;
        this.waitingTime = waitingTime;
        this.processNumber = processNumber;
    }
    
    @Test
    public void testCompletionTime()
    {
        int[][] processes = {{0, 10},
                             {6, 20},
                             {60, 10},
                             {110, 5}};
        assertEquals(completionTime, jobScheduler.completionTime(processes, processNumber));
    }
    
    @Test
    public void testTurnAroundTime()
    {
        int[][] processes = {{0, 10},
                             {6, 20},
                             {60, 10},
                             {110, 5}};
        assertEquals(turnAroundTime, jobScheduler.turnAroundTime(processes, processNumber));
    }
    
    @Test
    public void testWaitingTime()
    {
        int[][] processes = {{0, 10},
                             {6, 20},
                             {60, 10},
                             {110, 5}};
        assertEquals(waitingTime, jobScheduler.waitingTime(processes, processNumber));
    }
    
    @Test
    public void testAverageWaitingTime()
    {
        int[][] processes = {{0, 10},
                             {6, 20},
                             {60, 10},
                             {110, 5}};
        assertEquals(1.0, jobScheduler.averageWaitingTime(processes), 0.1);
    }
    
    @Test
    public void testMaximumWaitingTime()
    {
        int[][] processes = {{0, 10},
                             {6, 20},
                             {60, 10},
                             {110, 5}};
        assertEquals(4, jobScheduler.maximumWaitingTime(processes));
    }
}
