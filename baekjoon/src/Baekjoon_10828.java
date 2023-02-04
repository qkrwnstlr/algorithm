import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10828 {
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

    public int size() {
      return size;
    }

    public int empty() {
      return size == 0 ? 1 : 0;
    }

    public int top() {
      return head == null ? -1 : head.data;
    }
  }

  public void setStack(BufferedReader br, Stack stack) throws Exception {
    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기

    //switch rules are not supported in -source 11
    switch (st.nextToken()) {
      case "push": stack.push(Integer.parseInt(st.nextToken())); break;
      case "pop": System.out.println(stack.pop()); break;
      case "size": System.out.println(stack.size()); break;
      case "empty": System.out.println(stack.empty()); break;
      case "top": System.out.println(stack.top()); break;
    }
  }

  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    Stack stack = new Stack();
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      setStack(br, stack);
    }
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_10828().result();
  }
}
