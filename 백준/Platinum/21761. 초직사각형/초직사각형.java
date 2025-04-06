import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K;
  long[] sides;
  List<PriorityQueue<Integer>> cards;
  StringBuilder result;

  void init() throws IOException {
    result = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    sides = new long[4];
    for (int i = 0; i < 4; i++) sides[i] = Integer.parseInt(st.nextToken());

    cards = new ArrayList<>();
    for (int i = 0; i < 4; i++) cards.add(new PriorityQueue<>(Comparator.reverseOrder()));
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cards.get(st.nextToken().charAt(0) - 'A').add(Integer.parseInt(st.nextToken()));
    }
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    for (int i = 0; i < K; i++) {
      int maxI = 0;
      for (; maxI < 4 && cards.get(maxI).isEmpty(); maxI++) ;
      for (int j = maxI + 1; j < 4; j++) {
        if (cards.get(j).isEmpty()) continue;
        if (cards.get(maxI).peek() * sides[j] < cards.get(j).peek() * sides[maxI]) maxI = j;
      }
      int delta = cards.get(maxI).poll();
      sides[maxI] += delta;
      result.append((char) ('A' + maxI)).append(" ").append(delta).append("\n");
    }
  }
}
