class Solution {
    public int solution(String A, String B) {
        int answer = 0;
        String temp = A;
        while(!temp.equals(B)) {
            if(answer > A.length()) return -1;
            answer++;
            temp = temp.substring(A.length() - 1, A.length()) + temp.substring(0, A.length() - 1);
        }
        return answer;
    }
}