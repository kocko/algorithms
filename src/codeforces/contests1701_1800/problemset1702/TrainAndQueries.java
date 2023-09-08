package codeforces.contests1701_1800.problemset1702;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class TrainAndQueries implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TrainAndQueries() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      Map<Integer, Integer> first = new HashMap<>(), last = new HashMap<>();
      int n = in.ni(), q = in.ni();
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        if (!first.containsKey(next)) {
          first.put(next, i);
        }
        last.put(next, i);
      }
      while (q-- > 0) {
        int start = in.ni(), end = in.ni();
        boolean ans = (first.containsKey(start) && first.containsKey(end)) && (first.get(start) <= last.get(end));
        out.println(ans ? "YES" : "NO");
      }
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
    try (TrainAndQueries instance = new TrainAndQueries()) {
      instance.solve();
    }
  }
}
