package com.example.packages.exercises.Leetcode.sorting;
import java.util.*;

public class LongestWordInDictionary {
    public static  String longestWord(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length())
                    return o1.compareTo(o2);
                else {
                    return o2.length() - o1.length();
                }
            }
        });
        System.out.println(Arrays.toString(words));

        for (int i = 0; i < words.length; i++) {
            if (canForm(words, words[i].toCharArray())) {
                return words[i];
            }
        }
        return "";
    }

    public static boolean canForm(String[] words, char[] str) {
        int mainIndex = str.length - 2;
        for (int i = 1; i < words.length; i++) {
            if (mainIndex == 0) {
                return true;
            }
            char[] nextChar = words[i].toCharArray();
            for (int j = nextChar.length - mainIndex; j >= 0; j--) {
                if (str[mainIndex] == nextChar[j]) {
                    mainIndex--;
                    break;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] words = {"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"};
        System.out.println(longestWord(words));
    }

    class Solution3 {
        public String longestWord(String[] words) {
            Set<String> wordset = new HashSet();
            for (String word: words) wordset.add(word);
            Arrays.sort(words, (a, b) -> a.length() == b.length()
                    ? a.compareTo(b) : b.length() - a.length());
            System.out.println(Arrays.toString(words));
            for (String word: words) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) return word;
            }

            return "";
        }

        /*public static void main(String[] args) {
            String[] strings = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
            System.out.println(longestWord(strings));
        }*/
    }
/*Given a list of strings words representing an English Dictionary, find the longest word in words that can be built one character at a time by other words in words. If there is more than one possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

Input:
words = ["w","wo","wor","worl", "world"]
Output: "world"
Explanation:
The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Input:
words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
Output: "apple"
Explanation:
Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".*/
}
