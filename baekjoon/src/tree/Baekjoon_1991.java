package tree;

import java.io.*;
import java.util.HashMap;
import java.util.Objects;
import java.util.StringTokenizer;

public class Baekjoon_1991 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static HashMap<String, String[]> tree = new HashMap<>();

  static void preorder(String current) throws IOException {
    String[] children = tree.get(current);
    if (Objects.equals(current, ".")) return;
    bw.write(current);
    preorder(children[0]);
    preorder(children[1]);
  }

  static void inorder(String current) throws IOException {
    String[] children = tree.get(current);
    if (Objects.equals(current, ".")) return;
    inorder(children[0]);
    bw.write(current);
    inorder(children[1]);
  }

  static void postorder(String current) throws IOException {
    String[] children = tree.get(current);
    if (Objects.equals(current, ".")) return;
    postorder(children[0]);
    postorder(children[1]);
    bw.write(current);
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    int n = Integer.parseInt(st.nextToken());

    for (int i = 0; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      String value = st.nextToken();
      String[] children = {st.nextToken(), st.nextToken()};
      tree.put(value, children);
    }

    String start = tree.keySet().toArray(new String[0])[0];

    preorder(start);
    bw.write("\n");
    inorder(start);
    bw.write("\n");
    postorder(start);
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
