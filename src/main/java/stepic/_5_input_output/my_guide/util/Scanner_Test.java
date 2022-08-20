package stepic._5_input_output.my_guide.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Scanner_Test {

    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {

        String str1 = "4 5 8 8";
        String[] strings = str1.split(" ");
        List<String> list1 = Arrays.asList(strings);

        System.out.println(list1);

        //================================
        Scanner sc1 = new Scanner(System.in);
        String str = sc1.nextLine();
        while (!str.equals("")) {
            list.add(str);
            str = sc1.nextLine();
        }

        //================================
        int a;

        Scanner scanner = new Scanner(System.in);
        System.out.println("\nEnter an number:");
        a = scanner.nextInt();
        System.out.printf("You entered: " + a);
    }
}