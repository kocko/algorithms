package atcoder.beginner.contest124;

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

public class Handstand implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public Handstand() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int n = in.ni(), k = in.ni();
    char[] x = in.next().toCharArray();
    int[] prefix = new int[n + 1];
    if (x[0] == '0') {
      prefix[0] = prefix[1] = 1;
    }
    for (int i = 1; i < n; i++) {
      prefix[i + 1] = prefix[i];
      if (x[i - 1] == '1' && x[i] == '0') {
        prefix[i + 1]++;
      }
    }
    int result = 0;
    for (int i = 1; i <= n; i++) {
      int left = i, right = n;
      int score = 0, addition = x[i - 1] == '0' ? 1 : 0;
      while (left <= right) {
        int mid = left + (right - left) / 2;
        int count = prefix[mid] - prefix[i - 1] + addition;
        if (count > k) {
          right = mid - 1;
        } else {
          score = Math.max(score, mid - i + 1);
          left = mid + 1;
        }
      }
      result = Math.max(result, score);
    }
    out.println(result);
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
    try (Handstand instance = new Handstand()) {
      instance.solve();
    }
  }
}
