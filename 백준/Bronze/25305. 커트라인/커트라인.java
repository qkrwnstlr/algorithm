import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int k = Integer.parseInt(input[1]);

    List<Integer> list = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
    sort(list, 0, list.size() - 1);
    System.out.println(list.get(list.size() - k));
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

