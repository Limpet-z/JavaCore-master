package dlGSUby;

public class Simpledigits {
    public static void main(String[] args) {


        for (int i = 0; i <= 100; i++) {
            boolean x = i > 0;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    x = false;
                    break;
                }
            }
            if (x)
                System.out.println(i);
        }

    }
}
