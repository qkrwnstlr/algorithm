import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  BufferedReader br;
  StringTokenizer st;
  int N, result;
  int[][] table;

  void init() throws IOException {
    result = 0;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    table = new int[N][];
    for (int x = 0; x < N; x++) {
      table[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
  }

  public static void main(String[] args) throws Exception {
    new Main().run();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    move(0, 0, 1);
  }

  void move(int type, int x, int y) {
    if (x == N - 1 && y == N - 1) {
      result++;
      return;
    }

    for (int i = -1; i <= 1; i++) {
      switch (type + i) {
        case 0: {
          if (!isExist(x, y + 1) || table[x][y + 1] == 1) break;
          move(0, x, y + 1);
          break;
        }
        case 1: {
          if (!isExist(x + 1, y + 1) || table[x][y + 1] == 1 || table[x + 1][y + 1] == 1 || table[x + 1][y] == 1) break;
          move(1, x + 1, y + 1);
          break;
        }
        case 2: {
          if (!isExist(x + 1, y) || table[x + 1][y] == 1) break;
          move(2, x + 1, y);
          break;
        }
      }
    }
  }

  boolean isExist(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }
}