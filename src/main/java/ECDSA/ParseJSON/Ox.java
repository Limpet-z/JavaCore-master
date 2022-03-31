package ECDSA.ParseJSON;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Ox {
    public static final String JSON_PATH = "src/main/java/ECDSA/ParseJSON/URLs.json";
    private static final Logger logger = LoggerFactory.getLogger(Ox.class);
    private final static int PRIVATE_KEY = 2;

    public static void main(String[] args) throws InvalidAlgorithmParameterException, CipherException,
            NoSuchAlgorithmException, NoSuchProviderException, InterruptedException, ExecutionException, IOException {
        long startTime = System.currentTimeMillis();

        Set<String> allPrivateKey = new HashSet<>(PRIVATE_KEY);

        for (int i = 0; i < PRIVATE_KEY; i++) {
            allPrivateKey.add(random().toString());
        }

        logger.info("Private Key" + PRIVATE_KEY + " is generated");

        logger.info("Connecting to Ethereum ...");
        logger.info("Successfully connected to Ethereum");
        logger.info("PROGRAM start work ...");


        Map<String, Future<BigDecimal>> futures = getEthereumBalanceAsync(new ArrayList<>(allPrivateKey));

        long h = 0L;
        BigDecimal totalBalance = new BigDecimal(0);
        for (Map.Entry<String, Future<BigDecimal>> entry : futures.entrySet()) {

            BigDecimal x = BigDecimal.valueOf(0);
            BigDecimal balanceInEther = entry.getValue().get();
            Credentials credentials = Credentials.create(entry.getKey());

            if (balanceInEther.compareTo(x) < 1) {
                System.out.println("Private Key: " + entry.getKey());
                System.out.println("Balance: " + balanceInEther);
                System.out.println("Public Key: " + credentials.getAddress().toLowerCase(Locale.ROOT));
                System.out.println(" " +

                        " ");
            }
            totalBalance.add(balanceInEther);
            h++;
        }

        System.out.println("Number of verified wallets: " + h);
        System.out.println("Total Balances: " + totalBalance);
        System.out.println("Time work PROGRAM: " + (System.currentTimeMillis() - startTime) / 1000);
        System.exit(1);
    }

    public static StringBuilder random() throws CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException {

        ECKeyPair ecKeyPair = Keys.createEcKeyPair();
        BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();
        String PrivateKeyInHex = privateKeyInDec.toString(16);

        String seed = UUID.randomUUID().toString();
        WalletFile aWallet = Wallet.createLight(seed, ecKeyPair);
        String sAddress = aWallet.getAddress();
        StringBuilder str1 = new StringBuilder();

        StringBuilder str = new StringBuilder();
        str1.append("0x" + sAddress);
        str.append(PrivateKeyInHex);
//        System.out.println(str1);
        return str;
    }

    public static Map<String, Future<BigDecimal>> getEthereumBalanceAsync(List<String> EthID) throws InterruptedException, IOException {

        try {

            ExecutorService executor = Executors.newFixedThreadPool(10);
            Map<String, Future<BigDecimal>> futures = EthID.stream().collect(Collectors.toMap(Function.identity(),
                    (String privateKey) -> executor.submit(() -> {

                        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/cd601df89a60461f9d744777d13769a5"));
                        Credentials credentials = Credentials.create(privateKey);
                        EthGetBalance balanceWei = web3.ethGetBalance(credentials.getAddress(), DefaultBlockParameterName.LATEST).send();
                        BigDecimal balanceInEthereum;
                        balanceInEthereum = Convert.fromWei(balanceWei.getBalance().toString(), Convert.Unit.ETHER);
                        return balanceInEthereum;
                    })));
            executor.shutdown();
            executor.awaitTermination(1, TimeUnit.DAYS);
            return futures;

        } catch (InterruptedException e) {

            System.out.format("Can't retrieve Ethereum balances. Cause: %s%n", e.getMessage());
            throw e;


        }
    }

    public static List<String> urlMethod() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Model>>() {
        }.getType();
        List<Model> list = gson.fromJson(reader, type);

        List<String> y = new ArrayList<>();
        int  i = 0;
        for (var x : list) {

            y.add(x.getUrl());
            i++;
        }
        logger.info(String.valueOf(i));
        return y;

    }
}