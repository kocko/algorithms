package codeforces.gyms.gym100694;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class GoatInTheField implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int gx = in.ni(), gy = in.ni();
    String d = in.next();
    if ("UP".equals(d)) dir = 0;
    else if ("RIGHT".equals(d)) dir = 1;
    else if ("DOWN".equals(d)) dir = 2;
    else if ("LEFT".equals(d)) dir = 3;
    
    int bestScore = Integer.MAX_VALUE;
    String fastest = null;
    int s = in.ni();
    for (int i = 0; i < s; i++) {
      String name = in.next();
      int x = in.ni() - gx;
      int y = in.ni() - gy;
      int score = chaseGoat(x, y);
      if (score < bestScore) {
        bestScore = score;
        fastest = name;
      }
    }
    out.println(fastest);
  }
  
  private int dir;
  
  private int chaseGoat(int p, int q) {
    int x, y;
    if (dir == 0) {
      x = q;
      y = -p;
    } else if (dir == 1) {
      x = p;
      y = q;
    } else if (dir == 2) {
      x = -q;
      y = p;
    } else {
      x = -p;
      y = q;
    }
    int k = abs(y) / 2 + abs(y) % 2;
    int result;
    if (x > k) {
      result = k + (x - k) / 3 + 1;
    } else {
      result = k + (k - x);
    }
    return result;
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
    try (GoatInTheField instance = new GoatInTheField()) {
      instance.solve();
    }
  }
}
