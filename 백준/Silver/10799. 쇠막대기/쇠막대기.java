import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
  public static void main(String[] args) throws IOException {
    new Main().run();
  }

  BufferedReader br;
  StringBuilder result;
  String input;

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    result = new StringBuilder();

    init();
    solution();
    System.out.println(result);

    br.close();
  }

  void init() throws IOException {
    input = br.readLine();
  }

  void solution() {
    int count = 0;
    ArrayDeque<Character> stack = new ArrayDeque<>();
    for (int j = 0; j < input.length(); j++) {
      if (input.charAt(j) == ')') {
        stack.pop();
        if (input.charAt(j - 1) == '(') count += stack.size();
        else count++;
      } else {
        stack.push(input.charAt(j));
      }
    }
    result.append(count);
  }
}
