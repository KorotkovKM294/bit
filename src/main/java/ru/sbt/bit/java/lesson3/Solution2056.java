package ru.sbt.bit.java.lesson3;

import java.util.*;

/**
 * Created by Cyril Korotkov on 10.10.2016.
 */
public class Solution2056 {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.equals("")) {
                scanner.close();
            }
            String[] split = line.split(" ");
            for (String word : split) {
                Integer wordCount = map.get(word);
                map.put(word, wordCount == null ? 1 : ++wordCount);
            }
        }

        List<String> result = new ArrayList<String>();
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();

            if (count > maxCount) {
                result.clear();
                result.add(word.toLowerCase());
                maxCount = count;
            } else if (count == maxCount) {
                result.add(word);
            }
        }
        Comparator<String> alphabeticOrder = new Comparator<String>() {
            public int compare(String o1, String o2) {
                int res = String.CASE_INSENSITIVE_ORDER.compare(o1, o2);
                if (res == 0) {
                    res = o1.compareTo(o2);
                }
                return res;
            }
        };
        Collections.sort(result, alphabeticOrder);

        for (String word : result) {
            System.out.println(word);
        }
    }
}
