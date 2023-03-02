package search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2667 {
  static ArrayList<Integer> complex = new ArrayList<>();
  static int n;
  static boolean[] visited;
  static Queue<Integer> queue = new LinkedList<>();

  public static void setVisited(int current) {
    queue.add(current);
    visited[current] = true;
    complex.set(complex.size() - 1, complex.get(complex.size() - 1) + 1);
  }

  public static void findComplex(int start) {
    complex.add(0);
    setVisited(start);
    while (!queue.isEmpty()) {
      int current = queue.remove();
      if (current / n != n - 1 && !visited[current + n]) setVisited(current + n);
      if (current / n != 0 && !visited[current - n]) setVisited(current - n);
      if (current % n != n - 1 && !visited[current + 1]) setVisited(current + 1);
      if (current % n != 0 && !visited[current - 1]) setVisited(current - 1);
    }
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    n = Integer.parseInt(br.readLine());
    visited = new boolean[n * n];
    for (int i = 0; i < n; i++) {
      char[] str = br.readLine().toCharArray();
      for (int j = 0; j < n; j++) if (Integer.parseInt(String.valueOf(str[j])) == 0) visited[i * n + j] = true;
    }

    for (int i = 0; i < n * n; i++) {
      queue = new LinkedList<>();
      if (!visited[i]) findComplex(i);
    }

    System.out.println(complex.size());
    Collections.sort(complex);
    complex.forEach(System.out::println);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
