package com.company;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main(String[] arg) {
        Service_Of_List sol = new Service_Of_List<Integer>();
        //Select function
        sol.print_menu();
        int type_of_function = sol.inputAmount();
        do {
            if (type_of_function == 1) {
                System.out.println("Podaj liczbę iteracji: ");
                int num_of_iteration = sol.inputAmount();
                do {
                    System.out.println("Podaj liczbę całkowitą:");
                    int in = sol.inputAmount();
                    sol.add(in);
                    num_of_iteration--;
                } while (num_of_iteration != 0);
            } else if (type_of_function == 2) {
                if (sol.Get_List().isEmpty() == false) {
                    System.out.println("Wybierz typ sortowania: \n1. Sortowanie bąbelkowe \n2.Sortowanie przez wstawianie\n3. Sortowanie przez scalanie");
                    int Type_Of_Sort = sol.inputAmount();
                    switch (Type_Of_Sort) {
                        case 1:
                            System.out.println("Sortowanie bąbelkowe");
                            sol.set_sorter(new Bubble_Sort());
                            break;
                        case 2:
                            System.out.println("Sortowanie przez wstawianie");
                            sol.set_sorter(new Insertion_Sort());
                            break;
                        case 3:
                            System.out.println("Sortowanie przez scalanie");
                            sol.set_sorter(new Merge_Sort());
                            break;

                    }
                    sol.sort();
                } else {
                    System.out.println("Lista jest pusta. Dodaj elementy do tablicy...");
                }

            } else if (type_of_function == 3) {
                if (sol.Get_List().isEmpty() != true) {
                    sol.Print_List();
                } else {
                    System.out.println("Twoja lista jest pusta!");
                }

            }
            sol.promt_enter_key();
            sol.print_menu();
            type_of_function = sol.inputAmount();


        } while (type_of_function != 4);


    }

}

