import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M, result;
  int[][] office;
  ArrayList<Integer> cctv;
  int[] dy = {-1, 0, 1, 0};
  int[] dx = {0, 1, 0, -1};
  long bit;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    bit = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    office = new int[N][M];
    cctv = new ArrayList<>();
    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < M; x++) {
        office[y][x] = Integer.parseInt(st.nextToken());
        if (office[y][x] > 0) bit = turnOnBit(bit, y * M + x);
        if (office[y][x] > 0 && office[y][x] < 6) cctv.add(y * M + x);
      }
    }
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
    dfs(0, bit);
  }

  void dfs(int depth, long bit) {
    if (depth == cctv.size()) {
      result = Math.min(result, N * M - Long.bitCount(bit));
      return;
    }

    int cctvY = cctv.get(depth) / M;
    int cctvX = cctv.get(depth) % M;
    switch (office[cctvY][cctvX]) {
      case 1:
        for (int i = 0; i < dx.length; i++) {
          dfs(depth + 1, cover(cctvY, cctvX, dy[i], dx[i], bit));
        }
        break;
      case 2:
        for (int i = 0; i < dx.length / 2; i++) {
          long temp = bit;
          for (int j = 0; j < 2; j++) {
            temp = cover(cctvY, cctvX, dy[(i + j * 2) % dx.length], dx[(i + j * 2) % dx.length], temp);
          }
          dfs(depth + 1, temp);
        }
        break;
      case 3:
        for (int i = 0; i < dx.length; i++) {
          long temp = bit;
          for (int j = 0; j < 2; j++) {
            temp = cover(cctvY, cctvX, dy[(i + j) % dx.length], dx[(i + j) % dx.length], temp);
          }
          dfs(depth + 1, temp);
        }
        break;
      case 4:
        for (int i = 0; i < dx.length; i++) {
          long temp = bit;
          for (int j = 0; j < 3; j++) {
            temp = cover(cctvY, cctvX, dy[(i + j) % dx.length], dx[(i + j) % dx.length], temp);
          }
          dfs(depth + 1, temp);
        }
        break;
      case 5:
        long temp = bit;
        for (int i = 0; i < dx.length; i++) {
          temp = cover(cctvY, cctvX, dy[i], dx[i], temp);
        }
        dfs(depth + 1, temp);
        break;
    }
  }

  long cover(int cctvY, int cctvX, int dy, int dx, long bit) {
    long result = bit;
    int ny = cctvY + dy;
    int nx = cctvX + dx;
    while (isExist(ny, nx) && office[ny][nx] != 6) {
      result = turnOnBit(result, ny * M + nx);
      ny += dy;
      nx += dx;
    }
    return result;
  }

  boolean isExist(int y, int x) {
    return y >= 0 && y < N && x >= 0 && x < M;
  }

  long turnOnBit(long bit, int position) {
    return bit | (1L << position);
  }
}