package com.lina.sorting;

public class insertionSort {
    static <T extends Comparable<T>> void swap(T [] x, int index1, int index2){
        T temp = x[index1];
        x[index1]= x[index2];
        x[index2] = temp;
    }

    public static <T extends Comparable<T>> void sort(T[] x){

    }
}
