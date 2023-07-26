class Solution {
    public int solution(int n) {
        int current = 1;
        if(n == 1) return 1;
        for(int i = 0; i < 10; i++) {
            System.out.println(current);
            if(current > n) return i - 1;
            if(current == n) return i;
            current *= (i + 1);
        }
        return 10;
    }
}