class Solution {
    public int[] solution(int n, int m) {
        int temp = gcd(n, m);
        return new int[]{temp, n * m / temp};
    }
    int gcd(int a, int b) {
        if(b == 0) return a;
        return gcd(b, a % b);
    }
}