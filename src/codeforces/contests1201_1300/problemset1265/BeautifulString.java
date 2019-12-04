package codeforces.contests1201_1300.problemset1265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulString implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      boolean possible = true;
      for (int i = 1; i < n; i++) {
        if (x[i] != '?' && x[i] == x[i - 1]) {
          possible = false;
        }
      }
      if (possible) {
        for (int i = 0; i < n; i++) {
          if (x[i] == '?') {
            char prev = i > 0 ? x[i - 1] : '-';
            char next = i < n - 1 ? x[i + 1] : '-';
            for (char c : "abc".toCharArray()) {
              if (c != prev && c != next) {
                x[i] = c;
                break;
              }
            }
          }
          out.print(x[i]);
        }
        out.println();
      } else {
        out.println(-1);
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
    try (BeautifulString instance = new BeautifulString()) {
      instance.solve();
    }
  }
}
