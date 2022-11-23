package atcoder.beginner.contest276;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class DivideBy2Or3 implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int two = Integer.MAX_VALUE, three = two;
    for (int i = 0; i < n; i++) {
      x[i] = in.ni();
      int powerOfTwo = power(x[i], 2);
      int powerOfThree = power(x[i], 3);
      two = min(powerOfTwo, two);
      three = min(powerOfThree, three);
    }
    int result = 0;
    for (int i = 0; i < n; i++) {
      int powerOfTwo = power(x[i], 2);
      while (powerOfTwo > two) {
        x[i] /= 2;
        result++;
        powerOfTwo--;
      }
      int powerOfThree = power(x[i], 3);
      while (powerOfThree > three) {
        x[i] /= 3;
        result++;
        powerOfThree--;
      }
    }
    boolean can = true;
    for (int i = 0; i < n; i++) {
      can &= x[i] == x[0];
    }
    out.println(can ? result : -1);
  }

  private int power(int value, int d) {
    int result = 0;
    while (value % d == 0) {
      value /= d;
      result++;
    }
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
    try (DivideBy2Or3 instance = new DivideBy2Or3()) {
      instance.solve();
    }
  }
}