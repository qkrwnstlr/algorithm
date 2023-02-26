package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_10844 {
  static int mod = 1000000000;

  static public int next(int a, int b) {
    return (a + b) % mod;
  }

  static public void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] c = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0};
    int result = 0;
    // 그 위치의 경우의 수는 자신이 갈 수 있는 두 위치의 경우의 수의 합과 같다.
    for (int i = 1; i < n; i++) {
      c = new int[]{0, next(c[0], c[2]),
          next(c[1], c[3]), next(c[2], c[4]),
          next(c[3], c[5]), next(c[4], c[6]),
          next(c[5], c[7]), next(c[6], c[8]),
          next(c[7], c[9]), next(c[8], c[10]),
          next(c[9], c[11]), 0};
    }
    for (int i = 2; i < 11; i++) {
      result = next(result, c[i]);
    }

    System.out.println(result);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
