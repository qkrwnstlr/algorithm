class Solution {
    public int solution(int hp) {
        int current = hp;
        int a = current / 5;
        current %= 5;
        int b = current / 3;
        current %= 3;
        int c = current;
        return a + b + c;
    }
}