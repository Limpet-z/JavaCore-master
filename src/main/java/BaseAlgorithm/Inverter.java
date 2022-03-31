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
        Scanner scanner = new Scanner(System.in);
//        System.out.println(methodM(Integer.parseInt(scanner.nextLine())));

        int[] x = {123,1,2,4,632,32,5,2,56,6,234,546,8,45,23,4};
        boolean isSorted = false;
        int buffer = 0;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < x.length - 1; i++) {

                if (x[i] > x[i + 1]) {
                    isSorted = false;
                    buffer = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = buffer;
                }
            }

        }
        System.out.println(Arrays.toString(x));
    }
}
