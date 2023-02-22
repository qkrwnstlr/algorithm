package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_13415 {
  static class ArrayData implements Comparable<ArrayData> {
    int value;
    int index;
    char location;

    ArrayData(int value, int index, char location) {
      this.value = value;
      this.index = index;
      this.location = location;
    }

    @Override
    public int compareTo(ArrayData o) {
      return this.value - o.value == 0 ?
              this.index - o.index == 0 ?
                      o.location - this.location : this.index - o.index
              : this.value - o.value;
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    Integer[] ints = new Integer[n];
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    for (int i = 0; i < n; i++) ints[i] = Integer.parseInt(st.nextToken());
    int k = Integer.parseInt(br.readLine());

    ArrayData[] list = new ArrayData[k * 2];

    for (int i = 0; i < k * 2; i += 2) {
      st = new StringTokenizer(br.readLine());
      list[i] = new ArrayData(Integer.parseInt(st.nextToken()), i / 2, 'a');
      list[i + 1] = new ArrayData(Integer.parseInt(st.nextToken()), i / 2, 'b');
    }

    Arrays.sort(list, Comparator.reverseOrder());

    int maxIndex = -1;
    for (int i = 0; i < k * 2; i++) {
      if (list[i].index >= maxIndex) {
        if(list[i].location == 'a' && list[i].index == maxIndex) continue;
        maxIndex = list[i].index;
        if (list[i].location == 'a') Arrays.sort(ints, 0, list[i].value);
        else Arrays.sort(ints, 0, list[i].value, Comparator.reverseOrder());
      }
    }

    for (int i = 0; i < n; i++) sb.append(ints[i]).append(" ");
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
