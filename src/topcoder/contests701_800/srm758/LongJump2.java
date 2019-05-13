package topcoder.contests701_800.srm758;

public class LongJump2 {

  public int countNewLeaders(int n, int[] x) {
    int currentLeader = -1;
    int currentBest = -1;
    int answer = 0;
    int nextJump = 0;
    for (int round = 1; round <= 3; ++round) {
      for (int jumper = 1; jumper <= n; ++jumper) {
        int currentJump = x[nextJump++];
        if (currentJump > currentBest) {
          currentBest = currentJump;
          if (currentLeader != jumper) {
            currentLeader = jumper;
            ++answer;
          }
        }
      }
    }
    return answer;
  }

}
