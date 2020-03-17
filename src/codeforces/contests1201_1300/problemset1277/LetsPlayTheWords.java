package codeforces.contests1201_1300.problemset1277;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class LetsPlayTheWords implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Entry {
    private int idx;
    private String x;

    private Entry(int idx, String x) {
      this.idx = idx;
      this.x = x;
    }
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      Set<String> has = new HashSet<>();
      Set<Entry> zeroOne = new HashSet<>(), oneZero = new HashSet<>();
      boolean left = false, right = false;
      String[] x = new String[n];
      int twins = 0;
      for (int i = 0; i < n; i++) {
        x[i] = in.next();
        has.add(x[i]);
      }
      for (int i = 0; i < n; i++) {
        String next = x[i];
        if (next.charAt(0) == '1' && next.charAt(next.length() - 1) == '1') {
          left = true;
        } else if (next.charAt(0) == '0' && next.charAt(next.length() - 1) == '0') {
          right = true;
        } else {
          String reverse = new StringBuilder(next).reverse().toString();
          if (has.contains(reverse)) {
            has.remove(reverse);
            twins++;
          } else {
            has.add(next);
            if (next.charAt(0) == '0' && next.charAt(next.length() - 1) == '1') {
              zeroOne.add(new Entry(i, next));
            } else {
              oneZero.add(new Entry(i, next));
            }
          }
        }
      }
      if (left && right && (twins + zeroOne.size() + oneZero.size()) == 0) {
        out.println(-1);
        continue;
      }
      List<Integer> result = new ArrayList<>();
      if (left) {
        if (oneZero.size() >= zeroOne.size()) {
          int rem = oneZero.size() - zeroOne.size();
          Iterator<Entry> iterator = oneZero.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        } else {
          int rem = zeroOne.size() - oneZero.size();
          Iterator<Entry> iterator = zeroOne.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        }
      } else if (right) {
        if (zeroOne.size() >= oneZero.size()) {
          int rem = zeroOne.size() - oneZero.size();
          Iterator<Entry> iterator = zeroOne.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        } else {
          int rem = oneZero.size() - zeroOne.size();
          Iterator<Entry> iterator = oneZero.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        }
      } else {
        if (oneZero.size() >= zeroOne.size()) {
          int rem = oneZero.size() - zeroOne.size();
          Iterator<Entry> iterator = oneZero.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        } else {
          int rem = zeroOne.size() - oneZero.size();
          Iterator<Entry> iterator = zeroOne.iterator();
          while (rem >= 2) {
            result.add(iterator.next().idx);
            rem -= 2;
          }
        }
      }
      out.println(result.size());
      for (Integer idx : result) {
        out.print(idx + 1);
        out.print(' ');
      }
      out.println();
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
    try (LetsPlayTheWords instance = new LetsPlayTheWords()) {
      instance.solve();
    }
  }
}
