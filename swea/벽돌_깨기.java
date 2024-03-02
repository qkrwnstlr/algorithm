import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
  public static void main(String[] args) throws IOException {
    new Solution().run();
  }

  BufferedReader br;
  StringBuilder sb;
  StringTokenizer st;
  int N, W, H, result;
  int[][] table;
  int[] top;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    W = Integer.parseInt(st.nextToken());
    H = Integer.parseInt(st.nextToken());
    table = new int[H][W];
    top = new int[W];
    Arrays.fill(top, H);
    for (int i = 0; i < H; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < W; j++) {
        table[i][j] = Integer.parseInt(st.nextToken());
        if (top[j] == H && table[i][j] != 0) top[j] = i;
      }
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int testCase = 1; testCase <= T; testCase++) {
      init();
      solution();
      sb.append("#").append(testCase).append(" ").append(result).append("\n");
    }

    System.out.println(sb);

    br.close();
  }

  void solution() {
    play(0);
  }

  void play(int depth) {
    if (depth == N) {
      int count = 0;
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          if (table[i][j] != 0) count++;
        }
      }
      result = Math.min(result, count);
      return;
    }
    int[] tTop = Arrays.copyOf(top, W);
    int[][] tTable = deepCopyOf(table);
    int check = 0;
    for (int i = 0; i < W; i++) {
      int x = top[i];
      if (x != H) {
        boom(x, i);
        play(depth + 1);
      } else {
        check++;
      }
      top = Arrays.copyOf(tTop, W);
      table = deepCopyOf(tTable);
    }
    if (check == W) play(N);
  }

  int[][] deepCopyOf(int[][] table) {
    int[][] result = new int[H][W];
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        result[i][j] = table[i][j];
      }
    }
    return result;
  }

  int[] dx = {0, 1, 0, -1};
  int[] dy = {-1, 0, 1, 0};

  void boom(int x, int y) {
    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[]{x, y});
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      for (int i = 0; i < dx.length; i++) {
        for (int j = 1; j < table[current[0]][current[1]]; j++) {
          int nx = current[0] + dx[i] * j;
          int ny = current[1] + dy[i] * j;
          if (isExist(nx, ny) && table[nx][ny] != 0) queue.add(new int[]{nx, ny});
        }
      }
      table[current[0]][current[1]] = 0;
    }
    for (int i = 0; i < W; i++) {
      List<Integer> temp = new ArrayList<>();
      for (int j = 0; j < H; j++) {
        if (table[j][i] != 0) temp.add(table[j][i]);
        table[j][i] = 0;
      }
      for (int j = temp.size() - 1; j >= 0; j--) {
        table[H - 1 - j][i] = temp.get(temp.size() - 1 - j);
      }
      top[i] = H - temp.size();
    }
  }

  boolean isExist(int x, int y) {
    return x >= 0 && x < H && y >= 0 && y < W;
  }
}
