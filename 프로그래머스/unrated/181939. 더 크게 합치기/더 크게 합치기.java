class Solution {
    public int solution(int a, int b) {
        int n = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int m = Integer.parseInt(Integer.toString(b) + Integer.toString(a));
        int answer = m > n ? m : n;
        return answer;
    }
}