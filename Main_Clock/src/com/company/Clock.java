package com.company;

public class Clock implements Observer_Clocks {
    public String clock_name;

    public Clock(String clock_name) {
        this.clock_name = clock_name;
    }

    @Override
    public void show_time(String time) {
        System.out.println(clock_name + ": " + time);

    }


}
