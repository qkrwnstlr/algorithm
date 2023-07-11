class Solution {
    public int solution(int a, int b) {
        switch(a % 2 + b % 2) {
            case 0: return Math.abs(a - b);
            case 1: return (a + b) * 2;
            case 2: return a * a + b * b;
        }
        return 0;
    }
}