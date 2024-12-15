import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  int N, M;
  int[] count;
  ArrayList<ArrayList<Integer>> graph;

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    count = new int[N + 1];
    graph = new ArrayList<>();
    for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int start = Integer.parseInt(st.nextToken());
      int end = Integer.parseInt(st.nextToken());
      graph.get(start).add(end);
      count[end]++;
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();

    System.out.println(sb);

    br.close();
  }

  void solution() {
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    for (int i = 1; i <= N; i++) {
      if (count[i] == 0) queue.add(i);
    }
    while (!queue.isEmpty()) {
      int current = queue.pop();
      sb.append(current).append(" ");
      graph.get(current).forEach(next -> {
        if (--count[next] == 0) queue.add(next);
      });
    }
  }
}