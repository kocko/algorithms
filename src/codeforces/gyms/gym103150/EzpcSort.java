package codeforces.gyms.gym103150;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class EzpcSort implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public EzpcSort() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public EzpcSort(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      char[] x = in.next().toCharArray();
      boolean can = isSubsequence(x, "ezpc".toCharArray())
                 || isSubsequence(x, "zepc".toCharArray())
                 || isSubsequence(x, "zpec".toCharArray());
      out.println(can ? "YES" : "NO");
    }
  }

  private boolean isSubsequence(char[] a, char[] b) {
    int n = a.length, m = b.length;
    int i = 0, j = 0;
    while (i < n && j < m) {
      if (a[i] == b[j]) {
        j++;
      } else {
        i++;
      }
    }
    return j == m;
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
    try (EzpcSort instance = new EzpcSort()) {
      instance.solve();
    }
  }
}