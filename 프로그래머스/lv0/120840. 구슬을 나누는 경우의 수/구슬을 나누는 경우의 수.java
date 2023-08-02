class Solution {    
    public int solution(int balls, int share) {
        return combination(balls, share);
    }
    
    public int combination(int n, int r) {
        if(n == r) return 1;
        if(n == 1 || r == 1 || r == 0) return n;
        return combination(n - 1, r - 1) + combination(n - 1, r);
    }
}