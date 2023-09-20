import java.io.*;
import java.util.*;

public class Main {
  static boolean[][] field;
  static short M, N, K;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      M = Short.parseShort(st.nextToken());
      N = Short.parseShort(st.nextToken());
      K = Short.parseShort(st.nextToken());

      int max = Math.max(M, N);

      field = new boolean[M][N];
      int count = 0;

      for (int i = 0; i < K; i++) {
        st = new StringTokenizer(br.readLine());
        int X = Short.parseShort(st.nextToken());
        int Y = Short.parseShort(st.nextToken());
        field[X][Y] = true;
      }

      Queue<Short> queue;
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          if (!field[i][j]) continue;
          count++;
          queue = new LinkedList<>();
          queue.add((short) (i * max + j));
          field[i][j] = false;
          while (!queue.isEmpty()) {
            int p = queue.poll();
            int m = p / max;
            int n = p % max;
            if (m > 0 && field[m - 1][n]) {
              queue.add((short) ((m - 1) * max + n));
              field[m - 1][n] = false;
            }
            if (m < M - 1 && field[m + 1][n]){
              queue.add((short) ((m + 1) * max + n));
              field[m + 1][n] = false;
            }
            if (n > 0 && field[m][n - 1]) {
              queue.add((short) (m * max + n - 1));
              field[m][n - 1] = false;
            }
            if (n < N - 1 && field[m][n + 1]) {
              queue.add((short) (m * max + n + 1));
              field[m][n + 1] = false;
            }
          }
        }
      }

      System.out.println(count);
    }
  }
}