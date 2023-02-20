package recursion;

import java.io.*;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_1759 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int l;
  static int c;
  static String[] sl;
  static HashSet<String> vowels = new HashSet<>();

  static void recursion(int depth, String[] rl, int current, int vowelCount) throws IOException {
    if (depth == l) {
      if (vowelCount < 1 || l - vowelCount < 2) return;
      for (int i = 0; i < l; i++) bw.write(rl[i]);
      bw.write("\n");
      return;
    }
    for (int i = current; i < c; i++) {
      rl[depth] = sl[i];
      recursion(depth + 1, rl, i + 1, vowels.contains(sl[i]) ? vowelCount + 1 : vowelCount);
    }
  }

  static void result() throws IOException {
    vowels.add("a");
    vowels.add("e");
    vowels.add("i");
    vowels.add("o");
    vowels.add("u");

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    l = Integer.parseInt(st.nextToken());
    c = Integer.parseInt(st.nextToken());
    sl = new String[c];

    str = br.readLine();
    st = new StringTokenizer(str);
    PriorityQueue<String> pq = new PriorityQueue<>(String::compareTo);
    for (int i = 0; i < c; i++) pq.add(st.nextToken());
    for (int i = 0; i < c; i++) sl[i] = pq.poll();

    recursion(0, new String[l], 0, 0);
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
