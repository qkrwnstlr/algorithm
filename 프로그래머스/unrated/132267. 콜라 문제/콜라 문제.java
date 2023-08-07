class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int before = n;
        while(before > a - 1) {
            int temp = before / a * b;
            answer += temp;
            before = temp + before % a;
        }
        return answer;
    }
}