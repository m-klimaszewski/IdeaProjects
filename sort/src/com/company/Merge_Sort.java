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


