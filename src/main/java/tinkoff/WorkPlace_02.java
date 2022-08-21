package tinkoff;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class WorkPlace_02 {

    public static int method(StringBuilder builder) {
        int y1 = 0;
        int y2 = 0;
        int result;

        String s = builder.toString();
        String s2 = Arrays.toString(s.split(" "));
        for (int i = 0; i < s2.length(); i++) {

            var c1 = s2.charAt(1);
            var c2 = s2.charAt(3);

           y1 = Character.getNumericValue(c1);
            y2 = Character.getNumericValue(c2);
        }

        if (y1 >= y2) {
            result = (y1 - y2)^2;
        } else {
            result = (y2 - y1)^2;
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