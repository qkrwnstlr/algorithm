class Solution {
  public String solution(int n, int m, int x, int y, int r, int c, int k) {
    init(n, m, x, y, r, c, k);

    int distance = getLeftDistance(this.x, this.y);
    if (distance > k || (k - distance) % 2 == 1) return "impossible";

    dfs(this.x, this.y);

    return answer == null ? "impossible" : answer;
  }

  int n, m, x, y, r, c, k;

  int[] dx = {1, 0, 0, -1}, dy = {0, -1, 1, 0};
  String[] dc = {"d", "l", "r", "u"};

  StringBuilder sb;
  String answer;

  void init(int n, int m, int x, int y, int r, int c, int k) {
    this.n = n;
    this.m = m;
    this.x = x - 1;
    this.y = y - 1;
    this.r = r - 1;
    this.c = c - 1;
    this.k = k;
    sb = new StringBuilder();
  }

  void dfs(int x, int y) {
    if (answer != null) return;
    if (getLeftDistance(x, y) + sb.length() > k) return;
    if (sb.length() == k) {
      answer = sb.toString();
      return;
    }

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i];
      if (isAble(nx, ny)) {
        sb.append(dc[i]);
        dfs(nx, ny);
        sb.deleteCharAt(sb.length() - 1);
      }
    }
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < n && y >= 0 && y < m;
  }

  int getLeftDistance(int x, int y) {
    return Math.abs(x - r) + Math.abs(y - c);
  }
}
