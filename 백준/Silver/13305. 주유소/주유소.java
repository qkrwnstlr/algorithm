import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] distance = new int[N - 1];
    int[] price = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N - 1; i++) distance[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      min = Math.min(min, Integer.parseInt(st.nextToken()));
      price[i] = min;
    }
    int total = 0;
    for(int i = 0; i < N - 1; i++) total += distance[i] * price[i];
    System.out.println(total);
  }
}