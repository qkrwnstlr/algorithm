import java.io.*;
import java.util.*;

public class Main {
  static int N;


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    start(0, 0);
  }

  static void start(int current, int depth) {
    if (!check(current)) return;
    if (depth == N) {
      System.out.println(current);
      return;
    }

    int j = depth == 0 ? 2 : 0;
    for (; j < 10; j++) start(current * 10 + j, depth + 1);
  }

  static boolean check(int n) {
    for (int i = 2; i * i <= n; i++) {
      if (n % i == 0) return false;
    }
    return true;
  }
}