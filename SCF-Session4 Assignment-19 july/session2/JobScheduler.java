package session2;

//import java.util.*;

class JobScheduler
{
    /**
    * Calculates completion time for a process.
    * @param processNumber Process number for which 
    *           completion time is calculated
    * @return completion time for the processNumber 
    */
    int completionTime(int[][] processes, int processNumber)
    {
        int initialTime = processes[0][0];
        int finalTime = processes[0][1];
        for(int i=1; i<processNumber; i++)
        {
            if(processes[i][0] > finalTime)
            {
                finalTime = processes[i][0];
            }
            finalTime += processes[i][1];
        }
        finalTime -= initialTime;
        return finalTime;
    }
    
    /**
    * Calculates turn-around time for a process.
    * @param processNumber Process number for which 
    *               turn-around time is calculated
    * @return turnaround time for the processNumber 
    */
    int turnAroundTime(int[][] processes, int processNumber)
    {
        return (completionTime(processes, processNumber) - processes[processNumber-1][0]);
    }
    
    /**
    * Calculates waiting time for a process.
    * @param processNumber Process number for which 
    *               waiting time is calculated
    * @return waiting time for the processNumber 
    */
    int waitingTime(int[][] processes, int processNumber)
    {
        return (turnAroundTime(processes, processNumber) - processes[processNumber-1][1]);
    }
    
    /**
    * Computes the average waiting time for all processes
    * @return average waiting time 
    */
   float  averageWaitingTime(int[][] processes)
    {
        int sumOfWaitingTime = 0;
        int numberOfProcesses = processes.length; 
        for(int i=0; i<numberOfProcesses; i++)
        {
            sumOfWaitingTime += waitingTime(processes, i+1);
        }
        return sumOfWaitingTime/numberOfProcesses;
    }
    
    /**
    * Computes the maximum waiting time among all processes
    * @return maximum waiting time 
    */
    int maximumWaitingTime(int[][] processes)
    {
        int maximumWaitingTime = 0;
        int numberOfProcesses = processes.length;
        for(int i=0; i<numberOfProcesses; i++)
        {
            if(waitingTime(processes, i+1) > maximumWaitingTime)
            {
                maximumWaitingTime = waitingTime(processes, i+1);
            }
        }
        return maximumWaitingTime;
    }

}