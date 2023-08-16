import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    int d = sc.nextInt();
    int e = sc.nextInt();
    int f = sc.nextInt();

    int y = b * d - e * a == 0 ? a == 0 ? f / e : c / b : (c * d - f * a) / (b * d - e * a);
    int x = a == 0 ? (f - e * y) / d : (c - b * y) / a;
    System.out.println(x + " " + y);
  }
}