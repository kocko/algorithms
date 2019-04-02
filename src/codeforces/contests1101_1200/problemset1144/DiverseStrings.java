package codeforces.contests1101_1200.problemset1144;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DiverseStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      boolean ans = isDiverse(in.next());
      out.println(ans ? "Yes": "No");
    }
  }
  
  private boolean isDiverse(String x) {
    int[] cnt = new int[26];
    for (int i = 0; i < x.length(); i++) {
      cnt[x.charAt(i) - 'a']++;
    }
    int start = -1;
    for (int i = 0; i < 26; i++) {
      if (cnt[i] != 0) {
        start = i;
        break;
      }
    }
    int end = 26;
    for (int i = 25; i >= 0; i--) {
      if (cnt[i] != 0) {
        end = i;
        break;
      }
    }
    boolean result = true;
    for (int i = start; i <= end; i++) {
      result &= cnt[i] == 1;
    }
    return result;
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
    try (DiverseStrings instance = new DiverseStrings()) {
      instance.solve();
    }
  }
}
