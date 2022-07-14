package BaseAlgorithm;

import java.util.Arrays;

public class TextPerRole {
    public static String printTextPerRole(String[] roles, String[] textLines) {

        StringBuilder t = new StringBuilder();
        for (String role : roles) {
            t.append(role).append(":\n");

            for (int i = 0; i < textLines.length; i++) {

                String replica = textLines[i];
                int colonPosition = replica.indexOf(":");

                if (replica.substring(0, colonPosition).trim().equals(role)) {
                    t.append(i + 1).append(")").append(replica.replaceFirst(role + ":", "")).append("\n");
                }
            }
            t.append("\n");
        }
        return t.toString();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new String[]{printTextPerRole(new String[]{"Городничий", "Аммос Федорович", "Артемий Филиппович", "Лука Лукич"},

                new String[]{"Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                        "Аммос Федорович: Как ревизор?",
                        "Артемий Филиппович: Как ревизор?",
                        "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                        "Аммос Федорович: Вот те на!",
                        "Артемий Филиппович: Вот не было заботы, так подай!",
                        "Лука Лукич: Господи боже! еще и с секретным предписаньем!"
                })}));
    }
}