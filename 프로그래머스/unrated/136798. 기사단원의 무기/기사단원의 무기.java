class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++) {
            int p = power(i);
            answer += p <= limit ?  p : power;
        }
        return answer;
    }
    int power(int n) {
        int answer = 0;
        for(int i = 1; i * i <= n; i++) {
            if(n == i * i) answer++;
            else if(n % i == 0) answer += 2;
        }
        return answer;
    }
}