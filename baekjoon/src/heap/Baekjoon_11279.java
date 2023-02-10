package heap;

import java.io.*;
import java.util.ArrayList;

public class Baekjoon_11279 {
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static ArrayList<Integer> maxHeap;

  static void push(int value) {
    maxHeap.add(value);
    int currentIdx = maxHeap.size() - 1;
    while (currentIdx != 1) { // 최상단까지 올라가면 멈춤
      int parentIdx = currentIdx / 2; // 부모 인덱스는 항상 자식 인덱스 / 2
      int currentVal = maxHeap.get(currentIdx);
      int parentVal = maxHeap.get(parentIdx);
      if (!(parentVal < currentVal)) break; // 현재값이 부모값 보다 더 크지 않으면 종료
      maxHeap.set(currentIdx, parentVal); // 값 교환
      maxHeap.set(parentIdx, currentVal); // 값 교환
      currentIdx = parentIdx; // 부모 위치를 현재 위치로
    }
  }

  static int pop() {
    if (maxHeap.size() == 2) return maxHeap.remove(1); // 하나만 남았으면 바로 종료
    int result = maxHeap.get(1);
    maxHeap.set(1, maxHeap.remove(maxHeap.size() - 1)); // 가장 밑에 있던 노드를 가장 위로
    int currentIdx = 1;
    while (true) {
      int childIdx;
      if (currentIdx * 2 >= maxHeap.size()) { // 자식노드가 없으면
        break;
      } else if (currentIdx * 2 + 1 >= maxHeap.size()) { // 왼쪽 자식만 있으면
        childIdx = currentIdx * 2;
      } else {
        childIdx = maxHeap.get(currentIdx * 2) > maxHeap.get(currentIdx * 2 + 1) ? currentIdx * 2 : currentIdx * 2 + 1;
      }

      int currentVal = maxHeap.get(currentIdx);
      int childVal = maxHeap.get(childIdx);
      if (!(childVal > currentVal)) break; // 자식값이 현재값보다 더 크지 않으면 종료
      maxHeap.set(currentIdx, childVal); // 값 교환
      maxHeap.set(childIdx, currentVal); // 값 교환
      currentIdx = childIdx; // 자식위치를 현재위치로
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

    maxHeap = new ArrayList<>();
    maxHeap.add(-1); // index를 1부터 쓰기위한 깡통

    for (int i = 0; i < n; i++) {
      str = br.readLine();
      int value = Integer.parseInt(str);
      if (value == 0) {
        if (maxHeap.size() == 1) writeOnBuffer(0); // 비울게 없으면 0 반환
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
