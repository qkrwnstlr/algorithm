class Solution {
    public String solution(int a, int b) {
        String[] wDay = {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int[] mDay = {0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335};
        return wDay[(mDay[a - 1] + b) % 7];
    }
}