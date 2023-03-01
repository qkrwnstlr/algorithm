package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1697 {
  static int n;
  static int k;

  public static int move(int current, int i) {
    if (current / 2 + 1 < n) return i + Math.abs(current - n);
    if (current == n) return i;
    if (current % 2 != 0) {
      int a = move(current + 1, i + 1);
      int b = move(current - 1, i + 1);
      return Math.min(a, b);
    } else return move(current / 2, i + 1);
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    k = Integer.parseInt(st.nextToken());
    System.out.println(move(k, 0));
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
