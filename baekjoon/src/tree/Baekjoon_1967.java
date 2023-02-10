package tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_1967 {

  static class Node {
    int where;
    ArrayList<Integer> weight;
    ArrayList<Node> neighbor; // 0은 항상 부모

    Node(int weight, Node parent, int where) {
      this.weight = new ArrayList<>();
      this.neighbor = new ArrayList<>();
      this.where = where;
      this.weight.add(weight);
      this.neighbor.add(parent);
    }
  }

  static ArrayList<Node> leafList = new ArrayList<>();

  static void findLeaf(Node current) {
    if (current.neighbor.size() == 1) {
      leafList.add(current);
      return;
    }
    for (int i = 1; i < current.neighbor.size(); i++) {
      findLeaf(current.neighbor.get(i));
    }
  }

  static ArrayList<Integer> tempDiameters;

  static void checkDiameter(Node current, int weight, int where) {
    // 사작노드가 리프노드라 바로 끝남 -> checkDiameter.where을 추가함으로써 시작노드임을 거를수 있게됨
    if (where != -1 && current.neighbor.size() == 1) {
      tempDiameters.add(weight);
      return;
    }
    // 부모가 자기자신으로 돌아올 수도 있음, 자식이 부모로 돌아갈수도 있음
    // 자식이 자기가 몇번째 자식인지 모름 -> Node.where 추가
    // 부모가 자기 자식을 거를려면 이전 노드가 자신의 몇번쨰 자식였는지 확인하면됨, 자식 또한 자신의 부모를 거를려면 부몬지 확인하면 됨 -> checkDiameter.where 추가
    for (int i = 0; i < current.neighbor.size(); i++) {
      if (i == where || current.neighbor.get(i) == null) continue; // 자신을 호출한 자식이거나 현재 노드가 head면 부모가 없음으로 넘어감
      int currentWhere = i == 0 ? current.where : 0; // 부모로 가면 자신의 위치를 알려주고, 자식으로 가면 자신이 부모임을 알림
      checkDiameter(current.neighbor.get(i), weight + current.weight.get(i), currentWhere);
    }
  }

  static int diameter = 0;

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    StringTokenizer st = new StringTokenizer(str);

    int n = Integer.parseInt(st.nextToken());

    Node[] nodes = new Node[n];

    Node head = new Node(0, null, 0);
    nodes[0] = head;

    // 트리 초기화
    for (int i = 1; i < n; i++) {
      str = br.readLine();
      st = new StringTokenizer(str);
      int parent = Integer.parseInt(st.nextToken()) - 1; // 부모 노드 인덱스
      int child = Integer.parseInt(st.nextToken()) - 1; // 자식 노드 인덱스
      int weight = Integer.parseInt(st.nextToken()); // 부모 자식간 가중치

      Node newNode = new Node(weight, nodes[parent], nodes[parent].neighbor.size()); // 부모를 설정한 새로운 노드 생성

      nodes[parent].neighbor.add(newNode); // 부모 노드에 자식 노드 추가
      nodes[parent].weight.add(newNode.weight.get(0)); // 부모 노드에 자식 노드로 가는 간선의 가중치 추가
      nodes[child] = newNode; // 자식 노드 인덱스 위치에 노드 추가
    }

    findLeaf(head);

    for (Node leaf : leafList) {
      tempDiameters = new ArrayList<>();
      checkDiameter(leaf, 0, -1);
      diameter = Math.max(diameter, Collections.max(tempDiameters));
    }

    System.out.println(diameter);
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
