package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main_Clock extends Main_Clock_Abstract {
    public volatile boolean running = false;
    static List<Clock> clocks = new ArrayList<>();

    public synchronized void stop_cloak() {
        this.running = false;
    }


    @Override
    public void run() {

        while (running) {
            try {
                send_msg_to_clocks();
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main_Clock.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }


    @Override
    void subscribe(Clock clock) {
        clocks.add(clock);
    }

    @Override
    void unsubscribe(Clock clock) {
        clocks.remove(clock);
    }

    @Override
    boolean is_subscribed(Clock clock) {
        if (clocks.contains(clock)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void send_msg_to_clocks() {
        for (Clock clock : clocks) {
            Main_Clock main_clock = new Main_Clock();
            LocalTime localTime = LocalTime.now();
            clock.show_time(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        }
    }
}
