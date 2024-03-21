import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		new Main().run();
	}

	BufferedReader br;
	StringTokenizer st;
	int[][] table;
	boolean[][] rSets, cSets, bSets;

	void init() throws IOException {
		table = new int[9][9];
		rSets = new boolean[9][10];
		cSets = new boolean[9][10];
		bSets = new boolean[9][10];

		for (int r = 0; r < 9; r++) {
			String line = br.readLine();
			for (int c = 0; c < 9; c++) {
				table[r][c] = line.charAt(c) - '0';
				if (table[r][c] == 0) continue;
				rSets[r][table[r][c]] = true;
				cSets[c][table[r][c]] = true;
				bSets[(r / 3) * 3 + c / 3][table[r][c]] = true;
			}
		}
	}

	void run() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

		init();
		solution();

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(table[i][j]);
			}
			System.out.println();
		}
	}

	void solution() {
		setValue(0);
	}

	boolean setValue(int index) {
		if (index == 9 * 9) return true;
		int r = index / 9;
		int c = index % 9;
		if (table[r][c] != 0) return setValue(index + 1);
		for (int i = 1; i <= 9; i++) {
			if (rSets[r][i] || cSets[c][i] || bSets[(r / 3) * 3 + c / 3][i]) continue;
			rSets[r][i] = true;
			cSets[c][i] = true;
			bSets[(r / 3) * 3 + c / 3][i] = true;
			table[r][c] = i;
			if (!setValue(index + 1)) {
				rSets[r][i] = false;
				cSets[c][i] = false;
				bSets[(r / 3) * 3 + c / 3][i] = false;
				table[r][c] = 0;
			} else {
				return true;
			}
		}
		return false;
	}
}
