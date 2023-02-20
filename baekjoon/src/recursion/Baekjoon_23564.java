package recursion;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Baekjoon_23564 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    String str = br.readLine();
    ArrayList<Character> characters = new ArrayList<>();
    ArrayList<Integer> counts = new ArrayList<>();
    HashMap<Character, Integer> indexMap = new HashMap<>();
    int index = 0;
    for (int i = 0; i < str.length(); i++) {
      char current = str.charAt(i);
      if (!indexMap.containsKey(current)) {
        indexMap.put(current, index++);
        counts.add(1);
        characters.add(current);
      } else {
        counts.set(indexMap.get(current), counts.get(indexMap.get(current)) + 1);
      }
    }

    int current = 0;
    int factorial = 1;
    for (int i = counts.size() - 1; i >= 0; i--) {
      factorial *= current + 1;
      current = counts.get(i) / factorial;
      counts.set(i, current);
    }

    characters.forEach(e -> {
      try {
        bw.write(e.toString());
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    bw.write("\n");
    counts.forEach(e -> {
      try {
        bw.write(String.valueOf(e));
        bw.write(" ");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
