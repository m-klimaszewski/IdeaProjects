# Uniwersytet Śląski
## Wydział Nauk Ścisłych i Technicznych
### Wzorce Projektowe, Zadanie 2 - Strategia.
> Wykonał: Mateusz Klimaszewski, gr. PGK 2.  
> Data ćwiczenia: 12.04.2021r.

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>


#  Pliki:

- Lists:
    - <a href="#SOL">Service_Of_List.java</a>
 
- SortingStrategies:
    - <a href="#S">Sort.java</a>
    - IntegerSorting:
        - <a href="#BS">Bubble_Sort.java</a>
        - <a href="#MS">Merge_Sort.java</a>
        - <a href="#IS">Insertion_Sort.java</a>

- <a href="#M">Main.java</a>

> Odpowiedź na pytanie zadane w poleceniu znajduje się <a href="#Answer">TUTAJ</a>  



<div id="M"></div>

##Main.java
```
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

```

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>

## Lists:

<div id="SOL"></div>

### Service_Of_List
```
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
```

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>


## Sorting strategies:

<div id="S"></div>

### Sort.java
```
package com.company;

import java.util.List;

public interface Sort<T> {
    public List<T> Sorter(List<T> list);
}

```

<div id="BS"></div>

### Bubble_Sort.java
```
package com.company;

import java.util.List;

public class Bubble_Sort implements Sort<Integer> {

    @Override
    public List<Integer> Sorter(List<Integer> list) {
        int temp = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 1; j < (list.size() - i); j++) {
                if (list.get(j - 1) > list.get(j)) {
                    //swap the elements!
                    temp = list.get(j - 1);
                    list.set(j - 1, list.get(j));
                    list.set(j, temp);
                }

            }
        }
        return list;
    }
}

```

<div id="MS"></div>

### Merge_Sort.java
```
package com.company;

import java.util.ArrayList;
import java.util.List;

public class Merge_Sort implements Sort<Integer> {

    @Override
    public List<Integer> Sorter(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> aList = new ArrayList<Integer>(list.subList(0, list.size() / 2));
        List<Integer> bList = new ArrayList<Integer>(list.subList(list.size() / 2, list.size()));

        Sorter(aList);
        Sorter(bList);

        merge(aList, bList, list);
        return list;
    }


    private static List<Integer> merge(List<Integer> alist,
                                       List<Integer> blist, List<Integer> list) {
        int alistIndex = 0, blistIndex = 0, listIndex = 0;
        while (alistIndex < alist.size() && blistIndex < blist.size()) {
            if (alist.get(alistIndex) < blist.get(blistIndex)) {
                list.set(listIndex, alist.get(alistIndex));
                alistIndex++;
            } else {
                list.set(listIndex, blist.get(blistIndex));
                blistIndex++;
            }
            listIndex++;
        }
        List<Integer> rest;
        if (alistIndex == alist.size()) {
            rest = blist.subList(blistIndex, blist.size());
            for (int c = blistIndex; c < rest.size(); c++) {
                list.set(listIndex, blist.get(c));
                listIndex++;
            }
        } else {
            rest = alist.subList(alistIndex, alist.size());
            for (int c = alistIndex; c < rest.size(); c++) {
                list.set(listIndex, alist.get(c));
                listIndex++;
            }
        }
        return list;
    }
}



```

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>



<div id="IS"></div>

### Insertion_Sort.java
```
package com.company;

import java.util.List;

public class Insertion_Sort implements Sort<Integer> {

    @Override
    public List<Integer> Sorter(List<Integer> list) {
        for (var i = 0; i < list.size(); i++) {
            var item = list.get(i);
            var current_index = i;
            while ((current_index > 0) && (list.get(current_index - 1) > item)) {
                list.set(current_index, list.get(current_index - 1));
                current_index--;
            }
            list.set(current_index, item);
        }
        return list;
    }
}

```

<div style="page-break-after: always; visibility: hidden"> 
\pagebreak 
</div>



<div id="Answer"></div>

## Jak takie sortowanie można zrealizować na liście generycznej?
<div style="text-align: justify; background-color: #f6f8fa; padding: 5px 10px; border-radius: 2.5px">
<p>Aby móc sortowac listę generyczną trzeba poznać/wiedzieć jakie typy się w niej znajdują. Wtedy implementujemy funkcję porównawczą i wyszukujemy z listy interesujący nas typ danych. Następnie trzeba dopasować odpowiedni algorytm do danego typu danych.</p>

</div>
sprawozdanie.md
14 KB