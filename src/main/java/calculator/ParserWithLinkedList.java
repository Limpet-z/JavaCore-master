package calculator;

import java.util.LinkedList;

public class ParserWithLinkedList {

    public boolean mathOperations(char c) {

        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    public void mathActions(LinkedList<Integer> num, char symbol) {
        int a = num.removeLast();
        int b = num.removeLast();
        switch (symbol) {

            // case label_1, label_2, ..., label_n -> expression;|throw-statement;|block
            /* JAVA 12 (2019) new syntax */
            case '+' -> num.add(b + a);
            case '-' -> num.add(b - a);
            case '*' -> num.add(b * a);
            case '/' -> num.add(b / a);
        }
    }

    public int mathMaker(String s) {

        LinkedList<Integer> numsLinkedList = new LinkedList<>();
        LinkedList<Character> charsLinkedList = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ')
                continue;

            if (mathOperations(c)) {
                while (!charsLinkedList.isEmpty())

                    mathActions(numsLinkedList, charsLinkedList.removeLast());
                charsLinkedList.add(c);
            } else {

                StringBuilder operand = new StringBuilder(); //12,2,3,4

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    operand.append(s.charAt(i++));
                }
                --i;
                numsLinkedList.add(Integer.parseInt(operand.toString()));
            }
        }

        while (!charsLinkedList.isEmpty())
            mathActions(numsLinkedList, charsLinkedList.removeLast());
        return numsLinkedList.get(0);
    }
}
