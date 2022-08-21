package tinkoff;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WorkPlace_02 {

    public static int method(StringBuilder builder) {

        int result = 0;
        int maxX;
        int minX;
        int maxY;
        int minY;

        String s = builder.toString();
        String s2 = s.replaceAll(" ", "");


            var x1 = s2.charAt(0);
            int x11 = Character.getNumericValue(x1);
            var y1 = s2.charAt(1);
            int y11 = Character.getNumericValue(y1);
            var x2 = s2.charAt(2);
            int x22 = Character.getNumericValue(x2);
            var y2 = s2.charAt(3);
            int y22 = Character.getNumericValue(y2);

            if (x11 >= x22) {
                maxX = x11;
                minX = x22;
            } else {
                maxX = x22;
                minX = x11;
            }
            if (y11 >= y22) {
                maxY = y11;
                minY = y22;
            } else {
                maxY = y22;
                minY = y11;
            }

            int c = maxX - minX;
            int d = maxY - minY;

            if (c >= d) {
                result = (int) Math.pow(c, 2);
            } else  {
                result = (int) Math.pow(d, 2);
            }


        return result;
    }

    public static void main(String[] args) throws IOException {

        StringBuilder builder = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        while (!string.equals("")) {
            builder.append(string);
            string = sc.nextLine();
        }
        System.out.println(method(builder));
    }
}