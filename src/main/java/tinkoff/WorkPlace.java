package tinkoff;

import java.util.Scanner;

public class WorkPlace {

    private static int inputMethod(String s) {

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            if (c == ' ') continue;
            if (c == '\n') continue;


        }


        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        System.out.println(inputMethod(s));
    }
}