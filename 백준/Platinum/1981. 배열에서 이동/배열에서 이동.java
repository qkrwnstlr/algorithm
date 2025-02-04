import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;
  int[][] map;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    N = Integer.parseInt(br.readLine());
    map = new int[N][N];
    for (int x = 0; x < N; x++) map[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void printResult() {
    System.out.println(result);
  }

  int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

  void solution() {
    int min = Arrays.stream(map).mapToInt(it -> Arrays.stream(it).min().orElse(0)).min().orElse(0);
    int max = Arrays.stream(map).mapToInt(it -> Arrays.stream(it).max().orElse(0)).max().orElse(0);

    int l = 0, r = max - min;

    while (l < r) {
      int m = (l + r) / 2;

      boolean flag = false;
      for (int i = min; i <= max - m && !flag; i++) flag = bfs(i, i + m);

      if (flag) r = m;
      else l = m + 1;
    }

    result = l;
  }

  boolean bfs(int min, int max) {
    Queue<Node> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];

    if (map[0][0] < min || map[0][0] > max) return false;
    if (map[N - 1][N - 1] < min || map[N - 1][N - 1] > max) return false;

    queue.add(new Node(0, 0));
    visited[0][0] = true;

    while (!queue.isEmpty()) {
      Node node = queue.poll();

      for (int i = 0; i < 4; i++) {
        int nx = node.x + dx[i], ny = node.y + dy[i];

        if (isAble(nx, ny) && !visited[nx][ny] && map[nx][ny] >= min && map[nx][ny] <= max) {
          queue.add(new Node(nx, ny));
          visited[nx][ny] = true;
          if (nx == N - 1 && ny == N - 1) break;
        }
      }
    }

    return visited[N - 1][N - 1];
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }
}

class Node {
  int x, y;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
