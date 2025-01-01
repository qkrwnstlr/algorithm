import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, result;
  int[][] table;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    N = Integer.parseInt(br.readLine());
    table = new int[N][N];
    for (int i = 0; i < N; i++) table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    combination(0, 0);
  }

  void combination(int bit, int depth) {
    if (depth == N) {
      List<Integer> star = new ArrayList<>(), link = new ArrayList<>();
      for (int i = 0; i < N; i++) {
        if (bit % 2 == 1) star.add(i);
        else link.add(i);
        bit /= 2;
      }
      result = Math.min(result, Math.abs(getSum(star) - getSum(link)));
      return;
    }
    combination(bit | (1 << depth), depth + 1);
    combination(bit, depth + 1);
  }

  int getSum(List<Integer> list) {
    int sum = 0;
    for (int i = 0; i < list.size(); i++) {
      for (int j = i + 1; j < list.size(); j++) {
        sum += table[list.get(i)][list.get(j)] + table[list.get(j)][list.get(i)];
      }
    }
    return sum;
  }
}
