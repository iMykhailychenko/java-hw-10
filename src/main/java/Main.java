import task1.*;
import task2.*;
import task3.*;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        new PhoneReader("assets/file1.txt")
                .read(new PhoneValidator());

        var users = new UserBuilder("assets/file2.txt")
                .build();

        new JsonWriter("assets/user.json")
                .writeToFile(users);

        var words = WordsOrderUtils.sort(
                new WordsFrequency("assets/words.txt").count()
        );

        System.out.println(words);
    }
}
