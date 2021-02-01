package com.lina.problems;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MainTest {

    @Test
    @Description("Positive Scenario")
    void reverseString() {
        String result = Main.reverseString("Output");
        Assertions.assertEquals("tuptuO",result);
    }

    @Test
    void fizzBuzz() {
        Assertions.assertEquals("12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz",Main.fizzBuzz(15));
    }

    @Test
    void intersection() {
        System.out.println(Arrays.toString(Main.intersection(new int[]{1,2,2,1,3}, new int[]{3,2})));
    }

    @Test
    void missingNumbers() {
        System.out.println(Main.missingNumbers(new int[]{1,2,4,5,7}));
    }

    @Test
    void isAnagram() {
        Assertions.assertTrue(Main.isAnagram("abC","Cab"));
    }
}