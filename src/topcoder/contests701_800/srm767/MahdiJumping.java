package topcoder.contests701_800.srm767;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MahdiJumping {

  public long minDis(int n, int A, int B, int a, int b) {
    long[] dist = new long[n];
    for (int i = 0; i < n; i++) {
      dist[i] = Long.MAX_VALUE;
    }
    PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingLong(e -> e.weight));
    queue.offer(new Edge(0, 0));
    dist[0] = 0;
    while (queue.size() > 0) {
      Edge top = queue.poll();
      int x = top.to;
      if (x == n - 1) break;
      int next = (int) (((long) A * x + B) % n);
      if (dist[next] > dist[x] + b) {
        dist[next] = dist[x] + b;
        queue.offer(new Edge(next, dist[next]));
      }
      next = x + 1;
      if (next == n - 1) {
        dist[next] = Math.min(dist[next], dist[x] + a);
      } else {
        if (dist[next] > dist[x] + a) {
          dist[next] = dist[x] + a;
          queue.offer(new Edge(next, dist[next]));
        }
      }
    }
    return dist[n - 1];
  }

  private class Edge {
    private int to;
    private long weight;

    private Edge(int to, long weight) {
      this.to = to;
      this.weight = weight;
    }
  }
}
