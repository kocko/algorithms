package codeforces.gyms.gym101149;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.StringTokenizer;

public class ExMachina implements Closeable {

  private InputReader in = new InputReader(System.in);
  private PrintWriter out = new PrintWriter(System.out);

  public void solve() {
    int n = in.ni();
    int[] order = new int[n];
    for (int i = 0; i < n; i++) {
      order[i] = i + 1;
    }
    shuffle(order);
    char response = ask(order[0], order[1]);
    int first = order[0], second = order[1];
    if (response == '<' || response == '=') {
      first = order[1];
      second = order[0];
    }
    for (int i = 2; i < n; i++) {
      response = ask(order[i], second);
      if (response == '>') {
        second = order[i];
        response = ask(order[i], first);
        if (response == '>') {
          second = first;
          first = order[i];
        }
      }
    }
    answer(second);
  }

  private void shuffle(int[] x) {
    Random random = new Random();
    int n = x.length;
    for (int i = n - 1; i >= 0; i--) {
      int j = random.nextInt(i + 1);
      x[j] = x[i] ^ x[j] ^ (x[i] = x[j]);
    }
  }

  private char ask(int i, int j) {
    out.printf("? %d %d\n", i, j);
    out.flush();
    return in.next().charAt(0);
  }

  private void answer(int idx) {
    out.printf("! %d\n", idx);
    out.flush();
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
    try (ExMachina instance = new ExMachina()) {
      instance.solve();
    }
  }
}
