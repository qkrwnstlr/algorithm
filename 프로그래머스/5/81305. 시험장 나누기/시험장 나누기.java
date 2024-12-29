import java.util.Arrays;

class Solution {
  public int solution(int k, int[] num, int[][] links) {
    init(k, num, links);

    int low = Arrays.stream(num).max().orElse(0), high = Arrays.stream(num).sum();
    while (low <= high) {
      int mid = (low + high) / 2;
      if (check(nodePool, mid, k)) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }
    return low;
  }

  int N, K, count;
  NodePool nodePool;

  void init(int k, int[] num, int[][] links) {
    N = num.length;
    K = k;
    nodePool = new NodePool(num, links);
  }


  boolean check(NodePool nodePool, int limit, int k) {
    count = 0;
    dfs(nodePool.root, limit);
    return count < k;
  }

  int dfs(Node node, int limit) {
    if (node == null) return 0;

    if (node.num > limit) {
      count = N + 1;
      return node.num;
    }

    int left = dfs(node.left, limit);
    int right = dfs(node.right, limit);

    if (node.num + left + right <= limit) {
      return node.num + left + right;
    }
    if (node.num + Math.min(left, right) <= limit) {
      count += 1;
      return node.num + Math.min(left, right);
    }
    count += 2;
    return node.num;
  }
}

class NodePool {
  private final Node[] nodes;
  Node root;

  NodePool(int[] num, int[][] links) {
    nodes = new Node[num.length];
    for (int i = 0; i < num.length; i++) nodes[i] = new Node(num[i]);
    for (int i = 0; i < links.length; i++) addEdge(i, links[i][0], links[i][1]);
    root = Arrays.stream(nodes).filter(it -> it.parent == null).findFirst().orElse(new Node(0));
  }

  void addEdge(int parent, int left, int right) {
    if (left != -1) nodes[parent].setLeft(nodes[left]);
    if (right != -1) nodes[parent].setRight(nodes[right]);
  }
}

class Node {
  int num;
  Node left, right, parent;

  Node(int num) {
    this.num = num;
  }

  void setLeft(Node node) {
    left = node;
    node.setParent(this);
  }

  void setRight(Node node) {
    right = node;
    node.setParent(this);
  }

  private void setParent(Node node) {
    parent = node;
  }
}