package codeforces.contests1401_1500.problemset1499;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BinaryRemovals implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      boolean can = false;
      for (int zeroes = 0; zeroes < n; zeroes++) {
        int idx = 0, lastDeletion = -2;
        boolean possible = true;
        int z = 0;
        while (idx < n && z < zeroes) {
          if (x[idx] == '1') {
            if (idx == lastDeletion + 1) {
              possible = false;
              break;
            }
            lastDeletion = idx;
          } else {
            z++;
          }
          idx++;
        }
        while (idx < n) {
          if (x[idx] == '0') {
            if (idx == lastDeletion + 1) {
              possible = false;
              break;
            } else {
              lastDeletion = idx;
            }
          }
          idx++;
        }
        can |= possible;
      }
      out.println(can ? "YES" : "NO");
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
    try (BinaryRemovals instance = new BinaryRemovals()) {
      instance.solve();
    }
  }
}
