import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M, result;
  Position start;
  char[][] map;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");
    System.out.println(sb);

    br.close();
  }

  void init() throws IOException {
    result = -1;
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new char[N][M];
    for (int x = 0; x < N; x++) {
      String input = br.readLine();
      for (int y = 0; y < M; y++) {
        map[x][y] = input.charAt(y);
        if (map[x][y] == '0') {
          start = new Position(x, y, 0, 0);
          map[x][y] = '.';
        }
      }
    }
  }

  int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

  void solution() {
    boolean[][][] visited = new boolean[64][N][M];
    Queue<Position> queue = new LinkedList<>();

    visited[0][start.x][start.y] = true;
    queue.add(start);

    loop:
    while (!queue.isEmpty()) {
      Position current = queue.poll();
      for (int i = 0; i < 4; i++) {
        int nx = current.x + dx[i], ny = current.y + dy[i];
        if (!isAble(nx, ny) || map[nx][ny] == '#' || visited[current.key][nx][ny]) continue;
        if (map[nx][ny] == '1') {
          result = current.count + 1;
          break loop;
        }
        if (map[nx][ny] == '.') {
          visited[current.key][nx][ny] = true;
          queue.add(new Position(nx, ny, current.count + 1, current.key));
        } else if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {
          int newKey = current.key | (1 << (map[nx][ny] - 'a'));
          visited[current.key][nx][ny] = true;
          visited[newKey][nx][ny] = true;
          queue.add(new Position(nx, ny, current.count + 1, newKey));
        } else {
          if ((current.key & (1 << map[nx][ny] - 'A')) != 0) {
            visited[current.key][nx][ny] = true;
            queue.add(new Position(nx, ny, current.count + 1, current.key));
          }
        }
      }
    }
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < N && y >= 0 && y < M;
  }
}

class Position {
  int x, y, count, key;

  Position(int x, int y, int count, int key) {
    this.x = x;
    this.y = y;
    this.count = count;
    this.key = key;
  }
}