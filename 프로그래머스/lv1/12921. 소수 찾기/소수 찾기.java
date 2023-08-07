class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 2; i <= n; i++) if(check(i)) answer++;
        return answer;
    }
    
    boolean check(int n) {
        for(int i = 2; i * i <= n; i++) if(n % i == 0) return false;
        return true;
    }
}