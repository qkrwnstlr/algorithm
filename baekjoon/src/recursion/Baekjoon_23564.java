package recursion;

import java.io.*;
import java.util.ArrayList;

public class Baekjoon_23564 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static String str;

  static char stringPop() {
    char result = str.charAt(0);
    str = str.substring(1);
    return result;
  }

  static void result() throws IOException {
    str = br.readLine();

    ArrayList<Character> characters = new ArrayList<>();
    ArrayList<Integer> counts = new ArrayList<>();

    char current = stringPop();
    characters.add(current);
    counts.add(1);

    // 같은 순번에 들어온 문자열이 연속으로 나오는 경우는 처음 밖에 없다.
    // 즉, 처음을 제외하면 한번 문자가 바뀌면 그 뒤에는 반복되었던 문자가 나온다.
    // 이를 제거하면 직전에 추가되었던 문자 혹은 새로운 문자가 나온다.
    while (true) {
      int before = 0;
      int temp = 1;
      int accLength = 0; // 반복되는 문자열의 길이
      for (int i = counts.size() - 2; i >= 0; i--) { // 반복되는 문자열의 길이를 구한다
        temp *= before + 1;
        accLength += counts.get(i) * temp;
        before = counts.get(i);
      }

      for (int i = 0; i < accLength; i++) stringPop(); // 반복되는 문자열을 제거한다

      if (str.isEmpty()) break;

      current = stringPop(); // 다음 문자열을 확인한다

      if (current == characters.get(characters.size() - 1)) { // 만약 직전에 나온거와 같으면
        counts.set(counts.size() - 1, counts.get(counts.size() - 1) + 1); // 그 수를 늘린다
      } else { // 다르다면
        characters.add(current); // 새로운 문자를 추가한다
        counts.add(1);
      }
    }
    characters.forEach(e -> {
      try {
        bw.write(e);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    bw.write("\n");
    counts.forEach(e -> {
      try {
        bw.write(String.valueOf(e));
        bw.write(" ");
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    });
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
