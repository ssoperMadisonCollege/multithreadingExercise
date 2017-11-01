package edu.matc.multithreadingExercise;

class Riley implements Runnable
{
    Halloween halloween;

    public Riley(Halloween halloween)
    {
        this.halloween = halloween;
        System.out.println("Created Riley instance");
    }
    public void run()
    {
        System.out.println("Starting a Riley thread");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley thread started");
        while(true)
        {
            System.out.println("Giving candy...");
            halloween.giveCandy();
        }
    }
}
