package codeforces.gyms.gym101149;

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

public class NoTimeForDragons implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  private class Dragon implements Comparable<Dragon> {
    private long a, b;

    private Dragon(long a, long b) {
      this.a = a;
      this.b = b;
    }

    @Override
    public int compareTo(Dragon o) {
      int x = Long.compare(o.a - o.b, a - b);
      return x != 0 ? x : Long.compare(o.a, a);
    }
  }
  
  public void solve() {
    int n = in.ni();
    List<Dragon> dragons = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      long a = in.nl(), b = in.nl();
      dragons.add(new Dragon(a, b));
    }
    dragons.sort(Comparator.naturalOrder());
    long alive = dragons.get(0).a, delta = 0, killed = 0;
    for (int i = 0; i < n; i++) {
      if (alive + delta - killed < dragons.get(i).a) {
        delta += dragons.get(i).a - alive - delta + killed;
      }
      killed += dragons.get(i).b;
    }
    out.println(dragons.get(0).a + delta);
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
    try (NoTimeForDragons instance = new NoTimeForDragons()) {
      instance.solve();
    }
  }
}
