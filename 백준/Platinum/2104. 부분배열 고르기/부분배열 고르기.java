import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N;
  long result;
  SegmentTree segmentTree;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    int[] arr = new int[N + 1];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(st.nextToken());
    segmentTree = new SegmentTree(arr);
  }

  void solution() {
    result = binarySearch(1, N);
  }

  long binarySearch(int from, int to) {
    Node min = segmentTree.getMin(from, to);
    long sum = segmentTree.getSum(from, to);
    long result = min.value * sum;

    if (min.index > from) result = Math.max(result, binarySearch(from, min.index - 1));
    if (min.index < to) result = Math.max(result, binarySearch(min.index + 1, to));

    return result;
  }
}

class SegmentTree {
  int height;
  int[] arr;
  Node[] minTree;
  long[] sumTree;

  SegmentTree(int[] arr) {
    this.arr = arr;
    height = (int) Math.ceil(Math.log(arr.length) / Math.log(2));
    minTree = new Node[1 << (height + 1)];
    sumTree = new long[1 << (height + 1)];
    initMinTree(1, arr.length - 1, 1);
    initSumTree(1, arr.length - 1, 1);
  }

  private Node initMinTree(int from, int to, int node) {
    if (from == to) return minTree[node] = new Node(from, arr[from]);

    Node left = initMinTree(from, (from + to) / 2, node * 2);
    Node right = initMinTree((from + to) / 2 + 1, to, node * 2 + 1);

    return minTree[node] = left.value <= right.value ? left : right;
  }

  private long initSumTree(int from, int to, int node) {
    if (from == to) return sumTree[node] = arr[from];
    return sumTree[node] = initSumTree(from, (from + to) / 2, node * 2)
      + initSumTree((from + to) / 2 + 1, to, node * 2 + 1);
  }

  Node getMin(int from, int to) {
    return getMin(from, to, 1, 1, arr.length - 1);
  }

  private Node getMin(int from, int to, int node, int start, int end) {
    if (from > end || to < start) return new Node(-1, Integer.MAX_VALUE);
    if (from <= start && end <= to) return minTree[node];

    Node left = getMin(from, to, node * 2, start, (start + end) / 2);
    Node right = getMin(from, to, node * 2 + 1, (start + end) / 2 + 1, end);

    return left.value <= right.value ? left : right;
  }

  long getSum(int from, int to) {
    return getSum(from, to, 1, 1, arr.length - 1);
  }

  private long getSum(int from, int to, int node, int start, int end) {
    if (from > end || to < start) return 0;
    if (from <= start && end <= to) return sumTree[node];

    return getSum(from, to, node * 2, start, (start + end) / 2)
      + getSum(from, to, node * 2 + 1, (start + end) / 2 + 1, end);
  }
}

class Node {
  int index, value;

  Node(int index, int value) {
    this.index = index;
    this.value = value;
  }
}