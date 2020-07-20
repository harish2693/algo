package com.example;

import java.util.Arrays;

public class MatrixTranspose {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] result = transpose(matrix);
        for (int i =0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] transpose(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int[][] result = new int[columns][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                result[j][i] = matrix[i][j];
            }
        }

        return result;
    }
}
