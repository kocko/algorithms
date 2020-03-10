package codeforces.contests1301_1400.problemset1321;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RemoveAdjacent implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    StringBuilder sb = new StringBuilder(in.next());
    int result = 0;
    for (char remove = 'z'; remove >= 'a'; remove--) {
      boolean proceed;
      do {
        proceed = false;
        for (int i = 0; i < sb.length(); i++) {
          char current = sb.charAt(i);
          if (current == remove) {
            char prev = i > 0 ? sb.charAt(i - 1) : '?';
            char next = i < sb.length() - 1 ? sb.charAt(i + 1) : '?';
            if (current - prev == 1 || current - next == 1) {
              sb.deleteCharAt(i);
              result++;
              proceed = true;
            }
          }
        }
      } while (proceed);
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
    try (RemoveAdjacent instance = new RemoveAdjacent()) {
      instance.solve();
    }
  }
}
