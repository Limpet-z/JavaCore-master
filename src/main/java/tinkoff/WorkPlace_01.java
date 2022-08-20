package tinkoff;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WorkPlace_01 {
    static ArrayList<String> list = new ArrayList<>();

    private static int inputMethod() {



        return 0;
    }

    public static void main(String[] args) throws IOException {

        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();
        while (!str.equals("")) {
            list.add(str);
            str = sc1.nextLine();
        }

        System.out.println(list.toString());

    }
}