import java.io.*;
import java.util.Arrays;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 0; test_case < T; test_case++) {
			int K = Integer.parseInt(br.readLine());
			int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

			
			int[][] result = new int[K][K];
			int[][] size  = new int[K][K];
			for(int i = 0; i < K; i++) size[i][i] = arr[i];
			
			for(int i = 1; i < K; i++) {
				for(int j = 0; j < K - i; j++) {
					int k = j + i;
					result[j][k] = Integer.MAX_VALUE;
					for(int l = j; l < k; l++) {
						size[j][k] = size[j][l] + size[l + 1][k];
						result[j][k] = Integer.min(result[j][k], result[j][l] + result[l + 1][k] + size[j][k]);
					}
				}
			}
			
			System.out.println(result[0][K - 1]);
		}

		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}