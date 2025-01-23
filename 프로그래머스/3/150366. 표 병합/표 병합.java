  import java.util.ArrayList;
  import java.util.List;
  import java.util.StringTokenizer;
  
  class Solution {
    String[][] matrix;
    Point[][] points;
    List<String> answer;
  
    public String[] solution(String[] commands) {
      init();
  
      for (int i = 0; i < commands.length; i++) {
        StringTokenizer st = new StringTokenizer(commands[i]);
        switch (st.nextToken()) {
          case "UPDATE":
            String temp1 = st.nextToken(), temp2 = st.nextToken();
            if (st.hasMoreTokens()) update(Integer.parseInt(temp1), Integer.parseInt(temp2), st.nextToken());
            else update(temp1, temp2);
            break;
          case "MERGE":
            merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            break;
          case "UNMERGE":
            unmerge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            break;
          case "PRINT":
            print(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            break;
        }
      }
  
      return answer.toArray(String[]::new);
    }
  
    void init() {
      matrix = new String[51][51];
      points = new Point[51][51];
      for (int i = 1; i <= 50; i++) {
        for (int j = 1; j <= 50; j++) {
          points[i][j] = new Point(i, j);
        }
      }
      answer = new ArrayList<>();
    }
  
    void update(int r, int c, String value) {
      Point p = find(new Point(r, c));
      matrix[p.r][p.c] = value;
    }
  
    void update(String before, String after) {
      for (int i = 1; i <= 50; i++) {
        for (int j = 1; j <= 50; j++) {
          Point p = find(new Point(i, j));
          if (matrix[p.r][p.c] != null && matrix[p.r][p.c].equals(before)) matrix[p.r][p.c] = after;
        }
      }
    }
  
    void merge(int r1, int c1, int r2, int c2) {
      Point p1 = find(new Point(r1, c1)), p2 = find(new Point(r2, c2));
      if (matrix[p1.r][p1.c] == null && matrix[p2.r][p2.c] != null) union(new Point(r2, c2), new Point(r1, c1));
      else union(new Point(r1, c1), new Point(r2, c2));
    }
  
    void unmerge(int r, int c) {
      Point p = find(new Point(r, c));
      String temp = matrix[p.r][p.c];
  
      for (int i = 1; i <= 50; i++) {
        for (int j = 1; j <= 50; j++) {
          find(new Point(i, j));
        }
      }
  
      for (int i = 1; i <= 50; i++) {
        for (int j = 1; j <= 50; j++) {
          if (find(new Point(i, j)).equals(points[p.r][p.c])) {
            points[i][j] = new Point(i, j);
            matrix[i][j] = i == r && j == c ? temp : null;
          }
        }
      }
    }
  
    void print(int r, int c) {
      Point p = find(new Point(r, c));
      answer.add(matrix[p.r][p.c] == null ? "EMPTY" : matrix[p.r][p.c]);
    }
  
    private void union(Point p1, Point p2) {
      p1 = find(p1);
      p2 = find(p2);
      if (!p1.equals(p2)) {
        matrix[p2.r][p2.c] = null;
        points[p2.r][p2.c] = p1;
      }
    }
  
    private Point find(Point p) {
      if (p.equals(points[p.r][p.c])) return p;
      else return points[p.r][p.c] = find(points[p.r][p.c]);
    }
  }
  
  class Point {
    int r, c;
  
    Point(int r, int c) {
      this.r = r;
      this.c = c;
    }
  
    boolean equals(Point p) {
      return this.r == p.r && this.c == p.c;
    }
  }