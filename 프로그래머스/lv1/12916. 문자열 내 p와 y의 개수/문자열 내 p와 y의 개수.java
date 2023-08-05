class Solution {
    boolean solution(String s) {
        String temp = s.toLowerCase().replaceAll("[^p|y]", "");
        return temp.replaceAll("y", "").length() == temp.replaceAll("p", "").length();
    }
}