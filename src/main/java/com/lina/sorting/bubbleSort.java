package com.lina.sorting;

import javax.sound.midi.Soundbank;
import java.util.Arrays;

public class bubbleSort {
    static <T extends Comparable<T>> void swap(T [] x, int index1, int index2){
        T temp = x[index1];
        x[index1]=x[index2];
        x[index2] = temp;
    }

    public static <T extends Comparable<T>> void sort(T [] x){
        for(int i=0;i<x.length-1;i++){
            for(int j=1; j<x.length-i;j++){
                if(x[j-1].compareTo(x[j])>0){
                    swap(x,j-1,j);
                }
            }
        }
    }
//TODO: Move this to Test
    public static void main(String[] args) {
        Integer[] x = {2,3,11,6,1};
        bubbleSort.sort(x);
        Arrays.stream(x).forEach(i-> System.out.println(i));
    }
}
