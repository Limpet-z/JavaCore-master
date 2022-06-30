package BaseAlgorithm;

import java.math.BigInteger;

public class Factorial {

    public static BigInteger factorial(int value) { // value = 5;

        BigInteger result = BigInteger.valueOf(1);
        for (int i = 1; i <= value; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));
    }
}
