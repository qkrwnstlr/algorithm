import java.util.*;

class Solution {
    public int solution(int[][] lines) {
        int[] temp = new int[201];
        for(int[] line : lines) {
            for(int i = line[0]; i < line[1]; i++) {
                temp[i + 100]++;
            }
        }
        return (int) Arrays.stream(temp).filter(e -> e > 1).count();
    }
}