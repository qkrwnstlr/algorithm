import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue();
        
        for (String operation: operations) {
            StringTokenizer st = new StringTokenizer(operation);
            if (st.nextToken().equals("I")) {
                int input = Integer.parseInt(st.nextToken());
                maxHeap.add(input);
                minHeap.add(input);
            } else {
                if(maxHeap.isEmpty()) continue;
                if (st.nextToken().equals("1")) {
                    int output = maxHeap.poll();
                    minHeap.remove(output);
                } else {
                    int output = minHeap.poll();
                    maxHeap.remove(output);                    
                }
            }
        }
        
        if(maxHeap.isEmpty()) return new int[] {0, 0};
        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}