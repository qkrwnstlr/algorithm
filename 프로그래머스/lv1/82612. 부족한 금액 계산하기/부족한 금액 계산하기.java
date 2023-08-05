class Solution {
    public long solution(int price, int money, int count) {
        long result = (long) count * (count + 1) / 2 * price - money;
        return result < 0 ? 0 : result;
    }
}