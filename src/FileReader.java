import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public static String[] readFile(String name) {
        try {
            List<String> list = Files.readAllLines(Paths.get(name));
            return getAnswer(list);
        } catch (Exception e) {
            System.out.println("unable to load file " + name);
        }
        return new String[] {};
    }

    private static String[] getAnswer(List<String> list) {
        int listSize = list.size();
        String[] answer = new String[listSize];

        for (int lineNumber = 0; lineNumber < listSize; lineNumber++) {
            answer[lineNumber] = list.get(lineNumber);
        }
        return answer;
    }
}
