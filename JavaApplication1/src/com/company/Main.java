package com.company;

public class Main extends Rysownik {


    public static void main(String[] args) {
        Rysownik rysownik = new Kwadrat();
        rysownik.Rysuj();
        Rysownik rysownik1 = new Prostokat();
        rysownik1.Rysuj();
        Rysownik rysownik2 = new Trojkat();
        rysownik2.Rysuj();
    }
}
