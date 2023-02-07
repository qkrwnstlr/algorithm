package stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_10773 {
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

    public Stack() {
      head = null;
    }

    public int push(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
      return data; // 더하기 뺴기에 쓸꺼라 data 반환
    }

    public int pop() {
      if (head == null) return 0; // 더하기 뺴기에 쓸꺼라 없으면 0
      int result = head.data;
      head = head.next;
      return result;
    }
  }

  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    Stack stack = new Stack();
    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기
    int n = Integer.parseInt(st.nextToken());

    int result = 0;

    for (int i = 0; i < n; i++) {
      str = br.readLine(); // 한줄씩 받기
      st = new StringTokenizer(str); // " "를 기준으로 나눈기
      int input = Integer.parseInt(st.nextToken());

      if (input == 0) result -= stack.pop();
      else result += stack.push(input);
    }

    System.out.println(result);
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_10773().result();
  }
}
