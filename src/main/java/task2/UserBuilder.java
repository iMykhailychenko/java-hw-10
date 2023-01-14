package task2;

import utils.FileUtils;

import java.io.*;
import java.util.*;

public class UserBuilder {
    private final String path;
    private String[] head;

    public UserBuilder(String path) {
        this.path = path;
    }

    public ArrayList<Map<String, String>> build() throws FileNotFoundException {
        File file = FileUtils.getFile(path);
        ArrayList<Map<String, String>> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            head = reader.readLine().split(" ");

            String line = reader.readLine();
            while (line != null) {
                Map<String, String> user = new HashMap<>();
                String[] data = line.split(" ");

                for (int i = 0; i < data.length; i++) {
                    user.put(head[i], data[i]);
                }

                users.add(user);
                line = reader.readLine();
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return users;
    }


}
