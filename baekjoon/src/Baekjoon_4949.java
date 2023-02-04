import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_4949 {
  static class Stack {
    static class Node {
      private final int data;
      private Node next;

      public Node(int data) {
        this.data = data;
        this.next = null;
      }
    }

    private Node head;
    private int size;

    public Stack() {
      head = null;
      this.size = 0;
    }

    public void push(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
      size++;
    }

    public int pop() {
      if (head == null) return -1;
      int result = head.data;
      head = head.next;
      size--;
      return result;
    }

    public int empty() {
      return size == 0 ? 1 : 0;
    }
  }

  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    while (true) {
      Stack stack = new Stack();
      String str = br.readLine();
      if (str.equals(".")) break; // 종료 조건

      int i;

      for (i = 0; i < str.length(); i++) {
        char c = str.charAt(i);
        if (c == '(' || c == '[') {
          stack.push(c);
        } else if (c == ')') {
          if (stack.pop() != '(')
            break;
        } else if (c == ']') {
          if (stack.pop() != '[')
            break;
        }
      }
      if (i == str.length() && stack.empty() == 1) System.out.println("yes");
      else System.out.println("no");
    }
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_4949().result();
  }
}
