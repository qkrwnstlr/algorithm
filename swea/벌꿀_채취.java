import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
  public static void main(String[] args) throws IOException {
    new Solution().run();
  }
 
  BufferedReader br;
  StringBuilder sb;
  StringTokenizer st;
  int N, M, C, result;
  int[][] table, prices;
 
  void init() throws IOException {
    result = 0;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    table = new int[N][N];
    prices = new int[N][N];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) {
        table[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }
 
  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
 
    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      init();
      solution();
      sb.append("#").append(testCase).append(" ").append(result).append("\n");
    }
 
    System.out.println(sb);
 
    br.close();
  }
 
  void solution() {
    for (int i = 0; i < N; i++) {
      for (int j = 0; j <= N - M; j++) {
        calculate(i, j, 0, 0, 0);
      }
    }
 
    for (int i1 = 0; i1 < N; i1++) {
      for (int j1 = 0; j1 <= N - M; j1++) {
        for (int i2 = i1; i2 < N; i2++) {
          for (int j2 = 0; j2 <= N - M; j2++) {
            if (i1 == i2 && Math.abs(j1 - j2) < M) continue;
            result = Math.max(result, prices[i1][j1] + prices[i2][j2]);
          }
        }
      }
    }
  }
 
  void calculate(int i, int j, int amount, int price, int depth) {
    if (amount > C) return;
    if (depth == M) {
      prices[i][j - M] = Math.max(prices[i][j - M], price);
      return;
    }
    calculate(i, j + 1, amount + table[i][j], price + table[i][j] * table[i][j], depth + 1);
    calculate(i, j + 1, amount, price, depth + 1);
  }
}
