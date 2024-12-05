import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M, result;
  char[][] matrix;
  int BOARD_SIZE = 8;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    matrix = new char[N][M];
    for (int y = 0; y < N; y++) matrix[y] = br.readLine().toCharArray();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");

    System.out.println(sb);

    br.close();
  }

  void solution() {
    for (int y = 0; y <= N - BOARD_SIZE; y++) {
      for (int x = 0; x <= M - BOARD_SIZE; x++) {
        result = Math.min(result, count(y, x));
      }
    }
  }

  int count(int startY, int startX) {
    return Math.min(count(startY, startX, 'B', 'W'), count(startY, startX, 'W', 'B'));
  }

  int count(int startY, int startX, char first, char next) {
    int result = 0;
    for (int y = 0; y < BOARD_SIZE; y++) {
      for (int x = 0; x < BOARD_SIZE; x++) {
        if ((y + x) % 2 == 0 && matrix[startY + y][startX + x] != first) result++;
        if ((y + x) % 2 == 1 && matrix[startY + y][startX + x] != next) result++;
      }
    }
    return result;
  }
}