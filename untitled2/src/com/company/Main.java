package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       ze
        Zegar zegarKuchenny = new Zegar("Czas zegara kuchennego");
        Zegar zegarOgrodowy = new Zegar("Czas zegara ogrodowego");
        System.out.println("Menu:");
        System.out.println("Aby uruchomic Zegar Centralny nacisnij 1");
        System.out.println("W celu dodania/usuniecia wyswietlacza pokojowego nacisnij 2");
        System.out.println("W celu dodania/usuniecia wyswietlacza kuchennego nacisnij 3");
        System.out.println("W celu dodania/usuniecia wyswietlacza ogrodowego nacisnij 4");
        System.out.println("Aby zakonczyc dzialanie programu nacisnij 0");
        System.out.println();
        Dom domek = new Dom();
        Scanner s = new Scanner(System.in);
        boolean running = false;
        int userInputNumber;
        try {
            while ((userInputNumber = s.nextInt()) != 0) {
                switch (userInputNumber) {
                    case 1:
                        if (running) {
                            System.out.println("Zegar Centralny juz dziala!");
                            System.out.println();
                        } else {
                            System.out.println("Zegar Centralny rozpoczal prace");
                            System.out.println();
                            running = true;
                            domek.start();
                        }
                        break;
                    case 2:
                        if (!domek.isSubscribed(zegarPokojowy)) {
                            System.out.println("Dodano wyswietlacz pokojowy");
                            System.out.println();
                            domek.Subscribe(zegarPokojowy);
                        } else {
                            System.out.println("Usunieto wyswietlacz pokojowy");
                            System.out.println();
                            domek.Unsubscribe(zegarPokojowy);
                        }
                        break;
                    case 3:
                        if (!domek.isSubscribed(zegarKuchenny)) {
                            System.out.println("Dodano wyswietlacz kuchenny");
                            System.out.println();
                            domek.Subscribe(zegarKuchenny);
                        } else {
                            System.out.println("Usunieto wyswietlacz kuchenny");
                            System.out.println();
                            domek.Unsubscribe(zegarKuchenny);
                        }
                        break;
                    case 4:
                        if (!domek.isSubscribed(zegarOgrodowy)) {
                            System.out.println("Dodano wyswietlacz ogrodowy");
                            System.out.println();
                            domek.Subscribe(zegarOgrodowy);
                        } else {
                            System.out.println("Usunieto wyswietlacz ogrodowy");
                            System.out.println();
                            domek.Unsubscribe(zegarOgrodowy);
                        }
                        break;
                    default:
                        System.out.println("Wybrano nieprawidlowa opcje");
                        System.out.println();
                        break;
                }
            }
        } finally {
            domek.stopClock();
            System.out.println("Zegar Centralny zatrzymany, koniec programu.");
        }    }
}
