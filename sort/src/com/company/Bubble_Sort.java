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

