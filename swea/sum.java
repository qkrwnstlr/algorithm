import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution {
    BufferedReader br;
    StringBuilder sb;
    StringTokenizer st;
 
    int size;
    int[][] table;
    int[] sum;
 
    void solution() throws IOException {
        size = 100;
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
 
        int TC = 10;
        for (int testCase = 1; testCase <= TC; testCase++) {
            testCase = Integer.parseInt(br.readLine());
            size = 100;
            table = new int[size][];
            sum = new int[size * 2 + 2];
 
            for (int i = 0; i < size; i++) {
                table[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
 
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    sum[i] += table[i][j];
                    sum[i + size] += table[j][i];
                }
            }
 
            for (int i = 0; i < size; i++) {
                sum[size * 2] += table[i][i];
                sum[size * 2 + 1] += table[i][size - 1 - i];
            }
 
            int result = Arrays.stream(sum).max().getAsInt();
 
            sb.append("#").append(testCase).append(" ").append(result).append("\n");
        }
 
        System.out.println(sb);
    }
 
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}
