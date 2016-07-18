package topcoder.contests300_400.srm313;

public class CyclesInPermutations {
	
	public int maxCycle(int[] board) {
        int n = board.length;
		boolean[] visited = new boolean[n];
        int total = 0;
        int result = 0;
        while (total < n) {
            int start = 0;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    start = i;
                    break;
                }
            }
            int count = 0;
            while (!visited[start]) {
                count++;
                visited[start] = true;
                start = board[start] - 1;
            }
            total += count;
            result = Math.max(result, count);
        }
        return result;
	}
}
