package com.lina.problems;

import java.util.*;

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

*[1, 2, 3, 4, 5, 6, 7]

*However, we notice that there are some missing numbers in the sequence.

*[1, 2, 4, 5, 7] --> [3,6]
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
/*
Here's the definition of an anagram: a word, phrase, or name formed by rearranging the letters of another: such as cinema, formed from iceman.

We are given two strings like "cinema" and "iceman" as inputs. Can you write a method isAnagram(str1, str2)
that will return true or false depending on whether the strings are anagrams of each other?
 */
    public static boolean isAnagram(String inputA, String inputB) {
        if(inputA.length() != inputB.length()){
            return false;
        }
        char[] char1 = inputA.toLowerCase().toCharArray();
        char[] char2 = inputB.toLowerCase().toCharArray();
        Arrays.sort(char1);
        Arrays.sort(char2);
        return Arrays.equals(char1,char2);
    }
/*
Given a string str, can you write a method that will return True if is a palindrome and False if it is not? If you'll recall,
a palindrome is defined as "a word, phrase, or sequence that reads the same backward as forward"
 */
    public static boolean isPalindrome(String str) {
        for(int i=0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
/*
*Given an integer num, write a method to determine if it is a power of 3.
 */
    public static boolean powerOfThree(int num) {
        int currentQuotient = num;
        while(currentQuotient>0){
            currentQuotient=currentQuotient/3;
            if(currentQuotient == 1){
                return true;
            }
        }
        return false;
    }

/*
*In a given array of numbers, one element will show up once and the others will each show up twice.
*Can you find the number that only appears once in O(n) linear time? Bonus points if you can do it in O(1) space as well.
 */
    public static int lonelyNumber(int[] numbers) {
        HashMap<Integer,Integer> lonelyMap = new HashMap<>();
        for(int i=0; i<numbers.length;i++){
            if(lonelyMap.containsKey(numbers[i])){
                lonelyMap.remove(numbers[i]);
            }else {
                lonelyMap.put(numbers[i],1);
            }
        }
        return lonelyMap.keySet().iterator().next();
    }

    public static int fibonacciSequenceRecursive(int n){
        if(n==0){
            return 0;
        }
        if(n ==1){
            return 1;
        }
        return fibonacciSequenceRecursive(n-1) + fibonacciSequenceRecursive(n-2);
    }

    public static int fibonacciIterative(int n){
        if(n==0){
            return 0;
        }
        int n1 = 1;
        int n2 = 1;
        for(int i =1;i<n;i++){
            int sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }
        return n2;
    }
    /*
    Given two strings, one named sub and the other str, determine if sub is a subsequence of str.
    What is subsequence? You can think of it as a substring, but the letters don't have to be adjacent.
    It is formed from the base string by deleting some or none of the characters without affecting the relative positions of the other letters.
     */
    public static boolean isASubsequence(String sub, String str){
        int indexStr = 0;
        int indexSub = 0;
        while(indexStr<str.length()){
            if(sub.charAt(indexSub) == str.charAt(indexStr)){
                indexSub++;
                indexStr++;
                if(indexSub == sub.length()){
                    return true;
                }
            }else{
                indexStr++;
            }
        }
        return false;
    }

    public static int[] twoSum(int[] arr, int goal){
        int[] result = new int[2];
        HashMap<Integer,Integer> resultMap = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(resultMap.containsKey(arr[i])){
                result[0] = resultMap.get(arr[i]);
                result[1] = i;
                return result;
            }else{
                resultMap.put(goal - arr[i], i);
            }
        }
        return result;
    }

    public static int stockOptimizer(int[] prices){
        if(prices == null){
            return 0;
        }
        int currmax= prices[prices.length-1];
        int maxProfit = 0;
        for(int i=prices.length-1;i>=0;i--){
            if(prices[i]>currmax){
                currmax = prices[i];
            }
            if(maxProfit<currmax-prices[i]){
                maxProfit = currmax-prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
       /* System.out.println(Main.lonelyNumber(new int[]{1, 1, 2, 3, 3}));
        System.out.println(Main.fibonacciSequenceRecursive(2));
        System.out.println(Main.fibonacciIterative(2));
        System.out.println(Main.isASubsequence("b","co"));*//*
        System.out.println(Arrays.toString(Main.twoSum(new int[]{1, 3, 10, 2, 8, 4}, 7)));*/
        System.out.println(Main.stockOptimizer(new int[]{10, 7, 6, 2, 9, 4}));


    }
}
