package stepic._1_java_syntax;

public class First_2_3_10 {
    public static boolean isPalindrome(String text) {

        String s = text.replaceAll("[^a-zA-Z0-9]","");

        return s.equalsIgnoreCase(new StringBuilder(s).reverse().toString());
    }
}
