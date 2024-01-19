import java.io.*;
import java.util.Arrays;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		int[][] result = new int[N][N];

		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		for (int i = 1; i < N; i++) {
			for (int j = 0; j < N - i; j++) {
				int k = i + j;
				result[j][k] = Integer.MAX_VALUE;
				for (int l = j; l < k; l++) {
					result[j][k] = Integer.min(result[j][k], result[j][l] + result[l + 1][k] + arr[j][0] * arr[l + 1][0] * arr[k][1]);
				}
			}
		}
		
		System.out.println(result[0][N - 1]);

		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}