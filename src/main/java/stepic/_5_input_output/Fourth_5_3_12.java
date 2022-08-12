package stepic._5_input_output;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

/**
 * Напишите программу, читающую текст из System.in и выводящую в System.out сумму всех встреченных в тексте
 * вещественных чисел с точностью до шестого знака после запятой. Числом считается последовательность символов,
 * отделенная от окружающего текста пробелами или переводами строк и успешно разбираемая методом Double.parseDouble.
 */

public class Fourth_5_3_12 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        double d;
        double sum = 0.0;

        while (scanner.hasNext()) {

            if (scanner.hasNextDouble()) {
                d = scanner.nextDouble();
                sum += d;

            } else {
                scanner.next();
            }
        }
        System.out.printf(Locale.ENGLISH, "%.6f", sum);
    }
}