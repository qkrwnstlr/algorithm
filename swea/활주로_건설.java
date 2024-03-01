import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
  public static void main(String[] args) throws IOException {
    new Solution().solution();
  }

  BufferedReader br;
  StringTokenizer st;
  StringBuilder sb;
  int N, X, result;
  int[][] table;

  void solution() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      sb.append("#").append(testCase);

      st = new StringTokenizer(br.readLine());
      N = Integer.parseInt(st.nextToken());
      X = Integer.parseInt(st.nextToken());
      table = new int[N][N];

      for (int i = 0; i < N; i++) {
        table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      }

      result = 0;
      for (int i = 0; i < N; i++) {
        count(table[i]);
      }

      int[] temp = new int[N];
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
          temp[j] = table[j][i];
        }
        count(temp);
      }

      sb.append(" ").append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void count(int[] arr) {
    int countZero = 1;
    boolean isDown = false;
    for (int i = 1; i < N; i++) {
      if (Math.abs(arr[i] - arr[i - 1]) > 1) return;
      if (arr[i] - arr[i - 1] == 1) {
        if (isDown) return;
        if (countZero < X) return;
        countZero = 1;
      }
      if (arr[i] - arr[i - 1] == -1) {
        if (isDown) return;
        isDown = true;
        countZero = 1;
      }
      if (arr[i] - arr[i - 1] == 0) {
        countZero++;
        if (isDown && countZero == X) {
          isDown = false;
          countZero = 1;
        }
      }
    }
    if (isDown) return;
    result++;
  }
}
