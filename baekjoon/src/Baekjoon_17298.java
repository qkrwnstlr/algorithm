import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_17298 {
  static class Stack {
    static class Node {
      private final int data;
      private Node next;
      private final int index;

      public Node(int data, int index) {
        this.data = data;
        this.next = null;
        this.index = index;
      }
    }

    private Node head;
    private int size;

    public Stack() {
      head = null;
      this.size = 0;
    }

    public void push(int data, int index) {
      Node newNode = new Node(data, index);
      newNode.next = head;
      head = newNode;
      size++;
    }

    public void pop() {
      if (head == null) return;
      head = head.next;
      size--;
    }

    public boolean empty() {
      return size == 0;
    }

    public Node top() {
      return head;
    }
  }

  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    StringBuilder sb = new StringBuilder();

    Stack stack = new Stack();

    int n = Integer.parseInt(br.readLine());
    int[] arr = new int[n];
    Arrays.fill(arr, -1);

    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기

    for (int i = 0; i < n; i++) {
      int input = Integer.parseInt(st.nextToken());
      while (!stack.empty() && stack.top().data < input) {
        arr[stack.top().index] = input;
        stack.pop();
      }
      stack.push(input, i);
    }

    for (int i = 0; i < n; i++) {
      sb.append(arr[i]).append(" ");
    }

    System.out.println(sb);
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_17298().result();
  }
}
