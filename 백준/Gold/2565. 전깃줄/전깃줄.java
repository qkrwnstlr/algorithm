import java.io.*;
import java.util.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];

		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		Arrays.sort(arr, Comparator.comparingInt(e -> e[0]));

		int[] temp = new int[N];
		Arrays.fill(temp, 1);
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i][1] > arr[j][1]) {
					temp[i] = Math.max(temp[i], temp[j] + 1);
				}
			}
			max = Math.max(max, temp[i]);
		}
		
		System.out.println(N - max);

		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}
