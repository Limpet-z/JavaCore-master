package stepic._1_java_syntax;

public class First_2_2_8 {
    public static boolean isPowerOfTwo(int value) {
        return Integer.bitCount(Math.abs(value)) == 1;
    }
}
