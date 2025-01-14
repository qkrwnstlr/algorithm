import java.util.LinkedList;
import java.util.Queue;

class Solution {
  public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    init(rectangle, characterX, characterY, itemX, itemY);
    return bfs();
  }

  int characterX, characterY, itemX, itemY;
  int[][] map;

  void init(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    this.characterX = characterX * 2;
    this.characterY = characterY * 2;
    this.itemX = itemX * 2;
    this.itemY = itemY * 2;

    map = new int[101][101];

    for (int i = 0; i < rectangle.length; i++) {
      int[] rect = rectangle[i];
      for (int x = rect[0] * 2; x <= rect[2] * 2; x++) {
        for (int y = rect[1] * 2; y <= rect[3] * 2; y++) {
          if (map[x][y] == 2) continue;
          if (x == rect[0] * 2 || x == rect[2] * 2 || y == rect[1] * 2 || y == rect[3] * 2) map[x][y] = 1;
          else map[x][y] = 2;
        }
      }
    }
  }

  int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};

  int bfs() {
    Queue<Node> queue = new LinkedList<>();
    boolean[][] visited = new boolean[101][101];

    queue.add(new Node(characterX, characterY, 0));
    visited[characterX][characterY] = true;

    while (!queue.isEmpty()) {
      Node current = queue.poll();
      if (current.x == itemX && current.y == itemY) return current.count / 2;

      for (int i = 0; i < 4; i++) {
        int nx = current.x + dx[i], ny = current.y + dy[i];
        if (isAble(nx, ny) && map[nx][ny] == 1 && !visited[nx][ny]) {
          visited[nx][ny] = true;
          queue.add(new Node(nx, ny, current.count + 1));
        }
      }
    }

    return -1;
  }

  boolean isAble(int x, int y) {
    return x > 0 && x <= 100 && y > 0 && y <= 100;
  }
}

class Node {
  int x, y, count;

  Node(int x, int y, int count) {
    this.x = x;
    this.y = y;
    this.count = count;
  }
}