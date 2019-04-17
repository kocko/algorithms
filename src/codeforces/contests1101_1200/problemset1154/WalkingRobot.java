package codeforces.contests1101_1200.problemset1154;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class WalkingRobot implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni(), battery = in.ni(), accumulator = in.ni();
    int accumulatorCapacity = accumulator;
    boolean[] sun = new boolean[n];
    for (int i = 0; i < n; i++) {
      int next = in.ni();
      sun[i] = next == 1;
    }
    int segment = 0;
    while (segment < n) {
      if (sun[segment]) {
        if (accumulator + 1 <= accumulatorCapacity) {
          if (battery > 0) {
            accumulator++;
            battery--;
          } else {
            if (accumulator > 0) {
              accumulator--;
            } else {
              break;
            }
          }
        } else {
          accumulator--;
        }
      } else {
        if (accumulator > 0) {
          accumulator--;
        } else {
          if (battery > 0) {
            battery--;
          } else {
            break;
          }
        }
      }
      segment++;
    }
    out.println(segment);
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
    try (WalkingRobot instance = new WalkingRobot()) {
      instance.solve();
    }
  }
}
