package codeforces.contests1201_1300.problemset1251;

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

public class BinaryPalindromes implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int q = in.ni();
    while (q-- > 0) {
      int n = in.ni();
      int[] cnt = new int[2];
      List<Integer> sizes = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        char[] x = in.next().toCharArray();
        sizes.add(x.length);
        for (char c : x) {
          cnt[c - '0']++;
        }
      }
      sizes.sort(Comparator.naturalOrder());
      int result = 0;
      for (int size : sizes) {
        int need = 2 * (size / 2);
        boolean ok = false;
        for (int i = 0; i < 2; i++) {
          if (cnt[i] >= need) {
            cnt[i] -= need;
            result++;
            ok = true;
            break;
          }
        }
        if (!ok) {
          if (cnt[0] + cnt[1] >= need) {
            out:
            for (int i = 0; i < 2; i++) {
              for (int center = 1; center <= cnt[i]; center++) {
                int rem = size - center;
                if (rem <= cnt[i ^ 1] && rem % 2 == 0) {
                  cnt[i] -= center;
                  cnt[i ^ 1] -= rem;
                  result++;
                  break out;
                }
              }
            }
          }
        }
      }
      out.println(result);
    }
  }

  private boolean score(char[] x) {
    int[] count = new int[2];
    for (char c : x) {
      count[c - '0']++;
    }
    return count[0] % 2 != 1 || count[1] % 2 != 1;
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
    try (BinaryPalindromes instance = new BinaryPalindromes()) {
      instance.solve();
    }
  }
}
