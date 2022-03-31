package eth;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TestIvan {
    private final static int RRS = 1000000;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long startTime = System.currentTimeMillis();

        Set<String> stringArrayList = new HashSet<>(RRS);
        for (int i = 0; i < RRS; i++) {
            stringArrayList.add(random(64));
        }
        System.out.println("Connecting to Ethereum ...");
        System.out.println("Successfully connected to Ethereum");
        System.out.println("PROGRAM start work ...");
        long h = 0L;
        Map<String, Future<BigDecimal>> futures = getEthereumBalanceAsync(new ArrayList<>(stringArrayList));
        for (Map.Entry<String, Future<BigDecimal>> entry : futures.entrySet()) {

            BigDecimal x = BigDecimal.valueOf(0);
            BigDecimal balanceInEither = entry.getValue().get();

            if (!balanceInEither.equals(x)) {
                System.out.println("ID " + entry.getKey() + " Balance: " + balanceInEither);
            }
            h++;
        }
        System.out.println("Number WALLETS: " + h);
        System.out.println("Time work PROGRAM: " + (System.currentTimeMillis() - startTime) / 1000);
        System.exit(1);
    }

    public static String random(int length) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(random.nextInt()));
        }
        return sb.substring(0, length);
    }

    public static Map<String, Future<BigDecimal>> getEthereumBalanceAsync(List<String> ethereumIDsList) throws InterruptedException {
        try {
            ExecutorService executor = Executors.newFixedThreadPool(8);
            Map<String, Future<BigDecimal>> futures = ethereumIDsList.stream()
                    .collect(Collectors.toMap(
                            Function.identity(),
                            privateKey -> executor.submit(() -> {
//                                Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/42e3f26ba3b3456a8517305b2dce2201"));
//                                Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/cd601df89a60461f9d744777d13769a5"));
                                Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95")); // 695612981anthony@gmail.com
                                Credentials credentials = Credentials.create(privateKey);
                                EthGetBalance balanceWei = web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                                BigDecimal balanceInEither = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
                                return balanceInEither;
                            })));
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.DAYS);
            return futures;
        } catch (InterruptedException e) {
            System.out.format("Can't retrieve Ethereum balances. Cause: %s%n", e.getMessage());
            throw e;
        }
    }
}
