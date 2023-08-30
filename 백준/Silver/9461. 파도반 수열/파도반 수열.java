import java.io.*;

public class Main {
  static int T;

  static long[] temp;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    temp = new long[100];
    temp[0] = 1;
    temp[1] = 1;
    temp[2] = 1;
    temp[3] = 2;
    temp[4] = 2;
    temp[5] = 3;
    temp[6] = 4;
    temp[7] = 5;
    temp[8] = 7;
    temp[9] = 9;

    for (int i = 10; i < 100; i++) temp[i] = temp[i - 1] + temp[i - 5];


    T = Integer.parseInt(br.readLine());
    for (int i = 0; i < T; i++) System.out.println(temp[Integer.parseInt(br.readLine()) - 1]);
  }
}