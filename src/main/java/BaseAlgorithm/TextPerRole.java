package BaseAlgorithm;

import java.util.Arrays;
import java.util.Objects;

public class TextPerRole {

    public static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder b = new StringBuilder();
        StringBuilder t = new StringBuilder();
        int k = textLines.length;

        while (k != 0) {
            for (String j : roles) {
                b.append(j);
            }

            if (textLines[k-1].contains(b)) {
                t.append(b).append(textLines[k]);
            }
            k--;
        }
        return t.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{printTextPerRole(new String[]{"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"},

                new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                        "Аммос Федорович: Как ревизор?", "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                        "Аммос Федорович: Вот те на!", "Артемий Филиппович: Вот не было заботы, так подай!", "Лука Лукич: Господи боже! еще и с секретным предписаньем!",
                })}));
    }
}