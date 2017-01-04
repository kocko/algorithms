package topcoder.contests701_800.srm704;

public class ConnectedComponentConstruction {
	
	private char[][] result;
	
	public String[] construct(int[] s) {
		int n = s.length;
		result = new char[n][n];
		boolean[] visited = new boolean[n];
		boolean ok = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				result[i][j] = 'N';
			}
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int[] mates = new int[s[i]];
				mates[0] = i;
				int idx = 1;
				for (int j = 0; j < n && idx < s[i]; j++) {
					if (i != j && !visited[j] && s[j] == s[i]) {
						visited[j] = true;
						mates[idx++] = j; 
					}
				}
				if (idx < s[i]) {
					ok = false;
					break;
				}
				connect(mates);
			}
		}
		String[] result;
		if (ok) {
			result = new String[n];
			for (int i = 0; i < n; i++) {
				result[i] = String.valueOf(this.result[i]);
			}
		} else {
			result = new String[0];
		}
		return result;
	}
	
	private void connect(int[] mates) {
		int n = mates.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				result[mates[i]][mates[j]] = 'Y';
				result[mates[j]][mates[i]] = 'Y';
			}
		}
	}
	
}
