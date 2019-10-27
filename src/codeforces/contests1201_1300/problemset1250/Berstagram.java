package codeforces.contests1201_1300.problemset1250;

import java.io.*;
import java.util.StringTokenizer;

import static java.lang.Integer.*;

public class Berstagram implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), m = in.ni();
    int[] likes = new int[m];
    for (int i = 0; i < m; i++) {
      likes[i] = in.ni();
    }
    int[] high = new int[n + 1], low = new int[n + 1], pos = new int[n + 1], order = new int[n + 1];
    for (int post = 1; post <= n; post++) {
      high[post] = low[post] = pos[post] = order[post] = post;
    }
    for (int i = 0; i < m; i++) {
      int post = likes[i];
      if (pos[post] > 1) {
        int prevPosition = pos[post] - 1;
        int prevPost = order[prevPosition];
        
        high[post] = max(high[post], prevPosition);
        low[post] = min(low[post], prevPosition);
        
        high[prevPost] = max(high[prevPost], pos[post]);
        low[prevPost] = min(low[prevPost], pos[post]);
        
        order[prevPosition] = post;
        order[pos[post]] = prevPost;
        
        int temp = pos[post];
        pos[post] = prevPosition;
        pos[prevPost] = temp;
      }
    }
    for (int i = 1; i <= n; i++) {
      out.println(low[i] + " " + high[i]);
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
    try (Berstagram instance = new Berstagram()) {
      instance.solve();
    }
  }
}
