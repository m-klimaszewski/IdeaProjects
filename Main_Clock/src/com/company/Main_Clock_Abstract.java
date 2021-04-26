package com.company;


import java.util.ArrayList;
import java.util.List;

abstract class Main_Clock_Abstract extends Thread {
    static List<Clock> clocks = new ArrayList<>();

    abstract void subscribe(Clock clock);

    abstract void unsubscribe(Clock clock);

    abstract boolean is_subscribed(Clock clock);

    abstract void send_msg_to_clocks();
}
