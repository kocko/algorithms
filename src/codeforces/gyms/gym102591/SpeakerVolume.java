package codeforces.gyms.gym102591;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SpeakerVolume implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int x = in.ni(), y = in.ni(), z = in.ni();
    int[] dist = new int[101];
    ArrayDeque<Integer> queue = new ArrayDeque<>();
    queue.add(x);
    dist[x] = 0;
    boolean[] visited = new boolean[101];
    visited[x] = true;
    while (queue.size() > 0) {
      int top = queue.pollFirst();
      for (int step : new int[]{-z, +z, -1, +1}) {
        if (top + step >= 0 && top + step <= 100 && !visited[top + step]) {
          visited[top + step] = true;
          dist[top + step] = dist[top] + 1;
          queue.addLast(top + step);
        }
      }
    }
    out.println(dist[y]);
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
    try (SpeakerVolume instance = new SpeakerVolume()) {
      instance.solve();
    }
  }
}
