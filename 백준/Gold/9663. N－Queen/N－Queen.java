import java.util.*;

public class Main {
  static int[] position;
  static int N;
  static int count = 0;

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    position = new int[N];

    nQueen(0);
    System.out.println(count);
  }

  static void nQueen(int depth) {
    if (depth == N) {
      count++;
      return;
    }

    for (int i = 0; i < N; i++) {
      position[depth] = i;
      if (isPossible(depth)) nQueen(depth + 1);
    }
  }

  static boolean isPossible(int curr) {
    for (int i = 0; i < curr; i++) {
      if (position[curr] == position[i] || Math.abs(curr - i) == Math.abs(position[curr] - position[i])) return false;
    }
    return true;
  }
}