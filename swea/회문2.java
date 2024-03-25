import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        new Solution().run();
    }
 
    BufferedReader br;
    StringTokenizer st;
    StringBuilder sb;
 
    int result;
    int[][] P;
    char[][] table;
 
    void init() throws IOException {
        result = 0;
        table = new char[203][203];
 
        Arrays.fill(table[0], '$');
        for (int r = 1; r < 202; r++) Arrays.fill(table[r], '#');
        Arrays.fill(table[202], '%');
        for (int c = 1; c < 202; c++) {
            table[c][0] = '$';
            table[c][202] = '%';
        }
 
        for (int r = 0; r < 100; r++) {
            String line = br.readLine();
            for (int c = 0; c < 100; c++) table[r * 2 + 2][c * 2 + 2] = line.charAt(c);
        }
    }
 
    void run() throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int testCase = 1; testCase <= 10; testCase++) {
            testCase = Integer.parseInt(br.readLine());
            init();
            solution();
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
        br.close();
    }
 
    void solution() {
        P = new int[203][203];
        for (int r = 2; r < 202; r += 2) {
            int center = 0, right = 0;
            for (int c = 1; c < 202; c++) {
                int mirr = 2 * center - c;
                if (c < right) P[r][c] = Math.min(right - c, P[r][mirr]);
                while (table[r][c + P[r][c] + 1] == table[r][c - P[r][c] - 1]) P[r][c]++;
                if (c + P[r][c] > right) {
                    center = c;
                    right = c + P[r][c];
                }
            }
            for (int c = 1; c < 202; c++) result = Math.max(result, P[r][c]);
        }
 
        P = new int[203][203];
        for (int r = 2; r < 202; r += 2) {
            int center = 0, right = 0;
            for (int c = 1; c < 202; c++) {
                int mirr = 2 * center - c;
                if (c < right) P[r][c] = Math.min(right - c, P[r][mirr]);
                while (table[c + P[r][c] + 1][r] == table[c - P[r][c] - 1][r]) P[r][c]++;
                if (c + P[r][c] > right) {
                    center = c;
                    right = c + P[r][c];
                }
            }
            for (int c = 1; c < 202; c++) result = Math.max(result, P[r][c]);
        }
    }
}
