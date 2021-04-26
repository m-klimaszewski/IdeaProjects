package com.company;
import java.util.Arrays;

public class MyCustomList<T> implements IMyList<T> {
    T[] list = (T[]) new Object[100];

    @Override
    public void add(T element) {
        for (int i = 0; i <= size(); i++) {
            if (list[i] != null) continue;
            list[i] = element;
            break;
        }
    }

    @Override
    public void add(int index, T element) {
        if (index > size()) {
            System.out.println("Za mala tablica");
        } else {
            list[index] = element;
        }

    }

    @Override
    public void clear() {
        Arrays.fill(list, null);
    }

    @Override
    public T pop() {
        T elem = null;
        for (int i = 0; i <= size(); i++) {
            if (list[i] != null) continue;
            elem = list[i - 1];
            list[i - 1] = null;
            break;
        }
        return elem;
    }

    @Override
    public T get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return list.length;
    }

    @Override
    public T remove(int index) {
        T elem = list[index];
        list[index] = null;
        return elem;
    }
}
