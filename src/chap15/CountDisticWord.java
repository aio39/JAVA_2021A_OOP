package chap15;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class CountDisticWord {

    public static void main(String[] args) {
        countDisticWord();
    }

    private static void countDisticWord() {
        Set<String> set = new HashSet<>();
        File file = new File("./src/chap15/wordbook.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s.trim());
                set.add(s);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("중복되지 않은 단어 수:" + set.size());
    }

}
