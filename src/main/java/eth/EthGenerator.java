package eth;

import org.web3j.crypto.*;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.*;

public class EthGenerator {
    private final static int PRIVATE_KEY = 100;

    public static void main(String[] args) throws IOException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, CipherException {

        System.out.println("Connecting to Ethereum ...");
        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/22d6a5974f25485397c011159543ae95")); // 695612981anthony@gmail.com
        System.out.println("Successfully connected to Ethereum");
        System.out.println("PROGRAM start work ...");

        Set<Object> set = new HashSet<>();

        for (int i = 0; i < PRIVATE_KEY; i++) {

            ECKeyPair ecKeyPair = Keys.createEcKeyPair();
            BigInteger privateKeyInDec = ecKeyPair.getPrivateKey();
            String PrivateKeyInHex = privateKeyInDec.toString(16);
            String seed = UUID.randomUUID().toString();
            WalletFile aWallet = Wallet.createLight(seed, ecKeyPair);
            String sAddress = aWallet.getAddress();

            Map<Object, Object> map = new HashMap<>();
            map.put("Address", "0x" + sAddress);
            map.put("PrivateKey", PrivateKeyInHex);

            set.add(map.get("PrivateKey"));
        }

        int h = 0;
        BigDecimal result = new BigDecimal(0);
        for (Object o : set) {
            Credentials credentials = Credentials.create(o.toString());

            EthGetBalance balance = web3.ethGetBalance(credentials.getAddress().toLowerCase(Locale.ROOT), DefaultBlockParameterName.LATEST).send();
            BigDecimal balanceInEther = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER);

            BigDecimal u = BigDecimal.valueOf(0);
            if (balanceInEther.compareTo(u) > 0) {
                System.out.println("Balance: ");
                System.out.println(balanceInEther);

                System.out.println("Array public keys: ");
                System.out.println(credentials.getAddress().toLowerCase(Locale.ROOT));
                System.out.println("Array private keys: ");
                System.out.println(o);
            }
            h++;
            result.add(balanceInEther);

        }

        System.out.println("NO MONEY YET");
//      System.out.println("Load wallet: " + (new DecimalFormat("#,###,###").format(h)));
        System.out.format("%,1d,%n%n", h);
        System.out.println("Total balance: " + result + " ETH");
        System.exit(1);

    }
}
//      Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/cd601df89a60461f9d744777d13769a5")); //5244934@gmail.com
//      Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/083836b2784f48e19e03487eb3209923")); // find in Ethernet
//      Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/42e3f26ba3b3456a8517305b2dce2201")); //akozinau@gmail.com