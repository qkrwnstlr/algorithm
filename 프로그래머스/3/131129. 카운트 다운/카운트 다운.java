class Solution {
  public int[] solution(int target) {
    int[][] dp = new int[target + 1][2];
    for (int i = 1; i <= target; i++) dp[i][0] = Integer.MAX_VALUE;

    for (int i = 1; i <= target; i++) {
      for (int j = 1; j <= 20; j++) {
        if (i >= 50) {
          int k = i - 50;
          if (dp[i][0] > dp[k][0] + 1) {
            dp[i][0] = dp[k][0] + 1;
            dp[i][1] = dp[k][1] + 1;
          } else if (dp[i][0] == dp[k][0] + 1) {
            dp[i][1] = Math.max(dp[i][1], dp[k][1] + 1);
          }
        }

        if (i >= j) {
          int k = i - j;
          if (dp[i][0] > dp[k][0] + 1) {
            dp[i][0] = dp[k][0] + 1;
            dp[i][1] = dp[k][1] + 1;
          } else if (dp[i][0] == dp[k][0] + 1) {
            dp[i][1] = Math.max(dp[i][1], dp[k][1] + 1);
          }
        }

        if (i >= j * 2) {
          int k = i - j * 2;
          if (dp[i][0] > dp[k][0] + 1) {
            dp[i][0] = dp[k][0] + 1;
            dp[i][1] = dp[k][1];
          }
        }

        if (i >= j * 3) {
          int k = i - j * 3;
          if (dp[i][0] > dp[k][0] + 1) {
            dp[i][0] = dp[k][0] + 1;
            dp[i][1] = dp[k][1];
          }
        }
      }
    }

    return dp[target];
  }
}
