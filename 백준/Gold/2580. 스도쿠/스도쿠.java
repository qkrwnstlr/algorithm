import java.io.*;
import java.util.*;

public class Main {
  static int[][] board = new int[9][9];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    for (int i = 0; i < 9; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < 9; j++) board[i][j] = Integer.parseInt(st.nextToken());
    }

    play(0, 0);

    StringBuilder sb = new StringBuilder();
    for (int[] line : board) {
      for (int i : line) sb.append(i).append(" ");
      sb.append("\n");
    }
    System.out.println(sb);
  }

  static boolean play(int i, int j) {
    if (i >= 9 || j >= 9) return true;
    if (board[i][j] == 0) {
      boolean isPossible = true;
      for (int k = 1; k <= 9; k++) {
        isPossible = isPossible(i, j, k);
        if (isPossible) {
          board[i][j] = k;
          isPossible = play(i + (j + 1) / 9, (j + 1) % 9);
          if (isPossible) break;
          board[i][j] = 0;
        }
      }
      return isPossible;
    }
    return play(i + (j + 1) / 9, (j + 1) % 9);
  }

  static boolean isPossible(int n, int m, int value) {
    for (int i = 0; i < 9; i++) if (board[i][m] == value || board[n][i] == value) return false;
    n = n / 3 * 3;
    m = m / 3 * 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (board[n + i][m + j] == value) return false;
      }
    }
    return true;
  }
}