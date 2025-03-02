import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  int N, C, M, result;
  int[] truck;
  PriorityQueue<Node> schedule;

  void run() throws IOException {
    init();
    solution();
    printResult();
  }

  void init() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(br.readLine());

    truck = new int[N + 1];
    Arrays.fill(truck, C);

    schedule = new PriorityQueue<>();
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      schedule.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
    }

    br.close();
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() {
    while (!schedule.isEmpty()) {
      Node current = schedule.poll();

      int min = current.count;
      for (int i = current.from; i < current.to; i++) min = Math.min(min, truck[i]);
      for (int i = current.from; i < current.to; i++) truck[i] -= min;
      result += min;
    }
  }
}

class Node implements Comparable<Node> {
  int from, to, count;

  Node(int from, int to, int count) {
    this.from = from;
    this.to = to;
    this.count = count;
  }

  @Override
  public int compareTo(Node o) {
    return to == o.to ? from - o.from : to - o.to;
  }
}