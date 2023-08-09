import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    int[] list = new int[10001];
    for(int i = 0; i < n; i++) list[Integer.parseInt(br.readLine())]++;
    for(int i = 0; i < 10001; i++) for(int j = 0; j < list[i]; j++) sb.append(i).append('\n');
    System.out.println(sb);
  }
}