import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder result;
  int N;
  String[] arr;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    for (int test = 0; test < T; test++) {
      init();
      solution();
    }
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    N = Integer.parseInt(br.readLine());
    arr = new String[N];
    for (int i = 0; i < N; i++) arr[i] = br.readLine();
  }

  void solution() {
    Arrays.sort(arr);
    Trie trie = new Trie();
    for (int i = 0; i < arr.length; i++) {
      if (!trie.add(arr[i])) {
        result.append("NO").append("\n");
        return;
      }
    }
    result.append("YES").append("\n");
  }
}

class Trie {
  Node root;

  Trie() {
    root = new Node();
  }

  boolean add(String value) {
    return add(value, root, 0);
  }

  boolean add(String value, Node node, int depth) {
    if (depth == value.length()) {
      node.valid = true;
      return true;
    }

    if (node.valid) {
      return false;
    }

    char current = value.charAt(depth);

    if (!node.children.containsKey(current)) {
      node.children.put(current, new Node());
    }

    return add(value, node.children.get(current), depth + 1);
  }
}

class Node {
  boolean valid;
  Map<Character, Node> children;

  Node() {
    valid = false;
    children = new HashMap<>();
  }
}