package JSON;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateJson {

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("ETH", 0.112);
        map.put("USDT", 324.264);
        System.out.println(map);

        Gson gson = new Gson();
        Type type = new TypeToken<List<ModelX>>() {
        }.getType();
//        List<ModelX> c = gson.toJson(map, type);
        String c = gson.toJson(map, type);
        System.out.println(c);

    }
}
