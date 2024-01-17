import java.io.*;

public class Main {
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int n1 = s1.length();
		int n2 = s2.length();
		
		int[][] result = new int[n1 + 1][n2 + 1];
		
		for(int i = 1; i <= n1; i++) {
			for(int j = 1; j <= n2; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1)) {
					result[i][j] = result[i - 1][j - 1] + 1;
				} else {
					result[i][j] = Integer.max(result[i - 1][j], result[i][j - 1]);
				}
			}
		}
		
		System.out.println(result[n1][n2]);

		br.close();
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}