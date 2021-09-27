public class RoundRobin extends Scheduling{

    public void run(){
        // default quantum of 20
        // q is the quantum
        int done = 0;
        while(done==0){
            for(int processID=0; processID<TOTAL_NUMBER; processID++){

                if(PCB[processID].getProcessStatus()==0){
                    int val = 20;

                    System.out.println("Process " + processID + ": running");

                    while(val>0){
                        PCB[processID].decrementBurst();
                        val-=5;

                        if(PCB[processID].getProcessBurstTime()==0){
                            PCB[processID].setProcessStatus(1);
                            System.out.println("Process " + processID + ": completed");
                        }
                    }

                    if(PCB[processID].getProcessBurstTime()==0 && PCB[processID].getProcessStatus()!=1){
                        PCB[processID].setProcessStatus(1);
                        System.out.println("Process " + processID + " completed");
                    }
                }
            }

            // to check if any process is incomplete
            int count = 0;
            for(int i=0; i<TOTAL_NUMBER; i++){
                if(PCB[i].getProcessStatus()==0){
                    count++;
                }
            }
            if(count==0) done = 1;
        }
    }

    public void run(int q){
        // q is the quantum
        int done = 0;
        while(done==0){
            for(int processID=0; processID<TOTAL_NUMBER; processID++){

               if(PCB[processID].getProcessStatus()==0){
                   int val = q;

                   System.out.println("Process " + processID + ": running");

                   while(val>0){
                       PCB[processID].decrementBurst();
                       val-=5;

                       if(PCB[processID].getProcessBurstTime()==0){
                           PCB[processID].setProcessStatus(1);
                           System.out.println("Process " + processID + ": completed");
                       }
                   }

                   if(PCB[processID].getProcessBurstTime()==0 && PCB[processID].getProcessStatus()!=1){
                       PCB[processID].setProcessStatus(1);
                       System.out.println("Process " + processID + " completed");
                   }
               }
            }

            // to check if any process is incomplete
            int count = 0;
            for(int i=0; i<TOTAL_NUMBER; i++){
                if(PCB[i].getProcessStatus()==0){
                    count++;
                }
            }
            if(count==0) done = 1;
        }
    }



}
