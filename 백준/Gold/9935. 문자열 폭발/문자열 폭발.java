import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder sb;
  String input, c4, result;

  void init() throws IOException {
    input = br.readLine();
    c4 = br.readLine();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();

    init();
    solution();
    sb.append(result).append("\n");

    System.out.println(sb);

    br.close();
  }

  void solution() {
    ArrayList<Character> stack = new ArrayList<>();
    for (int i = 0; i < input.length(); i++) {
      stack.add(input.charAt(i));
      for (int j = 1; j <= c4.length(); j++) {
        if (stack.size() - j < 0 || stack.get(stack.size() - j) != c4.charAt(c4.length() - j)) break;
        if (j == c4.length()) for (int k = 0; k < c4.length(); k++) stack.remove(stack.size() - 1);
      }
    }
    result = stack.isEmpty() ? "FRULA" : stack.stream().map(String::valueOf).collect(Collectors.joining());
  }
}