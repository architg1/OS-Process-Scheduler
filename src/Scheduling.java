

public abstract class Scheduling {

    public static int TOTAL_NUMBER = 100;

    protected ProcessControlBlock PCB[] = new ProcessControlBlock[100];

    public void initialise(){
        for(int i=0; i<100; i++){
            PCB[i] = new ProcessControlBlock();
        }
    }

    public void add(int processID, int processPriority, int processBurstTime){
        // processID has to be between 0 and 99
        PCB[processID].setProcessID(processID);
        PCB[processID].setProcessPriority(processPriority);
        PCB[processID].setProcessBurstTime(processBurstTime);
        PCB[processID].setProcessStatus(0);

        if(processID==0){
            PCB[processID].setProcessPre(null);
        }
        else{
            PCB[processID].setProcessPre(PCB[processID-1]);
        }

        if(processID==99){
            PCB[processID].setProcessPost(null);
        }
        else{
            PCB[processID].setProcessPost(PCB[processID+1]);
        }

        ProcessControlBlock.numberOfProcesses++;
    }

    public void run(int processID){
        System.out.println("Process Number: " + processID + " is running");
        while(PCB[processID].getProcessBurstTime()>0){
            PCB[processID].decrementBurst();
        }
        if(PCB[processID].getProcessBurstTime()==0) {
            PCB[processID].setProcessStatus(1);
            System.out.println("Process " + processID + " completed");
        }
    }

    public abstract void run();
}


