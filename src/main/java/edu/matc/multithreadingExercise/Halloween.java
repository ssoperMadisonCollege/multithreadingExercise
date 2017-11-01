package edu.matc.multithreadingExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Halloween {
    int kidLinePosition;
    List<Kid> listOfKids;

    public Halloween()
    {
        kidLinePosition = 10;
        listOfKids = new LinkedList<Kid>();
        System.out.println("Created a Halloween, there are " + kidLinePosition + " positions in Riley's line...");
    }

    public void giveCandy()
    {
        Kid kid;
        System.out.println("Riley waiting for lock.");
        synchronized (listOfKids)
        {

            while(listOfKids.size()==0)
            {
                System.out.println("Riley is waiting for kid.");
                try
                {
                    listOfKids.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley found a kid in line.");
            kid = (Kid)((LinkedList<?>)listOfKids).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Riley telling " + kid.getName() + " their costume is super cool and giving them candy");
            duration = (long)(Math.random()*10);
            TimeUnit.SECONDS.sleep(duration);
        }
        catch(InterruptedException iex)
        {
            iex.printStackTrace();
        }
        System.out.println("Riley completed giving candy to Kid : "+kid.getName() + " in "+duration+ " seconds.");
    }

    public void add(Kid kid)
    {
        System.out.println("Kid : " + kid.getName() + " entering halloween (the dark of the night) at "+kid.getInTime());

        synchronized (listOfKids)
        {
            if(listOfKids.size() == kidLinePosition)
            {
                System.out.println("No candy available for kid "+kid.getName());
                System.out.println("Kid "+ kid.getName() + " Exists...");
                return ;
            }

            ((LinkedList<Kid>)listOfKids).offer(kid);
            System.out.println("Kid : " + kid.getName() + " got the candy.");

            if(listOfKids.size()==1)
                listOfKids.notify();
        }
    }
}
