package codeforces.contests1501_1600.problemset1547;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class AlphabeticalStrings implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public AlphabeticalStrings() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public AlphabeticalStrings(String input, String output) throws FileNotFoundException {
    in = new InputReader(new FileInputStream(input));
    out = new PrintWriter(new FileOutputStream(output));
  }

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      int n = x.length;
      int left = 0, right = n - 1;
      char expected = (char) ('a' + n - 1);
      boolean alphabetical = true;
      while (expected >= 'a') {
        if (x[left] == expected) {
          left++;
          expected--;
        } else if (x[right] == expected) {
          right--;
          expected--;
        } else {
          alphabetical = false;
          break;
        }
      }
      out.println(alphabetical ? "YES" : "NO");
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
    try (AlphabeticalStrings instance = new AlphabeticalStrings()) {
      instance.solve();
    }
  }
}
