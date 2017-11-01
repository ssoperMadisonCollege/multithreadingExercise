package edu.matc.multithreadingExercise;

class Riley implements Runnable
{
    Halloween halloween;

    public Riley(Halloween halloween)
    {
        this.halloween = halloween;
    }
    public void run()
    {
        try
        {
            Thread.sleep(10000);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley started..");
        while(true)
        {
            halloween.giveCandy();
        }
    }
}
