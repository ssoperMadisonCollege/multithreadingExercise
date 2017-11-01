package edu.matc.multithreadingExercise;

import java.util.Date;
import java.util.concurrent.TimeUnit;

class KidGenerator implements Runnable
{
    Halloween halloween;

    public KidGenerator(Halloween halloween)
    {
        this.halloween = halloween;
    }

    public void run()
    {
        while(true)
        {
            Kid kid = new Kid(halloween);
            kid.setInTime(new Date());
            Thread threadKid = new Thread(kid);
            kid.setName("Kid Thread "+threadKid.getId());
            threadKid.start();

            try
            {
                TimeUnit.SECONDS.sleep((long)(Math.random()*10));
            }
            catch(InterruptedException iex)
            {
                iex.printStackTrace();
            }
        }
    }

}
