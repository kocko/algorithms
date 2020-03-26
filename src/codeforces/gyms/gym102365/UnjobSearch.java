package codeforces.gyms.gym102365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class UnjobSearch implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    n = in.ni();
    skip = new boolean[n + 1];
    skip[1] = skip[2] = true;
    int u = 2;
    while (true) {
      prepareCandidates();
      boolean descendants = false;
      for (int v : candidates) {
        int response = ask(u, v);
        descendants = true;
        if (response == 1) {
          skip[v] = true;
          u = v;
          break;
        } else {
          skip[v] = true;
        }
      }
      if (!descendants) break;
    }
    answer(u);
  }

  private int n;
  private Set<Integer> candidates;
  private boolean[] skip;

  private void prepareCandidates() {
    candidates = new HashSet<>();
    for (int v = 3; v <= n; v++) {
      if (!skip[v]) {
        candidates.add(v);
      }
    }
  }

  private int ask(int u, int v) {
    out.println("? 1 " + u + " " + v);
    out.flush();
    return in.ni();
  }

  private void answer(int u) {
    out.println("! " + u);
    out.flush();
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
    try (UnjobSearch instance = new UnjobSearch()) {
      instance.solve();
    }
  }
}
