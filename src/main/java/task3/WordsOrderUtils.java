package task3;

import java.util.*;

public class WordsOrderUtils {
    public static Map<String, Integer> sort(final Map<String, Integer> map) {
        Map<String, Integer> newMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String key1, String key2) {
                int value1 = map.get(key1);
                int value2 = map.get(key2);

                if (value1 == value2) return 0;
                return value1 > value2 ? -1 : 1;
            }
        });
        newMap.putAll(map);

        return newMap;
    }
}
