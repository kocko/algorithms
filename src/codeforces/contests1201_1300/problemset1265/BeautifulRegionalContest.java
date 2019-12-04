package codeforces.contests1201_1300.problemset1265;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class BeautifulRegionalContest implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int T = in.ni();
    while (T-- > 0) {
      int n = in.ni();
      int[] p = new int[n];
      for (int i = 0; i < n; i++) {
        p[i] = in.ni();
      }
      int gold = 0, silver = 0, bronze = 0;
      int idx, half = n / 2;
      for (idx = 0; idx < half; idx++) {
        if (p[idx] > p[idx + 1]) {
          gold = idx + 1;
          break;
        }
      }
      idx++;
      for (; idx < half; idx++) {
        if (p[idx] > p[idx + 1]) {
          int cnt = idx + 1 - gold;
          if (cnt > gold) {
            silver = cnt;
            break;
          }
        }
      }
      idx++;
      for (; idx < half; idx++) {
        if (p[idx] > p[idx + 1]) {
          int cnt = idx + 1 - (gold + silver);
          if (cnt > gold) {
            bronze = cnt;
          }
        }
      }
      if (gold == 0 || silver == 0 || bronze == 0 || gold >= silver || gold + silver + bronze > half) {
        out.println("0 0 0");
      } else {
        out.println(gold + " " + silver + " " + bronze);
      }
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
    try (BeautifulRegionalContest instance = new BeautifulRegionalContest()) {
      instance.solve();
    }
  }
}
