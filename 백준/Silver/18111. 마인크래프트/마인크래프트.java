import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    int time = Integer.MAX_VALUE;
    int height = 0;
    int[] land = new int[N * M];
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) land[i * M + j] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(land);
    for (int i = 0; i < 257; i++) {
      int mine = 0;
      int build = 0;
      for (int j : land) {
        if (j >= i) mine += j - i;
        else build += i - j;
      }
      if (build <= B + mine) {
        int temp = mine * 2 + build;
        if (time >= temp) {
          time = temp;
          height = i;
        }
      }
    }
    System.out.println(time + " " + height);
  }
}
