import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> box = new ArrayList<>();
        for(int i : moves) {
            int temp = -1;
            for(int j = 0; j < board.length; j++) {
                if(board[j][i - 1] != 0) {
                    temp = board[j][i - 1];
                    board[j][i - 1] = 0;
                    break;
                }
            }
            if(temp == -1) continue;
            if(!box.isEmpty() && box.get(box.size() - 1) == temp) {
                box.remove(box.size() - 1);
                answer += 2;
            }
            else box.add(temp);
        }
        return answer;
    }
}