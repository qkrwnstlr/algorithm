import java.io.*;
import java.util.*;

public class Main {
  static int n;
  static long m;
  static long[] heightList;
  static long heightSum = 0L;
  static long max = 0L;
  static long min = 0L;

  public static Long getSum(Long mid) {
    long result = 0L;
    for (Long height : heightList) {
      long temp = height - mid;
      result += temp <= 0 ? 0 : temp;
    }
    return result;
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    m = Long.parseLong(st.nextToken());
    heightList = new long[n];
    str = br.readLine();
    st = new StringTokenizer(str);
    for (int i = 0; i < n; i++) {
      heightList[i] = Long.parseLong(st.nextToken());
      heightSum += heightList[i];
      max = Long.max(max, heightList[i]);
    }
    while (min < max) {
      long mid = (min + max) / 2;
      Long sum = getSum(mid);
      if (sum < m) max = mid;
      else min = mid + 1;
    }
    System.out.println(min - 1);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}