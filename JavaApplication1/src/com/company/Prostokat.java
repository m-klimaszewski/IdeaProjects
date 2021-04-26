package com.company;

public class Prostokat extends Rysownik {

    public String typ = "Prostokat";

    @Override
    public void Rysuj() {
        System.out.println(typ);
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
}
