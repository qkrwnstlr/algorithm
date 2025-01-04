import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  List<Runner> runners;
  FenwikTree tree;
  StringBuilder result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    result = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    runners = new ArrayList<>();
    for (int i = 0; i < N; i++) runners.add(new Runner(i, Integer.parseInt(br.readLine())));
    tree = new FenwikTree(N + 1);
  }

  void solution() {
    runners.sort(Comparator.comparingInt(a -> a.ability));
    for (int i = 0; i < N; i++) runners.get(i).ability = i;
    runners.sort(Comparator.comparingInt(a -> a.index));

    for (int i = 0; i < N; i++) {
      int ability = runners.get(i).ability;
      result.append(i - tree.getSum(ability) + 1).append("\n");
      tree.update(runners.get(i).ability, 1);
    }
  }
}

class FenwikTree {
  int[] tree;

  FenwikTree(int N) {
    tree = new int[N + 1];
  }

  void update(int index, int delta) {
    index++;
    while (index < tree.length) {
      tree[index] += delta;
      index += index & -index;
    }
  }

  int getSum(int index) {
    index++;
    int result = 0;
    while (index > 0) {
      result += tree[index];
      index &= index - 1;
    }
    return result;
  }
}

class Runner {
  int index, ability;

  Runner(int index, int ability) {
    this.index = index;
    this.ability = ability;
  }
}