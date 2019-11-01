package codeforces.gyms.gym102365;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class AbnormalWords implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    char type = in.next().charAt(0);
    int move = in.ni();
    char[] word = in.next().toCharArray();
    int n = word.length;
    char[] result = new char[n];
    if (type == 'E') {
      for (int i = 0; i < n; i++) {
        int code = (word[i] - 'a' + move) % 26;
        result[i] = (char) ('a' + code);
      }
    } else {
      for (int i = 0; i < n; i++) {
        int code = (word[i] - 'a' - move);
        if (code < 0) {
          code += 26;
        }
        result[i] = (char) ('a' + code);
      }
    }
    for (int i = 0; i < n; i++) {
      out.print(result[i]);
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
    try (AbnormalWords instance = new AbnormalWords()) {
      instance.solve();
    }
  }
}
