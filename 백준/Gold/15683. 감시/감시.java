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
  int N, M, result, wall;
  int[][] office;
  ArrayList<Integer> cctv;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    wall = 0;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    office = new int[N][M];
    cctv = new ArrayList<>();
    for (int y = 0; y < N; y++) {
      st = new StringTokenizer(br.readLine());
      for (int x = 0; x < M; x++) {
        office[y][x] = Integer.parseInt(st.nextToken());
        if (office[y][x] > 0 && office[y][x] < 6) cctv.add(y * M + x);
        if (office[y][x] == 6) wall++;
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
    dfs(0, 0);
  }

  void dfs(int depth, long bit) {
    if (depth == cctv.size()) {
      result = Math.min(result, N * M - Long.bitCount(bit) - wall);
      return;
    }

    int cctvY = cctv.get(depth) / M;
    int cctvX = cctv.get(depth) % M;
    for (int d = 1; d <= 4; d++) dfs(depth + 1, runCCTV(cctvY, cctvX, d, bit));
  }

  long runCCTV(int cctvY, int cctvX, int direction, long bit) {
    long result = bit;
    switch (office[cctvY][cctvX]) {
      case 1: {
        switch (direction) {
          case 1:
            result = setUp(cctvY, cctvX, result);
            break;
          case 2:
            result = setRight(cctvY, cctvX, result);
            break;
          case 3:
            result = setDown(cctvY, cctvX, result);
            break;
          case 4:
            result = setLeft(cctvY, cctvX, result);
            break;
        }
        break;
      }
      case 2: {
        switch (direction) {
          case 1:
          case 3:
            result = setUp(cctvY, cctvX, result);
            result = setDown(cctvY, cctvX, result);
            break;
          case 2:
          case 4:
            result = setRight(cctvY, cctvX, result);
            result = setLeft(cctvY, cctvX, result);
            break;
        }
        break;
      }
      case 3: {
        switch (direction) {
          case 1:
            result = setUp(cctvY, cctvX, result);
            result = setRight(cctvY, cctvX, result);
            break;
          case 2:
            result = setRight(cctvY, cctvX, result);
            result = setDown(cctvY, cctvX, result);
            break;
          case 3:
            result = setDown(cctvY, cctvX, result);
            result = setLeft(cctvY, cctvX, result);
            break;
          case 4:
            result = setLeft(cctvY, cctvX, result);
            result = setUp(cctvY, cctvX, result);
            break;
        }
        break;
      }
      case 4: {
        switch (direction) {
          case 1:
            result = setUp(cctvY, cctvX, result);
            result = setRight(cctvY, cctvX, result);
            result = setLeft(cctvY, cctvX, result);
            break;
          case 2:
            result = setRight(cctvY, cctvX, result);
            result = setDown(cctvY, cctvX, result);
            result = setUp(cctvY, cctvX, result);
            break;
          case 3:
            result = setDown(cctvY, cctvX, result);
            result = setLeft(cctvY, cctvX, result);
            result = setRight(cctvY, cctvX, result);
            break;
          case 4:
            result = setLeft(cctvY, cctvX, result);
            result = setUp(cctvY, cctvX, result);
            result = setDown(cctvY, cctvX, result);
            break;
        }
        break;
      }
      case 5: {
        result = setUp(cctvY, cctvX, result);
        result = setRight(cctvY, cctvX, result);
        result = setDown(cctvY, cctvX, result);
        result = setLeft(cctvY, cctvX, result);
        break;
      }
    }
    return result;
  }

  long setUp(int cctvY, int cctvX, long bit) {
    long result = bit;
    for (int y = cctvY; y >= 0; y--) {
      if (office[y][cctvX] == 6) break;
      result = turnOnBit(result, y * M + cctvX);
    }
    return result;
  }

  long setRight(int cctvY, int cctvX, long bit) {
    long result = bit;
    for (int x = cctvX; x < M; x++) {
      if (office[cctvY][x] == 6) break;
      result = turnOnBit(result, cctvY * M + x);
    }
    return result;
  }

  long setDown(int cctvY, int cctvX, long bit) {
    long result = bit;
    for (int y = cctvY; y < N; y++) {
      if (office[y][cctvX] == 6) break;
      result = turnOnBit(result, y * M + cctvX);
    }
    return result;
  }

  long setLeft(int cctvY, int cctvX, long bit) {
    long result = bit;
    for (int x = cctvX; x >= 0; x--) {
      if (office[cctvY][x] == 6) break;
      result = turnOnBit(result, cctvY * M + x);
    }
    return result;
  }

  long turnOnBit(long bit, int position) {
    return bit | (1L << position);
  }
}