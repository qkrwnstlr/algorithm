class Solution {
    public int solution(String s) {
        int answer = 0;
        while(!s.isEmpty()) {
            int a = 0;
            int b = 0;
            for(int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == s.charAt(0)) a++;
                else b++;
                if(a == b) break;
            }
            answer++;
            s = s.substring(a + b);
        }
        return answer;
    }
}