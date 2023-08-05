class Solution {
    public boolean solution(String s) {
        return s.length() == 4 || s.length() == 6 ? s.replaceAll("[0-9]", "").length() == 0 ? true : false : false;
    }
}