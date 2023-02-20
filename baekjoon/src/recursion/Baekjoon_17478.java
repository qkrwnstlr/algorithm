package recursion;

import java.io.*;

public class Baekjoon_17478 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int n = 0;

  static void write(int depth, String str) throws IOException {
    for (int i = 0; i < depth; i++) bw.write("____");
    bw.write(str);
  }

  static void recursion(int depth) throws IOException {
    write(depth, "\"재귀함수가 뭔가요?\"\n");
    if (depth == n) {
      write(depth, "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
    } else {
      write(depth, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
      write(depth, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
      write(depth, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
      recursion(depth + 1);
    }
    write(depth, "라고 답변하였지.\n");
  }

  static void result() throws IOException {
    String str = br.readLine();
    n = Integer.parseInt(str);
    bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
    recursion(0);
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
