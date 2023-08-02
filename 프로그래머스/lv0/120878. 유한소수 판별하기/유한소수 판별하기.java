class Solution {
    public int solution(int a, int b) {
        int temp = b / gcd(a, b);
        while(temp % 2 == 0) temp /= 2;
        while(temp % 5 == 0) temp /= 5;
        return temp == 1 ? 1 : 2;
    }
    
    int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}