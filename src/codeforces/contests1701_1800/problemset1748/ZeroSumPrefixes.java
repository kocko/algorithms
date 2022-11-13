package codeforces.contests1701_1800.problemset1748;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class ZeroSumPrefixes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), result = 0;
      Map<Long, Integer> prefixes = new HashMap<>();
      boolean seenZero = false;
      long prefix = 0L;
      int maxCount = 0;
      for (int i = 0; i < n; i++) {
        long next = in.nl();
        if (next == 0) {
          if (seenZero) {
            result += maxCount;
          } else {
            result += prefixes.getOrDefault(0L, 0);
          }
          seenZero = true;
          prefixes = new HashMap<>();
          maxCount = 0;
        }
        prefix += next;
        int cnt = prefixes.getOrDefault(prefix, 0) + 1;
        prefixes.put(prefix, cnt);
        if (cnt > maxCount) {
          maxCount = cnt;
        }
      }
      if (seenZero) {
        result += maxCount;
      } else {
        result += prefixes.getOrDefault(0L, 0);
      }
      out.println(result);
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
    try (ZeroSumPrefixes instance = new ZeroSumPrefixes()) {
      instance.solve();
    }
  }
}