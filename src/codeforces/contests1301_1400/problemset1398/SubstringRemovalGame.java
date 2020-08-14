package codeforces.contests1301_1400.problemset1398;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class SubstringRemovalGame implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      char[] x = in.next().toCharArray();
      List<Integer> s = new ArrayList<>();
      int current = 0;
      for (int i = 0; i < x.length; i++) {
        if (x[i] == '1') {
          current++;
        } else {
          if (current > 0) {
            s.add(current);
          }
          current = 0;
        }
      }
      if (current > 0) {
        s.add(current);
      }
      s.sort(Comparator.reverseOrder());
      int score = 0;
      for (int i = 0; i < s.size(); i += 2) {
        score += s.get(i);
      }
      out.println(score);
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
    try (SubstringRemovalGame instance = new SubstringRemovalGame()) {
      instance.solve();
    }
  }
}
