package ECDSA.ParseJSON;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.web3j.crypto.Credentials;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static ECDSA.ParseJSON.Ox.getEthereumBalanceAsync;

class OxTest {

    Ox ox = new Ox();

    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void main() throws ExecutionException, InterruptedException, IOException {
        long startTime = System.currentTimeMillis();
        final Object S = "6b65e98a95a890293d4bfcae6928586a8c94d481d261207451f5719242e2f4f4";
        final Object S1 = "0000000000000000000000000000000000000000000000000000000000000000";
        Set<String> allPrivateKey = new HashSet<>(2);
        allPrivateKey.add(S.toString());
        allPrivateKey.add(S1.toString());

        Map<String, Future<BigDecimal>> futures = getEthereumBalanceAsync(new ArrayList<>(allPrivateKey));
        long h = 0L;
        BigDecimal totalBalance = new BigDecimal(0);

        BigDecimal result = null;
        for (Map.Entry<String, Future<BigDecimal>> entry : futures.entrySet()) {
            result = new BigDecimal(0);
            BigDecimal x = BigDecimal.valueOf(0);
            BigDecimal balanceInEther = entry.getValue().get();
            Credentials credentials = Credentials.create(entry.getKey());


            if (balanceInEther.compareTo(x) >= 0) {

                System.out.println("Private Key: " + entry.getKey());
                System.out.println("Balance: " + balanceInEther);
                System.out.println("Public Key: " + credentials.getAddress().toLowerCase(Locale.ROOT));
                System.out.println(" " +

                        " ");
                result = totalBalance.add(balanceInEther);
            }

            h++;
        }
        System.out.println("Number of verified wallets: " + h);
        System.out.println("Total Balances: " + result);
        System.out.println("Time work PROGRAM: " + (System.currentTimeMillis() - startTime) / 1000 + " sec.");
        System.exit(1);
    }

    @Test
    String random() {
        final var s = "6b65e98a95a890293d4bfcae6928586a8c94d481d261207451f5719242e2f4f4";
        return s;
    }
}