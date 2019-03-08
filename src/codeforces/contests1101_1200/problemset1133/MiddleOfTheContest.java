package codeforces.contests1101_1200.problemset1133;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class MiddleOfTheContest implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    String[] start = in.next().split(":");
    String[] end = in.next().split(":");
    int s = parseInt(start[0]) * 60 + parseInt(start[1]);
    int e = parseInt(end[0]) * 60 + parseInt(end[1]);
    int offset = (e - s) / 2;
    int hours = offset / 60;
    int minutes = offset % 60;
    int[] result = new int[2];
    result[0] = parseInt(start[0]) + hours;
    result[1] = parseInt(start[1]) + minutes;
    if (result[1] >= 60) {
      result[1] -= 60;
      result[0]++;
    }
    String[] output = new String[2];
    for (int i = 0; i < 2; i++) {
      if (result[i] < 10) {
        output[i] = "0" + result[i];
      } else {
        output[i] = result[i] + "";
      }
    }
    out.println(output[0] + ":" + output[1]);
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
      return parseInt(next());
    }

    public long nl() {
      return Long.parseLong(next());
    }

    public void close() throws IOException {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    try (MiddleOfTheContest instance = new MiddleOfTheContest()) {
      instance.solve();
    }
  }
}
