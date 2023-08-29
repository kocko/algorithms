package codeforces.contests1801_1900.problemset1843;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class OmskMetroEasy implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public OmskMetroEasy() {
    in = new InputReader(System.in);
    out = new PrintWriter(System.out);
  }

  public void solve() {
    int T = in.ni();
    int N = (int) 2e5 + 5;
    int[] maxEndingHere = new int[N];
    int[] minEndingHere = new int[N];
    int[] maxSoFar = new int[N];
    int[] minSoFar = new int[N];
    while (T-- > 0) {
      int n = in.ni();
      maxSoFar[1] = maxEndingHere[1] = 1;
      minSoFar[1] = minEndingHere[1] = 0;
      int next = 2;
      while (n-- > 0) {
        char type = in.next().charAt(0);
        if (type == '+') {
          int parent = in.ni(), weight = in.ni();
          maxEndingHere[next] = max(maxEndingHere[parent] + weight, weight);
          minEndingHere[next] = min(minEndingHere[parent] + weight, weight);
          maxSoFar[next] = max(maxEndingHere[next], maxSoFar[parent]);
          minSoFar[next] = min(minEndingHere[next], minSoFar[parent]);
          next++;
        } else {
          int u = in.ni(), v = in.ni(), k = in.ni(); //u is always 1
          out.println(minSoFar[v] <= k && k <= maxSoFar[v] ? "YES" : "NO");
        }
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
    try (OmskMetroEasy instance = new OmskMetroEasy()) {
      instance.solve();
    }
  }
}
