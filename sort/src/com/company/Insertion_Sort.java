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
