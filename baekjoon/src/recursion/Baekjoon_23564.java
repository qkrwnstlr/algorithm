package recursion;

import java.io.*;

public class Baekjoon_23564 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sbCharacter = new StringBuilder(); // 문자열 저장
  static  StringBuilder sbCount = new StringBuilder(); // 개수 저장
  static String str; // 입력받은 T

  static char stringPop() { // String에서 맨 앞에 글자를 반환하고 String은 하나 삭제
    char value = str.charAt(0);
    str = str.replaceFirst(Character.toString(value), ""); // replace first고 charAt(0)을 지우니까 O(1)이겠지...? 설마 남은 문자열을 다 복사하나..?
    return value;
  }

  static void result() throws IOException {
    str = br.readLine();

    int accLength = 0; // 현재까지 확인된 반복되는 문자열의 길이

    char beforeCharacter = stringPop();
    int beforeCount = 1;
    sbCharacter.append(beforeCharacter);

    while (true) {
      // substring이 오래 걸리는 것으로 보임
      // substring은 자르고 남은 문자열을 다 복사하는 듯
      // 1. char list 로 만들고 index로 접근..?
      // 2, queue에 넣고 하나씩 pop?
      // 3. 반복되는 문자열을 저장해놓고 replaceFirst로 제거?
      str = str.substring(accLength); // 반복되고 있는 문자를 제거함

      if (str.isEmpty()) { // 문자열이 끝날때 까지 반복
        sbCount.append(beforeCount).append(" "); // 문자열이 끝났으면 마지막 출력을 안하므로 직접 해줌
        break;
      }

      char currentCharacter = stringPop(); // 문자 확인

      if (currentCharacter == beforeCharacter) { // 이전 문자와 같으면
        beforeCount++; // 갯수만 늘림
      } else { // 다르면
        sbCharacter.append(currentCharacter); // 이전 문자열이 끝났다고 판단 후 문자와
        sbCount.append(beforeCount).append(" "); // 갯수를 각각 저장하고
        accLength = accLength * (beforeCount + 1) + beforeCount; // 누적된 문자열의 길이를 저장
        beforeCharacter = currentCharacter; // 이전 문자열이 이제 현재 문자열이므로 바꿔주고
        beforeCount = 1; // 갯수도 1로 초기화
      }
    }
    System.out.println(sbCharacter);
    System.out.println(sbCount);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
