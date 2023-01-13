package task3;

import utils.FileUtils;

import java.io.*;
import java.util.*;

public class WordsFrequency {
    private String path;

    public WordsFrequency setPath(String path) {
        this.path = path;
        return this;
    }

    public void count() throws FileNotFoundException {
        File file = FileUtils.getFile(path);
        Map<String, Integer> map = new TreeMap<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line = buffer.readLine();
            while (line != null) {
                String[] list = line.split(" ");

                line = buffer.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
