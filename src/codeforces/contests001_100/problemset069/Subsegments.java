package codeforces.contests001_100.problemset069;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Subsegments implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), k = in.ni();
    int[] x = new int[n + 1];
    TreeSet<Integer> ones = new TreeSet<>();
    Map<Integer, Integer> more = new HashMap<>();
    for (int i = 0; i < n; i++) {
      x[i + 1] = in.ni();
    }
    for (int i = 1; i <= n; i++) {
      int next = x[i];
      if (!ones.contains(next)) {
        if (more.containsKey(next)) {
          more.put(next, more.get(next) + 1); 
        } else {
          ones.add(next);
        }
      } else {
        ones.remove(next);
        more.put(next, 2);
      }
      if (i > k) {
        int rem = x[i - k];
        if (ones.contains(rem)) {
          ones.remove(rem);
        } else {
          int count = more.get(rem);
          if (count == 2) {
            more.remove(rem);
            ones.add(rem);
          } else if (count == 1) {
            more.remove(rem);
          } else {
            more.put(rem, count - 1);
          }
        }
      }
      if (i >= k) {
        if (ones.size() > 0) {
          out.println(ones.last());
        } else {
          out.println("Nothing");
        }
      }
    }
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
    try (Subsegments instance = new Subsegments()) {
      instance.solve();
    }
  }
}
