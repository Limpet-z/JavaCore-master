package ECDSA.ParseJSON.ParserForAUS;

import ECDSA.ParseJSON.Ox;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestForAUS {

    private static final Logger logger = LoggerFactory.getLogger(Ox.class);
    public static final String JSON_PATH = "src/main/java/ECDSA/ParseJSON/ParserForAUS/Ascendex.json";

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(parse().toString());

    }

    public static Map<String, BigDecimal> parse() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH));
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, BigDecimal>>() {
        }.getType();

        Map<String, BigDecimal> map = gson.fromJson(reader, type);
        Map<Model321, Model321> map1 = new HashMap<>();


        return map;
    }
}
