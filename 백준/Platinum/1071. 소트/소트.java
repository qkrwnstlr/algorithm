import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  int[] arr;
  TreeMap<Integer, Integer> count;
  StringBuilder result;

  void init() throws IOException {
    result = new StringBuilder();

    N = Integer.parseInt(br.readLine());

    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    count = new TreeMap<>();
    for (int num : arr) count.put(num, count.getOrDefault(num, 0) + 1);
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
    int left = N;

    while (left > 0) {
      for (int i : count.keySet()) {
        if (count.get(i) == 0) continue;

        if (count.getOrDefault(i + 1, 0) > 0) {
          boolean done = false;
          for (int j : count.tailMap(i + 2).keySet()) {
            if (count.get(j) > 0) {
              left -= add(i, count.get(i));
              left -= add(j, 1);
              done = true;
              break;
            }
          }

          if (!done) {
            left -= add(i + 1, 1);
          }
        } else {
          left -= add(i, count.get(i));
        }
      }
    }
  }

  int add(int i, int n) {
    for (int j = 0; j < n; j++) result.append(i).append(" ");
    count.put(i, count.get(i) - n);
    return n;
  }
}
