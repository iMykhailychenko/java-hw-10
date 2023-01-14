import task1.PhoneReader;
import task1.PhoneValidator;
import task2.JsonWriter;
import task2.UserBuilder;
import task3.WordsFrequency;
import task3.WordsOrderUtils;
import task4.User;
import task4.UserJson;

import java.io.FileNotFoundException;
import java.nio.file.Paths;
import java.util.List;

public class Controller {
    public Controller runTask1() throws FileNotFoundException {
        String path = Paths.get("assets", "file1.txt").toString();
        new PhoneReader(path).read(new PhoneValidator());

        return this;
    }

    public Controller runTask2() throws FileNotFoundException {
        String path = Paths.get("assets", "file2.txt").toString();
        var users = new UserBuilder(path).build();

        String jsonPath1 = Paths.get("assets", "user.json").toString();
        new JsonWriter(jsonPath1).writeToFile(users);

        return this;
    }

    public Controller runTask3() throws FileNotFoundException {
        String path = Paths.get("assets", "words.txt").toString();
        var words = WordsOrderUtils.sort(new WordsFrequency(path).count());

        System.out.println(words);

        return this;
    }

    public Controller runTask4() throws FileNotFoundException {
        String filePath = Paths.get("assets", "file2.txt").toString();
        String jsonPath = Paths.get("assets", "user2.json").toString();

        List<User> users = new UserJson().readFromTxt(filePath).writeToJson(jsonPath).readFromJson(jsonPath);

        System.out.println(users);
        return this;
    }
}
