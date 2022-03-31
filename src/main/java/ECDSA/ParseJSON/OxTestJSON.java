package ECDSA.ParseJSON;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.function.Consumer;

import okhttp3.internal.concurrent.Task;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class OxTestJSON {

    private static final Logger logger = LoggerFactory.getLogger(Ox.class);
    public static final String JSON_PATH = "src/main/java/ECDSA/ParseJSON/URLs.json";

    public static void main(String[] args) throws IOException, ParseException, Exception {

        List<String> s = new ArrayList<>();
        s.add(urlMethod().toString());
        logger.info(s.toString());
    }

    public static List<String> urlMethod() throws FileNotFoundException {
        BufferedReader reader = new BufferedReader(new FileReader(JSON_PATH));
        Gson gson = new Gson();
        Type type = new TypeToken<List<Model>>() {
        }.getType();
        List<Model> list = gson.fromJson(reader, type);

        List<String> y = new ArrayList<>();
        for (var x : list) {
            y.add(x.getUrl());
        }
        return y;
    }
}