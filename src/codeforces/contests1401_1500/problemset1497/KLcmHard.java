package codeforces.contests1401_1500.problemset1497;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class KLcmHard implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int n = in.ni(), k = in.ni();
      int[] result;
      if (k == 3) {
        result = easy(n);
      } else {
        result = hard(n, k);
      }
      print(result);
    }
  }

  private int[] easy(int n) {
    int[] result = new int[3];
    if (n % 3 == 0) {
      result[0] = result[1] = result[2] = n / 3;
    } else {
      if (n % 2 == 0) {
        if (n % 4 == 0) {
          result[0] = result[1] = n / 4;
          result[2] = n / 2;
        } else {
          result[0] = result[1] = (n - 2) / 2;
          result[2] = 2;
        }
      } else {
        result[0] = result[1] = (n - 1) / 2;
        result[2] = 1;
      }
    }
    return result;
  }

  private int[] hard(int n, int k) {
    int[] result = new int[k];
    while (k > 3) {
      result[k - 1] = 1;
      k--;
      n--;
    }
    if (n % 2 == 1) {
      result[2] = 1;
      result[0] = result[1] = n / 2;
    } else {
      result[2] = result[1] = n / 2;
      if (n % 4 == 0) {
        result[0] = result[1] = n / 4;
      } else {
        result[0] = 2;
        result[1]--;
        result[2]--;
      }
    }
    return result;
  }

  private void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      out.print(arr[i]);
      out.print(' ');
    }
    out.println();
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
    try (KLcmHard instance = new KLcmHard()) {
      instance.solve();
    }
  }
}
