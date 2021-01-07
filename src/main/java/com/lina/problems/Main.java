package com.lina.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static String reverseString(String str){
        StringBuilder builder = new StringBuilder(str);
        builder.reverse();
        str = builder.toString();
        return str;
    }
/*
Fizz Buzz is a classic interview question that apparently many engineering candidates can't solve! Let's cover it today.

We're given a number in the form of an integer n.

Write a function that returns the string representation of all numbers from 1 to n based on the following rules:

If it's a multiple of 3, represent it as "fizz".

If it's a multiple of 5, represent it as "buzz".

If it's a multiple of both 3 and 5, represent it as "fizzbuzz".

If it's neither, just return the number itself.
 */
    public static String fizzBuzz(Integer num) {
        StringBuilder builder = new StringBuilder();
        for(int i =1; i<=num;i++){
            if(i%3 == 0 && i%5 == 0){
                builder.append("fizzbuzz") ;
            }
            else if(i%3 ==0){
                builder.append("fizz") ;
            }
            else if(i%5 == 0){
                builder.append("buzz") ;
            }
            else {
                builder.append(Integer.toString(i));
            }
        }

        return builder.toString();
    }

    /*
    Can you write a function that takes two arrays as inputs and returns to us their intersection?
    We can call the method intersection. Let's return the intersection of the two inputs in the form of an array.
    As a reminder, the definition of an intersection of two sets A and B is the set containing
    all elements of A that also belong to B (or equivalently, all elements of B that also belong to A).
    * */

    public static Integer[] intersection(int[] a, int[] b){
        HashMap<Integer,Integer> arrayMap = new HashMap<Integer,Integer>();
        Arrays.stream(a).forEach(i -> {
            if (arrayMap.containsKey(i)) {
                arrayMap.put(i, arrayMap.get(i)+1);
            } else{
                arrayMap.put(i,1);
            }
        });
        return Arrays.stream(b).filter(i -> arrayMap.containsKey(i)).distinct().boxed().toArray(Integer[]::new);
    }

    /*
    * We're given an array of continuous numbers that should increment sequentially by 1, which just means that we expect a sequence like:

[1, 2, 3, 4, 5, 6, 7]

However, we notice that there are some missing numbers in the sequence.

[1, 2, 4, 5, 7] --> [3,6]
* */
    public static List<Integer> missingNumbers(int[] numArr) {
        int prevNum = numArr[0];
        int lastNum = numArr[numArr.length - 1];
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i =1;i<numArr.length;i++){
            while(numArr[i]!= prevNum+1){
                prevNum = prevNum+1;
                result.add(prevNum);
            }
            prevNum = prevNum+1;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Main.missingNumbers(new int[]{3, 7, 9, 19}));
    }
}
