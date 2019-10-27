package codeforces.contests1201_1300.problemset1250;

import java.io.*;
import java.util.StringTokenizer;

public class HappyBirthday implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      int[] cnt = new int[10];
      int minIdx = -1, min = 1000000;
      for (int i = 0; i < 10; i++) {
        cnt[i] = in.ni();
        if (cnt[i] < min) {
          min = cnt[i];
          minIdx = i;
        }
      }
      if (minIdx == 0) {
        boolean found = false;
        for (int i = 1; i < 10; i++) {
          if (cnt[i] == cnt[0]) {
            for (int j = 0; j <= cnt[i]; j++) {
              out.print(i);
            }
            found = true;
            break;
          }
        }
        if (!found) {
          out.print(1);
          for (int i = 0; i <= min; i++) {
            out.print(0);
          }
        }
      } else {
        for (int i = 0; i <= min; i++) {
          out.print(minIdx);
        }
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
    try (HappyBirthday instance = new HappyBirthday()) {
      instance.solve();
    }
  }
}
