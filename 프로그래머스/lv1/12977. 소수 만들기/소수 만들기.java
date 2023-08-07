class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i + 1; j < nums.length - 1; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    if(check(nums[i] + nums[j] + nums[k])) answer++;
                }
            }
        }
        return answer;
    }
    boolean check(int a) {
        for(int i = 2; i * i <= a; i++) if(a % i == 0) return false;
        return true;
    }
}