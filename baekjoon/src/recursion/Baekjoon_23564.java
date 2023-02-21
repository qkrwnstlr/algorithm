package recursion;

import java.io.*;

public class Baekjoon_23564 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sbCharacter = new StringBuilder();
  static  StringBuilder sbCount = new StringBuilder();
  static String str;

  static char stringPop() {
    char result = str.charAt(0);
    str = str.substring(1);
    return result;
  }

  static void result() throws IOException {
    str = br.readLine();

    int accLength = 0;
    char beforeCharacter = stringPop();
    int beforeCount = 1;

    sbCharacter.append(beforeCharacter);

    while (true) {
      str = str.substring(accLength);

      if (str.isEmpty()) {
        sbCount.append(beforeCount).append(" ");
        break;
      }

      char currentCharacter = stringPop();

      if (currentCharacter == beforeCharacter) {
        beforeCount++;
      } else {
        sbCharacter.append(currentCharacter);
        sbCount.append(beforeCount).append(" ");
        accLength = accLength * (beforeCount + 1) + beforeCount;
        beforeCharacter = currentCharacter;
        beforeCount = 1;
      }
    }
    System.out.println(sbCharacter);
    System.out.println(sbCount);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
