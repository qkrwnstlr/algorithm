import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[][] schedule = new int[N][2];
    for(int i = 0; i < N; i++) {
      String[] read = br.readLine().split(" ");
      schedule[i][0] = Integer.parseInt(read[0]);
      schedule[i][1] = Integer.parseInt(read[1]);
    }
    int[] moneyList = new int[N + 1];
    for(int i = 0; i < N; i++) {
      if(i + schedule[i][0] <= N) moneyList[i + schedule[i][0]] = Math.max(moneyList[i + schedule[i][0]], moneyList[i] + schedule[i][1]);
      moneyList[i + 1] = Math.max(moneyList[i + 1], moneyList[i]);
    }
    System.out.println(moneyList[N]);
  }
}