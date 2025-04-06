import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K;
  int[] sides;
  List<List<Integer>> cards;
  StringBuilder result;

  void init() throws IOException {
    result = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    sides = new int[4];
    for (int i = 0; i < 4; i++) sides[i] = Integer.parseInt(st.nextToken());

    cards = new ArrayList<>();
    for (int i = 0; i < 4; i++) cards.add(new ArrayList<>());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cards.get(st.nextToken().charAt(0) - 'A').add(Integer.parseInt(st.nextToken()));
    }
    for (int i = 0; i < 4; i++) cards.get(i).sort(Collections.reverseOrder());
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
    int[] points = new int[4];
    for (int i = 0; i < K; i++) {
      int maxI = 0;
      long maxV = 0;
      for (int j = 0; j < 4; j++) {
        if (points[j] >= cards.get(j).size()) continue;
        long volume = cards.get(j).get(points[j]) * getVolume(i);
        if (volume > maxV) {
          maxV = volume;
          maxI = j;
        }
      }
      sides[maxI] += cards.get(maxI).get(points[maxI]);
      result.append((char) ('A' + maxI)).append(" ").append(cards.get(maxI).get(points[maxI])).append("\n");
      points[maxI]++;
    }
  }

  long getVolume(int excludeI) {
    long result = 1;
    for (int i = 0; i < 4; i++) {
      if (i == excludeI) continue;
      result *= sides[i];
    }
    return result;
  }
}
