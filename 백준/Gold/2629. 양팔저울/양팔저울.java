import java.io.*;
import java.util.Arrays;

public class Main {
	int N, M, MAX_WEIGHT = 15000;
	int[] chus, beads;
	boolean[][] result;

	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		chus = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		M = Integer.parseInt(br.readLine());
		beads = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		result = new boolean[N + 1][MAX_WEIGHT + 1];
		
		setResult(0, 0);
		
		StringBuilder sb = new StringBuilder();
		
		for (int bead : beads) {
			if (bead <= MAX_WEIGHT && result[N][bead]) sb.append("Y").append(" ");
			else sb.append("N").append(" ");
		}
		
		System.out.println(sb);

		br.close();
	}
	
	void setResult(int cIndex, int weight) {
		if(result[cIndex][weight]) return;
		result[cIndex][weight] = true;
		if (cIndex >= N) return;
		
		setResult(cIndex + 1, weight + chus[cIndex]); // 구슬 반대 쪽에 놓은 경우
		setResult(cIndex + 1, weight); // 사용 안한 경우
		setResult(cIndex + 1, Math.abs(weight - chus[cIndex])); // 구슬 쪽에 놓은 경우
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}