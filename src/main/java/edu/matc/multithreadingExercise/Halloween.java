package edu.matc.multithreadingExercise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class Halloween {
    int kidLinePosition;
    List<Kid> listKid;

    public Halloween()
    {
        kidLinePosition = 3;
        listKid = new LinkedList<Kid>();
    }

    public void giveCandy()
    {
        Kid kid;
        System.out.println("Riley waiting for lock.");
        synchronized (listKid)
        {

            while(listKid.size()==0)
            {
                System.out.println("Riley is waiting for kid.");
                try
                {
                    listKid.wait();
                }
                catch(InterruptedException iex)
                {
                    iex.printStackTrace();
                }
            }
            System.out.println("Riley found a kid in line.");
            kid = (Kid)((LinkedList<?>)listKid).poll();
        }
        long duration=0;
        try
        {
            System.out.println("Riley telling Kid their costume is super cool : "+kid.getName());
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
        System.out.println("Kid : "+kid.getName()+ " entering halloween at "+kid.getInTime());

        synchronized (listKid)
        {
            if(listKid.size() == kidLinePosition)
            {
                System.out.println("No candy available for kid "+kid.getName());
                System.out.println("Kid "+kid.getName()+"Exists...");
                return ;
            }

            ((LinkedList<Kid>)listKid).offer(kid);
            System.out.println("Kid : "+kid.getName()+ " got the candy.");

            if(listKid.size()==1)
                listKid.notify();
        }
    }
}
