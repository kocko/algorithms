package topcoder.tco.tco2017.round1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class PingPongQueue {
	
	public int[] whoPlaysNext(int[] skills, int n, int k) {
		Queue<Integer> queue = new ArrayDeque<>();
		for (int i = 2; i < skills.length; i++) {
			queue.add(skills[i]);
		}
		int[] result = new int[] {skills[0], skills[1]};
		int count = 0;
		int winner = -1;
		for (int i = 1; i < k; i++) {
			int current = Math.max(result[0], result[1]);
			int loser = Math.min(result[0], result[1]);
			if (current == winner) {
				count++;
				winner = current;
			} else {
				winner = current;
				count = 1;
			}
			if (count == n) {
				queue.offer(loser);
				queue.offer(winner);
				result[0] = queue.poll();
				result[1] = queue.poll();
			} else {
				queue.offer(loser);
				result[0] = winner;
				result[1] = queue.poll();
			}
		}
		Arrays.sort(result);
		return result;
	}
}
