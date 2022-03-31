package eth.encoders;

import java.util.Random;

public class PrivateKeyGenerator {

    public Object ethKeyGenerator(int length) {
        Random random = new Random();
        String a = "0123456789abcdef";

        StringBuilder c = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int x = random.nextInt(16);
            c.append(a.charAt(x));
        }
        return c;
    }
}
