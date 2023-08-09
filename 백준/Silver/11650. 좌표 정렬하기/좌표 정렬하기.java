import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    List<int[]> list = new ArrayList<>();
    for(int i = 0; i < N; i++) list.add(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
    heapsort(list);
    list.forEach(e -> sb.append(e[0]).append(" ").append(e[1]).append("\n"));
    System.out.println(sb);
  }

  public static void toMaxHeap(List<int[]> list, int i, int len) {
    while (i <= len / 2) { // 자식 존재 여부
      int j = i * 2;
      if (j < len && comparePoint(list.get(j - 1), list.get(j)) < 0) j++;
      if (comparePoint(list.get(i - 1), list.get(j - 1)) >= 0) break;
      Collections.swap(list, i - 1, j - 1);
      i = j;
    }
  }

  public static void heapsort(List<int[]> list) {
    int len = list.size();
    for (int i = len / 2; i > 0; i--) toMaxHeap(list, i, len); // 밑에서 부터 최대 힙으로 설정
    for(int i = len; i > 1; i--) {
      Collections.swap(list, 0, i - 1);
      toMaxHeap(list, 1, i - 1);
    }
  }

  static int comparePoint(int[] point1, int[] point2) {
    return point1[0] == point2[0] ? point1[1] == point2[1] ? 0 : point1[1] - point2[1] : point1[0] - point2[0];
  }
}