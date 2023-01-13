package task2;

import com.google.gson.*;
import utils.FileUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserBuilder {
    private String filePath;
    private String jsonPath;
    private String[] head;
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public UserBuilder setFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public UserBuilder setJsonPath(String jsonPath) {
        this.jsonPath = jsonPath;
        return this;
    }

    public void run() throws FileNotFoundException {
        File file = FileUtils.getFile(filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            head = reader.readLine().split(" ");
            ArrayList<Map<String, String>> users = new ArrayList<>();

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

            writeJson(gson.toJson(users));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void writeJson(String json) {
        File file = FileUtils.createAndGetFile(jsonPath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(json, 0, json.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
