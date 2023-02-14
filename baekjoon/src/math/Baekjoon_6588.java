package math;

import java.io.*;
import java.util.Arrays;

public class Baekjoon_6588 {
  static int MAX = 1000000;
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static boolean[] cash = new boolean[MAX + 1];

  static void Eratosthenes() {
    Arrays.fill(cash, true);
    // 2부터 100만까지 모든 소수를 구함
    for (int i = 2; i <= MAX; i++) {
      for (int j = i * 2; j <= MAX; j += i) {
        if (!cash[j]) continue;
        cash[j] = false;
      }
    }
  }

  static int goldBach(int n) {
    for (int i = 2; i <= n / 2; i++)
      if (cash[i] && cash[n - i]) return i; // 입력받은 값을 소수에서 뺏을때 그 수가 소수인지 확인
    return 0; // 끝까지 없으면 0 반환
  }

  static void write(int n, int a) throws IOException {
    if (a == 0) {
      bw.write("Goldbach's conjecture is wrong.\n");
      return;
    }
    bw.write(String.valueOf(n));
    bw.write(" = ");
    bw.write(String.valueOf(a));
    bw.write(" + ");
    bw.write(String.valueOf(n - a));
    bw.write("\n");
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Eratosthenes();
    while (true) {
      String str = br.readLine();
      int n = Integer.parseInt(str);
      if (n == 0) break;
      write(n, goldBach(n));
    }
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
