package edu.matc.multithreadingExercise;

import java.util.Date;

class Kid implements Runnable {
    String name;
    Date inTime;

    Halloween halloween;

    public Kid(Halloween halloween)
    {
        System.out.println("Created a new kid (on the block)...");
        this.halloween = halloween;
    }

    public String getName() {
        return name;
    }

    public Date getInTime() {
        return inTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInTime(Date inTime) {
        this.inTime = inTime;
        System.out.println("A time has been set for a kid...");
    }

    public void run()
    {
        goGetCandy();
    }
    private synchronized void goGetCandy()
    {
        halloween.add(this);
    }
}