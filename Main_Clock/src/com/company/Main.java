package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main_Clock main_clock = new Main_Clock();
        Clock zegar_kuchenny = new Clock("Zegar kuchenny");
        Clock zegar_pokojowy = new Clock("Zegar w pokoju");
        Clock zegar_ogrodowy = new Clock("Zegar ogrodowy");
        System.out.println("Witaj w programie zegarowym. Uruchom zegar główny, a następnie dwolony inny: ");
        System.out.println("1. Zegar główny\n2.Zegar kuchenny\n3. Zegar w pokoju\n4. Zegar w orodzie");
        Scanner scanner = new Scanner(System.in);
        int start = 0;
        final int run_cloak = 1;
        try {
            while ((start = scanner.nextInt()) != 0) {
                switch (start) {
                    case 1:
                        if (!main_clock.running) {
                            System.out.println("Uruchomiono zegar centralny");
                            main_clock.running = true;
                            main_clock.start();
                        } else {
                            System.out.println("Zegar centralny jest już urochomiony");
                        }

                        break;
                    case 2:
                        if (!main_clock.running) {
                            System.out.println("Uruchom zegar centralny, aby aktywować ten zegar");
                        } else {
                            if (!main_clock.is_subscribed(zegar_kuchenny)) {
                                System.out.println("Uruchomiono zegar w kuchni");
                                main_clock.subscribe(zegar_kuchenny);
                            } else {
                                main_clock.unsubscribe(zegar_kuchenny);
                                System.out.println("Zatrzymano zegar kuchenny");
                            }
                        }

                        break;
                    case 3:
                        if (!main_clock.running) {
                            System.out.println("Uruchom zegar centralny, aby aktywować ten zegar");
                        } else {
                            if (!main_clock.is_subscribed(zegar_pokojowy)) {
                                System.out.println("Uruchomiono w pokoju");
                                main_clock.subscribe(zegar_pokojowy);
                            } else {
                                main_clock.unsubscribe(zegar_pokojowy);
                                System.out.println("Zatrzymano zegar pokojowy");
                            }
                        }

                        break;
                    case 4:
                        if (!main_clock.running) {
                            System.out.println("Uruchom zegar centralny, aby aktywować ten zegar");
                        } else {
                            if (!main_clock.is_subscribed(zegar_ogrodowy)) {
                                System.out.println("Uruchomiono zegar w ogrodzie");
                                main_clock.subscribe(zegar_ogrodowy);
                            } else {
                                main_clock.unsubscribe(zegar_ogrodowy);
                                System.out.println("Zatrzymano zegar ogrodowy");
                            }
                        }

                        break;
                }
            }
        } finally {
            main_clock.stop_cloak();
            System.out.println("Zatrzymano zegar centralny. Żegnaj!");
        }

    }
}
