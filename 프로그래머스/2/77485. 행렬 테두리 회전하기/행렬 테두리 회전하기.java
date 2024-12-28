import java.util.Arrays;

class Solution {
  public static void main(String[] args) {
    int rows = 6;
    int columns = 6;
    int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
    System.out.println(Arrays.toString(new Solution().solution(rows, columns, queries)));
  }

  public int[] solution(int rows, int columns, int[][] queries) {
    int[] answer = new int[queries.length];

    int[][] matrix = new int[rows][columns];

    for (int x = 0; x < rows; x++) {
      for (int y = 0; y < columns; y++) {
        matrix[x][y] = x * columns + y + 1;
      }
    }

    for (int i = 0; i < queries.length; i++) {

      int x1 = queries[i][0] - 1;
      int y1 = queries[i][1] - 1;
      int x2 = queries[i][2] - 1;
      int y2 = queries[i][3] - 1;

      int before = matrix[x1][y1];
      answer[i] = before;

      for (int y = y1 + 1; y <= y2; y++) {
        int temp = matrix[x1][y];
        matrix[x1][y] = before;
        before = temp;
        answer[i] = Math.min(answer[i], before);
      }

      for (int x = x1 + 1; x <= x2; x++) {
        int temp = matrix[x][y2];
        matrix[x][y2] = before;
        before = temp;
        answer[i] = Math.min(answer[i], before);
      }

      for (int y = y2 - 1; y >= y1; y--) {
        int temp = matrix[x2][y];
        matrix[x2][y] = before;
        before = temp;
        answer[i] = Math.min(answer[i], before);
      }

      for (int x = x2 - 1; x >= x1; x--) {
        int temp = matrix[x][y1];
        matrix[x][y1] = before;
        before = temp;
        answer[i] = Math.min(answer[i], before);
      }
    }

    return answer;
  }
}