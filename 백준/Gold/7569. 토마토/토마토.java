import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int M = Integer.parseInt(st.nextToken());
    int N = Integer.parseInt(st.nextToken());
    int H = Integer.parseInt(st.nextToken());

    int[] dm = {-1, 0, 0, 1, 0, 0};
    int[] dn = {0, -1, 0, 0, 1, 0};
    int[] dh = {0, 0, -1, 0, 0, 1};

    int[][][] box = new int[H][N][M];
    LinkedList<int[]> queue = new LinkedList<>();

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        st = new StringTokenizer(br.readLine());
        for (int m = 0; m < M; m++) {
          box[h][n][m] = Integer.parseInt(st.nextToken());
          if (box[h][n][m] == 1) queue.add(new int[]{h, n, m});
        }
      }
    }

    while (!queue.isEmpty()) {
      int[] temp = queue.poll();
      int distance = box[temp[0]][temp[1]][temp[2]];
      for (int i = 0; i < 6; i++) {
        int h = temp[0] + dh[i];
        int n = temp[1] + dn[i];
        int m = temp[2] + dm[i];
        if (h >= 0 && h < H && n >= 0 && n < N && m >= 0 && m < M && box[h][n][m] == 0) {
          box[h][n][m] = distance + 1;
          queue.add(new int[]{h, n, m});
        }
      }
    }

    int max = 0;

    for (int h = 0; h < H; h++) {
      for (int n = 0; n < N; n++) {
        for (int m = 0; m < M; m++) {
          if (box[h][n][m] == 0) {
            System.out.println(-1);
            return;
          }
          max = Math.max(max, box[h][n][m]);
        }
      }
    }

    System.out.println(max - 1);
  }
}