package com.courses.spalah;

import java.util.Random;

/**
 * Класс который представляет рулетку
 */
public class Roulette {
    Cell[] cells = new Cell[37];

    public void generate() {
        // заполняем массив ячейками
        for (int i = 0; i < cells.length; i++) {
            cells[i] = new Cell();
        }
    }

    public void print() {
        // печататем все ячейки в рулетке
    }
}
