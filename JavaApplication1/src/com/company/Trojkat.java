package com.company;

public class Trojkat extends Rysownik {

    public String typ = "Trojkat";

    @Override
    public void Rysuj() {
        System.out.println(typ);
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < h; j++) {
                System.out.print(" * ");
            }
            h--;
            System.out.println();
        }
    }
}