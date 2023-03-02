package codeforces.contests1701_1800.problemset1800;

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

public class CountTheNumberOfPairs implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public CountTheNumberOfPairs() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      char[] x = in.next().toCharArray();
      int[] lower = new int[26];
      int[] upper = new int[26];
      for (int idx = 0; idx < n; idx++) {
        char c = x[idx];
        if (c >= 'A' && c <= 'Z') {
          upper[c - 'A']++;
        } else {
          lower[c - 'a']++;
        }
      }
      int result = 0;
      for (int i = 0; i < 26; i++) {
        int min = min(lower[i], upper[i]);
        lower[i] -= min;
        upper[i] -= min;
        result += min;
        if (k > 0) {
          int score = lower[i] / 2 + upper[i] / 2;
          int used = min(score, k);
          result += used;
          k -= used;
        }
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
    try (CountTheNumberOfPairs instance = new CountTheNumberOfPairs()) {
      instance.solve();
    }
  }
}
