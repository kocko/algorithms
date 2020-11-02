package codeforces.contests1401_1500.problemset1443;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TheDeliveryDilemma implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni();
      long[] courier = new long[n];
      long[] walk = new long[n];
      for (int i = 0; i < n; i++) {
        courier[i] = in.nl();
      }
      for (int i = 0; i < n; i++) {
        walk[i] = in.nl();
      }
      int left = 0, right = (int) 1e9;
      while (left != right) {
        int mid = left + (right - left) / 2;
        long sum = 0;
        for (int i = 0; i < n; i++) {
          if (courier[i] > mid) {
            sum += walk[i];
          }
        }
        if (sum > mid) {
          left = mid + 1;
        } else {
          right = mid;
        }
      }
      out.println(left);
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
    try (TheDeliveryDilemma instance = new TheDeliveryDilemma()) {
      instance.solve();
    }
  }
}
