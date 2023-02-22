package sort;

import java.io.*;
import java.util.*;

public class Baekjoon_18870 {
  static int n;
  static int[] ints;
  static int[] counts;
  static int[] sortedInts;
  static HashSet<Integer> intsSet = new HashSet<>();
  static HashMap<Integer, Integer> intsMap = new HashMap<>();


  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    n = Integer.parseInt(str);
    ints = new int[n];
    counts = new int[n];

    str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    for (int i = 0; i < n; i++) {
      ints[i] = Integer.parseInt(st.nextToken()); // 입력 받은 값 array로 전환
      intsSet.add(ints[i]); // 입력 받은 값 set으로 전환
    }

    sortedInts = new int[intsSet.size()]; // set으로 전환한 입력을 정렬한 array
    Iterator<Integer> iterator = intsSet.iterator();
    for (int i = 0; i < intsSet.size(); i++) sortedInts[i] = iterator.next();
    Arrays.sort(sortedInts);

    for (int i = 0; i < sortedInts.length; i++) intsMap.put(sortedInts[i], i); // map에 해당 값 보다 큰 값의 수 저장
    for (int i = 0; i < n; i++) sb.append(intsMap.get(ints[i])).append(" "); // map에 접근하여 해당 값보다 큰 값의 갯수 확인
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
