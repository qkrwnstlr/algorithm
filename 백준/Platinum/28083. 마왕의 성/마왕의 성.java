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
  int[] height, parent;
  long[] tax, result;
  int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
  Map<Integer, List<Integer>> map;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();
    solution();
    for (int x = 0; x < N; x++) {
      for (int y = 0; y < M; y++) sb.append(result[x * M + y]).append(" ");
      sb.append("\n");
    }
    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    height = new int[N * M];
    tax = new long[N * M];
    result = new long[N * M];
    parent = new int[N * M];
    map = new TreeMap<>();

    for (int x = 0; x < N; x++) {
      st = new StringTokenizer(br.readLine());
      for (int y = 0; y < M; y++) {
        int h = Integer.parseInt(st.nextToken());
        List<Integer> list = map.getOrDefault(h, new ArrayList<>());
        list.add(x * M + y);
        map.put(h, list);
        height[x * M + y] = h;
      }
    }

    for (int x = 0; x < N; x++) {
      st = new StringTokenizer(br.readLine());
      for (int y = 0; y < M; y++) {
        tax[x * M + y] = Integer.parseInt(st.nextToken());
        result[x * M + y] = tax[x * M + y];
        parent[x * M + y] = x * M + y;
      }
    }
  }

  void solution() {
    map.forEach((key, value) -> {
      for (int i = 0; i < value.size(); i++) {
        int p = value.get(i), x = p / M, y = p % M;
        for (int j = 0; j < 4; j++) {
          int nx = x + dx[j], ny = y + dy[j], np = nx * M + ny;
          if (isAble(nx, ny) && height[p] >= height[np]) union(p, np);
        }
      }

      for (int i = 0; i < value.size(); i++) {
        int p = value.get(i);
        result[p] = result[find(p)];
      }
    });
  }

  void union(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return;
    parent[b] = parent[a];
    result[a] += result[b];
  }

  int find(int a) {
    if (parent[a] == a) return a;
    return parent[a] = find(parent[a]);
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M;
  }
}
