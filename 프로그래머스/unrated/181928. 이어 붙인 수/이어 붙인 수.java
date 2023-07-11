class Solution {
    public int solution(int[] num_list) {
        String n = "";
        String m = "";
        for(int i = 0; i < num_list.length; i++) {
            if(num_list[i] % 2 == 0) n += num_list[i];
            else m += num_list[i];
        }
        int answer = Integer.parseInt(n) + Integer.parseInt(m);
        return answer;
    }
}