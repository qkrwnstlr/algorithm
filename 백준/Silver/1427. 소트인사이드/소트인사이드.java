import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String[] temp = br.readLine().split("");
    ArrayList<Integer> list = new ArrayList<>();
    for (String s : temp) list.add(Integer.parseInt(s));
    quickSort(list, 0, list.size() - 1);
    System.out.println(list.stream().map(String::valueOf).collect(Collectors.joining()));
  }

  static void quickSort(List<Integer> list, int start, int end) {
    if (start > end) return;
    int pivot = list.get(start), low = start, high = end;
    while (low < high) {
      while (pivot >= list.get(high) && low < high) high--;
      while (pivot <= list.get(low) && low < high) low++;
      if(low < high) Collections.swap(list, low, high);
      else Collections.swap(list, high, start);
    }
    quickSort(list, start, high - 1);
    quickSort(list, high + 1, end);
  }
}