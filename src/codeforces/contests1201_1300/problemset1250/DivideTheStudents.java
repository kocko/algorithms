package codeforces.contests1201_1300.problemset1250;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class DivideTheStudents implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int[] a = new int[3];
      int sum = 0, max = 0;
      for (int i = 0; i < 3; i++) {
        a[i] = in.ni();
        sum += a[i];
        max = Math.max(max, a[i]);
      }

      int left = 1, right = sum, result = right;

      while (left <= right) {
        int mid = (left + right) / 2;
        int[] x = {a[0], a[1], a[2]};
        int groups = 0;
        for (int i = 0; i <= 2; i += 2) {
          groups++;
          if (x[i] >= mid) {
            x[i] -= mid;
          } else {
            int need = mid - x[i];
            x[1] -= Math.min(x[1], need);
            x[i] = 0;
          }
          if (x[i] > 0) {
            groups++;
            int need = mid - x[i];
            if (need < 0) {
              groups = 5;
              break;
            } else {
              if (x[1] >= need) {
                x[1] -= need;
              } else {
                x[1] = 0;
              }
            }
          }
        }
        if (x[1] > 0) {
          groups += x[1] / mid + (x[1] % mid != 0 ? 1 : 0);
        }
        if (groups <= 3) {
          result = Math.min(result, mid);
          right = mid - 1;
        } else {
          left = mid + 1;
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
    try (DivideTheStudents instance = new DivideTheStudents()) {
      instance.solve();
    }
  }
}
