package codeforces.contests1201_1300.problemset1283;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class FriendsAndGifts implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] x = new int[n];
    int[] inDegree = new int[n];
    for (int i = 0; i < n; i++) {
      x[i] = in.ni() - 1;
      if (x[i] != -1) {
        inDegree[x[i]] = 1;
      }
    }
    List<Integer> start = new ArrayList<>(), end = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      if (inDegree[i] == 0) {
        int finish = i;
        while (x[finish] != -1) {
          finish = x[finish];
        }
        start.add(i);
        end.add(finish);
      }
    }
    for (int i = 0; i < end.size() - 1; i++) {
      int from = end.get(i), to = start.get(i + 1);
      x[from] = to;
    }
    int from = end.get(end.size() - 1), to = start.get(0);
    x[from] = to;
    for (int i = 0; i < n; i++) {
      out.print(x[i] + 1);
      out.print(' ');
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
    try (FriendsAndGifts instance = new FriendsAndGifts()) {
      instance.solve();
    }
  }
}
