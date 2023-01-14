import task1.*;
import task2.*;
import task3.*;

import java.io.FileNotFoundException;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        String path1 = Paths.get("assets", "file1.txt").toString();
        new PhoneReader(path1).read(new PhoneValidator());

        String path2 = Paths.get("assets", "file2.txt").toString();
        var users = new UserBuilder(path2).build();

        String jsonPath = Paths.get("assets", "user.json").toString();
        new JsonWriter(jsonPath).writeToFile(users);

        String path3 = Paths.get("assets", "words.txt").toString();
        var words = WordsOrderUtils.sort(new WordsFrequency(path3).count());

        System.out.println(words);
    }
}
