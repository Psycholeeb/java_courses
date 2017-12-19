package com.courses.spalah;

/**
 * Created by Jeka on 29.07.2016.
 */
public abstract class Command {
    String[] arguments;
    Roulette roulette;

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public void setRoulette(Roulette roulette) {
        this.roulette = roulette;
    }

    public abstract void execute();
}
