package chap15;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CountDisticWord {

    public static void main(String[] args) {
        countDisticWord();
    }

    private static void countDisticWord() {
        // Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        File file = new File("./src/chap15/wordbook.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String s = null;
            while ((s = br.readLine()) != null) {
                System.out.println(s.trim());
                Integer n = map.get(s);
                if (n == null) {
                    map.put(s, 1);
                } else {
                    map.put(s, n + 1);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        // System.out.println("중복되지 않은 단어 수:" + set.size());
        Set<String> set = map.keySet();
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            String key = iter.next();
            Integer value = map.get(key);
            System.out.println(key + ":" + value + ",");

        }
    }

}
