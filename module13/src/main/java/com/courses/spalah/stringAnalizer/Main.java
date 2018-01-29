package com.courses.spalah.stringAnalizer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private final static String SEARCH_WORD = "вечер";
    private final static String PATH_FILE = "H://courses-2-2016-vlad_stupak_homework_remote/module13/file.txt";
    private static ArrayList<String> textInFileArray = new ArrayList<>();

    public static void main(String args[]) {
        try {
            readFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        printInfo();
        serchInFile();
    }

    public static void printInfo() {
        System.out.println("\nСлово для поиска: " + "\"" + SEARCH_WORD + "\"");
        System.out.println("Путь к файлу: " + PATH_FILE);
        System.out.println("\nСодержание файла: ");
        System.out.println("================================");

        for (int i = 0; i < textInFileArray.size(); i++) {
            System.out.println(textInFileArray.get(i));
        }

        System.out.println("================================");
        System.out.println("\nСтроки которое содержат слово " + "\"" + SEARCH_WORD + ":");
        System.out.println("================================");
    }

    public static void readFile() throws FileNotFoundException{
        Scanner scanner = new Scanner(new File(PATH_FILE));

        while (scanner.hasNext()) {
            textInFileArray.add(scanner.nextLine().toLowerCase());
        }
    }

    private static void serchInFile() {
        for (int i = 0; i < textInFileArray.size(); i++) {
            if (textInFileArray.get(i).contains(SEARCH_WORD)) {
                System.out.println(textInFileArray.get(i));
            } else
                continue;
        }
    }
}
