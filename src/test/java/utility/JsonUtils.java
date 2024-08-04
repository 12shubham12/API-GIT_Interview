package utility;

import com.google.gson.Gson;
import java.util.Map;

//to convert the excel data to a JSON string
public class JsonUtils {
    public static String generateJsonString(Map<String, String> data){
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
