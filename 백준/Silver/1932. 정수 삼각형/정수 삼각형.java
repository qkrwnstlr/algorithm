import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[] max = new int[N + 1];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int[] temp = new int[N + 1];
      temp[0] = max[0] + Integer.parseInt(st.nextToken());
      for (int j = 1; j < i + 1; j++) temp[j] = Integer.max(max[j - 1], max[j]) + Integer.parseInt(st.nextToken());
      max = temp;
    }
    System.out.println(Arrays.stream(max).max().getAsInt());
  }
}