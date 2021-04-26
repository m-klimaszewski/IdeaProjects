package com.company;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Service_Of_List<T> {
    public Service_Of_List() {
        list = new ArrayList<T>();
    }

    private Sort<T> sorter;
    private List<T> list;

    void sort() {
        list = sorter.Sorter(list);
    }

    public void set_sorter(Sort<T> strategy) {
        sorter = strategy;
    }

    public List<T> Get_List() {
        return list;
    }

    public void add(T val) {
        list.add(val);
    }

    public void clear() {
        list.clear();
    }

    public void print_menu() {
        System.out.println("Wybierz funkcję:\n1.Dodaj elementy do listy\n2.Otwórz menu sortowania\n3.Pokaż zawartość listy\n4. Zamknij program");
    }
    public void promt_enter_key(){
        System.out.println("Wciśnij \"ENTER\" aby kontynuować...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
    }

    public int inputAmount() {
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                return input.nextInt();
            } catch (java.util.InputMismatchException e) {
                System.out.println("Podałeś złą wartość, spróbuj jeszsze raz:");
                input.nextLine();
            }
        }
    }

    public void Print_List() {
        Iterator<T> List_Iterator = list.iterator();
        while (List_Iterator.hasNext()) {
            System.out.println(List_Iterator.next());
        }
    }


}
