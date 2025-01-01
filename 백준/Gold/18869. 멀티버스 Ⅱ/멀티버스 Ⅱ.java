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
  int N, M, result;
  int[][] spaces;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());
    spaces = new int[M][N];
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());

      int[] space = new int[N];
      Set<Integer> set = new HashSet<>();

      for (int j = 0; j < N; j++) {
        space[j] = Integer.parseInt(st.nextToken());
        set.add(space[j]);
      }

      List<Integer> sorted = set.stream().sorted().collect(Collectors.toList());;

      for (int j = 0; j < N; j++) spaces[i][j] = Collections.binarySearch(sorted, space[j]);
    }
  }

  void solution() {
    for (int i = 0; i < M; i++) {
      for (int j = i + 1; j < M; j++) {
        if (Arrays.equals(spaces[i], spaces[j])) result++;
      }
    }
  }
}
