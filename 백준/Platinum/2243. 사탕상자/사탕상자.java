import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  int N, SIZE = 1_000_001;
  SegmentTree segmentTree;
  StringBuilder result;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));

    init();
    solution();
    printResult();

    br.close();
  }

  void init() throws IOException {
    result = new StringBuilder();
    segmentTree = new SegmentTree(SIZE);
    N = Integer.parseInt(br.readLine());
  }

  void printResult() {
    System.out.println(result);
  }

  void solution() throws IOException {
    for (int i = 0; i < N; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      switch (st.nextToken()) {
        case "1":
          result.append(segmentTree.get(Integer.parseInt(st.nextToken()))).append("\n");
          break;
        case "2":
          segmentTree.update(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
          break;
      }
    }
  }
}

class SegmentTree {
  int size, height;
  int[] tree;

  SegmentTree(int size) {
    this.size = size;
    height = (int) Math.ceil(Math.log(size) / Math.log(2));
    tree = new int[(int) Math.pow(2, height + 1)];
  }

  int get(int target) {
    return get(1, size, 1, target);
  }

  private int get(int start, int end, int index, int target) {
    if (start == end) {
      update(start, -1);
      return start;
    }

    int mid = (start + end) / 2;
    if (target <= tree[index * 2]) {
      return get(start, mid, index * 2, target);
    } else {
      return get(mid + 1, end, index * 2 + 1, target - tree[index * 2]);
    }
  }

  void update(int target, int diff) {
    update(1, size, 1, target, diff);
  }

  private void update(int start, int end, int index, int target, int diff) {
    if (target < start || end < target) return;

    tree[index] += diff;

    if (start == end) return;

    int mid = (start + end) / 2;
    update(start, mid, index * 2, target, diff);
    update(mid + 1, end, index * 2 + 1, target, diff);
  }
}