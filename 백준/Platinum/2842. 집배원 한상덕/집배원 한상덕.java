import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, P, K, result;
  char[][] map;
  int[][] height;

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

    map = new char[N][N];
    for (int x = 0; x < N; x++) {
      String input = br.readLine();
      for (int y = 0; y < N; y++) {
        map[x][y] = input.charAt(y);
        if (map[x][y] == 'P') P = x * N + y;
        if (map[x][y] == 'K') K++;
      }
    }

    height = new int[N][N];
    for (int x = 0; x < N; x++) {
      height[x] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
  }

  void printResult() {
    System.out.println(result);
  }

  int[] dx = {0, 1, 0, -1, -1, 1, 1, -1}, dy = {1, 0, -1, 0, 1, 1, -1, -1};

  void solution() {
    Set<Integer> set = new HashSet<>();
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < N; y++) {
        set.add(height[x][y]);
      }
    }
    List<Integer> heights = set.stream().sorted().collect(Collectors.toList());

    int l = 0, r = 0;
    while (r < set.size()) {
      while (l <= r) {
        if (!bfs(heights.get(l), heights.get(r))) break;
        result = Math.min(result, heights.get(r) - heights.get(l));
        l++;
      }
      r++;
    }
  }

  boolean bfs(int min, int max) {
    if (height[P / N][P % N] < min || height[P / N][P % N] > max) return false;

    Queue<Integer> queue = new ArrayDeque<>();
    boolean[][] visited = new boolean[N][N];
    int count = 0;

    queue.add(P);
    visited[P / N][P % N] = true;

    while (!queue.isEmpty()) {
      int current = queue.poll(), x = current / N, y = current % N;

      if (map[x][y] == 'K') {
        count++;
        if (count == K) return true;
      }

      for (int i = 0; i < 8; i++) {
        int nx = x + dx[i], ny = y + dy[i];
        if (isAble(nx, ny) && !visited[nx][ny] && height[nx][ny] >= min && height[nx][ny] <= max) {
          queue.add(nx * N + ny);
          visited[nx][ny] = true;
        }
      }
    }

    return false;
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < N;
  }
}
