import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, K, MAX = 65536;
  long result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() throws IOException {
    SegmentTree segmentTree = new SegmentTree(MAX + 1);
    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      int input = Integer.parseInt(br.readLine()) + 1;
      queue.add(input);
      segmentTree.update(input, 1);
      if (queue.size() < K) continue;
      if (queue.size() > K) segmentTree.update(queue.poll(), -1);
      result += segmentTree.get((K + 1) / 2) - 1;
    }
  }
}

class SegmentTree {
  int size;
  int[] tree;

  SegmentTree(int size) {
    this.size = size;
    int height = (int) Math.ceil(Math.log(size) / Math.log(2));
    tree = new int[(int) (Math.pow(2, height + 1))];
  }

  int get(int target) {
    return get(1, size, 1, target);
  }

  int get(int start, int end, int index, int target) {
    if (start == end) return start;

    int mid = (start + end) / 2;
    if (target <= tree[index * 2]) return get(start, mid, index * 2, target);
    else return get(mid + 1, end, index * 2 + 1, target - tree[index * 2]);
  }


  void update(int target, int diff) {
    update(1, size, 1, target, diff);
  }

  void update(int start, int end, int index, int target, int diff) {
    if (target < start || target > end) return;
    tree[index] += diff;
    if (start == end) return;
    int mid = (start + end) / 2;
    update(start, mid, index * 2, target, diff);
    update(mid + 1, end, index * 2 + 1, target, diff);
  }
}