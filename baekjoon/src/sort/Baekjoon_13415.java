package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baekjoon_13415 {
  static class ArrayData implements Comparable<ArrayData> {
    int value; // 입력받은 값
    int index; // 입력받은 순서
    char location; // 내림차순인지 오름차순인지

    ArrayData(int value, int index, char location) {
      this.value = value;
      this.index = index;
      this.location = location;
    }

    @Override
    public int compareTo(ArrayData o) { // value 가 작은순, index가 작은순, location이 큰 순
      return this.value - o.value == 0 ?
              this.index - o.index == 0 ?
                      o.location - this.location : this.index - o.index
              : this.value - o.value;
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    Short[] ints = new Short[n];

    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);
    for (int i = 0; i < n; i++) ints[i] = Short.parseShort(st.nextToken());
    int k = Integer.parseInt(br.readLine());

    ArrayData[] list = new ArrayData[k * 2];
    for (int i = 0; i < k * 2; i += 2) {
      st = new StringTokenizer(br.readLine());
      list[i] = new ArrayData(Integer.parseInt(st.nextToken()), i / 2, 'a');
      list[i + 1] = new ArrayData(Integer.parseInt(st.nextToken()), i / 2, 'b');
    }

    Arrays.sort(list, Comparator.reverseOrder());

    int maxIndex = -1; // index가 maxIndex보다 작으면 정렬할 가치가 없다.
    ArrayData lastArrayData = new ArrayData(0, 0, (char) 0); // 마지막에 정렬된 상태를 저장
    for (int i = 0; i < k * 2; i++) {
      if (list[i].index < maxIndex) continue;
      if (list[i].location == 'a' && list[i].index == maxIndex) continue; // 같은 index의 b가 먼저 있었으면 안함
      maxIndex = list[i].index;
      if (lastArrayData.value >= list[i].value) { // 이미 정렬이 되어있는 상태이면 O(n)으로 처리 가능
        if (lastArrayData.location != list[i].location) {
          int currentValue = list[i].value - 1;
          for (int j = 0; j <= currentValue / 2; j++) {
            Short temp = ints[j];
            ints[j] = ints[currentValue - j];
            ints[currentValue - j] = temp;
          }
          lastArrayData = list[i];
        }
        continue;
      }
      if (list[i].location == 'a') Arrays.sort(ints, 0, list[i].value); // 정렬을 보장할 수 없으면 각 location에 맞는 동작 수행
      else Arrays.sort(ints, 0, list[i].value, Comparator.reverseOrder());
      lastArrayData = list[i];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < n; i++) sb.append(ints[i]).append(" ");
    System.out.println(sb);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
