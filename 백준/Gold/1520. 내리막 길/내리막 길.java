import java.io.*;
import java.util.Arrays;

public class Main {
	int M;
	int N;
	int[] dx = {0, 0, -1, 1};
	int[] dy = {-1, 1, 0, 0};
	
	int[][] arr;
	int[][] result;
	
	public void result() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] temp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		
		M = temp[0];
		N = temp[1];
		arr = new int[M][N];
		result = new int[M][N];
		
		for(int i = 0; i < M; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		Arrays.stream(result).forEach(e -> Arrays.fill(e, -1));
		
		System.out.println(move(0, 0));
		
		br.close();
	}
	
	public int move(int x, int y) {
		if(x == M - 1 && y == N - 1) return result[x][y] = 1;
		if(result[x][y] != -1) return result[x][y];
		result[x][y] = 0;
		for(int i = 0; i < dx.length; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if(isAble(nx, ny) && arr[x][y] > arr[nx][ny]) {
				result[x][y] += move(nx, ny);
			}
		}
		return result[x][y];
	}
	
	public boolean isAble(int x, int y) {
		return x >= 0 && x < M && y >= 0 && y < N;
	}

	public static void main(String[] args) throws IOException {
		new Main().result();
	}
}