import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, M;
  int[] arr;
  StringBuilder result;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    result = new StringBuilder();

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    ArrayDeque<Node> deque = new ArrayDeque<>();
    for (int i = 0; i < 2 * M - 2; i++) {
      while (!deque.isEmpty() && deque.getLast().weight <= arr[i]) deque.removeLast();
      deque.add(new Node(i, arr[i]));
    }

    for (int i = 2 * M - 2; i < N; i++) {
      while (!deque.isEmpty() && deque.getFirst().index < i - 2 * M + 2) deque.removeFirst();
      while (!deque.isEmpty() && deque.getLast().weight <= arr[i]) deque.removeLast();
      deque.add(new Node(i, arr[i]));
      result.append(deque.getFirst().weight).append(" ");
    }
  }
}

class Node {
  int index, weight;

  Node(int index, int weight) {
    this.index = index;
    this.weight = weight;
  }
}
