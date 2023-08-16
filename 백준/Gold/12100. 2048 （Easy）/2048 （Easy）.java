import java.io.*;
import java.util.*;

public class Main {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    int[][] board = new int[N][N];
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < N; j++) board[i][j] = Integer.parseInt(st.nextToken());
    }
    System.out.println(play(board, 0));
  }

  static int[][] copy(int[][] board) {
    int[][] temp = new int[N][N];
    for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) temp[i][j] = board[i][j];
    return temp;
  }

  static int play(int[][] board, int count) {
    if (count == 5) return getMax(board);
    int left = play(moveLeft(copy(board)), count + 1);
    int right = play(moveRight(copy(board)), count + 1);
    int up = play(moveUp(copy(board)), count + 1);
    int down = play(moveDown(copy(board)), count + 1);
    return Math.max(Math.max(left, right), Math.max(up, down));
  }

  static int getMax(int[][] board) {
    return Arrays.stream(board).mapToInt(e -> Arrays.stream(e).max().getAsInt()).max().getAsInt();
  }

  static int[][] moveLeft(int[][] board) {
    for (int i = 0; i < N; i++) {
      int last = -1;
      for (int j = 1; j < N; j++) {
        if (board[i][j] == 0) continue;
        int k = 0;
        while (j - k - 1 >= 0 && board[i][j - k - 1] == 0) {
          board[i][j - k - 1] = board[i][j - k];
          board[i][j - k] = 0;
          if (j - k > 1) k++;
        }
        if (last != j - k - 1 && board[i][j - k - 1] == board[i][j - k]) {
          board[i][j - k - 1] *= 2;
          board[i][j - k] = 0;
          last = j - k - 1;
        }
      }
    }
    return board;
  }

  static int[][] moveRight(int[][] board) {
    for (int i = 0; i < N; i++) {
      int last = -1;
      for (int j = N - 2; j >= 0; j--) {
        if (board[i][j] == 0) continue;
        int k = 0;
        while (j + k < N - 1 && board[i][j + k + 1] == 0) {
          board[i][j + k + 1] = board[i][j + k];
          board[i][j + k] = 0;
          if (j + k < N - 2) k++;
        }
        if (last != j + k + 1 && board[i][j + k + 1] == board[i][j + k]) {
          board[i][j + k + 1] *= 2;
          board[i][j + k] = 0;
          last = j + k + 1;
        }
      }
    }
    return board;
  }

  static int[][] moveDown(int[][] board) {
    for (int j = 0; j < N; j++) {
      int last = -1;
      for (int i = N - 2; i >= 0; i--) {
        if (board[i][j] == 0) continue;
        int k = 0;
        while (i + k < N - 1 && board[i + k + 1][j] == 0) {
          board[i + k + 1][j] = board[i + k][j];
          board[i + k][j] = 0;
          if (i + k < N - 2) k++;
        }
        if (last != i + k + 1 && board[i + k + 1][j] == board[i + k][j]) {
          board[i + k + 1][j] *= 2;
          board[i + k][j] = 0;
          last = i + k + 1;
        }
      }
    }
    return board;
  }

  static int[][] moveUp(int[][] board) {
    for (int j = 0; j < N; j++) {
      int last = -1;
      for (int i = 1; i < N; i++) {
        if (board[i][j] == 0) continue;
        int k = 0;
        while (i - k - 1 >= 0 && board[i - k - 1][j] == 0) {
          board[i - k - 1][j] = board[i - k][j];
          board[i - k][j] = 0;
          if (i - k > 1) k++;
        }
        if (last != i - k - 1 && board[i - k - 1][j] == board[i - k][j]) {
          board[i - k - 1][j] *= 2;
          board[i - k][j] = 0;
          last = i - k - 1;
        }
      }
    }
    return board;
  }
}