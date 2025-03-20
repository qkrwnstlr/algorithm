import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringTokenizer st;
  int N, M, result;
  int[] indexes;
  int[][] scores;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    scores = new int[N][M];
    for (int i = 0; i < N; i++) {
      scores[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    }
    indexes = new int[N];
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();

    System.out.println(result);
  }

  void solution() {
    PriorityQueue<Integer> pq = new PriorityQueue<>((c1, c2) -> Long.compare(scores[c1][indexes[c1]], scores[c2][indexes[c2]]));
    int maxIndex = 0;
    for (int i = 0; i < N; i++) {
      pq.add(i);
      if (scores[maxIndex][indexes[maxIndex]] < scores[i][indexes[i]]) maxIndex = i;
    }
    while (!pq.isEmpty()) {
      int minIndex = pq.poll();
      result = Math.min(result, scores[maxIndex][indexes[maxIndex]] - scores[minIndex][indexes[minIndex]]);
      if (++indexes[minIndex] == M) break;
      if (scores[maxIndex][indexes[maxIndex]] < scores[minIndex][indexes[minIndex]]) maxIndex = minIndex;
      pq.add(minIndex);
    }
  }
}
