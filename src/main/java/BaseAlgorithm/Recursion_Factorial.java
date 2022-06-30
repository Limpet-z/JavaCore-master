package BaseAlgorithm;

import java.math.BigInteger;

public class Recursion_Factorial {

    public static BigInteger factorial(int value) { // value = 5;

        if (value <= 1) {
            return BigInteger.valueOf(1);
        } else {
            return BigInteger.valueOf(value).multiply(factorial(value - 1));
        }
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}