class Solution {
  public int solution(int[][] board, int[] aloc, int[] bloc) {
    init(board, aloc, bloc);
    return dfs(this.aloc, this.bloc, this.board);
  }

  int N, M, board, aloc, bloc;
  int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

  void init(int[][] board, int[] aloc, int[] bloc) {
    this.N = board.length;
    this.M = board[0].length;
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < M; y++) {
        if (board[x][y] == 0) this.board |= (1 << x * M + y);
      }
    }
    this.aloc = aloc[0] * M + aloc[1];
    this.bloc = bloc[0] * M + bloc[1];
  }

  int dfs(int a, int b, int board) {
    if (((board & (1 << a)) != 0)) return 0;

    int result = 0;

    int x = a / M, y = a % M;

    for (int i = 0; i < 4; i++) {
      int nx = x + dx[i], ny = y + dy[i], na = nx * M + ny;
      if (!isAble(nx, ny) || (((board & (1 << na))) != 0)) continue;

      int temp = dfs(b, na, board | (1 << a)) + 1;

      if (result % 2 == 0) {
        if (temp % 2 == 0) result = Math.max(result, temp);
        else result = temp;
      } else {
        if (temp % 2 == 1) result = Math.min(result, temp);
      }
    }

    return result;
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M;
  }
}