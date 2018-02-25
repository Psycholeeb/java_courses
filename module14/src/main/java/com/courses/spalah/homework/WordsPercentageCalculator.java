package com.courses.spalah.homework;

import com.courses.spalah.TextAnalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordsPercentageCalculator {
    private List<String> words = new ArrayList<>();

    public static void main(String[] args) {
        WordsPercentageCalculator calculator = new WordsPercentageCalculator();
        calculator.readAllWords();
        Map<String, Float> percentageMap = calculator.getPercentageMap();
        for (Map.Entry<String, Float> entry : percentageMap.entrySet()) {
            System.out.print("Слово " + entry.getKey());
            System.out.println(" составляет " + entry.getValue() + "% от всех слов в тексте");
        }
    }

    /**
     * Метод читает все слова в тексте и сохраняет их в поле класса.
     *
     * @return список слов
     */
    public void readAllWords() {
        List<String> lines = TextAnalyzer.readLines();

        for (String line : lines) {
            String cleanLine = line.replaceAll("\\.", "")
                    .replace(",", "")
                    .replace("-", "")
                    .replace("\n", " ")
                    .trim();
            String[] wordsInLine = cleanLine.split(" ");
            for (String word : wordsInLine) {
                words.add(word.toLowerCase());
            }
        }

        System.out.println("Все слова=" + words);
    }

    /**
     * Метод должен вернуть Map ключем которой является слово, а значением
     * процентное соотношение ко всем словам в тексте.
     *
     * @return Map
     */
    public Map<String, Float> getPercentageMap() {
        HashMap<String, Float> percentageMap = new HashMap<>();
        float procentPerOneWord = 1F / words.size() * 100;

        for (String key : words) {
            if (percentageMap.containsKey(key)) {
                percentageMap.put(key, (percentageMap.get(key)) + procentPerOneWord);
            } else {
                percentageMap.put(key, procentPerOneWord);
            }
        }
        return percentageMap;
    }
}
