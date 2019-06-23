package codeforces.contests1101_1200.problemset1185;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class EmailFromPolycarp implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    for (int i = 0; i < n; i++) {
      char[] x = in.next().toCharArray(), y = in.next().toCharArray();
      out.println(check(x, y) ? "YES" : "NO");
    }
  }

  private boolean check(char[] x, char[] y) {
    List<int[]> word = findMapping(x);
    List<int[]> broken = findMapping(y);
    boolean result = true;
    if (word.size() == broken.size()) {
      int n = word.size();
      for (int i = 0; i < n; i++) {
        result &= word.get(i)[0] == broken.get(i)[0] && word.get(i)[1] <= broken.get(i)[1];
      }
    } else {
      result = false;
    }
    return result;
  }

  private List<int[]> findMapping(char[] x) {
    List<int[]> result = new ArrayList<>();
    char letter = x[0], count = 1;
    for (int i = 1; i < x.length; i++) {
      if (x[i] == letter) {
        count++;
      } else {
        result.add(new int[]{letter - 'a', count});
        count = 1;
        letter = x[i];
      }
    }
    result.add(new int[]{letter - 'a', count});
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
    try (EmailFromPolycarp instance = new EmailFromPolycarp()) {
      instance.solve();
    }
  }
}
