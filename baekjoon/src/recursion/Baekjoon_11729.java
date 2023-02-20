package recursion;

import java.io.*;

public class Baekjoon_11729 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n;
  static int k;

  static void hanoi(int depth, int from, int to) throws IOException {
    int next = 6 - from - to; // 임시 위치
    if(depth != n) hanoi(depth + 1, from, next); // n - 1개를 먼저 from에서 next 에 옮기고
    move(from, to); // n을 from에서 to에 옮긴 후
    if(depth != n) hanoi(depth + 1, next, to); // 임시 위치에 둔 n - 1개를 next에서 to로 옮김
  }

  static void move(int from, int to) throws IOException {
    bw.write(String.valueOf(from));
    bw.write(" ");
    bw.write(String.valueOf(to));
    bw.write("\n");
  }

  static void result() throws IOException {
    n = Integer.parseInt(br.readLine());
    k = (int) (Math.pow(2, n) - 1);
    bw.write(String.valueOf(k));
    bw.write("\n");
    hanoi(1, 1, 3); // 1에 있는 놈들을 3으로 옮김
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
