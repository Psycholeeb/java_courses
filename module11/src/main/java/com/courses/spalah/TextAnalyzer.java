package com.courses.spalah;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author Ievgen Tararaka
 */
public class TextAnalyzer {
    private static int counterWords = 0;
    private static int counterSymbols = 0;
    private static int counterSentences = 0;
    private static int counterUniqueWords = 0;
    private static HashSet<String> mostRepeatedWord = new HashSet<>();
    private static ArrayList<String> arrayListOfWords = new ArrayList<>();
    private static String textInFile = "";

    public static void main(String[] args) {
        readTextFromFile();
        writeStatisticInFile();
    }

    public static void readTextFromFile() {
        final String PATH_INPUT_FILE = "F:/courses-2-2016-vlad_stupak_homework_remote/module11/src/main/resources/text_sample.txt";

        try {
            Scanner scanner = new Scanner(new File(PATH_INPUT_FILE));

            while (scanner.hasNext()) {
                countWordsInFile();
                countSymbolsInFile(scanner.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        countSentencesInFile();
        countUniqueWords();
        countMostRepeatedWords();
    }

    public static void writeStatisticInFile() {
        final String PATH_OUTPUT_FILE = "F:/courses-2-2016-vlad_stupak_homework_remote/module11/src/main/resources/output.txt";

        try (FileWriter fileWriter = new FileWriter(PATH_OUTPUT_FILE, false)) {

            fileWriter.write("Total amount symbols: " + counterSymbols);
            fileWriter.write("\nTotal amount words: " + counterWords);
            fileWriter.write("\nTotal amount sentences: " + counterSentences);
            fileWriter.write("\nTotal amount unique words: " + counterUniqueWords);
            fileWriter.write("\nMost repeated word: " + "\"" + mostRepeatedWord + "\"");
            fileWriter.write("\nMin length of word: " + foundMinLengthWord());
            fileWriter.write("\nMax length of word: " + foundMaxLengthWord());
            fileWriter.write("\n\nStatistic frequency words: \n");
            fileWriter.write(countFrequencyWords().toString());
            fileWriter.write("\nStatistic frequency letters: \n");
            fileWriter.write(countFrequencyLetters().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
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
        counterSentences = textInFile.split("\\.|\\!").length;
    }

    public static void countUniqueWords() {
        for (String words : arrayListOfWords) {
            if (Collections.frequency(arrayListOfWords, words) == 1) {
                counterUniqueWords++;
            }
        }
    }

    public static void countMostRepeatedWords() {
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

    public static StringBuilder countFrequencyWords() {
        HashMap<String, Integer> frequencyCounter = new HashMap<>();
        StringBuilder frequencyWords = new StringBuilder();

        for (String word : arrayListOfWords) {
            if (!frequencyCounter.containsKey(word)) {
                frequencyCounter.put(word, 0);
            }
            frequencyCounter.put(word, frequencyCounter.get(word) + 1);
        }

        for (String word : frequencyCounter.keySet()) {
            frequencyWords.append("| " + word + " = " + frequencyCounter.get(word) + "\n");
        }

        return frequencyWords;
    }

    public static StringBuilder countFrequencyLetters() {
        HashMap<Character, Integer> frequencyCounter = new HashMap<>();
        StringBuilder frequencyLetters = new StringBuilder();
        textInFile = textInFile.replaceAll("\\.|\\,|\\;", "");

        for (int i = 0; i < textInFile.length(); i++) {
            if (!frequencyCounter.containsKey(textInFile.charAt(i))) {
                frequencyCounter.put(textInFile.charAt(i), 0);
            }
            frequencyCounter.put(textInFile.charAt(i), frequencyCounter.get(textInFile.charAt(i)) + 1);
        }

        for (Character letter : frequencyCounter.keySet()) {
            frequencyLetters.append("| " + letter + " = " + frequencyCounter.get(letter) + "\n");
        }

        return frequencyLetters;
    }
}