import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  BufferedReader br;
  LinkedList header, tail;

  public void result() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int test_case = 1; test_case <= T; test_case++) {
      System.out.printf("#%d %s\n", test_case, solution());
    }
    br.close();
  }

  private String solution() throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int L = Integer.parseInt(st.nextToken());

    header = new LinkedList();
    st = new StringTokenizer(br.readLine());
    tail = header.next = new LinkedList(st.nextToken());
    for (int i = 1; i < N; i++) tail = tail.next = new LinkedList(st.nextToken());

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      String commend = st.nextToken();
      switch (commend) {
        case "I": {
          insert(Integer.parseInt(st.nextToken()), new LinkedList(st.nextToken()));
          break;
        }
        case "D": {
          delete(Integer.parseInt(st.nextToken()));
          break;
        }
        case "C" : {
          search(Integer.parseInt(st.nextToken())).value = st.nextToken();
        }
      }
    }

    LinkedList result = search(L);
    return result == null ? "-1" : result.value;
  }

  void insert(int index, LinkedList node) {
    LinkedList current = header;
    for (int i = 0; i < index; i++) current = current.next;
    node.next = current.next;
    current.next = node;
  }

  void delete(int start) {
    LinkedList current = header;
    for (int i = 0; i < start; i++) current = current.next;
    current.next = current.next.next;
    if (current.next == null) tail = current;
  }

  LinkedList search(int index) {
    LinkedList current = header.next;
    for (int i = 0; (i < index) && (current != null); i++) current = current.next;
    return current;
  }

  public static void main(String[] args) throws IOException {
    new Solution().result();
  }
}

class LinkedList {
  String value;
  LinkedList next;

  public LinkedList() {
    this(null);
  }

  public LinkedList(String value) {
    this(value, null);
  }

  public LinkedList(String value, LinkedList next) {
    this.value = value;
    this.next = next;
  }
}