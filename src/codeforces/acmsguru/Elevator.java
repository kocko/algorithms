package codeforces.acmsguru;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Elevator implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), f = in.ni();
    int[] order = new int[n];
    boolean[] mustVisit = new boolean[101];
    for (int i = 0; i < n; i++) {
      order[i] = in.ni();
      mustVisit[order[i]] = true;
    }
    int count = 0;
    boolean[] visited = new boolean[101];
    int idx = 0, current = f;
    List<Integer> result = new ArrayList<>();
    while (count < n) {
      if (!visited[order[idx]]) {
        int step = order[idx] > current ? +1 : -1;
        do {
          current += step;
          if (mustVisit[current] && !visited[current]) {
            count++;
            visited[current] = true;
            result.add(current);
          }
        } while (current != order[idx]);
      }
      idx++;
    }
    for (int entry : result) {
      out.print(entry);
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
    try (Elevator instance = new Elevator()) {
      instance.solve();
    }
  }
}
