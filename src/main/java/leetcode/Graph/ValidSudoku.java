package leetcode.Graph;

/**
 * https://leetcode.com/problems/valid-sudoku/
 * Created by jinjunzhu on 2019/4/13.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++){
            if (!isValid(board, i, i + 1, 0, 9)){
                return false;
            }
        }

        for (int i = 0; i < 9; i++){
            if (!isValid(board, 0, 9, i, i + 1)){
                return false;
            }
        }

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (!isValid(board, i * 3, (i + 1) * 3, j * 3, (j + 1) * 3)){
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] area, int rowLow, int rowHigh, int columnLow, int columnHigh) {
        boolean[] used = new boolean[9];
        for (int i = rowLow; i < rowHigh; i++){
            for (int j = columnLow; j < columnHigh; j++) {
                if (area[i][j] == '.'){
                    continue;
                }
                if (used[area[i][j] - '1'] == true){
                    return false;
                }
                else{
                    used[area[i][j] - '1'] = true;
                }
            }
        }

        return true;
    }
}
