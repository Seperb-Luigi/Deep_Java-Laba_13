package com.dev;

import java.util.stream.Collectors;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.List;


public class Filter {
    public static String filterWords(String[] words, String regex) {
        if (words == null || regex == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        return java.util.Arrays.stream(words)
                .filter(word -> word != null && !pattern.matcher(word).matches())
                .collect(Collectors.joining(" "));
    }

    public static void main(String[] args) {
        String regex = "\\d+";
        String[] words = {"zabuza", "777", "madara", "daruma"};

        String filteredWords = Filter.filterWords(words, regex);
        System.out.println("Filtered words: " + filteredWords);

        String sentence = "zabuza 777 madara 666 maruma";
        List<String> matchingWords = Filter.findMatchingWords(sentence, regex);
        System.out.println("Matching words: " + matchingWords);
    }



    public static List<String> findMatchingWords(String sentence, String regex) {
        if (sentence == null || regex == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        Pattern pattern = Pattern.compile(regex);
        List<String> matchingWords = new ArrayList<>();

        for (String word : sentence.split("\\s+")) {
            if (word != null && pattern.matcher(word).matches()) {
                matchingWords.add(word);
            }
        }

        return matchingWords;
    }

}
