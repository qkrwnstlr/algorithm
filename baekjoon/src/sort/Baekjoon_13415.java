package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_13415 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Integer[] ints = new Integer[n];
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    for (int i = 0; i < n; i++) ints[i] = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());
    for (int i = 0; i < k; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      Arrays.sort(ints, 0, Integer.parseInt(st.nextToken()));
      Arrays.sort(ints, 0, Integer.parseInt(st.nextToken()), Comparator.reverseOrder());
    }
    for (int i = 0; i < n; i++) sb.append(ints[i]).append(" ");
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
