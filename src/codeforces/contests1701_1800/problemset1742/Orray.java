package codeforces.contests1701_1800.problemset1742;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Orray implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public Orray() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] x = new int[n];
      int or = 0;
      for (int i = 0; i < n; i++) {
        int next = in.ni();
        or |= next;
        x[i] = next;
      }
      List<Integer> result = new ArrayList<>();
      int prefix = 0;
      boolean[] used = new boolean[n];
      while (prefix != or) {
        int bestNext = prefix;
        int which = -1;
        for (int i = 0; i < n; i++) {
          if (!used[i]) {
            if ((prefix | x[i]) > bestNext) {
              bestNext = (prefix | x[i]);
              which = i;
            }
          }
        }
        prefix |= x[which];
        used[which] = true;
        result.add(x[which]);
      }
      for (int i = 0; i < n; i++) {
        if (!used[i]) {
          result.add(x[i]);
        }
      }
      for (int i = 0; i < n; i++) {
        out.print(result.get(i));
        out.print(' ');
      }
      out.println();
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
    try (Orray instance = new Orray()) {
      instance.solve();
    }
  }
}
