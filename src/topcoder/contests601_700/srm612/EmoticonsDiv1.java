package topcoder.contests601_700.srm612;

import java.util.ArrayDeque;
import java.util.Arrays;

public class EmoticonsDiv1 {

  public int printSmiles(int smiles) {
    int[][] dist = new int[2001][1000];
    final int oo = 0x70707070;
    for (int[] row : dist) Arrays.fill(row, oo);
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(1);
    queue.add(0);
    dist[1][0] = 0;
    while (queue.size() > 0) {
      int have = queue.pollFirst();
      int clip = queue.pollFirst();
      if ((have + clip <= 2 * smiles) && (dist[have + clip][clip] >= oo)) {
        dist[have + clip][clip] = dist[have][clip] + 1;
        queue.addLast(have + clip);
        queue.addLast(clip);
      }
      if (have < smiles && (dist[have][have] >= oo)) {
        dist[have][have] = dist[have][clip] + 1;
        queue.addLast(have);
        queue.addLast(have);
      }
      if (have > 1 && (dist[have - 1][clip] >= oo)) {
        dist[have - 1][clip] = dist[have][clip] + 1;
        queue.addLast(have - 1);
        queue.addLast(clip);
      }
    }
    int result = smiles;
    for (int c = 1; c < smiles; c++) {
      result = Math.min(result, dist[smiles][c]);
    }
    return result;
  }
}
