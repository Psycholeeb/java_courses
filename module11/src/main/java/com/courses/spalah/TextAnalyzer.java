package com.courses.spalah;

import java.io.File;
import java.util.*;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    private static int counterWords = 0;
    private static int counterSymbols = 0;
    private static int counterSentences = 0;
    private static int counterUniqueWords = 0;
    private static Set<String> mostRepeatedWord = new HashSet<>();
    private static final String PATH_FILE = "D:/file.txt";
    private static ArrayList<String> arrayListOfWords = new ArrayList<>();
    private static String textInFile = "";

    public static void main(String[] args) {
        readTextFromFile();

        System.out.print("\n===================================");
        System.out.print("\nTotal amount symbols: " + counterSymbols);
        System.out.print("\nTotal amount words: " + counterWords);
        System.out.print("\nTotal amount sentences: " + counterSentences);
        System.out.print("\nTotal amount unique words: " + counterUniqueWords);
        System.out.print("\nMost repeated word: " + "\"" + mostRepeatedWord + "\"");
        System.out.print("\nMin length of word: " + foundMinLengthWord());
        System.out.print("\nMax length of word: " + foundMaxLengthWord());
        System.out.print("\n\nStatistic frequency words: \n");
        countFrequencyWords();
        System.out.print("\nStatistic frequency letters: \n");
        countFrequencyLetters();
        System.out.print("===================================\n");
    }

    public static void readTextFromFile() {
        try {
            Scanner scanner = new Scanner(new File(PATH_FILE));

            while (scanner.hasNext()) {
                countWordsInFile();
                countSymbolsInFile(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        countSentencesInFile();
        countUniqueWords();
        countMostRepeatedWord();
    }

    public static void countWordsInFile() {
        counterWords++;
    }

    public static void countSymbolsInFile(String words) {
        textInFile += words;
        counterSymbols = textInFile.length();

        arrayListOfWords.add(words.replaceAll("\\.|\\,|\\;", "").toLowerCase());
    }

    public static void countSentencesInFile() {
        counterSentences = textInFile.split("\\.").length;
    }

    public static void countUniqueWords() {
        for (String words : arrayListOfWords) {
            if (Collections.frequency(arrayListOfWords, words) == 1) {
                counterUniqueWords++;
            }
        }
    }

    public static void countMostRepeatedWord() {
        int maxRepeatedWordCounter = 0;

        for (String words : arrayListOfWords) {
            if (Collections.frequency(arrayListOfWords, words) > maxRepeatedWordCounter) {
                maxRepeatedWordCounter++;
            }
        }

        for (String words : arrayListOfWords) {
            if (Collections.frequency(arrayListOfWords, words) == maxRepeatedWordCounter) {
                mostRepeatedWord.add(words);
            }
        }
    }

    public static int foundMinLengthWord() {
        int minLengthWord = arrayListOfWords.get(0).length();

        for (String word : arrayListOfWords) {
            if (word.length() < minLengthWord) {
                minLengthWord = word.length();
            }
        }

        return minLengthWord;
    }

    public static int foundMaxLengthWord() {
        int maxLengthWord = arrayListOfWords.get(0).length();

        for (String word : arrayListOfWords) {
            if (word.length() > maxLengthWord) {
                maxLengthWord = word.length();
            }
        }

        return maxLengthWord;
    }

    public static void countFrequencyWords() {
        HashMap<String, Integer> frequencyCounter = new HashMap<>();

        for (String word : arrayListOfWords) {
            if (!frequencyCounter.containsKey(word)) {
                frequencyCounter.put(word, 0);
            }
            frequencyCounter.put(word, frequencyCounter.get(word) + 1);
        }

        for (String word : frequencyCounter.keySet()) {
            System.out.println("| " + word + " = " + frequencyCounter.get(word));
        }
    }

    public static void countFrequencyLetters() {
        HashMap<Character, Integer> frequencyCounter = new HashMap<>();
        textInFile = textInFile.replaceAll("\\.|\\,|\\;", "");

        for (int i = 0; i < textInFile.length(); i++) {
            if (!frequencyCounter.containsKey(textInFile.charAt(i))) {
                frequencyCounter.put(textInFile.charAt(i), 0);
            }
            frequencyCounter.put(textInFile.charAt(i), frequencyCounter.get(textInFile.charAt(i)) + 1);
        }

        for (Character letter : frequencyCounter.keySet()) {
            System.out.println("| " + letter + " = " + frequencyCounter.get(letter));
        }
    }
}
