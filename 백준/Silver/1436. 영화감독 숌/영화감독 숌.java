import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int count = 0;
    int current = 665;
    while(count < N) if(Integer.toString(++current).contains("666")) count++;
    System.out.println(current);
  }
}