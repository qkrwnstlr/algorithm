package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Baekjoon_1068 {
  static class Node {
    int parent;
    int index;
    ArrayList<Node> children;

    Node(int index, int parent) {
      // 부모가 먼저 선언이 안될수도 있다 -> where을 지정할 수 없다. -> where 삭제
      // 부모가 먼저 선언이 안될수도 있다 -> 부모를 지정할 수 없다 -> neighbor을 children으로 수정
      // 부모가 먼저 선언이 안될수도 있다 -> 부모를 찾을 수 없다. -> 탐색으로 몇번쨰 index인지 찾아야한다 -> index 추가
      this.index = index;
      this.parent = parent;
      children = new ArrayList<>();
    }
  }

  static ArrayList<Node> leafList = new ArrayList<>();

  static void findLeaf(Node current) {
    if (current.children.size() == 0) {
      leafList.add(current);
      return;
    }
    for (int i = 0; i < current.children.size(); i++) { // 부모는 더이상 leaf노드가 될수 없으므로 0은 제외
      findLeaf(current.children.get(i));
    }
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[n];

    str = br.readLine();
    st = new StringTokenizer(str);

    ArrayList<ArrayList<Node>> childrenList = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      childrenList.add(new ArrayList<>());
    }

    int head = 0;

    // 트리 초기화
    for (int i = 0; i < n; i++) {
      int parent = Integer.parseInt(st.nextToken()); // 부모 노드 인덱스
      Node newNode = new Node(i, parent); // 부모를 설정한 새로운 노드 생성
      nodes[i] = newNode; // 자식 노드 인덱스 위치에 노드 추가
      if (parent == -1) head = i; // 루트 노드면 루트로 지정
      else childrenList.get(parent).add(newNode); // 자식 노드면 부모의 자식으로 지정
    }

    for (int i = 0; i < n; i++) { // 자식 노드 지정
      nodes[i].children = childrenList.get(i);
    }

    str = br.readLine();
    st = new StringTokenizer(str);
    int remove = Integer.parseInt(st.nextToken());

    if (remove == head) {
      System.out.println(0);
      return;
    }

    Node parent = nodes[nodes[remove].parent];

    for (int i = 0; i < parent.children.size(); i++) {
      if (parent.children.get(i).index == remove) { // remove할 노드 삭제
        parent.children.remove(i);
        break;
      }
    }

    findLeaf(nodes[head]);

    System.out.println(leafList.size());
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
