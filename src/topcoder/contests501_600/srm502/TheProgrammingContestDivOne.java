package topcoder.contests501_600.srm502;

import java.util.Arrays;

public class TheProgrammingContestDivOne {

  private class Problem implements Comparable<Problem> {
    private int max, time, penalty;

    private Problem(int max, int time, int penalty) {
      this.max = max;
      this.time = time;
      this.penalty = penalty;
    }

    @Override
    public int compareTo(Problem problem) {
      return Long.compare(time * (long) problem.penalty, problem.time * (long) penalty);
    }
  }

  public int find(int t, int[] max, int[] penalty, int[] time) {
    this.n = max.length;
    this.t = t;
    problems = new Problem[n];
    for (int i = 0; i < n; i++) {
      problems[i] = new Problem(max[i], time[i], penalty[i]);
    }
    Arrays.sort(problems);
    dp = new Integer[n][t + 1];
    return recurse(0, 0);
  }

  private int n, t;
  private Problem[] problems;
  private Integer[][] dp;

  private int recurse(int idx, int time) {
    if (idx == n) return 0;
    if (dp[idx][time] != null) return dp[idx][time];
    int ans = 0;
    if (time + problems[idx].time <= t) {
      if ((time + problems[idx].time) * (long) problems[idx].penalty <= problems[idx].max) {
        int points = problems[idx].max - (time + problems[idx].time) * problems[idx].penalty;
        ans = points + recurse(idx + 1, time + problems[idx].time);
      }
    }
    ans = Math.max(ans, recurse(idx + 1, time));
    return dp[idx][time] = ans;
  }

  public static void main(String[] args) {
    int t = 40000;
    int[] max = {100000,100000};
    int[] penalty = {1, 100000};
    int[] time = {50000, 30000};
    System.out.println(new TheProgrammingContestDivOne().find(t, max, penalty, time));
  }
}
