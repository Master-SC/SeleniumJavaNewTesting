package utillits;
import java.util.Map;
import java.util.HashMap;


public class Storage {

    public static Map<String, String> assertMap = new HashMap<>();

    public static void rememberTheValue(String key, String value){
        assertMap.put(key, value);
    }

    public static String whatIsTheValue(String key){
        return assertMap.get(key);
    }

}

