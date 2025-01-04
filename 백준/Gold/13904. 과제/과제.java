import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result, maxDate;
  Map<Integer, List<Integer>> map;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = 0;
    N = Integer.parseInt(br.readLine());
    map = new HashMap<>();
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int leftDate = Integer.parseInt(st.nextToken());
      int score = Integer.parseInt(st.nextToken());
      List<Integer> list = map.getOrDefault(leftDate, new ArrayList<>());
      list.add(score);
      map.put(leftDate, list);
      maxDate = Math.max(maxDate, leftDate);
    }
  }

  void solution() {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    for (int i = maxDate; i > 0; i--) {
      pq.addAll(map.getOrDefault(i, new ArrayList<>()));
      if (!pq.isEmpty()) result += pq.poll();
      int d = 0;
    }
  }
}
