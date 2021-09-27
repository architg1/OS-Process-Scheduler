public class ProcessControlBlock {
    private int processID;
    private int processPriority;
    private int processBurstTime;
    private int processStatus; // -1 for not created, 0 for unfinished and 1 for finished
    private ProcessControlBlock processPost;
    private ProcessControlBlock processPre;
    protected static int numberOfProcesses;


    // constructors
    public ProcessControlBlock(){
        this.processID = -1;
        this.processPriority = -1;
        this.processBurstTime = 0;
        this.processStatus = -1;
        this.processPre = null;
        this.processPost = null;
    }

    public ProcessControlBlock(int processID, int processPriority, int processBurstTime){
        this.processID = processID;
        this.processPriority = processPriority;
        this.processBurstTime = processBurstTime;
        this.processStatus = -1;
        this.processPre = null;
        this.processPost = null;
        this.numberOfProcesses++;
    }

    // getter and setter methods

    public int getProcessID(){
        return processID;
    }
    public void setProcessID(int processID){
        this.processID = processID;
    }

    public int getProcessPriority(){
        return processPriority;
    }
    public void setProcessPriority(int processPriority){
        this.processPriority = processPriority;
    }

    public int getProcessBurstTime(){
        return processBurstTime;
    }
    public void setProcessBurstTime(int processBurstTime){
        this.processBurstTime = processBurstTime;
    }

    public int getProcessStatus(){
        return processStatus;
    }
    public void setProcessStatus(int processStatus){
        this.processStatus = processStatus;
    }

    public static int getTotalProcesses(){
        return numberOfProcesses ;
    }

    public ProcessControlBlock getProcessPre(){
        return processPre;
    }
    public void setProcessPre(ProcessControlBlock processPre){
        this.processPre = processPre;
    }

    public ProcessControlBlock getProcessPost(){
        return processPost;
    }
    public void setProcessPost(ProcessControlBlock processPost){
        this.processPost = processPost;
    }

    // other  methods

    public void decrementBurst(){
        processBurstTime = processBurstTime - 5;
    }

    public void decrementBurst(int decrement){
        processBurstTime = processBurstTime - decrement;
    }

    public void incrementBurst(){
        processBurstTime = processBurstTime + 5;
    }

    public void incrementBurst(int increment){
        processBurstTime = processBurstTime + increment;
    }






}
