import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder result;
  int N, M;
  Trie trie;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    trie = new Trie();
    for (int i = 0; i < N; i++) trie.add(br.readLine());
  }

  void solution() throws IOException {
    int count = 0;
    for (int i = 0; i < M; i++) {
      if (trie.contains(br.readLine())) count++;
    }
    result.append(count);
  }
}

class Trie {
  private final Node _root;

  Trie() {
    _root = new Node();
  }

  void add(String value) {
    add(value, _root, 0);
  }

  private void add(String value, Node node, int depth) {
    if (depth == value.length()) {
      node.valid = true;
      return;
    }

    int current = value.charAt(depth) - 'a';

    if (node.children[current] == null) node.children[current] = new Node();

    add(value, node.children[current], depth + 1);
  }

  boolean contains(String value) {
    return contains(value, _root, 0);
  }

  private boolean contains(String value, Node node, int depth) {
    if (depth == value.length()) {
      return node.valid;
    }

    int current = value.charAt(depth) - 'a';

    if (node.children[current] == null) return false;

    return contains(value, node.children[current], depth + 1);
  }
}

class Node {
  boolean valid;
  Node[] children;

  Node() {
    valid = false;
    children = new Node[26];
  }
}