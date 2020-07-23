package com.example.amazon;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequenceOfWords {

    public static void main(String[] args) {
        String input = "Iam Iam Hello Hello Hi Hi Hi Hi Test Test Test Hola Hola Kite Kite Kite Mango Mango Mango Apple";
        System.out.println(frequency(input));
    }

    public static List<String> frequency(String input) {
        String[] words = input.split(" ");

        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            int count = 1;
            if (result.get(words[i]) != null) {
                count = result.get(words[i]) + 1;
            }
            result.put(words[i], count);
        }

        return result.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2).map(Map.Entry::getKey).collect(Collectors.toList());
    }
}
