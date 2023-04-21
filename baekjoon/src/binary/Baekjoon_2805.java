package binary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2805 {
  static int n;
  static Long m;
  static Long[] heightList;
  static Long maxHeight = 0L;
  static Long currentHeight = 0L;
  static Long beforeHeight = 0L;

  public static Long getHeight(Long currentHeight) {
    long result = 0L;
    for (Long treeHeight : heightList) {
      result += treeHeight - currentHeight > 0 ? treeHeight - currentHeight : 0;
    }
    return result;
  }

  public static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    n = Integer.parseInt(st.nextToken());
    m = Long.parseLong(st.nextToken());
    heightList = new Long[n];
    str = br.readLine();
    st = new StringTokenizer(str);
    for (int i = 0; i < n; i++) {
      heightList[i] = Long.parseLong(st.nextToken());
      maxHeight = Long.max(maxHeight, heightList[i]);
    }
    while (currentHeight <= maxHeight) {
      Long height = getHeight(currentHeight);
      Long temp = currentHeight;
      if (height > m) currentHeight = (currentHeight + maxHeight) / 2;
      if (height < m) currentHeight = (currentHeight + beforeHeight) / 2;
      if (height.equals(m)) break;
      beforeHeight = temp.equals(beforeHeight) ? temp - 1 : temp;
    }
    System.out.println(currentHeight);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
