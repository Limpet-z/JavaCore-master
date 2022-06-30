package BaseAlgorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Inverter {
    /*
     * Input: 123456
     * Output: 654321
     * */

    public static int methodM(int x) {
        int result = 0;
        while (x != 0) {
            int i = x % 10; //6
            result = result * 10 + i; // 6*10+5=65/ 65*10+4//654*10+3
            x = x / 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(recursion(12345));
        System.out.println(methodM(12345));
    }

    public static int recursion(int i) {

        int result = 0;
        while (i != 0) {
            int j = i % 10;
            result = result * 10 + j;
            i = i/ 10;
        }
        return result;
    }
}
