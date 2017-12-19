package com.courses.spalah;

/**
 * Created by Jeka on 29.07.2016.
 */
public class CommandParser {
    public Command getCommand(String[] arguments) {
        Command command = null;
        // создаем разные типы комманд в зависимости от аргументов
        command.setArguments(arguments);
        return command;
    }
}
