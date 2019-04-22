package codeforces.gyms.gym102157;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class NorthEastSouthWest implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), dir = 0;
    for (int i = 0; i < n; i++) {
      String command = in.next();
      if ("left".equals(command)) dir--;
      else if ("right".equals(command)) dir++;
      else dir += 2;
      if (dir < 0) dir += 4;
      if (dir > 3) dir -= 4;
    }
    switch (dir) {
      case 0: out.println("north"); break;
      case 1: out.println("east"); break;
      case 2: out.println("south"); break;
      case 3: out.println("west"); break;
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
    try (NorthEastSouthWest instance = new NorthEastSouthWest()) {
      instance.solve();
    }
  }
}
