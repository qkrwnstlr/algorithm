import java.io.*;
import java.util.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		int[] result = new int[N];
		Arrays.fill(result, 1);
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j]) {
					result[i] = Integer.max(result[i], result[j] + 1);
				}
			}
		}
		
		System.out.println(Arrays.stream(result).max().getAsInt());

		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}