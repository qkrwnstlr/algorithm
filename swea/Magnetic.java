import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;

class Solution {
  BufferedReader br;
  StringBuilder sb;
  int[][] table;
  int size;

  public static void main(String[] args) throws IOException {
    new Solution().solution();
  }

  void solution() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = 10;

    for (int test_case = 1; test_case <= T; test_case++) {
      size = Integer.parseInt(br.readLine());
      table = new int[size][size];

      for (int i = 0; i < size; i++) {
        table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      int result = 0;

      for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
          int current = table[j][i];
          while (current != 1 && j < size - 1) {
            current = table[++j][i];
          }
          if (current == 2) continue;
          while (current != 2 && j < size - 1) {
            current = table[++j][i];
          }
          if (current == 2) result++;
        }
      }

      sb.append("#").append(test_case).append(" ").append(result).append("\n");
    }

    System.out.println(sb);
    br.close();
  }
}
