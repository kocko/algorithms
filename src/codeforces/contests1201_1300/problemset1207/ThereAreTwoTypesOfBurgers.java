package codeforces.contests1201_1300.problemset1207;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class ThereAreTwoTypesOfBurgers implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int b = in.ni(), p = in.ni(), f = in.ni(), hamburger = in.ni(), chicken = in.ni();
      int buns = b / 2, result = 0;
      if (hamburger >= chicken) {
        int min = Math.min(buns, p);
        result += min * hamburger;
        buns -= min;
        if (buns > 0) {
          result += Math.min(buns, f) * chicken;
        }
      } else {
        int min = Math.min(buns, f);
        result += min * chicken;
        buns -= min;
        if (buns > 0) {
          result += Math.min(buns, p) * hamburger;
        }
      }
      out.println(result);
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
    try (ThereAreTwoTypesOfBurgers instance = new ThereAreTwoTypesOfBurgers()) {
      instance.solve();
    }
  }
}
