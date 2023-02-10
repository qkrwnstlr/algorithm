package heap;

import java.io.*;
import java.util.ArrayList;

public class Baekjoon_11286 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static ArrayList<Integer> minHeap;

  static void push(int value) {
    minHeap.add(value);
    int currentIdx = minHeap.size() - 1;
    while (currentIdx != 1) {
      int parentIdx = currentIdx / 2;
      int currentVal = minHeap.get(currentIdx);
      int parentVal = minHeap.get(parentIdx);
      if (Math.abs(parentVal) < Math.abs(currentVal)) break;
      if (Math.abs(parentVal) == Math.abs(currentVal) && parentVal < currentVal) break;
      minHeap.set(currentIdx, parentVal);
      minHeap.set(parentIdx, currentVal);
      currentIdx = parentIdx;
    }
  }

  static int pop() {
    if (minHeap.size() == 2) return minHeap.remove(1);
    int result = minHeap.get(1);
    minHeap.set(1, minHeap.remove(minHeap.size() - 1));
    int currentIdx = 1;
    while (true) {
      int childIdx;
      if (currentIdx * 2 >= minHeap.size()) {
        break;
      } else if (currentIdx * 2 + 1 >= minHeap.size()) {
        childIdx = currentIdx * 2;
      } else {
        int left = minHeap.get(currentIdx * 2);
        int right = minHeap.get(currentIdx * 2 + 1);
        if(Math.abs(left) < Math.abs(right)) {
          childIdx = currentIdx * 2;
        } else if(Math.abs(left) == Math.abs(right) && left < right) {
          childIdx = currentIdx * 2;
        } else childIdx = currentIdx * 2 + 1;
      }

      int currentVal = minHeap.get(currentIdx);
      int childVal = minHeap.get(childIdx);
      if (Math.abs(childVal) > Math.abs(currentVal)) break;
      if (Math.abs(childVal) == Math.abs(currentVal) && childVal > currentVal) break;
      minHeap.set(currentIdx, childVal);
      minHeap.set(childIdx, currentVal);
      currentIdx = childIdx;
    }
    return result;
  }

  static void writeOnBuffer(int value) throws IOException {
    bw.write(Integer.toString(value));
    bw.write("\n");
  }

  static void result() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String str = br.readLine();

    int n = Integer.parseInt(str);

    minHeap = new ArrayList<>();
    minHeap.add(-1);

    for (int i = 0; i < n; i++) {
      str = br.readLine();
      int value = Integer.parseInt(str);
      if (value == 0) {
        if (minHeap.size() == 1) writeOnBuffer(0);
        else {
          writeOnBuffer(pop());
        }
        continue;
      }
      push(value);
    }
    bw.flush();
  }

  public static void main(String[] args) throws IOException {
    result();
  }
}
