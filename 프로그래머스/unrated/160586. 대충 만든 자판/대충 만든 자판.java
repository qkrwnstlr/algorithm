class Solution {
    public static int[] solution(String[] keymap, String[] targets) {
        int[] temp = new int[26];
        for(int i = 0; i < temp.length; i++) temp[i] = Integer.MAX_VALUE;
        for(String s : keymap) {
            for(int j = 0; j < s.length(); j++) {
                temp[s.charAt(j) - 'A'] = Math.min(temp[s.charAt(j) - 'A'], j);
            }
        }
        int[] answer = new int[targets.length];
        for(int i = 0; i < targets.length; i++) {
            int count = 0;
            for(char c : targets[i].toCharArray()) {
                if(temp[c - 'A'] == Integer.MAX_VALUE) {
                    count = -1;
                    break;
                }
                count += temp[c - 'A'] + 1;
            }
            answer[i] = count;
        }
        return answer;
    }
}