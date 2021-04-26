package com.company;

import java.io.*;
import java.lang.reflect.Array;


public class Main {


    public static <T> void main(String[] args) {
        MyCustomList myCustomList = new MyCustomList<T>();
        //add elem to table
        myCustomList.add(5);
        myCustomList.add('a');
        myCustomList.add("abx");
        myCustomList.add(8);
        myCustomList.add(0);
        //add elem to table at index 2
        myCustomList.add(2, 'p');
        // return last elem and remove it
        System.out.println(myCustomList.pop());
        // returns the elem at index 2
        System.out.println(myCustomList.get(2));
        //return size of table
        System.out.println(myCustomList.size());
        //remove and returns elem at index 2
        System.out.println(myCustomList.remove(2));
        //returns the elem at index 2
        System.out.println(myCustomList.get(2));
    }
}
