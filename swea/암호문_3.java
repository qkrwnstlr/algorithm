import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
  BufferedReader br;
  LinkedList header, tail;

  public void result() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    int T = 10;
    for (int test_case = 1; test_case <= T; test_case++) {
      System.out.printf("#%d %s\n", test_case, solution());
    }
    br.close();
  }

  private String solution() throws IOException {
    init();
    int M = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      String commend = st.nextToken();
      switch (commend) {
        case "I": {
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          LinkedList head, current, tail;
          head = tail = new LinkedList();
          for (int j = 0; j < y; j++) {
            current = new LinkedList(st.nextToken());
            if (j == 0) head = current;
            else tail.next = current;
            tail = current;
          }
          insert(x, head, tail);
          break;
        }
        case "D": {
          int x = Integer.parseInt(st.nextToken());
          int y = Integer.parseInt(st.nextToken());
          delete(x, y);
          break;
        }
        case "A": {
          int y = Integer.parseInt(st.nextToken());
          LinkedList head, current, tail;
          head = tail = new LinkedList();
          for (int j = 0; j < y; j++) {
            current = new LinkedList(st.nextToken());
            if (j == 0) head = current;
            else tail.next = current;
            tail = current;
          }
          add(head, tail);
          break;
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    LinkedList current = header;
    for(int i = 0; i < 10 ;i++) sb.append((current = current.next).value).append(" ");
    return sb.toString();
  }

  void init() throws IOException {
    int N = Integer.parseInt(br.readLine());
    header = new LinkedList();
    StringTokenizer st = new StringTokenizer(br.readLine());
    tail = header.next = new LinkedList(st.nextToken());
    for (int i = 1; i < N; i++) tail = tail.next = new LinkedList(st.nextToken());
  }

  void insert(int index, LinkedList head, LinkedList tail) {
    LinkedList current = header;
    for (int i = 0; i < index; i++) current = current.next;
    tail.next = current.next;
    current.next = head;
  }

  void add(LinkedList head, LinkedList tail) {
    this.tail.next = head;
    this.tail = tail;
  }

  void delete(int start, int count) {
    LinkedList current = header;
    for (int i = 0; i < start; i++) current = current.next;
    for (int i = 0; i < count; i++) current.next = current.next.next;
    if (current.next == null) tail = current;
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