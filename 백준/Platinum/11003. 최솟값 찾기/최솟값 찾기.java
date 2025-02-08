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

  BufferedReader br;
  int N, L;
  int[] arr;
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
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    L = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
  }

  void solution() {
    ArrayDeque<Node> deque = new ArrayDeque<>();

    for (int i = 0; i < N; i++) {
      while (!deque.isEmpty() && deque.getLast().value > arr[i]) deque.removeLast();
      deque.add(new Node(i, arr[i]));
      if (deque.getFirst().index < i - L + 1) deque.removeFirst();
      result.append(deque.getFirst().value).append(" ");
    }
  }


  static class Node {
    int index, value;

    Node(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }
}