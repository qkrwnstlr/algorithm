import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
  BufferedReader br;
  StringTokenizer st;
  int N, M, result;
  List<Integer> houseList, chickenList;
  List<List<Distance>> distancesList;
  List<Set<Integer>> combList;
  int[][] table;
  boolean[] visited;

  void init() throws IOException {
    result = Integer.MAX_VALUE;
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    table = new int[N][N];
    houseList = new ArrayList<>();
    chickenList = new ArrayList<>();
    for (int x = 0; x < N; x++) {
      st = new StringTokenizer(br.readLine());
      for (int y = 0; y < N; y++) {
        table[x][y] = Integer.parseInt(st.nextToken());
        if (table[x][y] == 1) houseList.add(x * N + y);
        if (table[x][y] == 2) chickenList.add(x * N + y);
      }
    }
    distancesList = new ArrayList<>();
    for (int i = 0; i < houseList.size(); i++) {
      int hx = houseList.get(i) / N;
      int hy = houseList.get(i) % N;
      ArrayList<Distance> distances = new ArrayList<>();
      for (int j = 0; j < chickenList.size(); j++) {
        int cx = chickenList.get(j) / N;
        int cy = chickenList.get(j) % N;
        distances.add(new Distance(chickenList.get(j), Math.abs(hx - cx) + Math.abs(hy - cy)));
      }
      distances.sort(Distance::compareTo);
      distancesList.add(distances);
    }
    visited = new boolean[chickenList.size()];
    combList = new ArrayList<>();
  }

  public static void main(String[] args) throws Exception {
    new Main().run();
  }

  void run() throws IOException {
    br = new BufferedReader(new InputStreamReader(System.in));
    init();
    solution();
    System.out.println(result);
  }

  void solution() {
    combination(0, 0);
    for (int i = 0; i < combList.size(); i++) {
      int temp = 0;
      for (int j = 0; j < houseList.size(); j++) {
        temp += getMinDistance(distancesList.get(j), combList.get(i));
      }
      result = Math.min(temp, result);
    }
  }


  void combination(int start, int depth) {
    if (depth == M) {
      Set<Integer> comb = new HashSet<>();
      for (int i = 0; i < chickenList.size(); i++) {
        if (visited[i]) comb.add(chickenList.get(i));
      }
      combList.add(comb);
      return;
    }
    for (int i = start; i < chickenList.size(); i++) {
      visited[i] = true;
      combination(i + 1, depth + 1);
      visited[i] = false;
    }
  }

  int getMinDistance(List<Distance> distances, Set<Integer> comb) {
    for (int i = 0; i < distances.size(); i++) {
      Distance distance = distances.get(i);
      if (comb.contains(distance.cId)) return distance.value;
    }
    return -1;
  }
}

class Distance implements Comparable<Distance> {
  int cId, value;

  Distance(int cId, int value) {
    this.cId = cId;
    this.value = value;
  }

  @Override
  public int compareTo(Distance o) {
    return this.value - o.value;
  }
}
