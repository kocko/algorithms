package codeforces.contests1101_1200.problemset1143;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Queen implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    boolean[] respectsParents = new boolean[n], respectedByChildren = new boolean[n];
    Arrays.fill(respectsParents, true);
    int root = -1;
    for (int child = 0; child < n; child++) {
      int parent = in.ni() - 1, respect = in.ni();
      if (parent < 0) {
        root = child;
      } else {
        respectedByChildren[parent] |= (respect == 0);
      }
      respectsParents[child] = respect == 0;
    }
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (i != root && !respectedByChildren[i] && !respectsParents[i]) {
        result.add(i);
      }
    }
    result.sort(Comparator.naturalOrder());
    if (result.size() > 0) {
      for (int vertex : result) {
        out.print(vertex + 1);
        out.print(' ');
      }
    } else {
      out.println(-1);
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
    try (Queen instance = new Queen()) {
      instance.solve();
    }
  }
}
