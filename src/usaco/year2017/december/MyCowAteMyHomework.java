package usaco.year2017.december;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

import static java.lang.Math.*;

public class MyCowAteMyHomework implements Closeable {

  private final InputReader in;
  private final PrintWriter out;

  public MyCowAteMyHomework() throws FileNotFoundException {
    in = new InputReader(new FileInputStream("homework.in"));
    out = new PrintWriter(new FileOutputStream("homework.out"));
  }

  public void solve() {
    int n = in.ni();
    long[] x = new long[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.nl();
    }
    long[] sum = new long[n];
    long[] min = new long[n];
    sum[n - 1] = min[n - 1] = x[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      sum[i] = sum[i + 1] + x[i];
      min[i] = Math.min(min[i + 1], x[i]);
    }
    List<Integer> result = new ArrayList<>();
    long bestSum = 0, count = 1;
    for (int i = 0; i < n - 2; i++) {
      long sumHere = sum[i + 1] - min[i + 1], countHere = n - i - 2;
      if (bestSum * countHere < sumHere * count) {
        result = new ArrayList<>();
        result.add(i + 1);
        bestSum = sumHere;
        count = countHere;
      } else if (bestSum * countHere == sumHere * count) {
        result.add(i + 1);
      }
    }
    result.forEach(out::println);
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
    try (MyCowAteMyHomework instance = new MyCowAteMyHomework()) {
      instance.solve();
    }
  }
}
