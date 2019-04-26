package codeforces.gyms.gym102152;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BuildingStrings implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    final int oo = Integer.MAX_VALUE;
    while (t-- > 0) {
      int n = in.ni(), m = in.ni();
      char[] x = in.next().toCharArray();
      int[] cost = new int[26];
      Arrays.fill(cost, oo);
      
      char[] y = in.next().toCharArray();
      for (int i = 0; i < n; i++) {
        cost[x[i] - 'a'] = Math.min(cost[x[i] - 'a'], y[i] - '0');
      }
      char[] z = in.next().toCharArray();
      int result = 0;
      for (char c : z) {
        if (cost[c - 'a'] != oo) {
          result += cost[c - 'a'];  
        } else {
          result = oo;
          break;
        }
      }
      out.println(result != oo ? result : -1);
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
    try (BuildingStrings instance = new BuildingStrings()) {
      instance.solve();
    }
  }
}
