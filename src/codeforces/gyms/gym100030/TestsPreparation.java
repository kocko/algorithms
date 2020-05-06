package codeforces.gyms.gym100030;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TestsPreparation implements Closeable {

  private InputReader in;
  private PrintWriter out;

  public TestsPreparation() throws IOException {
    in = new InputReader(new FileInputStream(new File("input.txt")));
    out = new PrintWriter(new FileOutputStream(new File("output.txt")));
  }

  public void solve() {
    int n = in.ni(), m = in.ni();
    long[] masks = new long[n];
    for (int i = 0; i < n; i++) {
      int k = in.ni();
      long mask = 0;
      for (int j = 0; j < k; j++) {
        int offset = in.ni() - 1;
        mask |= (1L << offset);
      }
      masks[i] = mask;
    }
    final long MASK = (1L << m) - 1;
    int minBits = 65;
    long bestMask = MASK;
    for (int i = 1; i < (1 << n); i++) {
      long or = 0;
      int count = 0;
      for (int j = 0; j < n; j++) {
        if ((i & (1 << j)) != 0) {
          or |= masks[j];
          count++;
        }
      }
      if (or == MASK) {
        if (count < minBits) {
          minBits = count;
          bestMask = i;
        }
      }
    }
    out.println(minBits);
    for (int i = 0; i < n; i++) {
      if ((bestMask & (1 << i)) != 0) {
        out.print((i + 1));
        out.print(' ');
      }
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
    try (TestsPreparation instance = new TestsPreparation()) {
      instance.solve();
    }
  }
}
