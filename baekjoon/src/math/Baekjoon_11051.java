package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11051 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    int n = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(st.nextToken());

    if(k == 0) {
      System.out.println(1);
      return;
    }

    int[][] cash = new int[1000][1000];
    for (int i = 0; i < n; i++) {
      cash[i][i] = 1;
      cash[i][0] = i + 1;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < k; j++) {
        if (cash[i][j] == 0 && i > j) cash[i][j] = (cash[i - 1][j - 1] + cash[i - 1][j]) % 10007;
      }
    }
    System.out.println(cash[n - 1][k - 1]);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
