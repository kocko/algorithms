package codeforces.contests1201_1300.problemset1281;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AzamonWebServices implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      String a = in.next(), b = in.next();
      if (b.compareTo(a) > 0) {
        out.println(a);
        continue;
      }
      char[] s = a.toCharArray();
      char[] c = b.toCharArray();
      int n = s.length, m = c.length;
      int[] min = new int[n];
      char best = s[n - 1];
      min[n - 1] = n - 1;
      int index = n - 1;
      for (int i = n - 1; i >= 0; i--) {
        char current = s[i];
        if (current < best) {
          best = current;
          index = i;
        }
        min[i] = index;
      }
      boolean ok = false;
      for (int i = 0; i < Math.min(m, n); i++) {
        if (s[i] < c[i]) {
          ok = true;
          break;
        } else if (s[i] == c[i]) {
          int idx = min[i];
          char smaller = s[idx];
          if (smaller < s[i]) {
            swap(s, i, idx);
            ok = true;
            break;
          }
        } else {
          int idx = min[i];
          char smaller = s[idx];
          if (smaller < s[i] && smaller <= c[i]) {
            swap(s, i, idx);
          }
          break;
        }
      }
      if (!ok) {
        a = new String(s);
        if (b.compareTo(a) > 0) {
          ok = true;
        }
      }
      if (ok) {
        for (char ch : s) {
          out.print(ch);
        }
        out.println();
      } else {
        out.println("---");
      }
    }
  }

  private void swap(char[] x, int a, int b) {
    char temp = x[a];
    x[a] = x[b];
    x[b] = temp;
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
    try (AzamonWebServices instance = new AzamonWebServices()) {
      instance.solve();
    }
  }
}
