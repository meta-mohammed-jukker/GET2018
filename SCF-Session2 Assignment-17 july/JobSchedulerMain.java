import java.util.*;

class JobScheduler
{
    int numberOfProcesses;
    int[][] processes;
    
    /**
    * Setter function for numberOfProcesses
    * @param numberOfProcesses  
    */
    void setNumberOfProcesses(int numberOfProcesses)
    {
        this.numberOfProcesses = numberOfProcesses;
    }
    
    /**
    * Getter function for numberOfProcesses
    * @return numberOfProcesses  
    */
    int getNumberOfProcesses()
    {
        return this.numberOfProcesses;
    }
    
    /**
    * Add processes along with thier arrival and burst time,
    * and save them in processes array.
    */
    void setProcesses()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: ");
        setNumberOfProcesses(sc.nextInt());
        this.processes = new int[this.numberOfProcesses][2];
        System.out.println("Enter each process's arrival and burst time: ");
        for(int i=0; i<this.numberOfProcesses; i++)
        {
            System.out.println("Process " + (i + 1) + " : \n");
            System.out.println("Arival Time : ");
            processes[i][0] = sc.nextInt();
            System.out.println("Burst Time : ");
            processes[i][1] = sc.nextInt();
        }
    }
    
    /**
    * Find completion time for a process.
    * @param processNumber Process number for which 
    *               completion time is calculated
    * @return completion time for the processNumber 
    */
    int completionTime(int processNumber)
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
    * Find turnaround time for a process.
    * @param processNumber Process number for which 
    *               turnaround time is calculated
    * @return turnaround time for the processNumber 
    */
    int turnAroundTime(int processNumber)
    {
        return (completionTime(processNumber) - processes[processNumber-1][0]);
    }
    
    /**
    * Find waiting time for a process.
    * @param processNumber Process number for which 
    *               waiting time is calculated
    * @return waiting time for the processNumber 
    */
    int waitingTime(int processNumber)
    {
        return (turnAroundTime(processNumber) - processes[processNumber-1][1]);
    }
    
    /**
    * Computes the average waiting time for all processes
    * @return average waiting time 
    */
   float  averageWaitingTime()
    {
        int sumOfWaitingTime = 0;
        for(int i=0; i<numberOfProcesses; i++)
        {
            sumOfWaitingTime += waitingTime(i+1);
        }
        return sumOfWaitingTime/numberOfProcesses;
    }
    
    /**
    * Computes the maximum waiting time amoung all processes
    * @return maximum waiting time 
    */
    int maximumWaitingTime()
    {
        int maximumWaitingTime = 0;
        for(int i=0; i<numberOfProcesses; i++)
        {
            if(waitingTime(i+1) > maximumWaitingTime)
            {
                maximumWaitingTime = waitingTime(i+1);
            }
        }
        return maximumWaitingTime;
    }

}

class JobSchedulerMain
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        JobScheduler jobScheduler = new JobScheduler();
        while(true)
		{
			System.out.println("Enter the operation to be performed:");
            System.out.println("1. add all processes");
            System.out.println("2. display completion time");
            System.out.println("3. display waiting time");
            System.out.println("4. display turnaround time");
            System.out.println("5. display average waiting time");
            System.out.println("6. display maximum waiting time");
			System.out.println("7. exit");
            int choice = scan.nextInt();
            switch(choice)
            {
                case 1:
					jobScheduler.setProcesses();
					break;
				case 2:
					System.out.println("Enter process number: ");
					int processNumber1 = scan.nextInt();
					System.out.println("Completion time of Process " + processNumber1 + " : " + jobScheduler.completionTime(processNumber1));
					break;
				case 3:
					System.out.println("Enter process number: ");
					int processNumber2 = scan.nextInt();
					System.out.println("Waiting time of Process " + processNumber2 + " : " + jobScheduler.waitingTime(processNumber2));
					break;
				case 4:
					System.out.println("Enter process number: ");
					int processNumber3 = scan.nextInt();
					System.out.println("Turnaround time of Process " + processNumber3 + " : " + jobScheduler.turnAroundTime(processNumber3));
					break;
				case 5:
					System.out.println("Average waiting time: " + jobScheduler.averageWaitingTime());
					break;
                case 6:
					System.out.println("Maximum waiting time: " + jobScheduler.maximumWaitingTime());
					break;
				case 7:
					System.exit(0);
					break;  
				default:
					System.out.println("Wrong Entry");
					break;
            }
        }
    }
}