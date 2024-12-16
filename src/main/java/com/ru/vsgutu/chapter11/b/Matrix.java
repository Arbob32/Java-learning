package com.ru.vsgutu.chapter11.b;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Matrix {
    private MatrixNode head = null;

    public void append(int row, int col, int value) {
        if (head == null) {
            head = new MatrixNode(row, col, value);
        } else {
            MatrixNode newNode = new MatrixNode(row, col, value);
            MatrixNode last = head;
            while (last.next != head) {
                last = last.next;
            }
            last.next = newNode;
            newNode.next = head;
        }
    }

    public Matrix add(Matrix other) {
        Matrix result = new Matrix();
        MatrixNode cur1 = this.head;
        MatrixNode cur2 = other.head;
        while (cur1 != null && cur2 != null) {
            if (cur1.row == cur2.row && cur1.col == cur2.col) {
                result.append(cur1.row, cur1.col, cur1.value + cur2.value);
                cur1 = cur1.next;
                cur2 = cur2.next;
            } else if (cur1.row < cur2.row || (cur1.row == cur2.row && cur1.col < cur2.col)) {
                result.append(cur1.row, cur1.col, cur1.value);
                cur1 = cur1.next;
            } else {
                result.append(cur2.row, cur2.col, cur2.value);
                cur2 = cur2.next;
            }
            if (cur1 == this.head) cur1 = null;
            if (cur2 == other.head) cur2 = null;
        }
        return result;
    }

    public Matrix multiply(Matrix other) {
        Matrix result = new Matrix();
        MatrixNode cur1 = this.head;
        int maxCol1 = getMaxCol();
        int maxRow1 = getMaxRow();
        int maxRow2 = other.getMaxRow();
        int maxCol2 = other.getMaxCol();
        for (int i = 0; i <= maxRow1; i++) {
            for (int j = 0; j <= maxCol2; j++) {
                int sum = 0;
                for (int k = 0; k <= maxCol1; k++) {
                    int val1 = getValue(i, k);
                    int val2 = other.getValue(k, j);
                    sum += val1 * val2;
                }
                if (sum != 0) {
                    result.append(i, j, sum);
                }
            }
        }
        return result;
    }

    private int getMaxCol() {
        int maxCol = 0;
        MatrixNode current = head;
        if (current != null) {
            maxCol = current.col;
            current = current.next;
            while (current != head) {
                if (current.col > maxCol) {
                    maxCol = current.col;
                }
                current = current.next;
            }
        }
        return maxCol;
    }

    private int getMaxRow() {
        int maxRow = 0;
        MatrixNode current = head;
        if (current != null) {
            maxRow = current.row;
            current = current.next;
            while (current != head) {
                if (current.row > maxRow) {
                    maxRow = current.row;
                }
                current = current.next;
            }
        }
        return maxRow;
    }

    private int getValue(int row, int col) {
        MatrixNode current = head;
        if (current != null) {
            do {
                if (current.row == row && current.col == col) {
                    return current.value;
                }
                current = current.next;
            } while (current != head);
        }
        return 0;
    }

    public void readFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(" ");
            int row = Integer.parseInt(parts[0]);
            int col = Integer.parseInt(parts[1]);
            int value = Integer.parseInt(parts[2]);
            append(row, col, value);
        }
        reader.close();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        MatrixNode current = head;
        if (current != null) {
            sb.append(current.row)
                    .append(" ")
                    .append(current.col)
                    .append(" ")
                    .append(current.value)
                    .append("\n");
            current = current.next;
            while (current != head) {
                sb.append(current.row)
                        .append(" ")
                        .append(current.col)
                        .append(" ")
                        .append(current.value)
                        .append("\n");
                current = current.next;
            }
        }
        return sb.toString();
    }
}
