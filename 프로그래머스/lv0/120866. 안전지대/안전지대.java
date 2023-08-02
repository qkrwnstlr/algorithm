import java.util.*;

class Solution {
    int[][] temp;
    public int solution(int[][] board) {
        temp = board;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(temp[i][j] == 1) check(i, j);
            }
        }
        return Arrays.stream(board).mapToInt(e -> (int) Arrays.stream(e).filter(k -> k == 0).count()).sum();
    }
    
    void check(int i, int j) {
        if(isAble(i - 1 ,j - 1) && temp[i - 1][j - 1] != 1) temp[i - 1][j - 1] = 2;
        if(isAble(i - 1 ,j) && temp[i - 1][j] != 1) temp[i - 1][j] = 2;
        if(isAble(i - 1 ,j + 1) && temp[i - 1][j + 1] != 1) temp[i - 1][j + 1] = 2;
        if(isAble(i ,j - 1) && temp[i][j - 1] != 1) temp[i][j - 1] = 2;
        if(isAble(i ,j + 1) && temp[i][j + 1] != 1) temp[i][j + 1] = 2;
        if(isAble(i + 1 ,j - 1) && temp[i + 1][j - 1] != 1) temp[i + 1][j - 1] = 2;
        if(isAble(i + 1 ,j) && temp[i + 1][j] != 1) temp[i + 1][j] = 2;
        if(isAble(i + 1 ,j + 1) && temp[i + 1][j + 1] != 1) temp[i + 1][j + 1] = 2;
    }
    
    boolean isAble(int i, int j) {
        return i >= 0 && i < temp.length && j >= 0 && j < temp[0].length;
    }
}