import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M;
  int[][] map;
  int count;
  int max;
  int result;
  int[] dx = {0, -1, 0, 1}, dy = {-1, 0, 1, 0};

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(count);
    System.out.println(max);
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[M][N];
    for (int i = 0; i < M; i++) map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    List<Integer> areas = new ArrayList<>();
    areas.add(0);
    int[] neighbor = new int[M * N + 1];

    Queue<Integer> queue = new ArrayDeque<>();
    int[] visited = new int[M * N];

    for (int i = 0; i < M * N; i++) {
      if (visited[i] != 0) continue;
      count++;
      queue.add(i);
      visited[i] = count;
      int size = 0;
      while (!queue.isEmpty()) {
        size++;
        int p = queue.poll(), x = p / N, y = p % N;
        for (int j = 0; j < 4; j++) {
          int nx = x + dx[j], ny = y + dy[j], np = nx * N + ny;
          if (isAble(nx, ny)) {
            if (visited[np] == 0 && ((map[x][y] & (1 << j)) == 0)) {
              queue.add(np);
              visited[np] = count;
            } else if (visited[np] != 0 && visited[np] != count) {
              neighbor[count] |= (1 << visited[np]);
            }
          }
        }
      }
      areas.add(size);
    }

    max = areas.stream().max(Comparator.comparingInt(it -> it)).orElse(0);
    result = areas.get(1);

    for (int i = 1; i <= count; i++) {
      for (int j = 1; j <= count; j++) {
        if ((neighbor[i] & (1 << j)) != 0) result = Math.max(result, areas.get(i) + areas.get(j));
      }
    }
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < M && y >= 0 && y < N;
  }
}
