public class CPU {

    public static void main(String[] args){
        Scheduling scheduler = new RoundRobin();
        scheduler.initialise();
        scheduler.add(1, 1, 80);
        scheduler.add(2, 2, 45);
        scheduler.add(3, 4, 30);
        scheduler.add(4, 3, 100);
        scheduler.run(30);
    }
}
