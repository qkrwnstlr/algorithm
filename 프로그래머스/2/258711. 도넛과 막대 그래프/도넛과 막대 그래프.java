import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
  public int[] solution(int[][] edges) {
    initGraph(edges);

    int newNode = findNewNode();

    int total = removeNode(newNode);

    int[] answer = classifyGraph();
    answer[0] = newNode;
    answer[1] = total - answer[2] - answer[3];

    return answer;
  }

  int N;
  Map<Integer, Set<Integer>> graph;
  Map<Integer, Set<Integer>> reverseGraph;

  private void initGraph(int[][] edges) {
    graph = new HashMap<>();
    reverseGraph = new HashMap<>();
    for (int[] edge : edges) {
      if (!graph.containsKey(edge[0])) graph.put(edge[0], new HashSet<>());
      if (!graph.containsKey(edge[1])) graph.put(edge[1], new HashSet<>());
      graph.get(edge[0]).add(edge[1]);

      if (!reverseGraph.containsKey(edge[0])) reverseGraph.put(edge[0], new HashSet<>());
      if (!reverseGraph.containsKey(edge[1])) reverseGraph.put(edge[1], new HashSet<>());
      reverseGraph.get(edge[1]).add(edge[0]);
    }

    N = graph.size();
  }

  private int findNewNode() {
    for (int i : reverseGraph.keySet()) {
      if (reverseGraph.get(i).isEmpty() && graph.get(i).size() > 1) return i;
    }
    return -1;
  }

  private int removeNode(int node) {
    int count = graph.get(node).size();

    graph.values().forEach(it -> it.remove(node));
    graph.remove(node);

    reverseGraph.values().forEach(it -> it.remove(node));
    reverseGraph.remove(node);

    return count;
  }

  private int[] classifyGraph() {
    int[] count = new int[4];

    for (Set<Integer> nodes : graph.values()) {
      if (nodes.isEmpty()) count[2]++;
      if (nodes.size() == 2) count[3]++;
    }

    return count;
  }
}