package edu.matc.multithreadingExercise;

public class RileyActions {

    public void doTheThreads() {
        Halloween halloween = new Halloween();

        Riley riley = new Riley(halloween);
        KidGenerator kidGenerator = new KidGenerator(halloween);

        Thread threadRiley = new Thread(riley);
        Thread threadKidGenerator = new Thread(kidGenerator);
        threadKidGenerator.start();
        threadRiley.start();
    }
}
