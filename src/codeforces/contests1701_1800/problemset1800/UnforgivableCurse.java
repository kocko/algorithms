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
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class UnforgivableCurse implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public UnforgivableCurse() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni(), k = in.ni();
      char[] x = in.next().toCharArray();
      char[] y = in.next().toCharArray();
      List<Character> have = new ArrayList<>();
      List<Character> target = new ArrayList<>();
      boolean[] used = new boolean[n];
      for (int i = 0; i < n - k; i++) {
        if (!used[i]) {
          have.add(x[i]);
          target.add(y[i]);
          used[i] = true;
        }
        if (i + k < n && !used[i + k]) {
          have.add(x[k + i]);
          target.add(y[k + i]);
          used[k + i] = true;
        }
      }
      have.sort(Comparator.naturalOrder());
      target.sort(Comparator.naturalOrder());
      boolean can = true;
      for (int idx = 0; idx < have.size(); idx++) {
        can &= have.get(idx).equals(target.get(idx));
      }
      for (int i = 0; i < n; i++) {
        if (!used[i]) {
          can &= x[i] == y[i];
        }
      }
      out.println(can ? "YES" : "NO");
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
    try (UnforgivableCurse instance = new UnforgivableCurse()) {
      instance.solve();
    }
  }
}
