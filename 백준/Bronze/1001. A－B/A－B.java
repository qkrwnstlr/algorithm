import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    System.out.println(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new Main().result();
  }
}
