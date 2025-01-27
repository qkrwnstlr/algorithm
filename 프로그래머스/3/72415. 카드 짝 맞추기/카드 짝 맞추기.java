import java.util.*;

class Solution {
  public static void main(String[] args) {
    int[][] board = {{1, 0, 0, 3}, {2, 0, 0, 0}, {0, 0, 0, 2}, {3, 0, 1, 0}};
    int r = 1, c = 0;
    System.out.println(new Solution().solution(board, r, c));
  }

  public int solution(int[][] board, int r, int c) {
    init(board, r, c);
    dfs(current, 0, 0);
    return answer;
  }

  int[][] board;
  Point current;
  Map<Integer, List<Point>> map;
  int answer;

  void init(int[][] board, int r, int c) {
    this.answer = Integer.MAX_VALUE;
    this.board = board;
    this.current = new Point(r, c);
    map = new HashMap<>();
    for (int x = 0; x < 4; x++) {
      for (int y = 0; y < 4; y++) {
        if (board[x][y] == 0) continue;
        List<Point> list = map.getOrDefault(board[x][y], new ArrayList<>());
        list.add(new Point(x, y));
        map.put(board[x][y], list);
      }
    }
  }

  int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};

  int getDistance(Point p1, Point p2, int bitmask) {
    Queue<Point> queue = new ArrayDeque<>();
    int[][] visited = new int[4][4];
    queue.add(p1);
    visited[p1.x][p1.y] = 1;
    while (!queue.isEmpty()) {
      Point current = queue.poll();
      if (p2.x == current.x && p2.y == current.y) return visited[p2.x][p2.y] - 1;
      for (int i = 0; i < 4; i++) {
        int nx = current.x + dx[i], ny = current.y + dy[i];
        if (!isAble(nx, ny)) continue;

        if (visited[nx][ny] == 0) {
          queue.add(new Point(nx, ny));
          visited[nx][ny] = visited[current.x][current.y] + 1;
        }

        while (board[nx][ny] == 0 || (bitmask & (1 << board[nx][ny])) != 0) {
          nx += dx[i];
          ny += dy[i];
          if (!isAble(nx, ny)) {
            nx -= dx[i];
            ny -= dy[i];
            break;
          }
        }

        if (visited[nx][ny] == 0) {
          queue.add(new Point(nx, ny));
          visited[nx][ny] = visited[current.x][current.y] + 1;
        }
      }
    }
    return visited[p2.x][p2.y] - 1;
  }

  boolean isAble(int x, int y) {
    return x >= 0 && x < 4 && y >= 0 && y < 4;
  }

  void dfs(Point current, int count, int bitmask) {
    if (Integer.bitCount(bitmask) == map.size()) {
      answer = Math.min(answer, count);
      return;
    }

    map.forEach((key, value) -> {
      if ((bitmask & (1 << key)) != 0) return;
      dfs(value.get(0), count + getDistance(current, value.get(1), bitmask) + getDistance(value.get(1), value.get(0), bitmask) + 2, bitmask | (1 << key));
      dfs(value.get(1), count + getDistance(current, value.get(0), bitmask) + getDistance(value.get(0), value.get(1), bitmask) + 2, bitmask | (1 << key));
    });
  }
}

class Point {
  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
