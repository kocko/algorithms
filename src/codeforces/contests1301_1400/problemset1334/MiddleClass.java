package codeforces.contests1301_1400.problemset1334;

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

public class MiddleClass implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      long x = in.nl();
      int[] p = new int[n];
      long save = 0;
      int richmen = 0;
      List<Integer> poor = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        p[i] = in.ni();
        if (p[i] >= x) {
          save += (p[i] - x);
          richmen++;
        } else if (p[i] < x) {
          poor.add(p[i]);
        }
      }
      poor.sort(Comparator.reverseOrder());
      for (int i = 0; i < poor.size(); i++) {
        long need = x - poor.get(i);
        if (need <= save) {
          save -= need;
          richmen++;
        } else break;
      }
      out.println(richmen);
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
    try (MiddleClass instance = new MiddleClass()) {
      instance.solve();
    }
  }
}
