package edu.matc.multithreadingExercise;

public class RileyActions {

    public void doTheThreads() {

        System.out.println("Starting a new RileyActions instance");

        Halloween halloween = new Halloween();

        Riley riley = new Riley(halloween);
        KidGenerator kidGenerator = new KidGenerator(halloween);

        Thread threadRiley = new Thread(riley);
        Thread threadKidGenerator = new Thread(kidGenerator);
        threadKidGenerator.start();
        System.out.println("This class instance (RileyActions) started a kid generator thread...");
        threadRiley.start();
        System.out.println("This class instance (RileyActions) started a Riley thread...");
    }
}
