package tree;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon_9934 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int[] tree;

  static void inorder(int current, StringTokenizer st) {
    if(current >= tree.length) return;
    inorder(current * 2, st);
    tree[current] = Integer.parseInt(st.nextToken());
    inorder(current * 2 + 1, st);
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int k = Integer.parseInt(st.nextToken());
    tree = new int[(int) Math.pow(2, k)];

    str = br.readLine();
    st = new StringTokenizer(str);
    inorder(1, st);

    for (int i = 0; i < k; i++) {
      for (int j = (int) Math.pow(2, i); j < Math.pow(2, i + 1); j++) {
        bw.write(Integer.toString(tree[j]));
        bw.write(" ");
      }
      bw.write("\n");
    }

    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
