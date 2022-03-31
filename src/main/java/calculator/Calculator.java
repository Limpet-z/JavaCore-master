package calculator;

import java.util.Scanner;

public class Calculator {

    public void calculate() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Input Anything: ");
        String s = scan.nextLine();

        ParserWithArrayList parserWithArrayList = new ParserWithArrayList();

        System.out.println(parserWithArrayList.mathMaker(s));

    }
}
