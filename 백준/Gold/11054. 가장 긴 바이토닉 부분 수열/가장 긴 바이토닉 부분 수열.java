import java.io.*;
import java.util.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int[] resultT = new int[N];
		int[] resultF = new int[N];

		Arrays.fill(resultT, 1);
		Arrays.fill(resultF, 1);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					resultT[i] = Integer.max(resultT[i], resultT[j] + 1);
				}
				if (arr[j] > arr[i]) {
					resultF[i] = Integer.max(resultF[i], Integer.max(resultT[j] + 1, resultF[j] + 1));
				}
			}
		}

		System.out.println(Integer.max(Arrays.stream(resultT).max().getAsInt(), Arrays.stream(resultF).max().getAsInt()));
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}