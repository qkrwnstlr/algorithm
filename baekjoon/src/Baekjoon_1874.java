import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1874 {
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


    public void push(int data) {
      Node newNode = new Node(data);
      newNode.next = head;
      head = newNode;
    }

    public int pop() {
      if (head == null) return -1;
      int result = head.data;
      head = head.next;
      return result;
    }
  }

  public void result() throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // 입력받기
    StringBuilder sb = new StringBuilder();

    Stack stack = new Stack();
    int now = 1;

    String str = br.readLine(); // 한줄씩 받기
    StringTokenizer st = new StringTokenizer(str); // " "를 기준으로 나눈기
    int n = Integer.parseInt(st.nextToken());

    for (var i = 0; i < n; i++) {
      str = br.readLine(); // 한줄씩 받기
      st = new StringTokenizer(str); // " "를 기준으로 나눈기
      int input = Integer.parseInt(st.nextToken());

      while (now <= input) { // push 할만큼 하기
        stack.push(now++);
        sb.append("+").append('\n');
      }
      if(stack.pop() == input){ // 출력해야하므로 pop하고 값 비교하기
        sb.append("-").append('\n');
      } else {
        sb.setLength(0);
        sb.append("NO").append('\n');
        break; // 조건에 벗어나면 바로 break 해줘야한다.
      }
    }
    System.out.println(sb);
    br.close();
  }

  public static void main(String[] args) throws Exception {
    new Baekjoon_1874().result();
  }
}
