package task3;

import utils.FileUtils;

import java.io.*;
import java.util.*;

public class WordsFrequency {
    private final String path;

    public WordsFrequency(String path) {
        this.path = path;
    }

    public Map<String, Integer> count() throws FileNotFoundException {
        File file = FileUtils.getFile(path);
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] words = line.replaceAll(" +", " ").split(" ");

                for (String word : words) {
                    if (map.containsKey(word)) {
                        map.put(word, map.get(word) + 1);
                        continue;
                    }

                    map.put(word, 1);
                }
                line = buffer.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return map;
    }
}
