package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon_2108 {
  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] ints = new int[n];
    HashMap<Integer, Integer> countsMap = new HashMap<>();
    int total = 0;
    for (int i = 0; i < n; i++) {
      ints[i] = Integer.parseInt(br.readLine());
      total += ints[i];
      countsMap.merge(ints[i], 1, Integer::sum);
    }
    System.out.println(Math.round((double) total / n)); // 산술 평균

    Arrays.sort(ints);
    System.out.println(ints[n / 2]); // 중앙값

    int maxCount = 0;
    ArrayList<Integer> maxKey = new ArrayList<>();
    Set<Integer> keySet = countsMap.keySet();
    for (int current : keySet) {
      if (countsMap.get(current) > maxCount) {
        maxKey.clear();
        maxKey.add(current);
        maxCount = countsMap.get(current);
      } else if (countsMap.get(current) == maxCount) maxKey.add(current);
    }
    int[] sortedMaxKey = new int[maxKey.size()];
    for (int i = 0; i < maxKey.size(); i++) sortedMaxKey[i] = maxKey.get(i);
    Arrays.sort(sortedMaxKey);
    System.out.println(sortedMaxKey.length > 1 ? sortedMaxKey[1] : sortedMaxKey[0]); // 최빈값

    System.out.println(ints[n - 1] - ints[0]); // 범위
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
