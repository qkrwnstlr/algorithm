import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

class Solution {
  BufferedReader br;
  StringBuilder sb;
  int[][] table;
  boolean[][] visited;
  int[] dx = {0, 0, 1}, dy = {1, -1, 0};
  int size;

  public static void main(String[] args) throws IOException {
    new Solution().solution();
  }

  void solution() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = 10;

    for (int test_case = 1; test_case <= T; test_case++) {
      test_case = Integer.parseInt(br.readLine());
      size = 100;
      table = new int[size][size];

      for (int i = 0; i < size; i++) {
        table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      int result = 0;

      for (int j = 0; j < size; j++) {
        if (table[0][j] == 0) continue;
        visited = new boolean[size][size];
        int x = 0;
        int y = j;
        while (x < size - 1) {
          visited[x][y] = true;
          for (int k = 0; k < dx.length; k++) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (isExist(nx, ny) && !visited[nx][ny] && table[nx][ny] != 0) {
              x = nx;
              y = ny;
              break;
            }
          }
        }

        if (table[x][y] == 2) {
          result = j;
          break;
        }
      }

      sb.append("#").append(test_case).append(" ").append(result).append("\n");
    }

    System.out.println(sb);
    br.close();
  }

  boolean isExist(int x, int y) {
    return x >= 0 && x < size && y >= 0 && y < size;
  }
}
