class Solution {
public int solution(int[][] board, int[][] skill) {
		int N = board.length;
		int M = board[0].length;
		int[][] temp = new int[N][M];

		for (int i = 0; i < skill.length; i++) {
			int degree = (skill[i][0] == 1 ? -1 : 1) * skill[i][5];
			int x1 = skill[i][1];
			int y1 = skill[i][2];
			int x2 = skill[i][3];
			int y2 = skill[i][4];

			temp[x1][y1] += degree;
			if (y2 != M - 1) {
				temp[x1][y2 + 1] -= degree;
			}
			if (x2 != N - 1) {
				temp[x2 + 1][y1] -= degree;
			}
			if (x2 != N - 1 && y2 != M - 1) {
				temp[x2 + 1][y2 + 1] += degree;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 1; j < M; j++) {
				temp[i][j] += temp[i][j - 1];
			}
		}

		for (int i = 0; i < M; i++) {
			for (int j = 1; j < N; j++) {
				temp[j][i] += temp[j - 1][i];
			}
		}

		int answer = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (board[i][j] + temp[i][j] > 0) {
					answer++;
				}
			}
		}

		return answer;
	}
}