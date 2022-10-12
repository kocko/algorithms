package codeforces.contests1701_1800.problemset1741;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class SendingASequenceOverTheNetwork implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      n = in.ni();
      x = new int[n];
      jumps = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        x[i] = in.ni();
        jumps.add(new ArrayList<>());
      }
      for (int i = 0; i < n; i++) {
        int where = i - x[i];
        if (where >= 0) {
          jumps.get(where).add(i + 1);
        }
      }
      dp = new Boolean[n];
      out.println(recurse(0) ? "YES" : "NO");
    }
  }

  private int n;
  private int[] x;
  private List<List<Integer>> jumps;
  private Boolean[] dp;

  private boolean recurse(int idx) {
    if (idx == n) return true;
    if (dp[idx] != null) return dp[idx];

    boolean can = false;
    for (int jump : jumps.get(idx)) {
      can |= recurse(jump);
    }
    if (idx + x[idx] < n) {
      can |= recurse(idx + x[idx] + 1);
    }
    return dp[idx] = can;
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
    try (SendingASequenceOverTheNetwork instance = new SendingASequenceOverTheNetwork()) {
      instance.solve();
    }
  }
}