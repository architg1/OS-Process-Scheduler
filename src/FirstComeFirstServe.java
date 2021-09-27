public class FirstComeFirstServe extends Scheduling{

    public void run(){
        for(int processID=0; processID < TOTAL_NUMBER; processID++){
            if(PCB[processID].getProcessStatus()==0){

                System.out.println("Process " + processID + " is running");

                while(PCB[processID].getProcessBurstTime()>0){
                    PCB[processID].decrementBurst();
                    //System.out.println("Remaining CPU Burst: " + PCB[processID].getProcessBurstTime());
                }

                if(PCB[processID].getProcessBurstTime()==0){
                    PCB[processID].setProcessStatus(1);
                    System.out.println("Process " + processID + " completed");
                }
            }
            else{
                continue;
            }
        }
    }
}
