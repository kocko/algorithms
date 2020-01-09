package topcoder.contests401_500.srm467;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class LateProfessor {

  public double getProbability(int waitTime, int walkTime, int lateTime, int bestArrival, int worstArrival) {
    int step = waitTime + walkTime;
    int lateInterval = walkTime - lateTime;
    if (lateInterval <= 0) {
      return 0.0;
    }
    int lateLength = 0;
    if (worstArrival == bestArrival) {
      for (int left = waitTime; left < worstArrival; left += step) {
        int right = left + lateInterval;
        if (worstArrival <= right) {
          return 1.0;
        }
      }
      return 0.0;
    }
    for (int left = waitTime; left < worstArrival; left += step) {
      int right = left + lateInterval;
      if (right < bestArrival) continue;
      lateLength += min(right, worstArrival) - max(left, bestArrival);
    }
    return (double) lateLength / (double) (worstArrival - bestArrival);
  }

}
