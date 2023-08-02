class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        for(String s: keyinput) {
            switch(s) {
                case "right": if(answer[0] < board[0] / 2) answer[0]++; break;
                case "left": if(answer[0] > -board[0] / 2) answer[0]--; break;
                case "down": if(answer[1] > -board[1] / 2) answer[1]--; break;
                case "up": if(answer[1] < board[1] / 2) answer[1]++; break;
            }
        }
        return answer;
    }
}