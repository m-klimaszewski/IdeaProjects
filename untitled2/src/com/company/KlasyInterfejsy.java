package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

interface ObserverClock {
    void showTime();
}

abstract class CentralClock extends Thread {
    abstract void Subscribe(Zegar zegar);
    abstract void Unsubscribe(Zegar zegar);
    abstract void showTimes();
}

class Zegar implements ObserverClock {
    public String ClockInfo;

    public Zegar(String info) {
        this.ClockInfo = info;
    }
    public void showTime() {
        String czytelnyZapisMinut;
        String czytelnyZapisGodzin;
        if (Dom.elapsedMinutes < 10) {
            czytelnyZapisMinut = "0" + Dom.elapsedMinutes;
        } else {
            czytelnyZapisMinut = "" + Dom.elapsedMinutes;
        }
        if (Dom.elapsedHours < 10) {
            czytelnyZapisGodzin = "0" + Dom.elapsedHours;
        } else {
            czytelnyZapisGodzin = "" + Dom.elapsedHours;
        }
        System.out.println(this.ClockInfo + ":   " + czytelnyZapisGodzin + ":" + czytelnyZapisMinut);
    }
}

class Dom extends CentralClock {
    private volatile boolean running = true;
    public static volatile int elapsedMinutes = 0;
    public static volatile int elapsedHours = 0;
    static List<Zegar> zegary = new ArrayList<>();

    public synchronized void stopClock() {
        this.running = false;
    }
    @Override
    public void Subscribe(Zegar zegar) {
        zegary.add(zegar);
    }
    @Override
    public void Unsubscribe(Zegar zegar) {
        zegary.remove(zegar);
    }
    boolean isSubscribed(Zegar zegar) {
        if (zegary.contains(zegar)) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void showTimes() {
        for (Zegar zegar : zegary) {
            zegar.showTime();
        }
        System.out.println();
    }
    @Override
    public void run() {
        while (running) {
            try {
                showTimes();
                elapsedMinutes = elapsedMinutes + 5;
                if (elapsedMinutes >= 60) {
                    elapsedMinutes = 0;
                    elapsedHours += 1;
                }
                if (elapsedHours >= 24) {
                    elapsedMinutes = 0;
                    elapsedHours = 0;
                }
                Thread.sleep(10000);
            } catch (InterruptedException ex) {
                Logger.getLogger(CentralClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

