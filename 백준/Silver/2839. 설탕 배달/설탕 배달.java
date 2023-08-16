import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int result = Integer.MAX_VALUE;
    for(int i = 0; i <= N / 3; i++) for(int j = 0; j <= N / 5; j++) if(i * 3 + j * 5 == N) result = Math.min(result, i + j);
    System.out.println(result == Integer.MAX_VALUE ? -1 : result);
  }
}