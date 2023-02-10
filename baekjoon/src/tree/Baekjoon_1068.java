package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_1068 {
  static class Node {
    int where;
    ArrayList<Node> neighbor; // 0은 항상 부모

    Node(Node parent) {
      this.neighbor = new ArrayList<>();
      this.where = parent == null ? 0 : parent.neighbor.size();
      this.neighbor.add(parent);
    }
  }

  static ArrayList<Node> leafList = new ArrayList<>();

  static void findLeaf(Node current) {
    if (current == null) return;
    if (current.neighbor.size() == 1) {
      leafList.add(current);
      return;
    }
    for (int i = 1; i < current.neighbor.size(); i++) { // 부모는 더이상 leaf노드가 될수 없으므로 0은 제외
      findLeaf(current.neighbor.get(i));
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[n];

    Node head = new Node(null);
    nodes[0] = head;


    str = br.readLine();
    st = new StringTokenizer(str);

    // 트리 초기화
    for (int i = 0; i < n; i++) {
      int parent = Integer.parseInt(st.nextToken()); // 부모 노드 인덱스
      if (parent == -1) continue;

      Node newNode = new Node(nodes[parent]); // 부모를 설정한 새로운 노드 생성

      nodes[parent].neighbor.add(newNode); // 부모 노드에 자식 노드 추가
      nodes[i] = newNode; // 자식 노드 인덱스 위치에 노드 추가
    }

    str = br.readLine();
    st = new StringTokenizer(str);
    int index = Integer.parseInt(st.nextToken());

    Node parent = nodes[index].neighbor.get(0);

    if (parent == null) head = null;
    else parent.neighbor.set(nodes[index].where, null);

    findLeaf(head);

    System.out.println(leafList.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
