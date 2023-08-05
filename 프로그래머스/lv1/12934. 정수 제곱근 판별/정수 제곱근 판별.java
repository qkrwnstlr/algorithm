class Solution {
    public long solution(long n) {
        double temp = Math.sqrt(n);
        return temp - (long) temp == 0 ? (long) Math.pow(temp + 1, 2) : -1;
    }
}