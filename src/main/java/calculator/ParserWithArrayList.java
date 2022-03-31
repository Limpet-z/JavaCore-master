package calculator;

import java.util.ArrayList;

/**
 * Тут я использую ArrayList, он раз в 15 быстрее работает, чем
 * LinkedList (ParserWithLinkedList.class).
 */

public class ParserWithArrayList {

    public boolean mathOperations(char c) {
        return c == '+' || c == '-' || c == '/' || c == '*';
    }

    public void mathActions(ArrayList<Integer> num, char symbol) {

        int a = num.remove(num.size() - 1);
        int b = num.remove(num.size() - 1);
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

        ArrayList<Integer> numsList = new ArrayList<>();
        ArrayList<Character> charsList = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);

            /*The continue statement skips the current iteration of a for, while , or do-while loop.*/
            if (c == ' ')
                continue;
            /*charsList.remove - */

            if (mathOperations(c)) {
                while (!charsList.isEmpty())
                    mathActions(numsList, charsList.remove(charsList.size() - 1));

                charsList.add(c);

            }    else {
                StringBuilder stringBuilder = new StringBuilder();

                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    stringBuilder.append(s.charAt(i++));
                }

                --i;
                numsList.add(Integer.parseInt(stringBuilder.toString()));
            }
        }
        while (!charsList.isEmpty())
            mathActions(numsList, charsList.remove(charsList.size() - 1));
        return numsList.get(0);
    }
}
