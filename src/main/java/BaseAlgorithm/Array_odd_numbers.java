package BaseAlgorithm;

public class Array_odd_numbers {
    public static void main(String[] args) {

        int[] array = {3, 5, 20, 8, 7, 3, 100};

        StringBuilder sb = new StringBuilder();

        for (int j : array) {
            if (!(j % 2 == 0)) {
                if (sb.toString().isEmpty()) {
                    sb.append(j);
                } else {
                    sb.append(',').append(j);
                }
            }
        }
        System.out.println(sb);
    }
}