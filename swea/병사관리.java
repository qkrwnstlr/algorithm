import java.util.ArrayList;
import java.util.List;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  private final static int CMD_INIT = 1;
  private final static int CMD_HIRE = 2;
  private final static int CMD_FIRE = 3;
  private final static int CMD_UPDATE_SOLDIER = 4;
  private final static int CMD_UPDATE_TEAM = 5;
  private final static int CMD_BEST_SOLDIER = 6;

  private final static UserSolution usersolution = new UserSolution();

  private static boolean run(BufferedReader br) throws Exception {
    StringTokenizer st;

    int numQuery;

    int mID, mTeam, mScore, mChangeScore;

    int userAns, ans;

    boolean isCorrect = false;

    numQuery = Integer.parseInt(br.readLine());

    for (int q = 0; q < numQuery; ++q) {
      st = new StringTokenizer(br.readLine(), " ");

      int cmd;
      cmd = Integer.parseInt(st.nextToken());

      switch (cmd) {
        case CMD_INIT:
          usersolution.init();
          isCorrect = true;
          break;
        case CMD_HIRE:
          mID = Integer.parseInt(st.nextToken());
          mTeam = Integer.parseInt(st.nextToken());
          mScore = Integer.parseInt(st.nextToken());
          usersolution.hire(mID, mTeam, mScore);
          break;
        case CMD_FIRE:
          mID = Integer.parseInt(st.nextToken());
          usersolution.fire(mID);
          break;
        case CMD_UPDATE_SOLDIER:
          mID = Integer.parseInt(st.nextToken());
          mScore = Integer.parseInt(st.nextToken());
          usersolution.updateSoldier(mID, mScore);
          break;
        case CMD_UPDATE_TEAM:
          mTeam = Integer.parseInt(st.nextToken());
          mChangeScore = Integer.parseInt(st.nextToken());
          usersolution.updateTeam(mTeam, mChangeScore);
          break;
        case CMD_BEST_SOLDIER:
          mTeam = Integer.parseInt(st.nextToken());
          userAns = usersolution.bestSoldier(mTeam);
          ans = Integer.parseInt(st.nextToken());
          if (userAns != ans) {
            isCorrect = false;
          }
          break;
        default:
          isCorrect = false;
          break;
      }
    }

    return isCorrect;
  }

  public static void main(String[] args) throws Exception {
    int TC, MARK;

    System.setIn(new java.io.FileInputStream("res/sample_25_input.txt"));

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    TC = Integer.parseInt(st.nextToken());
    MARK = Integer.parseInt(st.nextToken());

    for (int testcase = 1; testcase <= TC; ++testcase) {
      int score = run(br) ? MARK : 0;
      System.out.println("#" + testcase + " " + score);
    }

    br.close();
  }
}

class UserSolution {
  static int MAX_TEAM = 5;
  static int MAX_SCORE = 5;
  static int MAX_SOLDIER = 100000;
  List<List<LinkedList>> teams;
  List<Node<Soldier>> nodePool;

  public void init() {
    nodePool = new ArrayList<>();
    for (int i = 0; i <= MAX_SOLDIER; i++) {
      nodePool.add(new Node<>());
    }
    teams = new ArrayList<>();
    for (int i = 0; i <= MAX_TEAM; i++) {
      List<LinkedList> newTeam = new ArrayList<>();
      for (int j = 0; j <= MAX_SCORE; j++) {
        newTeam.add(new LinkedList(nodePool));
      }
      teams.add(newTeam);
    }
  }

  public void hire(int id, int teamId, int score) {
    this.teams.get(teamId).get(score).add(new Soldier(id, teamId));
  }

  public void fire(int id) {
    Node<Soldier> node = nodePool.get(id);
    if (node.next != null) {
      node.before.next = node.next;
      node.next.before = node.before;
    } else {
      List<LinkedList> team = teams.get(node.value.team);
      for (int i = 1; i <= MAX_SCORE; i++) {
        LinkedList soldiers = team.get(i);
        if (soldiers.tail != null && soldiers.tail.value.compareTo(node.value) == 0) {
          node.before.next = null;
          if (node.before.value == null) {
            soldiers.tail = null;
          } else {
            soldiers.tail = node.before;
          }
        }
      }
    }
    nodePool.set(id, new Node<>());
  }

  public void updateSoldier(int id, int score) {
    Soldier value = nodePool.get(id).value;
    fire(id);
    hire(id, value.team, score);
  }

  public void updateTeam(int teamId, int score) {
    List<LinkedList> team = teams.get(teamId);
    List<LinkedList> newTeam = new ArrayList<>();
    for (int i = 0; i <= MAX_TEAM; i++) {
      newTeam.add(new LinkedList(nodePool));
    }
    for (int i = 1; i <= MAX_SCORE; i++) {
      LinkedList soldiers = team.get(i);
      int targetScore = Math.max(Math.min(i + score, 5), 1);
      newTeam.get(targetScore).insert(soldiers);
    }
    teams.set(teamId, newTeam);
  }

  public int bestSoldier(int teamId) {
    List<LinkedList> team = teams.get(teamId);
    int id = -1;
    for (int i = MAX_SCORE; i > 0; i--) {
      Node<Soldier> current = team.get(i).header.next;
      while (current != null) {
        id = Math.max(current.value.id, id);
        current = current.next;
      }
      if (id != -1) return id;
    }
    return id;
  }
}

class LinkedList {
  Node<Soldier> header;
  Node<Soldier> tail;
  List<Node<Soldier>> nodePool;

  LinkedList(List<Node<Soldier>> nodePool) {
    this.header = new Node<>();
    this.nodePool = nodePool;
  }

  void add(Soldier value) {
    Node<Soldier> node = nodePool.get(value.id);
    node.value = value;
    node.next = this.header.next;
    if (this.header.next != null) {
      this.header.next.before = node;
    } else {
      this.tail = node;
    }
    node.before = this.header;
    this.header.next = node;
  }

  void insert(LinkedList list) {
    if (list.tail == null) return;
    if (this.tail == null) {
      this.tail = list.tail;
    } else {
      list.tail.next = this.header.next;
      this.header.next.before = list.tail;
    }
    this.header.next = list.header.next;
    list.header.next.before = this.header;
  }
}

class Node<T extends Comparable<T>> {
  T value;
  Node<T> next;
  Node<T> before;

  Node() {
  }
}

class Soldier implements Comparable<Soldier> {
  int id;
  int team;

  Soldier(int id, int team) {
    this.id = id;
    this.team = team;
  }

  @Override
  public int compareTo(Soldier o) {
    return this.id - o.id;
  }
}
