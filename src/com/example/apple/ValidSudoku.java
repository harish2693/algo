//Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules. (http://sudoku.com.au/TheRules.aspx)
//The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
//A partially filled sudoku which is valid.

//Note:
//A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

package com.example.apple;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] input = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudokuAlternate(input));

    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rows = new HashSet<>();
            HashSet<Character> columns = new HashSet<>();
            HashSet<Character> box = new HashSet<>();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                int rowIndex = (i / 3) * 3;
                int columnIndex = (i % 3) * 3;
                if (board[rowIndex + j / 3][columnIndex + j % 3] != '.' && !box.add(board[rowIndex + j / 3][columnIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudokuAlternate(char[][] board) {
        HashSet<String> visited = new HashSet<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char currentValue = board[i][j];

                if (currentValue != '.') {
                    if (!visited.add(currentValue + " found in row " + i) ||
                    !visited.add(currentValue + " found in column " + j) ||
                    !visited.add(currentValue + " found in box " + i / 3 + "-" + j / 3)) {
                        return true;
                    }
                }
            }
        }
        return true;
    }
}
