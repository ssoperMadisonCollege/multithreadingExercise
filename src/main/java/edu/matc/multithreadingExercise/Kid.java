package edu.matc.multithreadingExercise;

import java.util.Date;

class Kid implements Runnable {
    String name;
    Date inTime;

    Halloween halloween;

    public Kid(Halloween halloween)
    {
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