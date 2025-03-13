import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
  public static void main(String[] args) {
//    int[][] jobs = {{0, 3}, {1, 9}, {3, 5}};
    int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
    System.out.println(new Solution().solution(jobs));
  }

  public int solution(int[][] jobs) {
    PriorityQueue<int[]> disk = new PriorityQueue<>((o1, o2) -> o1[1] == o2[1] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]));

    PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

    pq.addAll(Arrays.asList(jobs));

    int current, total = 0;

    while (!pq.isEmpty()) {
      current = pq.peek()[0];
      while (!pq.isEmpty() && pq.peek()[0] <= current) disk.add(pq.poll());
      while (!disk.isEmpty()) {
        int[] job = disk.poll();
        if (current < job[0]) current = job[0];
        total += (current += job[1]) - job[0];
        while (!pq.isEmpty() && pq.peek()[0] <= current) disk.add(pq.poll());
      }
    }

    return total / jobs.length;
  }
}
