class Solution {
    int[][] answer;
    int current = 1;
    int i = 0;
    int j = -1;
    
    public int[][] solution(int n) {
        answer = new int[n][n];
        int count = n - 1;
        for(int k = 0; k < n; k++) answer[i][++j] = current++;
        while(count > 0) {
            moveI(count, (n - count) % 2 == 1);
            moveJ(count, (n - count) % 2 == 0);
            count--;
        }
        return answer;
    }
    
    void moveI(int count, boolean isForward) {
        if(isForward) {
            for(int k = 0; k < count; k++) {
                answer[++i][j] = current++;
            }
        } else {
            for(int k = 0; k < count; k++) {
                answer[--i][j] = current++;
            }
        }
    }
    
    void moveJ(int count, boolean isForward) {
        if(isForward) {
            for(int k = 0; k < count; k++) {
                answer[i][++j] = current++;
            }
        } else {
            for(int k = 0; k < count; k++) {
                answer[i][--j] = current++;
            }
        }
    }
}