class Solution {
    public int solution(int[] common) {
        int difference = common[1] - common[0];
        if(common[0] == 0 || common[2] - common[1] == difference) return common[common.length - 1] + difference;
        return common[common.length - 1] * common[1] / common[0];
    }
}