
public class PriorityBased extends Scheduling {

    public void run(){
        int total_no = ProcessControlBlock.getTotalProcesses();
        ProcessControlBlock SortedPCB[] = PCB;

        // sorting by priority

        boolean sorted = false;
        ProcessControlBlock temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < 11; i++) {
                if (SortedPCB[i].getProcessPriority() > SortedPCB[i+1].getProcessPriority()) {
                    temp = SortedPCB[i];
                    SortedPCB[i] = SortedPCB[i+1];
                    SortedPCB[i+1] = temp;
                    sorted = false;
                }
            }
        }

        // sorted


        for(int processID=0; processID<TOTAL_NUMBER; processID++){
            if(SortedPCB[processID].getProcessStatus()==0){

                System.out.println("Process " + SortedPCB[processID].getProcessID() + " is running");

                while(SortedPCB[processID].getProcessBurstTime()>0){
                    SortedPCB[processID].decrementBurst();
                    //System.out.println("Remaining CPU Burst: " + SortedPCB[i].getProcessBurstTime());
                }

                if(SortedPCB[processID].getProcessBurstTime()==0){
                    SortedPCB[processID].setProcessStatus(1);
                    System.out.println("Process " + SortedPCB[processID].getProcessID() + " completed");
                }
            }
            else{
                continue;
            }
        }
    }

}
