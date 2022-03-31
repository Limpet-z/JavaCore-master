package eth;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.EthGetBalance;
import org.web3j.protocol.http.HttpService;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class EthGeneratorTest {

    @org.junit.jupiter.api.Test
    void main() throws IOException {

        String str0 = "fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364141"; // - 10 eth
        String str00 = "fffffffffffffffffffffffffffffffebaaedce6af48a03bbfd25e8cd0364143"; // - 2.4

        String str1 = "cf48486ddb4e5e7c7b312dee6cfafede3ef6d8a022ee2f14bf023944412a6c3a"; // - test MetaMask
        String str2 = "18cd1922c276c6693ede3a3b3b85fe118f6a1fba997f6c4cb4169401612ae90c"; // - my program generated (JAVA)

        String mainBraveWallet = "812c3400ea52545af0644bdb3dd4d540522eff1d826a2801198d6ea4880abf00";
        String str = "0000000000000000000000000000000000000000000000000000000000000000";
        String str321 = "6b65e98a95a890293d4bfcae6928586a8c94d481d261207451f5719242e2f4f4";


        Web3j web3 = Web3j.build(new HttpService("https://mainnet.infura.io/v3/cd601df89a60461f9d744777d13769a5"));

        Credentials credentials = Credentials.create(str);

        EthGetBalance balance = web3.ethGetBalance(credentials.getAddress().toLowerCase(Locale.ROOT), DefaultBlockParameterName.LATEST).send();
        BigDecimal balanceInEther = Convert.fromWei(balance.getBalance().toString(), Convert.Unit.ETHER);

        BigDecimal u = BigDecimal.valueOf(0);
        if (balanceInEther.compareTo(u) > 0) {
            System.out.println("Balance: ");
            System.out.println(balanceInEther);

            System.out.println("Array public keys: ");
            System.out.println(credentials.getAddress().toLowerCase(Locale.ROOT));
            System.out.println("Array private keys: ");
            System.out.println(str);
        } else {
            System.out.println("Balance1: ");
            System.out.println(balanceInEther);
            System.out.println("Array public keys: ");
            System.out.println(credentials.getAddress().toLowerCase(Locale.ROOT));
            System.out.println("Array private keys: ");
            System.out.println(str);
        }


    }
}