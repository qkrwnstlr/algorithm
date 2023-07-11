class Solution {
    public int solution(String my_string, String is_prefix) {
        try {
            String prefix = my_string.substring(0, is_prefix.length());
            int answer = prefix.equals(is_prefix) ? 1 : 0;
            return answer;
        } catch(Exception e) {
            return 0;
        }
    }
}