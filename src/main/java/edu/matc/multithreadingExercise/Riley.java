package edu.matc.multithreadingExercise;

class Riley implements Runnable
{
    Halloween halloween;

    public Riley(Halloween halloween)
    {
        this.halloween = halloween;
        System.out.println("Created Riley instance...");
    }
    public void run()
    {
        System.out.println("Starting to start Riley thread...");
        try
        {
            Thread.sleep(3000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley instance finished starting...");
        while(true)
        {
            System.out.println("MADE IT HERE");
            halloween.giveCandy();
        }
    }
}
