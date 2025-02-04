import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int K, N, M, result;
  boolean[][] map;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    result = -1;
    K = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    map = new boolean[N][M];
    for (int x = 0; x < N; x++) {
      st = new StringTokenizer(br.readLine());
      for (int y = 0; y < M; y++) {
        map[x][y] = st.nextToken().equals("0");
      }
    }
  }

  void printResult() {
    System.out.println(result);
  }

  int[] dx = {-1, 0, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2}, dy = {0, 1, 0, -1, 1, 2, 2, 1, -1, -2, -2, -1};

  void solution() {
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][][] visited = new boolean[N][M][K + 1];
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < M; y++) {
        if (map[x][y]) continue;
        Arrays.fill(visited[x][y], true);
      }
    }

    queue.add(new Node(0, 0, K, 0));
    Arrays.fill(visited[0][0], true);

    while (!queue.isEmpty()) {
      Node current = queue.poll();

      if (current.x == N - 1 && current.y == M - 1) {
        result = current.count;
        break;
      }

      for (int i = 0; i < 4; i++) {
        int nx = current.x + dx[i], ny = current.y + dy[i];
        if (isAble(nx, ny) && !visited[nx][ny][current.k]) {
          queue.add(new Node(nx, ny, current.k, current.count + 1));
          visited[nx][ny][current.k] = true;
        }
      }

      if (current.k == 0) continue;

      for (int i = 4; i < dx.length; i++) {
        int nx = current.x + dx[i], ny = current.y + dy[i];
        if (isAble(nx, ny) && !visited[nx][ny][current.k - 1]) {
          queue.add(new Node(nx, ny, current.k - 1, current.count + 1));
          visited[nx][ny][current.k - 1] = true;
        }
      }
    }
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M;
  }
}

class Node {
  int x, y, k, count;

  Node(int x, int y, int k, int count) {
    this.x = x;
    this.y = y;
    this.k = k;
    this.count = count;
  }
}
