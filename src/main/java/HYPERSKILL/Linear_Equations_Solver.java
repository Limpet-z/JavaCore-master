package HYPERSKILL;

import java.util.Scanner;

/**
 * Sample Input 1:
 * Hello
 * Java
 * Future programmer

 * Sample Output 1:
 * Hello
 * Java
 * Future
 * programmer
 */

public class Linear_Equations_Solver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder builder = new StringBuilder();
        String string = scanner.nextLine();
        while (!string.equals("")) {
            builder.append(string);

        }
        String s = builder.toString();

        System.out.println(builder);
    }
}