import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        int row = 0;
        int column = 0;
        for(int[] size : sizes) {
            size = Arrays.stream(size).sorted().toArray();
            row = Math.max(row, size[0]);
            column = Math.max(column, size[1]);
        }
        return row * column;
    }
}