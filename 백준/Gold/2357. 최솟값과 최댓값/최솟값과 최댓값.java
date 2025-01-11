import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, M;
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
    M = Integer.parseInt(st.nextToken());
    arr = new int[N + 1];
    for (int i = 1; i <= N; i++) arr[i] = Integer.parseInt(br.readLine());
  }

  void solution() throws IOException {
    SegmentTree segmentTree = new SegmentTree(arr);
    for (int i = 0; i < M; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      result.append(segmentTree.getMin(a, b)).append(" ").append(segmentTree.getMax(a, b)).append("\n");
    }
  }
}

class SegmentTree {
  int[] arr, minTree, maxTree;

  SegmentTree(int[] arr) {
    this.arr = arr;
    int height = (int) Math.ceil(Math.log10(arr.length) / Math.log10(2));
    minTree = new int[(int) Math.pow(2, height + 1)];
    initMin(arr, 1, 1, arr.length - 1);
    maxTree = new int[(int) Math.pow(2, height + 1)];
    initMax(arr, 1, 1, arr.length - 1);
  }

  private int initMin(int[] arr, int node, int start, int end) {
    if (start == end) return minTree[node] = arr[start];

    return minTree[node] = Math.min(
      initMin(arr, node * 2, start, (start + end) / 2),
      initMin(arr, node * 2 + 1, (start + end) / 2 + 1, end)
    );
  }

  private int initMax(int[] arr, int node, int start, int end) {
    if (start == end) return maxTree[node] = arr[start];

    return maxTree[node] = Math.max(
      initMax(arr, node * 2, start, (start + end) / 2),
      initMax(arr, node * 2 + 1, (start + end) / 2 + 1, end)
    );
  }

  int getMin(int start, int end) {
    return getMin(1, 1, arr.length - 1, start, end);
  }

  int getMax(int start, int end) {
    return getMax(1, 1, arr.length - 1, start, end);
  }

  private int getMin(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return Integer.MAX_VALUE;
    if (left <= start && end <= right) return minTree[node];

    return Math.min(
      getMin(node * 2, start, (start + end) / 2, left, right),
      getMin(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    );
  }

  private int getMax(int node, int start, int end, int left, int right) {
    if (left > end || right < start) return Integer.MIN_VALUE;
    if (left <= start && end <= right) return maxTree[node];

    return Math.max(
      getMax(node * 2, start, (start + end) / 2, left, right),
      getMax(node * 2 + 1, (start + end) / 2 + 1, end, left, right)
    );
  }
}