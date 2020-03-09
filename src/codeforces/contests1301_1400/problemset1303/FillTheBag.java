package codeforces.contests1301_1400.problemset1303;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class FillTheBag implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long bag = in.nl();
      int m = in.ni();
      long[] have = new long[63];
      for (int i = 0; i < m; i++) {
        int next = in.ni();
        int idx = -1;
        while (next > 0) {
          idx++;
          next >>= 1;
        }
        have[idx]++;
      }
      int result = 0;
      for (int i = 0; i < 62; i++) {
        long bit = 1L << i;
        if ((bag & bit) != 0) {
          if (have[i] > 0) {
            have[i]--;
          } else {
            for (int j = 0; j < i; j++) {
              if (have[j] >= 2) {
                have[j + 1] += have[j] / 2;
                have[j] %= 2;
              }
            }
            if (have[i] > 0) {
              have[i]--;
            } else {
              boolean ok = false;
              for (int j = i + 1; j < have.length; j++) {
                if (have[j] > 0) {
                  have[j]--;
                  ok = true;
                  for (int k = j - 1; k >= i; k--) {
                    have[k]++;
                  }
                  result += j - i;
                  break;
                }
              }
              if (!ok) {
                result = -1;
                break;
              }
            }
          }
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
    try (FillTheBag instance = new FillTheBag()) {
      instance.solve();
    }
  }
}
