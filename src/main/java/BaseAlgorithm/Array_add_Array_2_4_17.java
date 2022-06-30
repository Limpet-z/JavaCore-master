package BaseAlgorithm;

import java.util.Arrays;

public class Array_add_Array_2_4_17 {

    public static int[] mergeArrays(int[] a1, int[] a2) {

        int i = 0, j = 0, h = 0, a = a1.length, b = a2.length;
        int[] result = new int[a1.length + a2.length];

        while (i < a && j < b) {
            if (a1[i] <= a2[j]) {
                result[h] = a1[i];
                i++;
            } else {
                result[h] = a2[j];
                j++;
            }
            h++;
        }
        while (i < a) {
            result[h] = a1[i];
            i++;
            h++;
        }
        while (j < b) {
            result[h] = a2[j];
            j++;
            h++;
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(mergeArrays(new int[]{0, 2, 2}, new int[]{1, 3})));
    }
}