import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    List<Integer> list = new ArrayList<>();
    for(int i = 0; i < n; i++) list.add(Integer.parseInt(br.readLine()));
    sort(list, 0, list.size() - 1);
    for (int number : list) System.out.println(number);
  }
  static void sort(List<Integer> list, int start, int end) {
    if (start > end) return;
    int pivot = list.get(start);
    int low = start, high = end;
    while (low < high) {
      while (pivot <= list.get(high) && low < high) high--;
      while (pivot >= list.get(low) && low < high) low++;
      if(low < high) Collections.swap(list, low, high);
      else Collections.swap(list, high, start);
    }
    sort(list, start, high - 1);
    sort(list, high + 1, end);
  }
}