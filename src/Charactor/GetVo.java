package Charactor;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GetVo {
    public static ArrayList<String> getWords(String file) throws FileNotFoundException {
        ArrayList<String> words;
        try (Scanner input = new Scanner(new File(file))) {
            words = new ArrayList<>();
            while(input.hasNext()) {
                words.add(input.next());
            }
        }
        return words;
    }
}
