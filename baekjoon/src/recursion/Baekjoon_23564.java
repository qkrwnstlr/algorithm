package recursion;

import java.io.*;

public class Baekjoon_23564 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sbCharacter = new StringBuilder(); // 문자열 저장
  static  StringBuilder sbCount = new StringBuilder(); // 개수 저장
  static char[] characters;
  static int index = 0; // characters에 접근할 다음 index


  static char stringPop() { // 다음 문자를 반환하고 index를 증가시켜 넘김
    return characters[index++];
  }

  static void result() throws IOException {
    characters = br.readLine().toCharArray(); // 입력받은 문자열을 character array로 변환

    int accLength = 0; // 현재까지 확인된 반복되는 문자열의 길이

    char beforeCharacter = stringPop(); // 초기값 설정
    int beforeCount = 1; // 초기갑 설정
    sbCharacter.append(beforeCharacter);

    while (true) {
      index += accLength; // 반복되고 있는 문자를 index를 증가시켜 넘김

      if (characters.length == index) { // 문자열이 끝날때 까지 반복
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
