package com.company;

public class Kwadrat extends Rysownik {

    public String typ = "Kwadrat";

    @Override
    public void Rysuj() {
        System.out.println(typ);
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= a; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}