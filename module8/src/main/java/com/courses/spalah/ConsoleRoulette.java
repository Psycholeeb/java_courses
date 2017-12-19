package com.courses.spalah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Класс-стартер для вашей реализации рулетки
 */
public class ConsoleRoulette {
    public static void main(String[] args) {
        Roulette roulette = new Roulette();
        roulette.generate();
        roulette.print();

        while(true) {
            String[] arguments = readFromConsole();
            CommandParser commandParser = new CommandParser();
            Command command = commandParser.getCommand(arguments);
            command.setRoulette(roulette);
            command.execute();
        }
    }

    public static String[] readFromConsole() {
        try {
            BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
            String input = bufferRead.readLine();
            return input.split("\\s");
        } catch (IOException e) {
            return new String[]{""};
        }
    }
}
