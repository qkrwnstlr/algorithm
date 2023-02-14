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

    int[][] cash = new int[n][k + 1]; // (1 ~ n) C (0 ~ k)
    for (int i = 0; i < n; i++) { // 초기값 설정
      cash[i][0] = 1; // nC0 = 1
      if(k == 0) continue;
      cash[i][1] = i + 1; // nC1 = n
      if(i >= k) continue;
      cash[i][i] = i + 1; // nCn-1 = n
      cash[i][i + 1] = 1; // nCn = 1
    }
    for (int i = 1; i < n; i++) {
      for (int j = 2; j <= k; j++) {
        if (cash[i][j] == 0 && i >= j) { // 아직 값을 구하지 않았으면 계산, nCk에서 k가 더 크면 0이므로 계산하지 마라
          cash[i][j] = (cash[i - 1][j - 1] + cash[i - 1][j]) % 10007; // nCk = n-1Ck-1 + n-1Ck
        }
      }
    }
    System.out.println(cash[n - 1][k]); // nCk
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
