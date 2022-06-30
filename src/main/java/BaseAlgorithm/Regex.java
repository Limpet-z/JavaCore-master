package BaseAlgorithm;

import java.util.Locale;

public class Regex {


    public static void main(String[] args) {

        String text = "Eva, Can I Stab Bats In A Cave?";
        String text2 = " , , , ! !";


        String s = text.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
        String builder = new StringBuilder(s).reverse().toString();



        System.out.println(builder);

    }
}