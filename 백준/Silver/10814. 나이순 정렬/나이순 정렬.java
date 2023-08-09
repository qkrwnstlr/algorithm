import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int N = Integer.parseInt(br.readLine());
    List<String[]> list = new ArrayList<>();
    for(int i = 0; i < N; i++) list.add((br.readLine() + " " + i).split(" "));
    heapsort(list);
    list.stream().distinct().forEach(e -> sb.append(e[0]).append(" ").append(e[1]).append("\n"));
    System.out.println(sb);
  }

  public static void toMaxHeap(List<String[]> list, int i, int len) {
    while (i <= len / 2) {
      int j = i * 2;
      if (j < len && compareMember(list.get(j - 1), list.get(j)) < 0) j++;
      if (compareMember(list.get(i - 1), list.get(j - 1)) >= 0) break;
      Collections.swap(list, i - 1, j - 1);
      i = j;
    }
  }

  public static void heapsort(List<String[]> list) {
    int len = list.size();
    for (int i = len / 2; i > 0; i--) toMaxHeap(list, i, len);
    for(int i = len; i > 1; i--) {
      Collections.swap(list, 0, i - 1);
      toMaxHeap(list, 1, i - 1);
    }
  }

  static int compareMember(String[] member1, String[] member2) {
    return member1[0].equals(member2[0]) ? Integer.parseInt(member1[2]) - Integer.parseInt(member2[2]) : Integer.parseInt(member1[0]) - Integer.parseInt(member2[0]);
  }
}