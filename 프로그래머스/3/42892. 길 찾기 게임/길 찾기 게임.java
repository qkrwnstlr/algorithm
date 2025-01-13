import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

class Solution {
  public int[][] solution(int[][] nodeinfo) {
    Node[] sorted = IntStream.range(0, nodeinfo.length)
      .mapToObj(it -> new Node(it + 1, nodeinfo[it][0], nodeinfo[it][1]))
      .sorted((a, b) -> a.y == b.y ? a.x - b.x : b.y - a.y)
      .toArray(Node[]::new);

    BinaryTree binaryTree = new BinaryTree(sorted[0]);

    for (int i = 1; i < sorted.length; i++) binaryTree.addNode(sorted[i]);

    List<Integer> preorder = new ArrayList<>(), postorder = new ArrayList<>();
    binaryTree.preorder(it -> preorder.add(it.index));
    binaryTree.postorder(it -> postorder.add(it.index));

    return new int[][]{preorder.stream().mapToInt(it -> it).toArray(), postorder.stream().mapToInt(it -> it).toArray()};
  }
}

class BinaryTree {
  private final Node root;

  BinaryTree(Node root) {
    this.root = root;
  }

  void addNode(Node node) {
    addNode(root, node);
  }

  private void addNode(Node parent, Node child) {
    if (parent.x < child.x) {
      if (parent.right == null) parent.right = child;
      else addNode(parent.right, child);
    } else {
      if (parent.left == null) parent.left = child;
      else addNode(parent.left, child);
    }
  }

  void preorder(Callback callback) {
    preorder(root, callback);
  }

  private void preorder(Node current, Callback callback) {
    if (current == null) return;
    callback.invoke(current);
    preorder(current.left, callback);
    preorder(current.right, callback);
  }

  void postorder(Callback callback) {
    postorder(root, callback);
  }

  void postorder(Node current, Callback callback) {
    if (current == null) return;
    postorder(current.left, callback);
    postorder(current.right, callback);
    callback.invoke(current);
  }

  public interface Callback {
    void invoke(Node value);
  }
}

class Node {
  int index, x, y;
  Node left, right;

  Node(int index, int x, int y) {
    this.index = index;
    this.x = x;
    this.y = y;
  }
}