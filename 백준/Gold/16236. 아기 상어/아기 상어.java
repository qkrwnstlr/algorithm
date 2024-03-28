import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, result;
  Shark shark;
  int[][] table;

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    result = 0;
    table = new int[N][N];
    for (int r = 0; r < N; r++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int c = 0; c < N; c++) {
        table[r][c] = Integer.parseInt(st.nextToken());
        if (table[r][c] == 9) {
          shark = new Shark(r, c, 2);
          table[r][c] = 0;
        }
      }
    }
  }

  void run() throws IOException {
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    Edge next;
    while ((next = bfs()) != null) {
      result += next.w;
      shark.r = next.r;
      shark.c = next.c;
      table[shark.r][shark.c] = 0;
      shark.hunt();
    }
  }

  Edge bfs() {
    boolean[][] visited = new boolean[N][N];

    Queue<Edge> q = new PriorityQueue<>();
    q.add(new Edge(shark.r, shark.c, 0));
    visited[shark.r][shark.c] = true;
    while (!q.isEmpty()) {
      Edge e = q.poll();
      if (table[e.r][e.c] > 0 && table[e.r][e.c] < shark.size) return e;
      for (int d = 0; d < 4; d++) {
        int nr = e.r + dr[d], nc = e.c + dc[d];
        if (!isExist(nr, nc) || visited[nr][nc]) continue;
        visited[nr][nc] = true;
        if (table[nr][nc] <= shark.size) q.add(new Edge(nr, nc, e.w + 1));
      }
    }

    return null;
  }

  int[] dr = {-1, 0, 0, 1}, dc = {0, -1, 1, 0};

  boolean isExist(int r, int c) {
    return r >= 0 && r < N && c >= 0 && c < N;
  }
}

class Point {
  int r, c;

  Point(int r, int c) {
    this.r = r;
    this.c = c;
  }
}

class Edge extends Point implements Comparable<Edge> {
  int w;

  Edge(int r, int c, int w) {
    super(r, c);
    this.w = w;
  }

  @Override
  public int compareTo(Edge o) {
    if (this.w - o.w != 0) return this.w - o.w;
    if (this.r - o.r != 0) return this.r - o.r;
    return this.c - o.c;
  }
}

class Shark extends Point {
  int size, exp;

  Shark(int r, int c, int size) {
    super(r, c);
    this.size = size;
  }

  void hunt() {
    if (++exp == size) {
      size++;
      exp = 0;
    }
  }
}