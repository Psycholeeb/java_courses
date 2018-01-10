package com.courses.spalah;

/**
 * Класс который представляет ячейку на рулетке
 */

public class Cell {
    private int numberOfCell;
    private int colorOfCell;    //0-green, 1-black, 2-red

    public void setNumberOfCell(int numberOfCell) {
        this.numberOfCell = numberOfCell;
    }

    public int getNumberOfCell() {
        return numberOfCell;
    }

    public void setColorOfCell(int color) {
        this.colorOfCell = color;
    }

    public int getColorOfCell() {
        return colorOfCell;
    }
}

