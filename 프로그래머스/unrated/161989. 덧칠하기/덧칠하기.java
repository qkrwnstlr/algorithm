class Solution {
    public int solution(int n, int m, int[] section) {
        int[] wall = new int[n + 1];
        int answer = 0;
        for(int i : section) {
            wall[i]--;
            if(wall[i] >= 0) continue;
            for(int j = 0; j < m && i + j <= n; j++) wall[i + j]++;
            answer++;
        }
        return answer;
    }
}