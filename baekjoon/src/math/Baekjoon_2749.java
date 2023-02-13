package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2749 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    int pisano = 1500000;
    long n = Long.parseLong(str);

    int[] cash = new int[pisano + 1];
    cash[0] = 0;
    cash[1] = 1;
    int i;
    for (i = 2; i <= n % pisano; i++) {
      cash[i] = (cash[i - 1] + cash[i - 2]) % 1000000;
    }
    System.out.println(cash[i - 1]);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
