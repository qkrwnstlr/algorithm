import java.io.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n + 1];
		arr[1] = arr[2] = 1;
		
		for(int i = 2; i <= n; i++) arr[i] = arr[i - 1] + arr[i - 2];
		
		System.out.println(arr[n] + " " + (n - 2));
		
		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}