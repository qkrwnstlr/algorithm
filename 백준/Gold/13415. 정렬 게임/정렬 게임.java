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
  Integer[] arr, result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
    result = new Integer[N];
    K = Integer.parseInt(br.readLine());
  }

  void printResult() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) sb.append(result[i]).append(" ");
    System.out.println(sb);
  }

  void solution() throws IOException {
    Deque<Node> deque = new ArrayDeque<>();
    for (int i = 0; i < K; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int A = Integer.parseInt(st.nextToken()), B = Integer.parseInt(st.nextToken());

      while (!deque.isEmpty() && deque.getLast().index <= A) deque.removeLast();
      if (deque.isEmpty() || !deque.getLast().isAsc) deque.addLast(new Node(A, true));

      while (!deque.isEmpty() && deque.getLast().index <= B) deque.removeLast();
      if (deque.isEmpty() || deque.getLast().isAsc) deque.addLast(new Node(B, false));
    }

    deque.add(new Node(0, true));

    Node before = deque.removeFirst();
    int ascIndex = before.index - 1, descIndex = 0;

    Arrays.sort(arr, 0, before.index);
    System.arraycopy(arr, before.index, result, before.index, N - before.index);

    while (!deque.isEmpty()) {
      Node current = deque.removeFirst();
      if (before.isAsc) {
        for (int i = before.index - 1; i >= current.index; i--) result[i] = arr[ascIndex--];
      } else {
        for (int i = before.index - 1; i >= current.index; i--) result[i] = arr[descIndex++];
      }
      before = current;
    }
  }
}

class Node {
  int index;
  boolean isAsc;

  Node(int index, boolean isAsc) {
    this.index = index;
    this.isAsc = isAsc;
  }
}