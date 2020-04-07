package codeforces.contests1201_1300.problemset1295;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ObtainTheString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] s = in.next().toCharArray(), t = in.next().toCharArray();
      int n = s.length;
      int[][] next = new int[26][n + 1];
      for (char ch = 'a'; ch <= 'z'; ch++) {
        int last = n + 1;
        for (int i = n; i >= 1; i--) {
          next[ch - 'a'][i] = last;
          if (s[i - 1] == ch) {
            last = i;
          }
        }
        next[ch - 'a'][0] = last;
      }
      int iterations = 1;
      int pos = 0;
      boolean possible = true;
      int idx = 0;
      while (idx < t.length) {
        char need = t[idx];
        int nxt = next[need - 'a'][pos];
        if (pos == 0 && nxt > n) {
          possible = false;
          break;
        }
        if (nxt <= n) {
          idx++;
        }
        pos = nxt;
        if (pos > n) {
          pos = 0;
          iterations++;
        }
      }
      out.println(possible ? iterations : -1);
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
    try (ObtainTheString instance = new ObtainTheString()) {
      instance.solve();
    }
  }
}
