import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());
    int[][] min = new int[N][3];
    st = new StringTokenizer(br.readLine());
    for (int j = 0; j < 3; j++) min[0][j] = Integer.parseInt(st.nextToken());
    for (int i = 1; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      min[i][0] = Math.min(min[i - 1][1], min[i - 1][2]) + Integer.parseInt(st.nextToken());
      min[i][1] = Math.min(min[i - 1][0], min[i - 1][2]) + Integer.parseInt(st.nextToken());
      min[i][2] = Math.min(min[i - 1][0], min[i - 1][1]) + Integer.parseInt(st.nextToken());
    }
    System.out.println(Arrays.stream(min[N - 1]).min().getAsInt());
  }
}