import java.io.*;
import java.util.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());
		
		int[] arr = new int[X + 1];
		Arrays.fill(arr, Integer.MAX_VALUE);
		arr[0] = 0;
		arr[1] = 0;
		
		for(int i = 2; i <= X; i++) {
			if(i % 3 == 0) arr[i] = Integer.min(arr[i], arr[i / 3]);
			if(i % 2 == 0) arr[i] = Integer.min(arr[i], arr[i / 2]);
			arr[i] = Integer.min(arr[i], arr[i - 1]) + 1;
		}
		
		System.out.println(arr[X]);
		
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}
