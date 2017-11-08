package edu.matc.multithreadingExercise;

import org.junit.Test;

import static org.junit.Assert.*;

public class RileyTest {
    @Test
    public void testThread() throws Exception {
        System.out.println("Just before creating a new runnable...");
        Halloween halloween = new Halloween();
        Riley riley = new Riley(halloween);
        Thread runnableThread = new Thread(riley);
        runnableThread.start();
    }
}