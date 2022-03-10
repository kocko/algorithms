package codeforces.contests1601_1700.problemset1650;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.min;

public class VitalyAndAdvancedUselessAlgorithms implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public VitalyAndAdvancedUselessAlgorithms() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  private class Training {
    private int idx, time, percentage;

    private Training(int idx, int time, int percentage) {
      this.idx = idx;
      this.time = time;
      this.percentage = percentage;
    }
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      n = in.ni();
      m = in.ni();
      trainingsPerTask = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        trainingsPerTask.add(new ArrayList<>());
      }
      a = new long[n];
      for (int i = 0; i < n; i++) {
        a[i] = in.ni();
      }
      for (int i = 0; i < m; i++) {
        trainingsPerTask.add(new ArrayList<>());
      }
      for (int i = 0; i < m; i++) {
        int task = in.ni() - 1, timeToComplete = in.ni(), percent = in.ni();
        trainingsPerTask.get(task).add(new Training(i + 1, timeToComplete, percent));
      }
      List<Integer> result = new ArrayList<>();
      long currentTime = 0;
      task = 0;
      boolean possible = true;
      while (task < n) {
        int tasks = trainingsPerTask.get(task).size();
        dp = new long[tasks][101];
        for (int i = 0; i < tasks; i++) {
          for (int j = 0; j <= 100; j++) {
            dp[i][j] = -1;
          }
        }
        next = new int[tasks][101];
        long optimal = recurse(0, 0);
        if (currentTime + optimal <= a[task]) {
          currentTime += optimal;
          result.addAll(restoreResult());
        } else {
          possible = false;
          break;
        }
        task++;
      }
      if (possible) {
        out.println(result.size());
        for (int idx : result) {
          out.print(idx);
          out.print(' ');
        }
        out.println();
      } else {
        out.println(-1);
      }
    }
  }

  private final long oo = (long) 2e9;
  private int n, m, task;
  private long[] a;
  private List<List<Training>> trainingsPerTask;
  private long[][] dp;
  private int[][] next;

  private long recurse(int idx, int percentage) {
    if (idx == trainingsPerTask.get(task).size()) return percentage == 100 ? 0 : oo;
    if (dp[idx][percentage] != -1) return dp[idx][percentage];

    Training current = trainingsPerTask.get(task).get(idx);
    long takeTheTraining = current.time + recurse(idx + 1, min(100, percentage + current.percentage));
    long skipTheTraining = recurse(idx + 1, percentage);
    if (takeTheTraining < skipTheTraining) {
      next[idx][percentage] = min(100, percentage + current.percentage);
    } else {
      next[idx][percentage] = percentage;
    }
    return dp[idx][percentage] = min(takeTheTraining, skipTheTraining);
  }

  private List<Integer> restoreResult() {
    List<Integer> result = new ArrayList<>();
    int idx = 0, percentage = 0;
    while (percentage < 100 && idx < trainingsPerTask.get(task).size()) {
      if (next[idx][percentage] != percentage) {
        result.add(trainingsPerTask.get(task).get(idx).idx);
        percentage = next[idx][percentage];
      }
      idx++;
    }
    return result;
  }

  @Override
  public void close() throws IOException {
    in.close();
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
      tokenizer = null;
    }

    public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }

    public int ni() {
      return Integer.parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (VitalyAndAdvancedUselessAlgorithms instance = new VitalyAndAdvancedUselessAlgorithms()) {
      instance.solve();
    }
  }
}
