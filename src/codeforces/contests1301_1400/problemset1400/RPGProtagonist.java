package codeforces.contests1301_1400.problemset1400;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class RPGProtagonist implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int t = in.ni();
    while (t-- > 0) {
      long me = in.nl(), you = in.nl(), S = in.nl(), A = in.nl(), sword = in.nl(), axe = in.nl();
      if (sword > axe) {
        A = S ^ A ^ (S = A);
        axe = sword ^ axe ^ (sword = axe);
      }
      long result = 0;
      for (long mySwords = 0; mySwords <= S && mySwords * sword <= me; mySwords++) {
        long yourSwords = Math.min(S - mySwords, you / sword);
        long rem_me = me - mySwords * sword;
        long rem_you = you - yourSwords * sword;

        long myAxes = Math.min(rem_me / axe, A);
        long yourAxes = Math.min(rem_you / axe, A - myAxes);

        result = Math.max(result, mySwords + myAxes + yourSwords + yourAxes);
      }
      out.println(result);
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
    try (RPGProtagonist instance = new RPGProtagonist()) {
      instance.solve();
    }
  }
}
