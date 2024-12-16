package com.ru.vsgutu.chapter11.b;

class MatrixNode {
    int row, col, value;
    MatrixNode next;

    MatrixNode(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
        this.next = this;
    }
}
