package codeforces.contests1101_1200.problemset1153;

import java.io.*;
import java.util.StringTokenizer;

public class ServalAndParenthesisSequence implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    char[] x = in.next().toCharArray();
    int open = n / 2;
    for (int i = 0; i < n; i++) {
      if (x[i] == '(') open--;
    }
    char[] result = new char[n];
    boolean possible = n % 2 == 0 && x[0] != ')' && x[n - 1] != '(';
    if (possible) {
      for (int i = 0; i < n; i++) {
        if (x[i] == '?') {
          if (open-- > 0) {
            result[i] = '(';
          } else {
            result[i] = ')';
          }
        } else {
          result[i] = x[i];
        }
      }
    }
    int balance = 0;
    for (int i = 0; i < n - 1; i++) {
      if (result[i] == '(') balance++;
      else balance--;
      possible &= balance > 0;
    }
    if (result[n - 1] == ')') balance--;
    possible &= balance == 0;
    if (possible) {
      for (char c : result) out.print(c); 
    } else {
      out.println(":(");
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
    try (ServalAndParenthesisSequence instance = new ServalAndParenthesisSequence()) {
      instance.solve();
    }
  }
}
