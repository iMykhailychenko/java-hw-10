package task4;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import utils.FileUtils;

import java.io.*;
import java.util.*;

public class UserJson {
    private List<User> users;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public UserJson readFromTxt(String path) throws FileNotFoundException {
        File file = FileUtils.getFile(path);
        users = new ArrayList<>();

        try (BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            buffer.readLine(); // skip heading
            String line = buffer.readLine();

            while (line != null) {
                String[] userInfo = line.split(" ");

                users.add(new User(userInfo[0], Integer.parseInt(userInfo[1])));
                line = buffer.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return this;
    }

    public UserJson writeToJson(String path) {
        File file = FileUtils.createAndGetFile(path);

        try (BufferedWriter buffer = new BufferedWriter(new FileWriter(file))) {
            String json = gson.toJson(users);
            buffer.write(json, 0, json.length());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return this;
    }

    public List<User> readFromJson(String path) throws FileNotFoundException {
        File file = FileUtils.getFile(path);
        StringBuilder json = new StringBuilder();

        try(BufferedReader buffer = new BufferedReader(new FileReader(file))) {
            String line = buffer.readLine();

            while (line != null) {
                json.append(line);
                line = buffer.readLine();
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return gson.fromJson(json.toString(), new TypeToken<List<User>>(){}.getType());
    }
}
