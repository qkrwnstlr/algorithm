import java.util.*;

class Main {
  static int N;
  static int M;
  static StringBuilder sb = new StringBuilder();
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    N = sc.nextInt();
    M = sc.nextInt();
    dfs(0, new ArrayList<>());
    System.out.println(sb);
  }

  static void dfs(int depth, ArrayList<Integer> list) {
    if(depth == M) {
      for(int i : list) sb.append(i).append(" ");
      sb.append("\n");
      return;
    }
    for(int i = 1; i <= N; i++) {
      if(list.contains(i)) continue;
      ArrayList<Integer> temp = (ArrayList<Integer>) list.clone();
      temp.add(i);
      dfs(depth + 1, temp);
    }
  }
}