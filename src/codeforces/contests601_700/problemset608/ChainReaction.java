package codeforces.contests601_700.problemset608;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class ChainReaction implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);
  
  private class Beacon implements Comparable<Beacon> {
    private int position, range, score;

    private Beacon(int position, int range) {
      this.position = position;
      this.range = range;
    }

    public void setScore(int score) {
      this.score = score;
    }

    @Override
    public int compareTo(Beacon o) {
      return Integer.compare(this.position, o.position);
    }
  }

  public void solve() {
    int n = in.ni();
    if (n == 1) {
      out.println(0);
      return;
    }
    beacons = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      beacons.add(new Beacon(in.ni(), in.ni()));
    }
    beacons.sort(Comparator.naturalOrder());
    for (int i = 1; i < n; i++) {
      int left = 0, right = i - 1, position = beacons.get(i).position, range = beacons.get(i).range;
      int leftmost = i;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        if (position - range <= beacons.get(mid).position) {
          leftmost = Math.min(leftmost, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
        }
      }
      beacons.get(i).setScore(i - leftmost);
    }
    dp = new Integer[n];
    int ans = Integer.MAX_VALUE;
    for (int i = n - 1; i >= 0; i--) {
      ans = Math.min(n - 1 - i + recurse(i), ans);
    }
    out.println(ans);
  }
  
  private List<Beacon> beacons;
  private Integer[] dp;
  
  private int recurse(int idx) {
    if (idx <= 0) return 0;
    
    if (dp[idx] != null) return dp[idx];
    
    int destroyed = beacons.get(idx).score;
    int ans = destroyed + recurse(idx - destroyed - 1);
    return dp[idx] = ans;
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
    try (ChainReaction instance = new ChainReaction()) {
      instance.solve();
    }
  }
}
